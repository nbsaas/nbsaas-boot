package com.nbsaas.boot.generator.beans;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class FormBean implements Serializable {

    List<FieldBean> searches = new ArrayList<FieldBean>();
    private String title;
    private String add;
    private String list;
    private String update;
    private String menu;
    private String searchWidth;
    private String viewWidth;
    private String className;
    private Boolean hasDate = false;
    private Boolean hasImage = false;
    private Integer leftSize;
    /**
     * 是否是目录类
     */
    private boolean catalog;
    /**
     * 详情展示的时候是否是组合展示
     */
    private boolean compose;
    /**
     * 是否有用户Bean
     */
    private boolean createByUser;
    private boolean permissionClass;
    private boolean tenantPermissionClass;
    private List<FieldBean> fields = new ArrayList<>();
    private Set<FieldBean> requests = new HashSet<>();
    private Set<FieldBean> simples = new HashSet<>();
    private Set<FieldBean> responses = new HashSet<FieldBean>();
    private List<FieldBean> dates = new ArrayList<FieldBean>();


    private List<FieldBean> grids = new ArrayList<FieldBean>();


    private List<FieldBean> images = new ArrayList<FieldBean>();


    private Set<ComponentSimple> componentSet = new HashSet<>();

    private Set<ComponentSimple> components = new HashSet<>();

}
