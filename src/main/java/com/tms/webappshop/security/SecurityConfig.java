package com.tms.webappshop.security;

import com.tms.webappshop.entity.PermissionsEnum;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import static com.tms.webappshop.common.Helpers.passwordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(/*Qualifier("userDetailsServiceImpl") */UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/v2/admin/**").hasAuthority(PermissionsEnum.WRITE.getPermission())
                .antMatchers(HttpMethod.GET, "/api/v2/products/**").anonymous()
                .antMatchers(HttpMethod.GET, "/api/v2/products/**").permitAll()
                .antMatchers(HttpMethod.GET, "/user/**").hasAuthority(PermissionsEnum.READ.getPermission())
                .antMatchers(HttpMethod.GET, "/admin/**").hasAuthority(PermissionsEnum.WRITE.getPermission())
                .antMatchers(HttpMethod.GET, "/products/**").hasAuthority(PermissionsEnum.READ.getPermission())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();

    }

//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService() {
//        return new InMemoryUserDetailsManager(
//                User.builder()
//                        .username("admin")
//                        .password(passwordEncoder().encode("admin"))
////                        .roles(RoleEnum.ADMIN.name())
//                        .authorities(RoleEnum.ADMIN.getAuthorities())
//                        .build(),
//                User.builder()
//                        .username("user")
//                        .password(passwordEncoder().encode("user"))
////                        .roles(RoleEnum.USER.name())
//                        .authorities(RoleEnum.USER.getAuthorities())
//                        .build()
//        );
//    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

//    @Bean
//    protected PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(12);
//    }

    @Bean
    protected DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }
}
