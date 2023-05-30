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

package com.nbsaas.boot.generator.entity;

import com.nbsaas.boot.code.annotation.FormAnnotation;
import com.nbsaas.boot.code.annotation.FormField;
import com.nbsaas.boot.code.annotation.InputType;
import lombok.Data;

import java.util.Date;

/**
 * Entity - 广告
 */

@FormAnnotation(title = "广告管理", model = "广告", menu = "1,51,53")
@Data
public class Ad {

    /**
     * 标题
     */
    @FormField(title = "广告名称", sortNum = "10", grid = true, col = 22, required = true)
    private String title;


    /**
     * 路径
     */
    @FormField(title = "广告图片", sortNum = "20", grid = true, col = 22, type = InputType.image)
    private String path;

    /**
     * 起始日期
     */
    @FormField(title = "广告开始时间", sortNum = "20", grid = true, col = 22, type = InputType.el_date_time_picker)
    private Date beginDate;

    /**
     * 结束日期
     */
    @FormField(title = "广告结束时间", sortNum = "30", grid = true, col = 22, type = InputType.el_date_time_picker)
    private Date endDate;

    /**
     * 链接地址
     */
    @FormField(title = "链接地址", sortNum = "40", grid = true, col = 22)
    private String url;


    /**
     * 分类
     */
    private Integer catalog;


    @FormField(title = "内容", sortNum = "60", grid = true, col = 22, type = InputType.textarea)
    private String note;

    private Long bussId;

}