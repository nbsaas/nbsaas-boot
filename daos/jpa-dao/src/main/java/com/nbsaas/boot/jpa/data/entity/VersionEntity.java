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

import javax.persistence.MappedSuperclass;

/**
 * 版本同步实体
 *
 * @author aniaojian
 */

@Data
@MappedSuperclass
public class VersionEntity extends AbstractEntity {

    /**
     * 版本号.
     */

    @Comment("数据版本号")
    private Long versionNum;

    /**
     * 状态 1 为增加 2为更新 3为删除.
     */
    @Comment("数据状态")
    private Integer state;


}
