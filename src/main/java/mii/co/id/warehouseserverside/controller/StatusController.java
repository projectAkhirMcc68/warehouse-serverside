/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mii.co.id.warehouseserverside.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import mii.co.id.warehouseserverside.model.Status;
import mii.co.id.warehouseserverside.service.StatusService;
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
@RequestMapping("/status")
public class StatusController {
     private final StatusService statusService;
    
    @GetMapping
    public ResponseEntity <List<Status>> getAll(){
        return new ResponseEntity(statusService.getAll(),HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Status> getById(@PathVariable Long id){
        return new ResponseEntity(statusService.getById(id),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Status> create(@RequestBody Status status){
        return new ResponseEntity(statusService.create(status),HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Status> update(@PathVariable Long id,@RequestBody Status status){
        return new ResponseEntity(statusService.update(id, status),HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Status> delete(@PathVariable Long id){
        return new ResponseEntity(statusService.delete(id),HttpStatus.OK);
    }
}
