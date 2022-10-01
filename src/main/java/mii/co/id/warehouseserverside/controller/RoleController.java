/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mii.co.id.warehouseserverside.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import mii.co.id.warehouseserverside.model.Role;
import mii.co.id.warehouseserverside.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/role")
@PreAuthorize("hasRole('ADMIN') ")
public class RoleController {
    
    private final RoleService roleService;
    
    @PreAuthorize("hasAuthority('READ_ADMIN')")
    @GetMapping
    public ResponseEntity <List<Role>> getAll(){
        return new ResponseEntity(roleService.getAll(),HttpStatus.OK);
    }
    
    @PreAuthorize("hasAuthority('READ_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Role> getById(@PathVariable Long id){
        return new ResponseEntity(roleService.getById(id),HttpStatus.OK);
    }
    
    @PreAuthorize("hasAuthority('CREATE_ADMIN')")
    @PostMapping
    public ResponseEntity<Role> create(@RequestBody Role role){
        return new ResponseEntity(roleService.create(role),HttpStatus.CREATED);
    }
    
    @PreAuthorize("hasAuthority('UPDATE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Role> update(@PathVariable Long id,@RequestBody Role role){
        return new ResponseEntity(roleService.update(id, role),HttpStatus.CREATED);
    }
    
    @PreAuthorize("hasAuthority('DELETE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Role> delete(@PathVariable Long id){
        return new ResponseEntity(roleService.delete(id),HttpStatus.OK);
    }
    
}
