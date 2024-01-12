## oauth2-springboot-authorization


- [springboot-demo](https://github.com/dyc87112/SpringBoot-Learning)：基础代码来源
当中代码有部分感觉有歧义 而且在与datart oauth2.0 调试中出现问题 于是修改一版本

详细部分参考README.adoc

datart配置参考
```yaml

security:
  oauth2:
    client:
      registration:
        cas:
          provider: cas
          client-id: oauth2
          client-name: "Sign in with CAS"
          client-secret: oauth2
          #authorization-grant-type: authorization_code
          authorization-grant-type: authorization_code
          client-authentication-method: post
          redirect-uri: "{baseUrl}/login/oauth2/code/{registrationId}"
          scope: WRITE
      provider:
        cas:
          #访问datart重定向到此地址授权页面 datart调用本服务（oauth2框架提供）
          authorization-uri: http://macbook1:8080/oauth/authorize
          #带着授权码获取token接口 datart调用本服务（oauth2框架提供）
          token-uri: http://macbook1:8080/oauth/token
          #用户信息获取 datart调用本服务（手写代码）
          user-info-uri: http://macbook1:8080/demo/userinfo
          user-name-attribute: id
          userMapping:
            email: "attributes.email"
            name: "attributes.name"
            avatar: "attributes.avatar"
```


