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

package com.nbsaas.boot.generator.rest.handle.base;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.nbsaas.boot.code.annotation.FormField;
import com.nbsaas.boot.generator.api.apis.FieldHandle;
import com.nbsaas.boot.generator.beans.FieldBean;
import com.nbsaas.boot.generator.rest.handle.untils.FieldUtils;
import org.hibernate.annotations.Comment;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

public abstract class BaseFieldHandle implements FieldHandle {

    protected void updateComment(Field field, FieldBean bean) {
        //注释注解
        Comment comment = field.getAnnotation(Comment.class);
        if (comment != null) {
            bean.setComment(comment.value());
        }
        if (!StringUtils.hasText(bean.getComment())) {
            FormField formField = field.getAnnotation(FormField.class);
            if (formField != null) {
                bean.setComment(formField.title());
            }
        }
        TableField tableField = field.getAnnotation(TableField.class);
        if (tableField != null) {
            bean.setDbField(tableField.value());
        }
        if (bean.getDbField()==null){
            TableId tableId = field.getAnnotation(TableId.class);
            if (tableId!=null){
                bean.setDbField(tableId.value());
            }
        }
        if (bean.getDbField()==null){
            bean.setDbField(bean.getId());
        }

    }

    protected boolean isCollection(Field field) {
        Class<?> fieldType = field.getType();
        return Collection.class.isAssignableFrom(fieldType)|| Map.class.isAssignableFrom(fieldType);
    }

    protected boolean isBasicType(Class<?> type) {
        return FieldUtils.isBasicType(type);
    }
}
