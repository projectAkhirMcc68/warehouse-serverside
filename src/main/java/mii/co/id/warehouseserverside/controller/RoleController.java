
package mii.co.id.warehouseserverside.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import mii.co.id.warehouseserverside.model.Role;
import mii.co.id.warehouseserverside.service.RoleService;
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
<<<<<<< HEAD
 * @author aditya jalu
=======
 * @author USER
>>>>>>> 85ce60a9325591b8601c379feb8ea32c2ed542d9
 */
@AllArgsConstructor
@RestController
@RequestMapping("/role")
public class RoleController {
    
    private RoleService roleService;
    
    @GetMapping
    public ResponseEntity <List<Role>> getAll() {
        return new ResponseEntity(roleService.getAll(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Role> getById(@PathVariable Long id) {
        return new ResponseEntity(roleService.getById(id), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<Role> create(@RequestBody Role role) {
        return new ResponseEntity(roleService.create(role), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Role> update(@PathVariable Long id, @RequestBody Role role) {
        return new ResponseEntity(roleService.update(id, role), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Role> delete(@PathVariable Long id) {
        return new ResponseEntity(roleService.delete(id), HttpStatus.OK);

    }
}
