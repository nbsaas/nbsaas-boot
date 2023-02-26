package com.nbsaas.boot.user.ext.domain.request;

import com.nbsaas.boot.rest.request.RequestObject;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserLoginRequest extends RequestObject {

    @NotEmpty(message = "手机号不能为空")
    private String username;


    @NotEmpty(message = "密码不能为空")
    private String password;

}
