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

import com.nbsaas.boot.code.annotation.SearchItem;
import com.nbsaas.boot.generator.beans.FieldBean;
import com.nbsaas.boot.generator.beans.FormBean;
import com.nbsaas.boot.generator.rest.handle.base.BaseFieldHandle;
import com.nbsaas.boot.generator.rest.handle.untils.FieldUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

public class SearchFieldHandle extends BaseFieldHandle {
    @Override
    public void handle(Class<?> object, Field field, FormBean formBean) {
        SearchItem annotation = field.getAnnotation(SearchItem.class);
        if (annotation == null) {
            return;
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
        updateComment(field, bean);


        bean.setKey(annotation.key());
        bean.setOperator(annotation.operator().name());
        Integer sortNum = FieldUtils.getInteger(annotation);
        bean.setSortNum(sortNum);
        bean.setShow(annotation.show());
        if (StringUtils.isEmpty(bean.getTitle())) {
            bean.setTitle(field.getName());
        }
        if (StringUtils.isEmpty(bean.getKey())) {
            bean.setKey(field.getName());
        }
        if (StringUtils.isEmpty(bean.getId())) {
            bean.setId(field.getName());
        }
        if (StringUtils.isEmpty(bean.getPlaceholder())) {
            bean.setPlaceholder(bean.getTitle());
        }
        bean.setApi(annotation.api());
        if (StringUtils.isEmpty(bean.getApi())) {
            bean.setApi(annotation.name());
        }
        formBean.getSearches().add(bean);
    }
}
