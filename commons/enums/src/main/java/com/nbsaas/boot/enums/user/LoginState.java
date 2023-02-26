package com.nbsaas.boot.enums.user;

public enum LoginState {
    fail, success, out;

    @Override
    public String toString() {
        if (name().equals("fail")) {
            return "登陆失败";
        } else if (name().equals("success")) {
            return "登陆成功";
        } else if (name().equals("out")) {
            return "退出登录";
        }
        return super.toString();
    }
}
