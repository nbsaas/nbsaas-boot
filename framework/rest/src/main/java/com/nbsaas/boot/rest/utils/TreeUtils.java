package com.nbsaas.boot.rest.utils;

import com.nbsaas.boot.rest.simple.Tree;

import java.util.*;

public class TreeUtils {

    public static  <T extends Tree<T>> List<T> tree(List<T> nodeList) {
        List<T> tree = new ArrayList<>();
        if (nodeList != null && !nodeList.isEmpty()) {
            Map<Long, T> map = new HashMap<>();
            for (T item : nodeList) {
                map.put(item.getId(), item);
            }
            for (T item : nodeList) {
                if (item.getParent() == null) {
                    tree.add(item);
                } else {
                    T parent = map.get(item.getParent());
                    if (parent != null) {
                        if (parent.getChildren() == null) {
                            parent.setChildren(new ArrayList<>());
                        }
                        parent.getChildren().add(item);
                    }
                }
            }

            // 对根节点和子节点按Code排序
            tree.sort(Comparator.comparing(T::getCode));
            for (T node : tree) {
                if (node.getChildren() != null) {
                    node.getChildren().sort(Comparator.comparing(T::getCode));
                }
            }
        }
        return tree;
    }
}
