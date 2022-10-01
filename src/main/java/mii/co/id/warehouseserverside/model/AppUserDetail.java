/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mii.co.id.warehouseserverside.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author USER
 */
@Slf4j
public class AppUserDetail implements UserDetails{
    
     private  User user;

    public AppUserDetail(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return user.getRoles()
//                .stream()
//                .map(role->new SimpleGrantedAuthority("ROLE_"+role.getName().toUpperCase()))
//                .collect(Collectors.toList());
            List<GrantedAuthority> authorities = new ArrayList<>();
            
            user.getRoles().forEach(role-> {
                String userRole = role.getName().toUpperCase();
                authorities.add(new SimpleGrantedAuthority("ROLE_"+userRole));
                
                role.getPrivileges().forEach(privilege->{
                    String userPrivilege =privilege.getName().toUpperCase();
                    authorities.add(new SimpleGrantedAuthority(userPrivilege));
                });
            });
            authorities.forEach(a -> System.out.println(a));
            return authorities;
    }

    @Override
    public String getPassword() {
       return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
       return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
       return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
