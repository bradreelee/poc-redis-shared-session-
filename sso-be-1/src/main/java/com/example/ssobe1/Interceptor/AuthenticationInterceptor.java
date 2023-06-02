package com.example.ssobe1.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return false;
        }

        String userName = (String) session.getAttribute("user");
        if ("brad".equals(userName)) {
            return true;
        }
        return false;
    }
}
