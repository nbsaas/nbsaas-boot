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

package com.nbsaas.boot.generator.rest.handle.field;

import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.code.annotation.FieldName;
import com.nbsaas.boot.code.annotation.data.Dict;
import com.nbsaas.boot.code.annotation.data.DictItem;
import com.nbsaas.boot.code.annotation.data.DictKey;
import com.nbsaas.boot.generator.beans.FieldBean;
import com.nbsaas.boot.generator.beans.FormBean;
import com.nbsaas.boot.generator.beans.dict.DictItemSimple;
import com.nbsaas.boot.generator.rest.handle.base.BaseFieldHandle;
import jodd.util.StringUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * 特殊注解解析，优先级最高
 */
public class FieldConvertFieldHandle extends BaseFieldHandle {
    @Override
    public void handle(Class<?> object, Field field, FormBean formBean) {
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
            formBean.getSimples().add(bean);
            formBean.getResponses().add(bean);
            formBean.getRequests().add(bean);

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
            formBean.getSimples().add(bean);
            formBean.getResponses().add(bean);
        }

        if (field.getType().isEnum()) {
            FieldBean bean = new FieldBean();
            bean.setId(field.getName());
            bean.setType(field.getType().getSimpleName());
            bean.setFullType(field.getType().getName());
            bean.setFieldType(4);
            updateComment(field, bean);
            formBean.getSimples().add(bean);
            formBean.getResponses().add(bean);
        }

        //处理字段注解是字典类型的
        Dict dict = field.getAnnotation(Dict.class);
        if (dict != null) {
            FieldBean bean = new FieldBean();
            updateComment(field, bean);
            bean.setId(field.getName());
            bean.setType(field.getType().getSimpleName());
            bean.setFullType(field.getType().getName());
            bean.setExtName("Name");
            if (dict.keyType().getSimpleName().equals("String")) {
                bean.setFieldType(202);
            } else {
                bean.setFieldType(201);
            }
            DictItem[] items = dict.items();
            if (items != null) {
                bean.setDictItems(new ArrayList<>());
                for (DictItem item : items) {
                    DictItemSimple simple = new DictItemSimple();
                    simple.setValue(item.value());
                    simple.setLabel(item.label());
                    simple.setNote(item.note());
                    bean.getDictItems().add(simple);
                }
            }

            DictKey dictKey = field.getAnnotation(DictKey.class);
            if (dictKey != null) {
                bean.setDictKey(dictKey.value());
            } else {
                bean.setDictKey(field.getName());
            }
            //bean.setType("dictionary");
            formBean.getSimples().add(bean);
            formBean.getResponses().add(bean);
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
