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


import com.nbsaas.boot.code.annotation.*;
import jodd.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Comment;

import java.lang.reflect.Field;
import java.util.*;

public class FormBeanConvert {

    private static void updateComment(Field f, FieldBean bean) {
        //注释注解
        Comment comment = f.getAnnotation(Comment.class);
        if (comment != null) {
            bean.setComment(comment.value());
        }
    }

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
                bean.setType(annotation.type().name());
                bean.setPlaceholder(annotation.placeholder());
                bean.setTitle(annotation.label());
                bean.setId(annotation.name());
                bean.setClassName(annotation.classType().getSimpleName());
                bean.setFullType(annotation.classType().getName());
                if (!isBasicType(annotation.classType())) {
                    bean.setFieldType(5);
                }


                bean.setKey(annotation.key());
                bean.setOperator(annotation.operator().name());
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
                bean.setApi(annotation.api());
                if (StringUtils.isEmpty(bean.getApi())) {
                    bean.setApi(annotation.name());
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
                    fieldBean.setClassName(item.classType().getSimpleName());
                    fieldBean.setFullType(item.classType().getName());
                    if (!isBasicType(item.classType())) {
                        fieldBean.setFieldType(5);
                    }
                    fieldBean.setKey(item.key());
                    fieldBean.setOperator(item.operator().name());
                    fieldBean.setShow(item.show());
                    Integer sortNum = getInteger(item);
                    fieldBean.setSortNum(sortNum);
                    if (StringUtils.isEmpty(fieldBean.getKey())) {
                        fieldBean.setKey(fieldBean.getId());
                    }
                    if (StringUtils.isEmpty(fieldBean.getPlaceholder())) {
                        fieldBean.setPlaceholder("");
                    }
                    fieldBean.setApi(item.api());
                    if (StringUtils.isEmpty(fieldBean.getApi())) {
                        fieldBean.setApi(item.name());
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
            for (Field field : fs) {
                field.setAccessible(true);
                FieldConvert convert = field.getAnnotation(FieldConvert.class);
                if (convert != null) {
                    FieldBean bean = new FieldBean();
                    bean.setId(field.getName());
                    bean.setType(convert.classType().getSimpleName());
                    bean.setFieldType(2);
                    bean.setParentType(field.getType().getSimpleName());
                    bean.setParentFullType(field.getType().getName());
                    bean.setFullType(field.getType().getName());
                    updateComment(field, bean);
                    beans.add(bean);
                }

                FieldName fieldName = field.getAnnotation(FieldName.class);
                if (fieldName != null) {
                    FieldBean bean = new FieldBean();
                    String parent = fieldName.parent();
                    if (StringUtil.isNotBlank(parent)) {
                        String temp = parent.substring(0, 1).toUpperCase() + parent.substring(1);
                        bean.setId(field.getName() + temp);
                        bean.setExtName(parent);
                    } else {
                        bean.setId(field.getName() + "Name");
                        bean.setExtName("Name");
                    }
                    bean.setParent(field.getName());
                    bean.setType(fieldName.classType());
                    bean.setFieldType(3);
                    bean.setFullType(field.getType().getName());
                    updateComment(field, bean);
                    beans.add(bean);
                }


                if (field.getType().isEnum()) {
                    FieldBean bean = new FieldBean();
                    bean.setId(field.getName());
                    bean.setType(field.getType().getSimpleName());
                    bean.setFullType(field.getType().getName());
                    bean.setFieldType(4);
                    beans.add(bean);
                }


                if (isBasicType(field.getType())) {
                    if (annotation != null && field.getAnnotation(annotation) != null) {
                        continue;
                    }
                    FieldBean bean = new FieldBean();
                    bean.setId(field.getName());
                    bean.setType(field.getType().getSimpleName());
                    bean.setFieldType(1);

                    updateComment(field, bean);
                    beans.add(bean);

                }
            }
        }
        return beans;
    }

    boolean isBasicType(Class<?> type) {
        if (type.getName().startsWith("java.lang")
                || type.getName().equals("int")
                || type.getName().equals("long")
                || type.getName().equals("float")
                || type.getName().equals("double")
                || type.getSimpleName().equals("BigDecimal")
                || type.getSimpleName().equals("Date")) {
            return true;
        } else {
            return false;
        }
    }

