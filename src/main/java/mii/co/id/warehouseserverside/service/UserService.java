/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mii.co.id.warehouseserverside.service;

import java.util.List;
import lombok.AllArgsConstructor;
import mii.co.id.warehouseserverside.model.User;
import mii.co.id.warehouseserverside.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author USER
 */
@AllArgsConstructor
@Service
public class UserService {
    
    private final UserRepository userRepository;
    
   public  List<User> getAll(){
       return userRepository.findAll();
   }
   
   public  User getById(Long id){
       return userRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Data User Not Found"));
   }
   
   public User create(User user){
//       if (user.getId() != null) {
//           throw new ResponseStatusException(HttpStatus.CONFLICT, "Data User Has Ready Exist!!");
//       }
       return userRepository.save(user);
   }
   
   public User update(Long id, User user){
       getById(id);
       user.setId(id);
       return userRepository.save(user);
   }
   
   public User delete(Long id){
       User user = getById(id);
       userRepository.delete(user);
       return user;
   }
    
}
