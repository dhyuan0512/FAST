package com.cy.fast.common.config;

import java.util.LinkedHashMap;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringShiroConfig {

    /**
     * 配置SecurityManager对象(shiro核心安全管理器对象)
     */
    @Bean
    public SecurityManager securityManager(Realm realm) {
        DefaultWebSecurityManager sManager = new DefaultWebSecurityManager();
        sManager.setRealm(realm);
        return sManager;
    }

    /**
     * 配置ShiroFilterFactoryBean对象，通过此对象
     * 创建过滤器工厂，并指定过滤规则
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactory(SecurityManager securityManager) {
        ShiroFilterFactoryBean sfBean = new ShiroFilterFactoryBean();
        sfBean.setSecurityManager(securityManager);
        //未认证先跳转
        sfBean.setLoginUrl("/doLoginUI");
        //定义map指定请求过滤规则(哪些资源允许匿名访问,哪些必须认证访问)
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        //静态资源允许匿名访问:"anon"
        map.put("/bower_components/**", "anon");
        map.put("/build/**", "anon");
        map.put("/dist/**", "anon");
        map.put("/plugins/**", "anon");
        map.put("/user/doLogin", "anon");
        map.put("/doLogout", "logout");
        map.put("/index", "anon");
        map.put("/shop_cart", "anon");
        map.put("/swagger-ui.html", "anon");
        map.put("/swagger-resources", "anon");
        map.put("/v2/api-docs", "anon");
        map.put("/webjars/springfox-swagger-ui/**", "anon");
        map.put("/configuration/security", "anon");
        map.put("/configuration/ui", "anon");
        //除了匿名访问的资源,其它都要认证("authc")后访问
        map.put("/**", "authc");
        sfBean.setFilterChainDefinitionMap(map);
        return sfBean;
    }
}
