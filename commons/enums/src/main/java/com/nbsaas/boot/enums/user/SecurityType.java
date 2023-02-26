package com.nbsaas.boot.enums.user;

public enum SecurityType {

    account, pay, authentication, authorization, other;

    @Override
    public String toString() {
        if (name().equals("account")) {
            return "密码认证";
        } else if (name().equals("pay")) {
            return "支付认证";
        } else if (name().equals("authentication")) {
            return "认证";
        } else if (name().equals("authorization")) {
            return "授权";
        } else if (name().equals("other")) {
            return "其他";
        }
        return super.toString();
    }
}
