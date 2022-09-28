/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mii.co.id.warehouseserverside.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import mii.co.id.warehouseserverside.model.Barang;
import mii.co.id.warehouseserverside.model.Pengajuan;
import mii.co.id.warehouseserverside.model.PengajuanBarang;
import mii.co.id.warehouseserverside.model.dto.request.PengajuanRequest;
import mii.co.id.warehouseserverside.repository.PengajuanRepository;
import org.modelmapper.ModelMapper;
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
    private final BarangService barangService;
   //private final PengajuanBarang pengajuanBarang;
   private final ModelMapper modelMapper;
    
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
   
public Pengajuan savePengajuan (Pengajuan pengajuan){
        Pengajuan newPengajuan = new Pengajuan();
        newPengajuan.setTanggal(pengajuan.getTanggal());
        newPengajuan.setStatus(pengajuan.getStatus());
        newPengajuan.setUser(pengajuan.getUser());
        newPengajuan.getQuantitys().addAll((pengajuan.getQuantitys()
                .stream()
                .map(quantity->{
                    Barang  barang= barangService.getById(quantity.getBarang().getId());
                    PengajuanBarang newPengajuanBarang = new PengajuanBarang();
                    newPengajuanBarang.setBarang(barang);
                    newPengajuanBarang.setPengajuan(newPengajuan);
                    newPengajuanBarang.setQuantity(quantity.getQuantity());
                    return newPengajuanBarang;
                })
                .collect(Collectors.toList())
                ));
        return pengajuanRepository.save(newPengajuan);
    }

    public Pengajuan createDto(PengajuanRequest pengajuanRequest){
        Pengajuan pengajuan = modelMapper.map(pengajuanRequest, Pengajuan.class);
        //Barang barang = modelMapper.map(pengajuanRequest, Barang.class);
        pengajuan.getQuantitys().addAll((pengajuan.getQuantitys()
                .stream()
                .map(quantity->{
                    Barang  barang= barangService.getById(quantity.getBarang().getId());
                     PengajuanBarang pengajuanBarang = modelMapper.map(pengajuanRequest, PengajuanBarang.class);
                     pengajuanBarang.setBarang(barang);
                    return pengajuanBarang;
                })
                .collect(Collectors.toList())
                ));
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
