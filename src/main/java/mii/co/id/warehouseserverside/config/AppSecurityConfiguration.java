/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mii.co.id.warehouseserverside.config;

import mii.co.id.warehouseserverside.service.AppUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author USER
 */
@Configuration
@EnableWebSecurity
public class AppSecurityConfiguration extends WebSecurityConfigurerAdapter{
    
    private AppUserDetailService appUserDetailService;

    @Autowired
    public AppSecurityConfiguration(AppUserDetailService appUserDetailService) {
        this.appUserDetailService = appUserDetailService;
    }
    

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
        auth
                .userDetailsService(appUserDetailService)
                .passwordEncoder(passwordEncoder());
        
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/login").permitAll()
//                .antMatchers("/user").hasRole("ADMIN")
//                 .antMatchers("/barang").hasRole("ADMIN")
                 .antMatchers("/role").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .httpBasic();
        
    }
    
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    
}
