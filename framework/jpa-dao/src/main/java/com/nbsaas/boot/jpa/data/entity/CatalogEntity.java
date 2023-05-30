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

package com.nbsaas.boot.jpa.data.entity;


import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 分类基础类
 *
 * @author 年高
 */

@Data
@MappedSuperclass
public abstract class CatalogEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("主键id")
    private Long id;


    @Comment("名称")
    private String name;


    @Comment("排序号")
    private Integer sortNum;

    @Comment("编码")
    @Column(length = 50)
    private String code;

    @Comment("ids")
    private String ids;

    @Comment("左节点")
    private Integer lft;


    @Comment("右节点")
    private Integer rgt;

    @Comment("深度")
    private Integer depth;


    @Comment("添加时间")
    private Date addDate;

    @Comment("最新修改时间")
    private Date lastDate;


}
