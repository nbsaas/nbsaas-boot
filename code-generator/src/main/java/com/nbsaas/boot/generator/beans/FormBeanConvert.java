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


import com.nbsaas.boot.generator.entity.Ad;
import com.nbsaas.boot.generator.api.apis.BeanHandle;
import com.nbsaas.boot.generator.rest.handle.base.BaseFieldHandle;
import com.nbsaas.boot.generator.rest.resource.FormBeanHandleResource;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.Set;

public class FormBeanConvert {


    public FormBean convertClass(Class<?> object) {
        FormBeanHandleResource resource=new FormBeanHandleResource();


        Reflections fieldReflections = new Reflections("com.nbsaas.boot.generator.rest.handle.field");
        Set<Class<? extends BaseFieldHandle>> handleList = fieldReflections.getSubTypesOf(BaseFieldHandle.class);
        for (Class<? extends BaseFieldHandle> handle : handleList) {
            if (Modifier.isAbstract(handle.getModifiers())) {
                continue;
            }
            try {
                BaseFieldHandle beanHandle = handle.newInstance();
                resource.add(beanHandle);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        Reflections beanReflections = new Reflections("com.nbsaas.boot.generator.rest.handle.bean");
        Set<Class<? extends BeanHandle>> handleBeanList = beanReflections.getSubTypesOf(BeanHandle.class);
        for (Class<? extends BeanHandle> handle : handleBeanList) {
            if (Modifier.isAbstract(handle.getModifiers())) {
                continue;
            }
            try {
                BeanHandle beanHandle = handle.newInstance();
                resource.add(beanHandle);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }


        return    resource.collect(object);



    }

    public static void main(String[] args) {
        FormBeanConvert formBeanConvert = new FormBeanConvert();
        FormBean bean = formBeanConvert.convertClass(Ad.class);
        System.out.println(bean);
    }


}
