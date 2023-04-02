package com.nbsaas.boot.generator.beans;


import com.nbsaas.boot.code.annotation.*;
import jodd.util.StringUtil;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.*;

public class FormBeanConvert {

    // SearchItem
    public List<FieldBean> search(Class<?> object) {
        List<FieldBean> beans = new ArrayList<>();
        for (Class<?> clazz = object; clazz != Object.class; clazz = clazz.getSuperclass()) {
            Field[] fs = clazz.getDeclaredFields();
            for (Field f : fs) {
                f.setAccessible(true);
                SearchItem annotation = f.getAnnotation(SearchItem.class);
                if (annotation == null) {
                    continue;
                }
                FieldBean bean = new FieldBean();
                if (annotation == null) {
                    continue;
                }
                bean.setType(annotation.type().name());
                bean.setPlaceholder(annotation.placeholder());
                bean.setTitle(annotation.label());
                bean.setId(annotation.name());
                bean.setClassName(annotation.classType());
                bean.setKey(annotation.key());
                bean.setOperator(annotation.operator());
                Integer sortNum = getInteger(annotation);
                bean.setSortNum(sortNum);
                bean.setShow(annotation.show());
                if (StringUtils.isEmpty(bean.getTitle())) {
                    bean.setTitle(f.getName());
                }
                if (StringUtils.isEmpty(bean.getKey())) {
                    bean.setKey(f.getName());
                }
                if (StringUtils.isEmpty(bean.getId())) {
                    bean.setId(f.getName());
                }
                if (StringUtils.isEmpty(bean.getPlaceholder())) {
                    bean.setPlaceholder(bean.getTitle());
                }
                beans.add(bean);
            }
        }

        SearchBean bean = object.getAnnotation(SearchBean.class);
        if (bean != null) {
            SearchItem[] items = bean.items();
            if (items != null) {
                for (SearchItem item : items) {
                    FieldBean fieldBean = new FieldBean();
                    if (item == null) {
                        continue;
                    }
                    fieldBean.setType(item.type().name());
                    fieldBean.setPlaceholder(item.placeholder());
                    fieldBean.setTitle(item.label());
                    fieldBean.setId(item.name());
                    fieldBean.setClassName(item.classType());
                    fieldBean.setKey(item.key());
                    fieldBean.setOperator(item.operator());
                    fieldBean.setShow(item.show());
                    Integer sortNum = getInteger(item);
                    fieldBean.setSortNum(sortNum);
                    if (StringUtils.isEmpty(fieldBean.getKey())) {
                        fieldBean.setKey(fieldBean.getId());
                    }
                    if (StringUtils.isEmpty(fieldBean.getPlaceholder())) {
                        fieldBean.setPlaceholder("");
                    }
                    beans.add(fieldBean);
                }
            }
        }


        beans.sort(new Comparator<FieldBean>() {
            @Override
            public int compare(FieldBean o1, FieldBean o2) {
                return o1.getSortNum().compareTo(o2.getSortNum());
            }
        });
        return beans;
    }



    /**
     * 获取实体所有字段
     *
     * @param object
     * @return
     */
    public Set<FieldBean> fields(Class<?> object) {
        Set<FieldBean> beans = new HashSet<>();
        for (Class<?> clazz = object; clazz != Object.class; clazz = clazz.getSuperclass()) {
            Field[] fs = clazz.getDeclaredFields();
            for (Field f : fs) {
                f.setAccessible(true);
//                if (haveId(f)) {
//                    continue;
//                }
                NoHandle noHandle = f.getAnnotation(NoHandle.class);
                if (noHandle != null) {
                    continue;
                }
                FieldConvert convert = f.getAnnotation(FieldConvert.class);
                if (convert != null) {
                    FieldBean bean = new FieldBean();
                    bean.setId(f.getName());
                    bean.setType(convert.classType());
                    bean.setFieldType(2);
                    bean.setParentType(f.getType().getSimpleName());
                    bean.setParentFullType(f.getType().getName());
                    beans.add(bean);
                }

                if (f.getType().isEnum()) {
                    FieldBean bean = new FieldBean();
                    bean.setId(f.getName());
                    bean.setType(f.getType().getSimpleName());
                    bean.setFieldType(4);
                    bean.setFullType(f.getType().getName());
                    beans.add(bean);
                    continue;
                }

                if (f.getType().getName().startsWith("java.lang")
                        || f.getType().getName().equals("int")
                        || f.getType().getName().equals("long")
                        || f.getType().getName().equals("float")
                        || f.getType().getName().equals("double")
                        || f.getType().getName().equals("Date")
                        || f.getType().getSimpleName().equals("BigDecimal")
                        || f.getType().getSimpleName().equals("Date")) {
                    FieldBean bean = new FieldBean();
                    bean.setId(f.getName());
                    bean.setType(f.getType().getSimpleName());
                    bean.setFieldType(1);
                    beans.add(bean);
                }
            }
        }
        return beans;
    }

