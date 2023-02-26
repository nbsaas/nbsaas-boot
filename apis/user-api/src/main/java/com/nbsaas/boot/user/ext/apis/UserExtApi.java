package com.nbsaas.boot.user.ext.apis;

import com.nbsaas.boot.enums.user.AccountType;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.user.api.domain.response.UserAccountExtResponse;
import com.nbsaas.boot.user.api.domain.response.UserInfoResponse;
import com.nbsaas.boot.user.ext.domain.request.UserLoginRequest;
import com.nbsaas.boot.user.ext.domain.request.UserRegisterRequest;
import com.nbsaas.boot.user.ext.domain.response.UserInfoExtResponse;

public interface UserExtApi {


    ResponseObject<UserAccountExtResponse> account(String username, AccountType accountType);

    ResponseObject<UserAccountExtResponse> password(String username, AccountType accountType);

    boolean checkRegister(String phone);


    ResponseObject<UserInfoExtResponse> login(UserLoginRequest request);

    ResponseObject<UserInfoResponse> register(UserRegisterRequest request);


}
