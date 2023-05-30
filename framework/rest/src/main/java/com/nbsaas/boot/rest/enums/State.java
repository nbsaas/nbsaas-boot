package com.nbsaas.boot.rest.enums;
/*
 * 版权声明和许可协议
 *
 * 版权所有 (c) 2023 纽百特®
 * 版权所有，保留所有权利
 *
 * 本软件使用 MIT 许可协议进行许可，详情请参阅：
 *
 *   https://opensource.org/licenses/MIT
 *
 * 更多信息，请访问我们的网站：
 *
 *   http://www.nbsaas.com
 *
 * 纽百特® 是西安纽百特科技有限责任公司的注册商标，未经授权不得使用。
 */

/**
 * 状态.
 * <p>
 * Created by ada on 2017/6/27.
 */
public enum State {
    ENABLE, DISABLE, OPEN, CLOSE, ON, OFF;

    @Override
    public String toString() {
        if (name().equals("ENABLE")) {
            return "可用";
        } else if (name().equals("DISABLE")) {
            return "不可用";
        } else if (name().equals("OPEN")) {
            return "打开";
        } else if (name().equals("CLOSE")) {
            return "关闭";
        } else if (name().equals("ON")) {
            return "打开";
        } else if (name().equals("OFF")) {
            return "关闭";
        }
        return super.toString();
    }
}
