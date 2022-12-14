/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mii.co.id.warehouseserverside.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import mii.co.id.warehouseserverside.model.User;
import mii.co.id.warehouseserverside.model.dto.request.AddRoleRequest;
import mii.co.id.warehouseserverside.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USER
 */
@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    
    private final UserService userService;
    
    @GetMapping
    public ResponseEntity <List<User>> getAll(){
        return new ResponseEntity(userService.getAll(),HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id){
        return new ResponseEntity(userService.getById(id),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        return new ResponseEntity(userService.create(user),HttpStatus.CREATED);
    }
    
    @PostMapping("/{id}")
    public ResponseEntity<User> addRole(@PathVariable Long id, @RequestBody AddRoleRequest addRoleRequest) {
        return new ResponseEntity(userService.addRole(id, addRoleRequest), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id,@RequestBody User user){
        return new ResponseEntity(userService.update(id, user),HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id){
        return new ResponseEntity(userService.delete(id),HttpStatus.OK);
    }
    
    
}
