/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mii.co.id.warehouseserverside.service;

import java.util.Collection;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mii.co.id.warehouseserverside.model.AppUserDetail;
import mii.co.id.warehouseserverside.model.User;
import mii.co.id.warehouseserverside.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@AllArgsConstructor
@Service
@Slf4j
public class AppUserDetailService implements UserDetailsService{
    
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Username Incorrect"));
       return new AppUserDetail(user);
    }
  
   
}
