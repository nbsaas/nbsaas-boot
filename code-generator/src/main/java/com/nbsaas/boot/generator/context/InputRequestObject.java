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

package com.nbsaas.boot.generator.context;

import com.nbsaas.boot.generator.beans.FormBean;
import com.nbsaas.boot.generator.config.Config;
import com.nbsaas.boot.rest.request.RequestObject;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;


@Data
public class InputRequestObject extends RequestObject {


    private Config config;
    private FormBean formBean;
    private Map<String, Object> maps = new HashMap<>();

    public Object get(Object key) {
        return maps.get(key);
    }

    public Object put(String key, Object value) {
        return maps.put(key, value);
    }
}
