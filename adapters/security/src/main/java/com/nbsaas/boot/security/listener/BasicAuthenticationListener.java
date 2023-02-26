package com.nbsaas.boot.security.listener;

import com.nbsaas.boot.enums.user.LoginState;
import com.nbsaas.boot.rest.enums.StoreState;
import com.nbsaas.boot.security.utils.ServletUtil;
import com.nbsaas.boot.user.api.apis.UserLoginLogApi;
import com.nbsaas.boot.user.api.domain.request.UserLoginLogDataRequest;
import com.nbsaas.boot.user.api.domain.response.UserInfoResponse;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author ada
 */
public class BasicAuthenticationListener implements AuthenticationListener {


    @Lazy
    @Resource
    private UserLoginLogApi userLoginLogApi;

    @Override
    public void onSuccess(AuthenticationToken token, AuthenticationInfo info) {
        UserLoginLogDataRequest req = new UserLoginLogDataRequest();
        req.setAddDate(new Date());
        req.setState(LoginState.success);
        req.setStoreState(StoreState.normal);
        if (token instanceof UsernamePasswordToken) {
            UsernamePasswordToken passwordToken = (UsernamePasswordToken) token;
            req.setAccount(passwordToken.getUsername());
            req.setIp(passwordToken.getHost());
        }
        req.setClient("后台登录");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        if (request != null) {
            String ip = ServletUtil.getIpAddr(request);
            if (req.getIp() == null) {
                req.setIp(ip);
            }
        }
        PrincipalCollection collection = info.getPrincipals();
        Object user = collection.getPrimaryPrincipal();
        if (user instanceof UserInfoResponse) {
            UserInfoResponse cur = (UserInfoResponse) user;
            req.setUser(cur.getId());
        }
        req.setNote("登录成功");
        userLoginLogApi.create(req);
    }

    @Override
    public void onFailure(AuthenticationToken token, AuthenticationException ae) {
        UserLoginLogDataRequest req = new UserLoginLogDataRequest();
        req.setAddDate(new Date());
        req.setState(LoginState.success);
        req.setStoreState(StoreState.normal);
        if (token instanceof UsernamePasswordToken) {
            UsernamePasswordToken passwordToken = (UsernamePasswordToken) token;
            req.setAccount(passwordToken.getUsername());
            req.setPassword(new String(passwordToken.getPassword()));
            req.setIp(passwordToken.getHost());
        }
        req.setClient("后台登录");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        if (request != null) {
            String ip = ServletUtil.getIpAddr(request);
            if (req.getIp() == null) {
                req.setIp(ip);
            }
        }
        req.setNote("登录失败");
        userLoginLogApi.create(req);
    }

    @Override
    public void onLogout(PrincipalCollection principals) {

    }
}
