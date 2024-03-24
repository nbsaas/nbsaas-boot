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
import com.nbsaas.boot.code.annotation.NoResponse;
import com.nbsaas.boot.generator.beans.FieldBean;
import com.nbsaas.boot.generator.beans.FormBean;
import com.nbsaas.boot.generator.rest.handle.base.BaseFieldHandle;

import javax.persistence.Entity;
import java.lang.reflect.Field;

public class ResponseFieldHandle extends BaseFieldHandle {
    @Override
    public void handle(Class<?> object,Field field, FormBean formBean) {
        field.setAccessible(true);
        if (isBasicType(field.getType())) {
            if (field.getAnnotation(NoResponse.class) != null) {
                return;
            }
            FieldBean bean = new FieldBean();
            bean.setId(field.getName());
            bean.setType(field.getType().getSimpleName());
            bean.setFieldType(1);

            updateComment(field, bean);
            formBean.getResponses().add(bean);

        }else {

            //要是集合类不处理
            if (isCollection(field)){
                return;
            }
            Entity entity = field.getType().getAnnotation(Entity.class);
            if (entity != null) {
                FieldConvert fieldConvert = field.getAnnotation(FieldConvert.class);
                if (fieldConvert==null){
                    throw new RuntimeException(object.getName() + "中实体类不能为做请求参数:" + field.getType().getSimpleName());
                }
            }else {
                FieldBean bean = new FieldBean();
                bean.setId(field.getName());
                bean.setType(field.getType().getSimpleName());
                bean.setFullType(field.getType().getName());
                bean.setFieldType(104);
                updateComment(field, bean);
                formBean.getResponses().add(bean);
            }

        }
    }
}
