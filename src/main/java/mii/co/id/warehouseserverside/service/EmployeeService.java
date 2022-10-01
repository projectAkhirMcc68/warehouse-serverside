/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mii.co.id.warehouseserverside.service;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import mii.co.id.warehouseserverside.model.Employee;
import mii.co.id.warehouseserverside.model.Role;
import mii.co.id.warehouseserverside.model.User;
import mii.co.id.warehouseserverside.model.dto.request.EmployeeRequest;
import mii.co.id.warehouseserverside.repository.EmployeeRepository;
import mii.co.id.warehouseserverside.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author USER
 */
@AllArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    
   public  List<Employee> getAll(){
       return employeeRepository.findAll();
   }
   
   public  Employee getById(Long id){
       return employeeRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Data Employee Not Found"));
   }
   
   public Employee create(Employee employee){
       if (employee.getId() != null) {
           throw new ResponseStatusException(HttpStatus.CONFLICT, "Data Employee Has Ready Exist!!");
       }
       return employeeRepository.save(employee);
   }
   
   public Employee createDto(EmployeeRequest employeeRequest){
       Employee employee = modelMapper.map(employeeRequest, Employee.class);
       User user = modelMapper.map(employeeRequest, User.class);
       user.setPassword(passwordEncoder.encode(employeeRequest.getPassword()));
       
        List<Role> role = new ArrayList<>();
        role.add(roleRepository.findById(employeeRequest.getRoleId()).get());
        
        user.setRoles(role);   
        user.setEmployee(employee);
        employee.setUser(user);
       
       return employeeRepository.save(employee);
   }
   
   public Employee update(Long id, Employee employee){
       getById(id);
       employee.setId(id);
       return employeeRepository.save(employee);
   }
   
   public Employee delete(Long id){
       Employee employee = getById(id);
       employeeRepository.delete(employee);
       return employee;
   }
    
}