    public Set<FieldBean> fieldsForSimple(Class<?> object) {
        return getFieldBeans(object, NoSimple.class);
    }

    public Set<FieldBean> fieldsForResponse(Class<?> object) {
        return getFieldBeans(object, NoResponse.class);
    }

    private Set<FieldBean> getFieldBeans(Class<?> object, Class annotation) {
        Set<FieldBean> beans = new HashSet<>();
        for (Class<?> clazz = object; clazz != Object.class; clazz = clazz.getSuperclass()) {
            Field[] fs = clazz.getDeclaredFields();
            for (Field f : fs) {
                f.setAccessible(true);
                FieldConvert convert = f.getAnnotation(FieldConvert.class);
                if (convert != null) {
                    FieldBean bean = new FieldBean();
                    bean.setId(f.getName());
                    bean.setType(convert.classType());
                    bean.setFieldType(2);
                    bean.setParentType(f.getType().getSimpleName());
                    bean.setParentFullType(f.getType().getName());
                    beans.add(bean);
                }

                FieldName fieldName = f.getAnnotation(FieldName.class);
                if (fieldName != null) {
                    FieldBean bean = new FieldBean();
                    String parentName = fieldName.name();
                    if (StringUtil.isNotBlank(parentName)) {
                        bean.setId(parentName);
                        String parent = fieldName.parent();
                        if (StringUtils.isNoneEmpty(parent)) {
                            bean.setExtName(parent);
                        } else {
                            bean.setExtName(parentName);
                        }
                    } else {
                        bean.setId(f.getName() + "Name");
                        bean.setExtName("Name");
                    }
                    bean.setParent(f.getName());
                    bean.setType(fieldName.classType());
                    bean.setFieldType(3);
                    beans.add(bean);
                }

                if (f.getType().isEnum()) {
                    FieldBean bean = new FieldBean();
                    bean.setId(f.getName());
                    bean.setType(f.getType().getSimpleName());
                    bean.setFieldType(4);
                    beans.add(bean);
                }


                if (f.getType().getName().startsWith("java.lang")
                        || f.getType().getName().equals("int")
                        || f.getType().getName().equals("long")
                        || f.getType().getName().equals("float")
                        || f.getType().getName().equals("double")
                        || f.getType().getSimpleName().equals("BigDecimal")
                        || f.getType().getSimpleName().equals("Date")) {
                    if (f.getAnnotation(annotation) != null) {
                        continue;
                    }
                    FieldBean bean = new FieldBean();
                    bean.setId(f.getName());
                    bean.setType(f.getType().getSimpleName());
                    bean.setFieldType(1);
                    beans.add(bean);

                }
            }
        }
        return beans;
    }

