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

package com.nbsaas.boot.generator.rest.resource;

import com.nbsaas.boot.generator.api.apis.BeanCollector;
import com.nbsaas.boot.generator.api.apis.BeanHandle;
import com.nbsaas.boot.generator.api.apis.FieldCollector;
import com.nbsaas.boot.generator.api.apis.FieldHandle;
import com.nbsaas.boot.generator.beans.FormBean;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FormBeanHandleResource implements BeanCollector {

    private FieldCollector fieldCollector;


    public boolean add(FieldHandle fieldHandle) {
        return fieldHandles.add(fieldHandle);
    }

    public boolean addAllField(Collection<FieldHandle> fieldHandle) {
        if (fieldHandle == null) {
            return false;
        }
        return fieldHandles.addAll(fieldHandle);
    }

    public boolean add(BeanHandle fieldHandle) {
        return beanHandles.add(fieldHandle);
    }

    private final List<FieldHandle> fieldHandles = new ArrayList<>();

    private final List<BeanHandle> beanHandles = new ArrayList<>();


    public FormBeanHandleResource(FieldCollector fieldCollector) {
        this.fieldCollector = fieldCollector;
    }

    public FormBeanHandleResource() {
        this.fieldCollector = new FieldCollectorResource();
    }

    @Override
    public FormBean collect(Class<?> object) {
        FormBean result = new FormBean();

        List<Field> fields = fieldCollector.getAllFields(object);


        for (Field field : fields) {
            for (FieldHandle fieldHandle : fieldHandles) {
                fieldHandle.handle(object, field, result);
            }
        }


        for (BeanHandle beanHandle : beanHandles) {
            beanHandle.handle(object, result);
        }

        return result;
    }
}
