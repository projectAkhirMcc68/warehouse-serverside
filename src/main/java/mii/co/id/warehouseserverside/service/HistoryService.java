/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mii.co.id.warehouseserverside.service;

import java.util.List;
import lombok.AllArgsConstructor;
import mii.co.id.warehouseserverside.model.History;
import mii.co.id.warehouseserverside.repository.HistoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author USER
 */
@AllArgsConstructor
@Service
public class HistoryService {
    
    private final HistoryRepository historyRepository;
    
    public List<History> getAll(){
        return historyRepository.findAll();
    }
    
      public List<History> getAllDto(){
        return historyRepository.findAll();
    }
    
    public  History getById(Long id){
        return historyRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Data Tidak Ada"));
    }
    
     public  History getByIdDto(Long id){
        return historyRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Data Tidak Ada"));
    }
    
    public List<History> getByIdPengajuan(Long pId){
        return historyRepository.findIdPengajuan(pId);
    }
    
    public History delete(Long id){
        History history = getById(id);
        historyRepository.delete(history);
        return history;
    }
}
