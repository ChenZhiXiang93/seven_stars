package com.bonc.security;

import com.bonc.valid.ValidCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Author:ChenZhiXiang
 * @Description: security配置类
 * @Date:Created in 15:54 2018/8/6
 * @Modified By:
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(-1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationSuccessHandler loginSuccess;

    @Autowired
    private AuthenticationFailureHandler loginFailed;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ValidCodeFilter validCodeFilter = new ValidCodeFilter();
        validCodeFilter.setAuthenticationFailureHandler(loginFailed);
        http
                .addFilterBefore(validCodeFilter,UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .loginPage("/authentication/require")
                .loginProcessingUrl("/user/login")
                .successHandler(loginSuccess)
                .failureHandler(loginFailed)
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/module/login/login.html")
                .and()
                .authorizeRequests()
                .antMatchers("/module/login/login.html","/authentication/require","/code/image").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .cors()//新加入
                .and().csrf().disable();

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //解决静态资源被拦截的问题
        web.ignoring().antMatchers("/img/**","/json/**","/module/**","/plugin/**","/static/static/**","/static/resources/**","/resources/**");
    }
}
