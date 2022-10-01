/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mii.co.id.warehouseserverside.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import mii.co.id.warehouseserverside.model.User;
import mii.co.id.warehouseserverside.model.dto.request.LoginRequest;
import mii.co.id.warehouseserverside.model.dto.response.LoginResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@AllArgsConstructor
@Service
public class LoginService {
    
    private UserDetailsService userDetailsService;
    private AuthenticationManager authenticationManager;
    private UserService userService;
    
    public LoginResponse login(LoginRequest loginRequest){
        UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(authReq);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        User user = userService.getByUsername(loginRequest.getUsername());
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        
        List<String>    authorities = userDetails.getAuthorities()
                .stream().map(authority->authority.getAuthority())
                .collect(Collectors.toList());
        
        return new LoginResponse(user.getUsername(),user.getEmployee().getEmail(),authorities);
    }
    
}
