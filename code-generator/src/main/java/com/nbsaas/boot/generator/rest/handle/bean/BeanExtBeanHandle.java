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

package com.nbsaas.boot.generator.rest.handle.bean;

import com.nbsaas.boot.code.annotation.BeanExt;
import com.nbsaas.boot.code.annotation.FormExtField;
import com.nbsaas.boot.generator.beans.FieldBean;
import com.nbsaas.boot.generator.beans.FormBean;
import com.nbsaas.boot.generator.api.apis.BeanHandle;
import com.nbsaas.boot.generator.rest.handle.untils.FieldUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;

public class BeanExtBeanHandle implements BeanHandle {
    @Override
    public void handle(Class<?> object, FormBean formBean) {
        //查找扩展bean
        BeanExt beanExt = object.getAnnotation(BeanExt.class);
        if (beanExt != null) {
            FormExtField[] items = beanExt.items();
            if (items == null) {
                return;
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
                if (StringUtils.isNotBlank(item.parent())){
                    if (!FieldUtils.isBasicType(item.fieldClass())) {
                        bean.setFullType(item.fieldClass().getName());
                        bean.setFieldType(100);
                    } else {
                        bean.setFieldType(101);
                    }
                }else{
                    //如果没有父字段值  判断是否有其他字段值，要是转换自己的子的字段
                    if (StringUtils.isNotBlank(item.parentField())){
                        bean.setFieldType(102);
                    }else{
                        bean.setFieldType(103);
                    }
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
    }
}
