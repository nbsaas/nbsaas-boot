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

import com.nbsaas.boot.generator.beans.FieldBean;
import com.nbsaas.boot.generator.beans.FormBean;
import com.nbsaas.boot.generator.api.apis.BeanHandle;

import java.util.Collections;
import java.util.Comparator;

public class GridBeanHandle implements BeanHandle {
    @Override
    public void handle(Class<?> object, FormBean formBean) {

        Collections.sort(formBean.getGrids(),Comparator.comparing(FieldBean::getSortNum));

        int left = (int) (24 - (formBean.getSearches().stream().filter(FieldBean::isShow).count()%4)* 6);
        formBean.setLeftSize(left);
    }

    @Override
    public int getOrder() {
        return 100;
    }
}
