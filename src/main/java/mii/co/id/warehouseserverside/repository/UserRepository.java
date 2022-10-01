/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mii.co.id.warehouseserverside.repository;

import java.util.Optional;
import mii.co.id.warehouseserverside.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
   
    Optional<User> findByUsername(String name);
    
}
