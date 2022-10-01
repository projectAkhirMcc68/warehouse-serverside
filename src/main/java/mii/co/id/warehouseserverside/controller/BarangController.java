/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mii.co.id.warehouseserverside.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import mii.co.id.warehouseserverside.model.Barang;
import mii.co.id.warehouseserverside.service.BarangService;
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
@RequestMapping("/barang")
@PreAuthorize("hasRole('ADMIN') ")
public class BarangController {
    
    private final BarangService barangService;
    
    @PreAuthorize("hasAuthority('READ_ADMIN')")
    @GetMapping
    public ResponseEntity <List<Barang>> getAll(){
        return new ResponseEntity(barangService.getAll(),HttpStatus.OK);
    }
    
    @PreAuthorize("hasAuthority('READ_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Barang> getById(@PathVariable Long id){
        return new ResponseEntity(barangService.getById(id),HttpStatus.OK);
    }
    
    @PreAuthorize("hasAuthority('CREATE_ADMIN')")
    @PostMapping
    public ResponseEntity<Barang> create(@RequestBody Barang barang){
        return new ResponseEntity(barangService.create(barang),HttpStatus.CREATED);
    }
    
    @PreAuthorize("hasAuthority('UPDATE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Barang> update(@PathVariable Long id,@RequestBody Barang barang){
        return new ResponseEntity(barangService.update(id, barang),HttpStatus.CREATED);
    }
    
    @PreAuthorize("hasAuthority('DELETE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Barang> delete(@PathVariable Long id){
        return new ResponseEntity(barangService.delete(id),HttpStatus.OK);
    }
}
