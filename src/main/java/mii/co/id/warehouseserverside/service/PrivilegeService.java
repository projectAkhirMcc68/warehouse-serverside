/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.warehouseserverside.service;

import java.util.List;
import lombok.AllArgsConstructor;
import mii.co.id.warehouseserverside.model.Privilege;
import mii.co.id.warehouseserverside.repository.PrivilegeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author aditya jalu
 */
@AllArgsConstructor
@Service
public class PrivilegeService {
    private PrivilegeRepository privilegeRepository;
    
    public List<Privilege> getAll() {
        return privilegeRepository.findAll();
    }
     
    public Privilege getById(Long id) {
        return privilegeRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Privilege not found"));
    }
    
    public Privilege create(Privilege privilege) {
        if (privilege.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Privilege already Exist");
        }
        return privilegeRepository.save(privilege);
    }
    
    public Privilege update(Long id, Privilege privilege) {
        getById(id);
        privilege.setId(id);
        return privilegeRepository.save(privilege);
    }
    
    public Privilege delete(Long id) {
        Privilege privilege = getById(id);
        privilegeRepository.delete(privilege);
        return privilege;
    }
    
    
}
