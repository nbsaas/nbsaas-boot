package com.nbsaas.boot.user.api.domain.response;

import lombok.Data;

@Data
public class UserAccountExtResponse extends UserAccountResponse {

    private UserInfoResponse userData;

    private String phone;

    private String password;

    private String salt;
}
