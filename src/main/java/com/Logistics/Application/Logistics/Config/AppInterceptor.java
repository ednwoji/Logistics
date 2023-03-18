package com.Logistics.Application.Logistics.Config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
public class AppInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        String requestURI = request.getRequestURI();

        //Do whatever you need
        if(request.getRequestURI().contains("/logistics")){
            HttpSession session = request.getSession();

            String user = (String) session.getAttribute("userName");
            String role = (String) session.getAttribute("userRole");

            if (user == null || role == null) {

                request.setAttribute("error", "Unauthorized Access, please login");
                log.info("Redirecting");
                response.sendRedirect("/home");
                return false;
            }
        }


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("In the PostHandle method");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("In the afterCompletion method");
    }
}
