package com.crud.demo.ws;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.*;
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getRequestURI();

        // Vérifie si l'utilisateur est connecté
        if (!isLoggedIn(request.getSession())) {
            response.sendRedirect("/login");
            return false;
        }

        return true;
    }

    private boolean isLoggedIn(HttpSession session) {
        // Vérifie si l'utilisateur est connecté en vérifiant la présence d'une clé dans la session
        return session.getAttribute("user") != null;
    }
}