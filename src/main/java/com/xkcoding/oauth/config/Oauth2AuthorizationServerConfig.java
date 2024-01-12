package com.xkcoding.oauth.config;

import com.xkcoding.oauth.service.SysClientDetailsService;
import com.xkcoding.oauth.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/**
 * .
 *
 * @author <a href="https://echocow.cn">EchoCow</a>
 * @date 2020-01-06 13:32
 */
@Configuration
@RequiredArgsConstructor
@EnableAuthorizationServer
public class Oauth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
  private final SysClientDetailsService sysClientDetailsService;
  private final SysUserService sysUserService;
  private final TokenStore tokenStore;
  private final AuthenticationManager authenticationManager;
  private final JwtAccessTokenConverter jwtAccessTokenConverter;


  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
    //认证管理对象 spring security
    endpoints.authenticationManager(authenticationManager)
      //todo 重写security 从db获取 用户名密码校验
      .userDetailsService(sysUserService)
      //spring security 内存token
      .tokenStore(tokenStore)
      //spring security jwt
      .accessTokenConverter(jwtAccessTokenConverter);
  }

  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    // 从数据库读取我们自定义的客户端信息
    // todo 客户端信息 重定向地址 客户端密钥等 (判断/oauth/token 是否有权限) 使用jdbc
    clients.withClientDetails(sysClientDetailsService);


//      clients.withClientDetails(new SysClientDetailsService() {
//        @Override
//        public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
//          return new ClientDetails();
//        }
//      });
  }

  @Override
  public void configure(AuthorizationServerSecurityConfigurer security) {
    //使用client_id和client_secret来进行身份验证，而不是通过Authorization头
    security.allowFormAuthenticationForClients()
      // 获取 token key 需要进行 basic 认证客户端信息
      //.tokenKeyAccess("isAuthenticated()")
//      .tokenKeyAccess("permitAll()")
//      // 获取 token 信息同样需要 basic 认证客户端信息
//      //.checkTokenAccess("isAuthenticated()");
//      .checkTokenAccess("permitAll()")
    ;
  }
}
