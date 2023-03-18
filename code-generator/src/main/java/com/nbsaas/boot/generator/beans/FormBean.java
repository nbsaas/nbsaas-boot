package com.nbsaas.boot.generator.beans;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class FormBean implements Serializable {

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

    private List<FieldBean> fields = new ArrayList<>();

    private Set<FieldBean> requests = new HashSet<>();

    private Set<FieldBean> simples = new HashSet<>();

    private Set<FieldBean> responses = new HashSet<FieldBean>();

    List<FieldBean> searches = new ArrayList<FieldBean>();
    private List<FieldBean> dates = new ArrayList<FieldBean>();


    private List<FieldBean> grids = new ArrayList<FieldBean>();


    private List<FieldBean> images = new ArrayList<FieldBean>();


}
