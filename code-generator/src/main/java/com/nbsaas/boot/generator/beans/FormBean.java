/*
 *
 *  * 版权声明和许可协议
 *  *
 *  * 版权所有 (c) 2023 纽百特®
 *  * 版权所有，保留所有权利
 *  *
 *  * 本软件使用 MIT 许可协议进行许可，详情请参阅：
 *  *
 *  *   https://opensource.org/licenses/MIT
 *  *
 *  * 更多信息，请访问我们的网站：
 *  *
 *  *   http://www.nbsaas.com
 *  *
 *  * 纽百特® 是西安纽百特科技有限责任公司的注册商标，未经授权不得使用。
 *
 */

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
    private String model;
    private String menu;
    private String searchWidth;
    private String viewWidth;
    private String className;
    private Boolean hasDate = false;
    private Boolean hasImage = false;
    private Integer leftSize;

    private String sortField;

    private boolean showHandle;
    private boolean showAdd;
    private boolean showSelect;


    /**
     * 时候启用数据表逻辑删除
     */
    private boolean storeState;

    private String handleWidth;

    /**
     * 是否是目录类
     */
    private boolean catalog;

    private boolean lazy;

    /**
     * 是否有字典
     */
    private boolean dict;

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

    private boolean permissionDataClass;

    /**
     * 模型类型 0数据表 1视图
     */
    private int modelType;

    /**
     * 页面字段集合(添加，修改，查询)
     */
    private List<FieldBean> fields = new ArrayList<>();

    /**
     * 请求对象集合
     */
    private Set<FieldBean> requests = new HashSet<>();

    /**
     * 列表对象
     */
    private Set<FieldBean> simples = new HashSet<>();

    /**
     * 详情对象
     */
    private Set<FieldBean> responses = new HashSet<FieldBean>();
    private List<FieldBean> dates = new ArrayList<FieldBean>();

    /**
     * 搜索字段
     */
    List<FieldBean> searches = new ArrayList<>();

    /**
     * 没有标记搜索注解的字段
     */
    List<FieldBean> searchFields = new ArrayList<>();


    /**
     * 列表显示字段
     */
    private List<FieldBean> grids = new ArrayList<FieldBean>();


    private List<FieldBean> images = new ArrayList<FieldBean>();


    private Set<ComponentSimple> componentSet = new HashSet<>();

    private Set<ComponentSimple> components = new HashSet<>();


    private Set<ComponentSimple> searchComponentSet = new HashSet<>();

}