    public FormBean convertClass(Class<?> object) {
        FormBean formBean = new FormBean();
        formBean.setClassName(object.getSimpleName());
        formBean.setSimples(fieldsForSimple(object));
        formBean.setResponses(fieldsForResponse(object));
        formBean.setSearches(search(object));
        formBean.setRequests(getFieldBeans(object, null));

        formBean.getSearchFields().addAll(formBean.getRequests());
        formBean.getSearchFields().removeAll(formBean.getSearches());
        //formBean.getSearches().addAll(formBean.getRequests());
        FormAnnotation formAnnotation = object.getAnnotation(FormAnnotation.class);
        if (formAnnotation != null) {
            formBean.setTitle(formAnnotation.title());
            formBean.setMenu(formAnnotation.menu());
            formBean.setViewWidth(formAnnotation.viewWidth());
            formBean.setSearchWidth(formAnnotation.searchWidth());
            formBean.setModel(formAnnotation.model());

        }
        CatalogClass catalogClass = object.getAnnotation(CatalogClass.class);
        if (catalogClass != null) {
            formBean.setCatalog(true);
            formBean.setLazy(catalogClass.lazyData());
        }
        ComposeView composeView = object.getAnnotation(ComposeView.class);
        if (composeView != null) {
            formBean.setCompose(true);
        }
        CreateByUser createByUser = object.getAnnotation(CreateByUser.class);
        if (createByUser != null) {
            formBean.setCreateByUser(true);
        }
        PermissionClass permissionClass = object.getAnnotation(PermissionClass.class);
        if (permissionClass != null) {
            formBean.setPermissionClass(true);
        }
        TenantPermissionClass tenantPermissionClass = object.getAnnotation(TenantPermissionClass.class);
        if (tenantPermissionClass != null) {
            formBean.setTenantPermissionClass(true);
        }

        PermissionDataClass permissionDataClass = object.getAnnotation(PermissionDataClass.class);
        if (permissionDataClass != null) {
            formBean.setPermissionDataClass(true);
        }

        List<FieldBean> beanList = formBean.getFields();

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


                //
                if (field.type() == InputType.image) {

                    formBean.getComponentSet().add(ComponentSimple.builder()
                            .name("avatar").model("@/components/avatar.vue")
                            .build());
                }
                if (field.type() == InputType.el_upload) {
                    formBean.getComponentSet().add(ComponentSimple.builder()
                            .name("avatar").model("@/components/avatar.vue")
                            .build());
                }
                if (field.type() == InputType.dictionary) {
                    formBean.getComponentSet().add(ComponentSimple.builder()
                            .name("nbSelect").model("@/components/nbSelect.vue")
                            .build());
                }
                if (field.type() == InputType.richText) {
                    formBean.getComponentSet().add(ComponentSimple.builder()
                            .name("VueUeditorWrap").model("vue-ueditor-wrap")
                            .build());
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

        int left = 24 - formBean.getSearches().size() * 6;
        if (left == 0) {
            left = 24;
        }
        formBean.setLeftSize(left);

        //查找扩展bean
        BeanExt beanExt = object.getAnnotation(BeanExt.class);
        if (beanExt != null) {
            FormExtField[] items = beanExt.items();
            if (items == null) {
                return formBean;
            }
            for (FormExtField item : items) {
                FieldBean bean = new FieldBean();
                bean.setId(item.fieldName());
                bean.setType(item.fieldClass().getSimpleName());
                bean.setParent(item.parent());
                bean.setParentField(item.parentField());
                bean.setTitle(item.title());
                bean.setSortNum(item.sortNum());
                bean.setWidth(item.width());
                if (!isBasicType(item.fieldClass())) {
                    bean.setFullType(item.fieldClass().getName());
                    bean.setFieldType(100);
                } else {
                    bean.setFieldType(101);
                }

                if (item.simple()) {
                    formBean.getSimples().add(bean);
                }

                if (item.response()) {
                    formBean.getResponses().add(bean);
                }

                if (item.grid()) {
                    formBean.getGrids().add(bean);
                    formBean.getGrids().sort(Comparator.comparing(FieldBean::getSortNum));
                }
            }

        }

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
