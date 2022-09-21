/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mii.co.id.warehouseserverside.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import mii.co.id.warehouseserverside.model.Pengajuan;
import mii.co.id.warehouseserverside.service.PengajuanService;
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
 * @author USER
 */
@AllArgsConstructor
@RestController
@RequestMapping("/pengajuan")
public class PengjauanController {
    
    private final PengajuanService pengajuanService;
    
    @GetMapping
    public ResponseEntity <List<Pengajuan>> getAll(){
        return new ResponseEntity(pengajuanService.getAll(),HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Pengajuan> getById(@PathVariable Long id){
        return new ResponseEntity(pengajuanService.getById(id),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Pengajuan> create(@RequestBody Pengajuan pengajuan){
        return new ResponseEntity(pengajuanService.create(pengajuan),HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Pengajuan> update(@PathVariable Long id,@RequestBody Pengajuan pengajuan){
        return new ResponseEntity(pengajuanService.update(id, pengajuan),HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Pengajuan> delete(@PathVariable Long id){
        return new ResponseEntity(pengajuanService.delete(id),HttpStatus.OK);
    }
    
}
