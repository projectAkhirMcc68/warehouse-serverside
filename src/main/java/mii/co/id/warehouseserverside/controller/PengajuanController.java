/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mii.co.id.warehouseserverside.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import mii.co.id.warehouseserverside.model.Pengajuan;
import mii.co.id.warehouseserverside.model.dto.request.PengajuanRequest;
import mii.co.id.warehouseserverside.service.PengajuanService;
import org.modelmapper.ModelMapper;
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
@RequestMapping("/pengajuan")
@PreAuthorize("hasAnyRole('ADMIN','USER') ")
public class PengajuanController {
    
    private final PengajuanService pengajuanService;
    private ModelMapper modelMapper;
    
//    @GetMapping
//    public ResponseEntity <List<Pengajuan>> getAll(){
//        return new ResponseEntity(pengajuanService.getAll().stream().map(response-> modelMapper.map(response, PengajuanResponse.class))
//                .collect(Collectors.toList()),HttpStatus.OK);
//    }
    
    @PreAuthorize("hasAnyAuthority('READ_ADMIN','READ_USER')")
    @GetMapping
    public ResponseEntity<List<Pengajuan>> getAll(){
        return new ResponseEntity(pengajuanService.getAll(),HttpStatus.OK);
    } 
    
    @PreAuthorize("hasAnyAuthority('READ_ADMIN','READ_USER')")
    @GetMapping("/{id}")
    public ResponseEntity<Pengajuan> getById(@PathVariable Long id){
        return new ResponseEntity(pengajuanService.getById(id),HttpStatus.OK);
    }
    
    @PreAuthorize("hasAnyAuthority('CREATE_ADMIN','CREATE_USER')")
    @PostMapping
    public ResponseEntity<Pengajuan> create(@RequestBody Pengajuan pengajuan){
        return new ResponseEntity(pengajuanService.create(pengajuan),HttpStatus.CREATED);
    }
    
//     @PostMapping
//    public ResponseEntity<Pengajuan> create(@RequestBody PengajuanRequest pengajuanRequest){
//        return new ResponseEntity(pengajuanService.create(pengajuanRequest),HttpStatus.CREATED);
//    }
    
//  @PostMapping("/save")
//    public ResponseEntity<Pengajuan> createPengajuan(@RequestBody Pengajuan pengajuan){
//        return new ResponseEntity(pengajuanService.savePengajuan(pengajuan),HttpStatus.CREATED);
//    }
    @PreAuthorize("hasAnyAuthority('CREATE_ADMIN','CREATE_USER')")
     @PostMapping("/dto")
    public ResponseEntity<Pengajuan> createDto(@RequestBody PengajuanRequest pengajuanRequest){
        return new ResponseEntity(pengajuanService.createDto(pengajuanRequest),HttpStatus.CREATED);
    }
    
//    @PutMapping("/{id}")
//    public ResponseEntity<Pengajuan> update(@PathVariable Long id,@RequestBody Pengajuan pengajuan){
//        return new ResponseEntity(pengajuanService.update(id, pengajuan),HttpStatus.CREATED);
//    }
    @PreAuthorize("hasAuthority('UPDATE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Pengajuan> update(@PathVariable Long id,@RequestBody PengajuanRequest pengajuanRequest){
        return new ResponseEntity(pengajuanService.update(id, pengajuanRequest),HttpStatus.CREATED);
    }
    
    @PreAuthorize("hasAuthority('DELETE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Pengajuan> delete(@PathVariable Long id){
        return new ResponseEntity(pengajuanService.delete(id),HttpStatus.OK);
    }
    
}
