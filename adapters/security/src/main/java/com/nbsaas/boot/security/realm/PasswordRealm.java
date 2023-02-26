package com.nbsaas.boot.security.realm;

import com.nbsaas.boot.enums.user.AccountType;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.user.api.domain.response.UserAccountExtResponse;
import com.nbsaas.boot.user.ext.apis.UserExtApi;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.context.annotation.Lazy;

import javax.annotation.Resource;


/**
 * 获取用户的角色和权限信息
 * Created by bamboo on 2017/5/10.
 */
public class PasswordRealm extends AuthorizingRealm {


    @Lazy
    @Resource
    private UserExtApi userExtApi;


    public PasswordRealm() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        //matcher.setHashSalted(true);
        matcher.setHashIterations(2048);
        matcher.setHashAlgorithmName("SHA-256");
        matcher.setStoredCredentialsHexEncoded(false);
        setCredentialsMatcher(matcher);
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        ResponseObject<UserAccountExtResponse> res = userExtApi.password(token.getUsername(), AccountType.Phone);
        if (res.getCode() != 200) {
            throw new AccountException(res.getMsg());
        }
        UserAccountExtResponse user = res.getData();
        ByteSource salt = ByteSource.Util.bytes(Base64.decode(user.getSalt()));
        return new SimpleAuthenticationInfo(user.getUserData(), user.getPassword(), salt, getName());

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