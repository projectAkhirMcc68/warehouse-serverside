/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mii.co.id.warehouseserverside.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import mii.co.id.warehouseserverside.model.Privilege;
import mii.co.id.warehouseserverside.service.PrivilegeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USER
 */
@AllArgsConstructor
@RestController
@RequestMapping("/privilege")
public class PrivilegeController {
    private PrivilegeService privilegeService;
    
    @GetMapping
    public ResponseEntity <List<Privilege>> getAll(){
        return new ResponseEntity(privilegeService.getAll(),HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Privilege> getById(@PathVariable Long id){
        return new ResponseEntity(privilegeService.getById(id),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Privilege> create(@RequestBody Privilege privilege){
        return new ResponseEntity(privilegeService.create(privilege),HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Privilege> update(@PathVariable Long id,@RequestBody Privilege privilege){
        return new ResponseEntity(privilegeService.update(id, privilege),HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Privilege> delete(@PathVariable Long id){
        return new ResponseEntity(privilegeService.delete(id),HttpStatus.OK);
    }
    
}
