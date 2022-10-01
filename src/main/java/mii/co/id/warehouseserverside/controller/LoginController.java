/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mii.co.id.warehouseserverside.controller;

import lombok.AllArgsConstructor;
import mii.co.id.warehouseserverside.model.dto.request.LoginRequest;
import mii.co.id.warehouseserverside.model.dto.response.LoginResponse;
import mii.co.id.warehouseserverside.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USER
 */
@AllArgsConstructor
@RestController
//@RequestMapping("/login")
public class LoginController {
    
    private LoginService loginService;
    
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        return loginService.login(loginRequest);
    }
}
