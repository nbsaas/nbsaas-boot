package com.nbsaas.boot.security.realm;

import com.nbsaas.boot.enums.user.AccountType;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.user.api.domain.response.UserAccountExtResponse;
import com.nbsaas.boot.user.ext.apis.UserExtApi;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;


/**
 * 获取用户的角色和权限信息
 * Created by bamboo on 2017/5/10.
 */
public class ShiroRealm extends AuthorizingRealm {

    @Resource
    private UserExtApi userExtApi;


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        ResponseObject<UserAccountExtResponse> res = userExtApi.account(token.getUsername(), AccountType.Account);
        if (res.getCode() != 200) {
            throw new AccountException(res.getMsg());
        }
        UserAccountExtResponse user = res.getData();
        return new SimpleAuthenticationInfo(user.getUserData(), user.getPassword(), getName());

    }

    /**
     * 权限认证
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //用户的角色集合
        info.addRole("front");
        //用户的权限集合
        info.addStringPermission("front");
        return info;
    }


}