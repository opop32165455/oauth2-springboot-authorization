package com.xkcoding.oauth.service.impl;

import cn.hutool.core.collection.ListUtil;
import com.xkcoding.oauth.entity.SysUser;
import com.xkcoding.oauth.repostiory.SysUserRepository;
import com.xkcoding.oauth.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户相关操作.
 *
 * @author <a href="https://echocow.cn">EchoCow</a>
 * @date 2020-01-06 15:06
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl implements SysUserService {


  private final SysUserRepository sysUserRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    SysUser sysUser = sysUserRepository.findFirstByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    List<SimpleGrantedAuthority> roles = sysUser.getRoles().stream().map(sysRole -> new SimpleGrantedAuthority(sysRole.getName())).collect(Collectors.toList());
    // 在这里手动构建 UserDetails 的默认实现
    return new User(sysUser.getUsername(), sysUser.getPassword(), roles);
  }

}
