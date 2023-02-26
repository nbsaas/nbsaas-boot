package com.nbsaas.boot.enums.user;

public enum BindType {
    phone, email, account, other;

    @Override
    public String toString() {
        if (name().equals("phone")) {
            return "手机";
        } else if (name().equals("email")) {
            return "邮箱";
        } else if (name().equals("account")) {
            return "账号";
        } else if (name().equals("other")) {
            return "其他";
        }
        return super.toString();
    }
}
