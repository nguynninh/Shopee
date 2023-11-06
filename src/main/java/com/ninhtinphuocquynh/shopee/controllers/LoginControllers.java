package com.ninhtinphuocquynh.shopee.controllers;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sso")
public class LoginControllers {
    @GetMapping("/signin_google")
    public Map<String, Object> loginGoogle(OAuth2AuthenticationToken authenticationToken) {
        if (authenticationToken != null) {
            return authenticationToken.getPrincipal().getAttributes();
        } else {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Authentication token is null");
            return errorResponse;
        }
    }
}

