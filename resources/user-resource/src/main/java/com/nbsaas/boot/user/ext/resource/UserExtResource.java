package com.nbsaas.boot.user.ext.resource;

import com.nbsaas.boot.enums.user.AccountType;
import com.nbsaas.boot.enums.user.SecurityType;
import com.nbsaas.boot.rest.filter.Filter;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.user.api.apis.UserAccountApi;
import com.nbsaas.boot.user.api.apis.UserInfoApi;
import com.nbsaas.boot.user.api.apis.UserPasswordApi;
import com.nbsaas.boot.user.api.domain.request.UserAccountDataRequest;
import com.nbsaas.boot.user.api.domain.request.UserInfoDataRequest;
import com.nbsaas.boot.user.api.domain.request.UserPasswordDataRequest;
import com.nbsaas.boot.user.api.domain.response.UserAccountExtResponse;
import com.nbsaas.boot.user.api.domain.response.UserAccountResponse;
import com.nbsaas.boot.user.api.domain.response.UserInfoResponse;
import com.nbsaas.boot.user.api.domain.response.UserPasswordResponse;
import com.nbsaas.boot.user.ext.apis.UserExtApi;
import com.nbsaas.boot.user.ext.domain.request.UserLoginRequest;
import com.nbsaas.boot.user.ext.domain.request.UserRegisterRequest;
import com.nbsaas.boot.user.ext.domain.response.UserInfoExtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
public class UserExtResource implements UserExtApi {

    @Autowired
    private UserAccountApi userAccountApi;

    @Autowired
    private UserPasswordApi userPasswordApi;

    @Autowired
    private UserInfoApi userInfoApi;

    @Transactional
    @Override
    public ResponseObject<UserAccountExtResponse> account(String username, AccountType accountType) {
        return password(username, accountType);
    }

    @Transactional
    @Override
    public ResponseObject<UserAccountExtResponse> password(String username, AccountType accountType) {
        ResponseObject<UserAccountExtResponse> result = new ResponseObject<>();

        UserAccountResponse userAccount = userAccountApi.oneData(Filter.eq("username", username),
                Filter.eq("accountType", AccountType.Phone));
        if (userAccount == null) {
            result.setCode(501);
            result.setMsg("账号不存在");
            return result;
        }
        UserPasswordResponse security = userPasswordApi.oneData(Filter.eq("user.id", userAccount.getUser()));
        if (security == null) {
            result.setCode(502);
            result.setMsg("没有设置密码");
            return result;
        }
        UserInfoResponse user = userInfoApi.oneData(Filter.eq("id", security.getUser()));
        if (user == null) {
            result.setCode(503);
            result.setMsg("无效用户信息");
            return result;
        }
        UserAccountExtResponse res = new UserAccountExtResponse();
        res.setAccountType(accountType);
        res.setUsername(username);
        res.setSalt(security.getSalt());
        res.setPassword(security.getPassword());
        res.setUserData(user);

        result.setData(res);
        return result;
    }

    @Override
    public boolean checkRegister(String phone) {
        Long num = userAccountApi.countData(Filter.eq("username", phone),
                Filter.eq("accountType", AccountType.Phone));
        if (num == null) {
            num = 0L;
        }
        if (num > 0) {
            return false;
        } else {
            return true;

        }
    }

    @Override
    public ResponseObject<UserInfoExtResponse> login(UserLoginRequest request) {
        //SecurityUtils.getSubject().logout();

        return null;
    }

    @Transactional
    @Override
    public ResponseObject<UserInfoResponse> register(UserRegisterRequest request) {
        ResponseObject<UserInfoResponse> result = new ResponseObject<>();
        if (request.getUsername() == null) {
            result.setCode(502);
            result.setMsg("手机号不能为空");
            return result;
        }
        /**
         * 描述：查询user账户是否被备注
         */
        Long num = userAccountApi.countData(Filter.eq("accountType", AccountType.Phone),
                Filter.eq("username", request.getUsername()));
        if (num == null) {
            num = 0L;
        }
        if (num > 0) {
            result.setCode(503);
            result.setMsg("该用户名已被使用");
            return result;
        }
        /**
         * 描述：user表写入
         */
        UserInfoDataRequest userForm = new UserInfoDataRequest();
        userForm.setName(request.getUsername());
        userForm.setPhone(request.getUsername());
        UserInfoResponse response = userInfoApi.createData(userForm);

        /**
         * 描述：user账户表写入
         */
        UserAccountDataRequest userAccount = new UserAccountDataRequest();
        userAccount.setAccountType(AccountType.Phone);
        userAccount.setUsername(request.getUsername());
        userAccount.setLoginSize(0);
        userAccount.setUser(response.getId());
        userAccountApi.createData(userAccount);


        UserPasswordDataRequest userPassword = new UserPasswordDataRequest();
        //PasswordResponse password = PasswordUtils.password(request.getPassword());
        userPassword.setSalt(request.getSalt());
        userPassword.setPassword(request.getDbPassword());
        userPassword.setUser(response.getId());
        userPassword.setSecurityType(SecurityType.account);
        userPassword.setAddDate(new Date());
        userPassword.setLastDate(new Date());
        userPasswordApi.createData(userPassword);

        return result;
    }
}
