package com.bonc.valid;

import com.bonc.controller.ValidCodeController;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:ChenZhiXiang
 * @Description: 验证码的过滤器
 * @Date:Created in 21:58 2018/8/6
 * @Modified By:
 */
public class ValidCodeFilter extends OncePerRequestFilter {

    private AuthenticationFailureHandler authenticationFailureHandler;

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    public AuthenticationFailureHandler getAuthenticationFailureHandler() {
        return authenticationFailureHandler;
    }

    public void setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
        this.authenticationFailureHandler = authenticationFailureHandler;
    }

    public SessionStrategy getSessionStrategy() {
        return sessionStrategy;
    }

    public void setSessionStrategy(SessionStrategy sessionStrategy) {
        this.sessionStrategy = sessionStrategy;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //在请求登录时才调用此方法
        if (StringUtils.equals("/user/login",request.getRequestURI()) && StringUtils.equalsIgnoreCase(request.getMethod(),"post")){
            try {
                validate(new ServletWebRequest(request));
            }catch (ValidCodeException e){
                authenticationFailureHandler.onAuthenticationFailure(request,response,e);
                return;
            }
        }
        filterChain.doFilter(request,response);
    }

    private void validate(ServletWebRequest servletWebRequest) throws ServletRequestBindingException {
        ImageCode codeInSession = (ImageCode) sessionStrategy.getAttribute(servletWebRequest,ValidCodeController.SESSION_KEY);
        String codeInRequest = ServletRequestUtils.getStringParameter(servletWebRequest.getRequest(),"imageCode");

        if (StringUtils.isBlank(codeInRequest)){
            throw new ValidCodeException("验证码的值不能为空");
        }
        if (codeInSession == null){
            throw new ValidCodeException("验证码不存在");
        }
        if (codeInSession.isExpried()){
            sessionStrategy.removeAttribute(servletWebRequest,ValidCodeController.SESSION_KEY);
            throw new ValidCodeException("验证码已过期");
        }
        if (!StringUtils.equals(codeInSession.getCode().toLowerCase(),codeInRequest.toLowerCase())){
            throw new ValidCodeException("验证码不匹配");
        }
        sessionStrategy.removeAttribute(servletWebRequest,ValidCodeController.SESSION_KEY);
    }
}
