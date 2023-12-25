package com.nbsaas.boot.generator.handle.impl;


import com.nbsaas.boot.code.annotation.bean.StoreStateBean;
import com.nbsaas.boot.generator.beans.FormBean;
import com.nbsaas.boot.generator.handle.base.BaseFieldHandle;
import com.nbsaas.boot.rest.enums.StoreState;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 排序是否有储存类型字段
 */
public class StoreStateHandle extends BaseFieldHandle {

    @Override
    protected void handleField(Class<?> object, List<Field> fields, FormBean context) {
        if (fields != null) {
            for (Field field : fields) {
                if (field.getType() == StoreState.class) {
                    StoreStateBean bean = object.getAnnotation(StoreStateBean.class);
                    if (bean != null) {
                        context.setStoreState(true);
                        return;
                    }
                }
            }
        }
    }
}
