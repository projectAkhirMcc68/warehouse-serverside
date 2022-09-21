/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mii.co.id.warehouseserverside.service;

import java.util.List;
import lombok.AllArgsConstructor;
import mii.co.id.warehouseserverside.model.Pengajuan;
import mii.co.id.warehouseserverside.repository.PengajuanRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author USER
 */
@AllArgsConstructor
@Service
public class PengajuanService {
    
    private final PengajuanRepository pengajuanRepository;
    
   public  List<Pengajuan> getAll(){
       return pengajuanRepository.findAll();
   }
   
   public  Pengajuan getById(Long id){
       return pengajuanRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Data Pengajuan Not Found"));
   }
   
   public Pengajuan create(Pengajuan pengajuan){
       if (pengajuan.getId() != null) {
           throw new ResponseStatusException(HttpStatus.CONFLICT, "Data Pengajuan Has Ready Exist!!");
       }
       return pengajuanRepository.save(pengajuan);
   }
   
   public Pengajuan update(Long id, Pengajuan pengajuan){
       getById(id);
       pengajuan.setId(id);
       return pengajuanRepository.save(pengajuan);
   }
   
   public Pengajuan delete(Long id){
       Pengajuan pengajuan = getById(id);
       pengajuanRepository.delete(pengajuan);
       return pengajuan;
   }
   
}
