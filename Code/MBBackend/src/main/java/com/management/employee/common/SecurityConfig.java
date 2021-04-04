package com.management.employee.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http
//                .headers().disable();
//        http.httpBasic()
//                .and().csrf().disable()
//                .authorizeRequests().antMatchers("/").authenticated()
//                .and()
//                .authorizeRequests().antMatchers("/**").permitAll();

	http.cors().and().csrf().disable().	authorizeRequests()
	.antMatchers("/**").permitAll();
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder authentication)
//            throws Exception {
//        authentication.inMemoryAuthentication()
//                .withUser("email")
//                .password("password")
//                .authorities("MANAGER");
//    }


}
