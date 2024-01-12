package com.xkcoding.oauth.service.impl;

import com.xkcoding.oauth.entity.SysClientDetails;
import com.xkcoding.oauth.repostiory.SysClientDetailsRepository;
import com.xkcoding.oauth.service.SysClientDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * 客户端 相关操作.
 *
 * @author <a href="https://echocow.cn">EchoCow</a>
 * @date 2020-01-06 13:37
 */
@Service
@RequiredArgsConstructor
public class SysClientDetailsServiceImpl implements SysClientDetailsService {
  private final SysClientDetailsRepository sysClientDetailsRepository;
  private final PasswordEncoder passwordEncoder;


    @Override
    public ClientDetails loadClientByClientId(String id) throws ClientRegistrationException {
        return sysClientDetailsRepository.findFirstByClientId(id).orElseThrow(() -> new ClientRegistrationException("Loading client exception."));
    }

}
