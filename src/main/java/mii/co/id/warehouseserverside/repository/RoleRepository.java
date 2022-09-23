/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.warehouseserverside.repository;

import mii.co.id.warehouseserverside.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aditya jalu
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
}
