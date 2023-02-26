package com.nbsaas.boot.user.api.domain.field;


/**
 * description: user_password 用户密码信息 字段映射类
 */
public class UserPasswordField {


    /**
     * id
     */
    public static final String id = "id";

    /**
     * addDate 创建时间
     */
    public static final String addDate = "addDate";

    /**
     * lastDate 更新时间
     */
    public static final String lastDate = "lastDate";

    /**
     * checkSize 使用次数
     */
    public static final String checkSize = "checkSize";

    /**
     * password 密码
     */
    public static final String password = "password";

    /**
     * salt 加密盐
     */
    public static final String salt = "salt";

    /**
     * password_state 密码状态：1初始，2重置
     */
    public static final String passwordState = "password_state";

    /**
     * securityType 账号类型
     */
    public static final String securityType = "securityType";

    /**
     * user_id 用户Id
     */
    public static final String userId = "user_id";

}