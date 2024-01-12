package com.xkcoding.oauth.service;

import com.xkcoding.oauth.entity.SysClientDetails;
import org.springframework.security.oauth2.provider.ClientAlreadyExistsException;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationService;
import org.springframework.security.oauth2.provider.NoSuchClientException;

import java.util.List;

/**
 * 声明自己的实现.
 * 参见 {@link ClientRegistrationService}
 *
 * @author <a href="https://echocow.cn">EchoCow</a>
 * @date 2020-01-06 13:39
 */
public interface SysClientDetailsService extends ClientDetailsService {
}
