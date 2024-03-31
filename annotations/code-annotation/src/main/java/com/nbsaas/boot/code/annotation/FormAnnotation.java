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

package com.nbsaas.boot.code.annotation;


import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FormAnnotation {

    /**
     * 标题
     *
     * @return
     */
    String title() default "";

    /**
     * 模型名称
     *
     * @return
     */
    String model() default "";

    /**
     * 当前菜单编码
     *
     * @return
     */
    String menu() default "";

    /**
     * 搜索区域宽度
     *
     * @return
     */
    String searchWidth() default "80";

    /**
     * 详情区域宽度
     *
     * @return
     */
    String viewWidth() default "80";

    /**
     * 操作区域宽度
     *
     * @return
     */
    String handleWidth() default "210";

    /**
     * 表格是否有操作区域
     *
     * @return
     */
    boolean showHandle() default true;


    /**
     * 模型类型   0:数据表 1:视图 2:自定义查询 3:储存过程
     *
     * @return
     */
    int modelType() default 0;

}
