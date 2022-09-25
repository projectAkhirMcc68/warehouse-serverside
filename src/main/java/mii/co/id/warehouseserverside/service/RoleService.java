/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mii.co.id.warehouseserverside.service;

import java.util.List;
import lombok.AllArgsConstructor;
import mii.co.id.warehouseserverside.model.Role;
import mii.co.id.warehouseserverside.repository.RoleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author USER
 */
@AllArgsConstructor
@Service
public class RoleService {
    
    private final RoleRepository roleRepository;
    
   public  List<Role> getAll(){
       return roleRepository.findAll();
   }
   
   public  Role getById(Long id){
       return roleRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Data Role Not Found"));
   }
   
   public Role create(Role role){
       if (role.getId() != null) {
           throw new ResponseStatusException(HttpStatus.CONFLICT, "Data Role Has Ready Exist!!");
       }
       return roleRepository.save(role);
   }
   
   public Role update(Long id, Role role){
       getById(id);
       role.setId(id);
       return roleRepository.save(role);
   }
   
   public Role delete(Long id){
       Role role = getById(id);
       roleRepository.delete(role);
       return role;
   }
    
}
