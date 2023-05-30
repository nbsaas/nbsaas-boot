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

package com.nbsaas.boot.generator.command.common;

import com.nbsaas.boot.generator.context.InputRequestObject;
import com.nbsaas.boot.rest.response.ResponseObject;

public class FinishCommand extends BaseCommand {
    @Override
    public ResponseObject handle(InputRequestObject context) {

        if (context.getFormBean() != null) {
            System.out.println(context.getFormBean().getClassName() + "代码生成完成");
        }
        return ResponseObject.success();
    }

    @Override
    public String outPath() {
        return null;
    }
}
