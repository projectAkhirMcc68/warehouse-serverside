/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.warehouseserverside.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import mii.co.id.warehouseserverside.model.Barang;
import mii.co.id.warehouseserverside.service.BarangService;
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
 * @author aditya jalu
 */
@AllArgsConstructor
@RestController
@RequestMapping("/barang")
public class BarangController {
    private BarangService barangService;
    
    @GetMapping
    public ResponseEntity <List<Barang>> getAll() {
        return new ResponseEntity(barangService.getAll(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Barang> getById(@PathVariable Long id) {
        return new ResponseEntity(barangService.getById(id), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Barang> create(@RequestBody Barang barang) {
        return new ResponseEntity(barangService.create(barang), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Barang> update(@PathVariable Long id, @RequestBody Barang barang) {
        return new ResponseEntity(barangService.update(id, barang), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Barang> delete(@PathVariable Long id) {
        return new ResponseEntity(barangService.delete(id), HttpStatus.OK);
    }
    
}
