package com.nbsaas.boot.rest.enums;

/**
 * 数据存储状态.
 */
public enum StoreState {
    draft, normal, recycle, archive;

    @Override
    public String toString() {
        if (name().equals("normal")) {
            return "正常";
        } else if (name().equals("recycle")) {
            return "回收站";
        } else if (name().equals("draft")) {
            return "草稿";
        } else if (name().equals("archive")) {
            return "归档";
        }
        return super.toString();
    }
}
