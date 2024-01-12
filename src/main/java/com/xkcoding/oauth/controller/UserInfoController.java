package com.xkcoding.oauth.controller;

import cn.hutool.core.map.MapUtil;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义确认授权页面.
 * 需要注意的是： 不能在代码中 setComplete，因为整个授权流程并没有结束
 * 我们只是在中途修改了它确认的一些信息而已。
 *
 * @author <a href="https://echocow.cn">EchoCow</a>
 * @date 2020-01-06 16:42
 */
@RestController
@RequiredArgsConstructor
public class UserInfoController {


  /**
   *
   * @return
   */
  @RequestMapping("/demo/userinfo")
  public Map<String, Object> getAccessConfirmation() {
    var userMap = new HashMap<String, String>() {
      {
        put("id", "1");
        put("name", "admin");
        put("email", "abc@gamil.com");
        put("avatar", "abc.jpg");
      }
    };
    return new HashMap<String, Object>() {
      {
        put("id", "1");
        put("attributes", userMap);
      }
    };
  }

}
