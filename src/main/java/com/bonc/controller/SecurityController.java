package com.bonc.controller;

import com.bonc.response.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:ChenZhiXiang
 * @Description:
 * @Date:Created in 17:06 2018/8/6
 * @Modified By:
 */
@RestController
@CrossOrigin
public class SecurityController {
    /**
     * RequestCache请求缓存域   其实现类HttpSessionRequestCache
     */
    private RequestCache requestCache = new HttpSessionRequestCache();
    /**
     * 实现转发
     */
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @RequestMapping(value = "/authentication/require",method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public Object requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //取到缓存里的请求
        SavedRequest savedRequest = requestCache.getRequest(request,response);
        if (savedRequest != null){
            String url = savedRequest.getRedirectUrl();
           /* System.out.println("转发的url"+url);*/
            if (StringUtils.endsWithIgnoreCase(url,".html")){
                redirectStrategy.sendRedirect(request,response,"/module/login/login.html");
            }
        }
        return ResponseData.FAILURE1;
    }

}
