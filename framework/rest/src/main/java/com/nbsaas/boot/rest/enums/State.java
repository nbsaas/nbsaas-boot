package com.nbsaas.boot.rest.enums;

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
