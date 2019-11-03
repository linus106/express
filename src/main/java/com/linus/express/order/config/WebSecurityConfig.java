package com.linus.express.order.config;

import com.linus.express.order.dao.entity.UserInfo;
import com.linus.express.order.dao.repository.UserInfoRepository;
import com.linus.express.order.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author ：wangxiangyu
 * @date ：Created in 2019/11/2
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfig {


//    @Bean
//    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
//        return new WebSecurityConfigurerAdapter() {
//            @Override
//            public void configure(HttpSecurity http) throws Exception {
////                http.csrf().ignoringAntMatchers("/h2-console/**");
//                http.csrf().disable();
//                http.headers().frameOptions().sameOrigin(); // deal with h2-console login problem
//                http.
//                        exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler()).authenticationEntryPoint(new CustomAuthenticationEntryPoint()).
//                        and().authorizeRequests().antMatchers("/*").permitAll().
//                        and().authorizeRequests().antMatchers("/api/user/**").hasRole("admin").
//                        and().authorizeRequests().antMatchers("/api/order/**").authenticated().
//                        and().formLogin().successHandler(new CustomAuthenticationSuccessHandler()).failureHandler(new CustomAuthenticationFailureHandler()).
//                        and().logout().logoutSuccessHandler(new CustomAuthenticationLogoutSuccessHandler()).invalidateHttpSession(true).deleteCookies("JSESSIONID").
//                        and().authorizeRequests().anyRequest().permitAll();
//            }
//        };
//    }


    @Bean
    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
        return new WebSecurityConfigurerAdapter() {
            @Override
            public void configure(HttpSecurity http) throws Exception {
//                http.csrf().ignoringAntMatchers("/h2-console/**");
                http.csrf().disable();
                http.headers().frameOptions().sameOrigin(); // deal with h2-console login problem
                http.
//                        exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler()).authenticationEntryPoint(new CustomAuthenticationEntryPoint()).
                        authorizeRequests().antMatchers("/*").permitAll().
                        and().authorizeRequests().antMatchers("/api/user/**").hasRole("admin").
                        and().authorizeRequests().antMatchers("/api/order/**").authenticated().
                        and().formLogin().
//                        and().formLogin().successHandler(new CustomAuthenticationSuccessHandler()).failureHandler(new CustomAuthenticationFailureHandler()).
//                        and().logout().logoutSuccessHandler(new CustomAuthenticationLogoutSuccessHandler()).invalidateHttpSession(true).deleteCookies("JSESSIONID").
                        and().authorizeRequests().anyRequest().permitAll();
            }
        };
    }

    @Bean
    public UserDetailsService userDetailsService(UserInfoRepository userInfoRepository) {
        return username -> {
            List<UserInfo> users = userInfoRepository.findByUserName(username);
            if (CollectionUtils.isEmpty(users)) {
                throw new UsernameNotFoundException("用户名未找到");
            }
            UserInfo user = users.get(0);
            String password = user.getPassword();
            PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            String passwordAfterEncoder = passwordEncoder.encode(password);
            return User.withUsername(username).password(passwordAfterEncoder).roles(user.getRole()).build();
        };
    }

}
