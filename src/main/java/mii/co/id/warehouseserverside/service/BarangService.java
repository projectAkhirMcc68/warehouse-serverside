/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.warehouseserverside.service;

import java.util.List;
import lombok.AllArgsConstructor;
import mii.co.id.warehouseserverside.model.Barang;
import mii.co.id.warehouseserverside.repository.BarangRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author aditya jalu
 */
@AllArgsConstructor
@Service
public class BarangService {
    private BarangRepository barangRepository;
    
    public List<Barang> getAll() {
        return barangRepository.findAll();
    }
    
    public Barang getById(Long id) {
        return barangRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Barang Not Found"));
    }
    
    public Barang create(Barang barang) {
        if (barang.getId() != null ) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Data Barang has Already Exist!");
        }
        return barangRepository.save(barang);
    }
    
    public Barang update(Long id, Barang barang) {
        getById(id);
        barang.setId(id);
        return barangRepository.save(barang);
    }
    
    public Barang delete(Long id) {
        Barang barang = getById(id);
        barangRepository.delete(barang);
        return barang;
    }
    
    
}
