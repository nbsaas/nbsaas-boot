package com.nbsaas.boot.security.config;

import com.nbsaas.boot.security.listener.BasicAuthenticationListener;
import com.nbsaas.boot.security.realm.PasswordRealm;
import org.apache.shiro.authc.AbstractAuthenticator;
import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ada
 */
@Configuration
public class ShiroConfig {

    protected static final long MILLIS_PER_SECOND = 1000;
    protected static final long MILLIS_PER_MINUTE = 60 * MILLIS_PER_SECOND;
    protected static final long MILLIS_PER_HOUR = 60 * MILLIS_PER_MINUTE;

    @Bean(name = "shiroRealm")
    @DependsOn("lifecycleBeanPostProcessor")
    public PasswordRealm shiroRealm() {
        PasswordRealm realm = new PasswordRealm();
        //realm.setCacheManager(redisCacheManager());
        return realm;
    }


    @Bean
    public MySessionManager sessionManager() {
        MySessionManager sessionManager = new MySessionManager();
        sessionManager.setGlobalSessionTimeout(ShiroConfig.MILLIS_PER_MINUTE * 60 * 24 * 20);
        // sessionManager.setSessionDAO(sessionDAO());
        return sessionManager;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
        securityManager.setSessionManager(sessionManager());
        //securityManager.setCacheManager(redisCacheManager());
        Authenticator authenticator = securityManager.getAuthenticator();
        if (authenticator instanceof AbstractAuthenticator) {
            AbstractAuthenticator a = (AbstractAuthenticator) authenticator;
            a.getAuthenticationListeners().add(listener());
        }
        return securityManager;
    }

    @Bean
    public BasicAuthenticationListener listener() {
        BasicAuthenticationListener result = new BasicAuthenticationListener();
        return result;
    }

    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
        daap.setProxyTargetClass(true);
        return daap;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String, String> filterChainDefinitionManager = new LinkedHashMap<>();
        filterChainDefinitionManager.put("/loginFront", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionManager);

        shiroFilterFactoryBean.setSuccessUrl("/loginSuccess");
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setLoginUrl("/loginFront");

        return shiroFilterFactoryBean;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
        aasa.setSecurityManager(securityManager);
        return aasa;
    }


}
