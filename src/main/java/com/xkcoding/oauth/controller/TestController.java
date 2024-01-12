package com.xkcoding.oauth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.provider.endpoint.AuthorizationEndpoint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


@RestController
@RequiredArgsConstructor
public class TestController {


    @PostMapping ("/test")
    public String getAccessConfirmation() {
        return "TEST";
    }

}
