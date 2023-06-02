package com.example.ssobe2.controller;

import com.example.ssobe2.model.LoginRequestVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @PostMapping(value = "login")
    public String login(@RequestBody LoginRequestVO loginRequestVO, HttpServletRequest request) {
        if("brad".equals(loginRequestVO.getUserId())) {
            HttpSession session = request.getSession();
            session.setAttribute("user", "brad");

            return "login success";
        }
        return "login fail";
    }

    @GetMapping(value = "logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "it was not logged in before";
        }

        if(session.getAttribute("user") == null) {
            return "already logged out";
        }

        session.removeAttribute("user");
        session.invalidate();
        return "logged out";
    }

    @GetMapping(value = "authentication-required")
    public String authenticationRequired(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "it was not logged in before";
        }
        String userName = (String) session.getAttribute("user");
        return userName + ": logged in";
    }

}
