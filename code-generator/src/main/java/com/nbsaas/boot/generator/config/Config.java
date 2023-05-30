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

package com.nbsaas.boot.generator.config;

import lombok.Data;

import java.util.List;


@Data
public class Config {


    /**
     * 是否启用多模块
     */
    private Boolean multiple;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目路径
     */
    private String outputPath;


    private String base;
    /**
     * 模板路径
     */
    private String templateDir;
    /**
     * 基础包名称
     */
    private String basePackage;
    /**
     * 实体类路径
     */
    private String entityPackage;
    /**
     * 需要生成的实体类
     */
    private List<String> entities;

    public String getBasePackage() {
        if (multiple) {
            return basePackage + "." + projectName;
        }
        return basePackage;
    }

    public String getSimplePackage() {
        return basePackage;
    }

    public String getBasicPackage() {
        return basePackage;
    }

}