    public FormBean convertClass(Class<?> object) {
        FormBean formBean = new FormBean();
        formBean.setClassName(object.getSimpleName());
        formBean.setSimples(fieldsForSimple(object));
        formBean.setResponses(fieldsForResponse(object));
        formBean.setSearches(search(object));
        formBean.setRequests(fields(object));
        List<FieldBean> beanList = formBean.getFields();
        FormAnnotation formAnnotation = object.getAnnotation(FormAnnotation.class);
        if (formAnnotation != null) {
            formBean.setTitle(formAnnotation.title());
            formBean.setMenu(formAnnotation.menu());
            formBean.setViewWidth(formAnnotation.viewWidth());
            formBean.setSearchWidth(formAnnotation.searchWidth());
        }
        CatalogClass catalogClass=object.getAnnotation(CatalogClass.class);
        if (catalogClass!=null){
            formBean.setCatalog(true);
        }
        ComposeView composeView=object.getAnnotation(ComposeView.class);
        if (composeView!=null){
            formBean.setCompose(true);
        }
        CreateByUser createByUser=object.getAnnotation(CreateByUser.class);
        if (createByUser!=null){
            formBean.setCreateByUser(true);
        }
        PermissionClass permissionClass=object.getAnnotation(PermissionClass.class);
        if (permissionClass!=null){
            formBean.setPermissionClass(true);
        }
        TenantPermissionClass tenantPermissionClass=object.getAnnotation(TenantPermissionClass.class);
        if (tenantPermissionClass!=null){
            formBean.setTenantPermissionClass(true);
        }


        for (Class<?> clazz = object; clazz != Object.class; clazz = clazz.getSuperclass()) {
            Field[] fs = clazz.getDeclaredFields();
            for (Field f : fs) {
                f.setAccessible(true);
                FormField field = f.getAnnotation(FormField.class);
                FieldBean bean = new FieldBean();
                if (field == null) {
                    continue;
                }

                if (f.getType().isEnum()) {
                    bean.setFieldType(4);
                    bean.setExtName("Name");
                } else {
                    bean.setFieldType(1);
                    bean.setExtName("");
                }
                FieldName fieldName = f.getAnnotation(FieldName.class);
                if (fieldName != null) {
                    bean.setFieldType(3);
                    bean.setExtName("Name");
                }
                bean.setWidth(field.width());
                bean.setClassName(field.className());
                bean.setId(field.id());
                if (bean.getId() == null) {
                    bean.setId(f.getName());
                }
                bean.setType(field.type().name());
                bean.setPlaceholder(field.placeholder());
                Integer sortNum = getInteger(field);
                bean.setSortNum(sortNum);
                bean.setTitle(field.title());
                bean.setCol(field.col());
                bean.setRequired(field.required());
                bean.setOption(field.option());
                bean.setSort(field.sort());
                if (field.grid()) {
                    formBean.getGrids().add(bean);
                }
                if (StringUtils.isEmpty(bean.getTitle())) {
                    bean.setTitle(f.getName());
                }
                if (StringUtils.isEmpty(bean.getId())) {
                    bean.setId(f.getName());
                }
                if (StringUtils.isEmpty(bean.getPlaceholder())) {
                    bean.setPlaceholder(bean.getTitle());
                }
                if ("date".equals(bean.getType())) {
                    formBean.setHasDate(true);
                    formBean.getDates().add(bean);
                }
                if ("image".equals(bean.getType())) {
                    formBean.setHasImage(true);
                    formBean.getImages().add(bean);
                }
                if (field.ignore()) {
                    continue;
                }
                if (!beanList.contains(bean)) {
                    beanList.add(bean);
                }
            }
        }
        beanList.sort(new Comparator<FieldBean>() {
            @Override
            public int compare(FieldBean o1, FieldBean o2) {
                return o1.getSortNum().compareTo(o2.getSortNum());
            }
        });
        Collections.sort(formBean.getGrids());
        return formBean;
    }

    public FormBean convertObject(Object object) {
        return convertClass(object.getClass());
    }

    private Integer getInteger(FormField annotation) {
        Integer result = 0;
        String b = annotation.sortNum();
        try {
            result = Integer.parseInt(b);
        } catch (Exception e) {
            result = 0;
        }
        return result;
    }

    private Integer getInteger(SearchItem annotation) {
        Integer result = 0;
        String b = annotation.sortNum();
        try {
            result = Integer.parseInt(b);
        } catch (Exception e) {
            result = 0;
        }
        return result;
    }

    public Set<DaoBean> daoBeans(Class<?> object) {
        Set<DaoBean> beans = new HashSet<>();
        for (Class<?> clazz = object; clazz != Object.class; clazz = clazz.getSuperclass()) {
            Field[] fs = clazz.getDeclaredFields();
            for (Field field : fs) {
                field.setAccessible(true);
                FieldConvert convert = field.getAnnotation(FieldConvert.class);
                if (convert != null) {
                    DaoBean bean = new DaoBean();
                    String dao = field.getType().getCanonicalName();
                    dao = dao.replace("entity", "dao") + "Dao";

                    String repository = field.getType().getCanonicalName();
                    repository = repository.replace("entity", "repository") + "Repository";

                    bean.setDaoName(dao);
                    bean.setDao(field.getType().getSimpleName() + "Dao");
                    bean.setDaoField(field.getName());

                    bean.setRepository(repository);
                    bean.setRepositoryName(field.getType().getSimpleName() + "Repository");
                    bean.setRepositoryField(field.getName());
                    beans.add(bean);
                }

            }
        }
        return beans;
    }

    public Set<EnumBean> enums(Class<?> object) {
        Set<EnumBean> beans = new HashSet<>();
        for (Class<?> clazz = object; clazz != Object.class; clazz = clazz.getSuperclass()) {
            Field[] fs = clazz.getDeclaredFields();
            for (Field f : fs) {
                f.setAccessible(true);
                if (f.getType().isEnum()) {
                    EnumBean bean = new EnumBean();
                    String dao = f.getType().getCanonicalName();
                    bean.setClassName(f.getType().getName());
                    bean.setField(f.getName());
                    beans.add(bean);
                }

            }
        }
        return beans;
    }

}
