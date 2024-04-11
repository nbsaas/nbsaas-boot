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

import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.generator.api.apis.BeanHandle;
import com.nbsaas.boot.generator.beans.FormBean;

public class BasicFormBeanHandle implements BeanHandle {
    @Override
    public void handle(Class<?> object, FormBean formBean) {
        formBean.setClassName(object.getSimpleName());

        FormAnnotation formAnnotation = object.getAnnotation(FormAnnotation.class);
        if (formAnnotation != null) {
            formBean.setTitle(formAnnotation.title());
            formBean.setMenu(formAnnotation.menu());
            formBean.setViewWidth(formAnnotation.viewWidth());
            formBean.setSearchWidth(formAnnotation.searchWidth());
            formBean.setHandleWidth(formAnnotation.handleWidth());
            formBean.setModel(formAnnotation.model());
            formBean.setShowHandle(formAnnotation.showHandle());
            formBean.setModelType(formAnnotation.modelType());
            formBean.setSortField(formAnnotation.sortField());
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
    }
}
