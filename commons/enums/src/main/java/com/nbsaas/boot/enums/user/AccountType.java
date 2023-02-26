package com.nbsaas.boot.enums.user;

/**
 * 账号类型
 * <p>
 * Created by ada on 2016/12/15.
 */
public enum AccountType {
    Phone, Email, Account;

    @Override
    public String toString() {
        if (name().equals("Phone")) {
            return "手机账号";
        } else if (name().equals("Email")) {
            return "邮件账号";
        } else if (name().equals("Account")) {
            return "普通账号";
        }
        return super.toString();
    }
}
