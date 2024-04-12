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

import com.nbsaas.boot.code.annotation.SearchBean;
import com.nbsaas.boot.code.annotation.SearchItem;
import com.nbsaas.boot.generator.beans.FieldBean;
import com.nbsaas.boot.generator.beans.FormBean;
import com.nbsaas.boot.generator.api.apis.BeanHandle;
import com.nbsaas.boot.generator.rest.handle.untils.FieldUtils;
import org.apache.commons.lang3.StringUtils;

public class SearchBeanHandle implements BeanHandle {
    @Override
    public void handle(Class<?> object, FormBean formBean) {
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
                    if (!FieldUtils.isBasicType(item.classType())) {
                        fieldBean.setFieldType(5);
                    }
                    fieldBean.setKey(item.key());
                    fieldBean.setOperator(item.operator().name());
                    fieldBean.setShow(item.show());
                    Integer sortNum = FieldUtils.getInteger(item);
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
                    fieldBean.setComment(item.label());
                    formBean.getSearches().add(fieldBean);
                }
            }
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
