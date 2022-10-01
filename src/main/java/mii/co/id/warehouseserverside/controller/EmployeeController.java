/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mii.co.id.warehouseserverside.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import mii.co.id.warehouseserverside.model.Employee;
import mii.co.id.warehouseserverside.model.dto.request.EmployeeRequest;
import mii.co.id.warehouseserverside.service.EmployeeService;
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
@RequestMapping("/employee")
@PreAuthorize("hasAnyRole('ADMIN','USER') ")
public class EmployeeController {
    
    private final EmployeeService employeeService;
    
    @PreAuthorize("hasAnyAuthority('READ_ADMIN','READ_USER')")
    @GetMapping
    public ResponseEntity <List<Employee>> getAll(){
        return new ResponseEntity(employeeService.getAll(),HttpStatus.OK);
    }
    
    @PreAuthorize("hasAnyAuthority('READ_ADMIN','READ_USER')")
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id){
        return new ResponseEntity(employeeService.getById(id),HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('CREATE_ADMIN')")
    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee){
        return new ResponseEntity(employeeService.create(employee),HttpStatus.CREATED);
    }
    
    @PreAuthorize("hasAuthority('CREATE_ADMIN')")
      @PostMapping("/dto")
    public ResponseEntity<Employee> createDto(@RequestBody EmployeeRequest employeeRequest){
        return new ResponseEntity(employeeService.createDto(employeeRequest),HttpStatus.CREATED);
    }
    
    @PreAuthorize("hasAnyAuthority('UPDATE_ADMIN','UPDATE_USER')")
    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id,@RequestBody Employee employee){
        return new ResponseEntity(employeeService.update(id, employee),HttpStatus.CREATED);
    }
    
    @PreAuthorize("hasAuthority('DELETE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> delete(@PathVariable Long id){
        return new ResponseEntity(employeeService.delete(id),HttpStatus.OK);
    }
    
    
}
