/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mii.co.id.warehouseserverside.service;

import java.util.List;
import lombok.AllArgsConstructor;
import mii.co.id.warehouseserverside.model.Status;
import mii.co.id.warehouseserverside.repository.StatusRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author USER
 */
@AllArgsConstructor
@Service
public class StatusService {
    
    private final StatusRepository statusRepository;
    
   public  List<Status> getAll(){
       return statusRepository.findAll();
   }
   
   public  Status getById(Long id){
       return statusRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Data Status Not Found"));
   }
   
   public Status create(Status status){
       if (status.getId() != null) {
           throw new ResponseStatusException(HttpStatus.CONFLICT, "Data Status Has Ready Exist!!");
       }
       return statusRepository.save(status);
   }
   
   public Status update(Long id, Status status){
       getById(id);
       status.setId(id);
       return statusRepository.save(status);
   }
   
   public Status delete(Long id){
       Status status = getById(id);
       statusRepository.delete(status);
       return status;
   }
    
}
