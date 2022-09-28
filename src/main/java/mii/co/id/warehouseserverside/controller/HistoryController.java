/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mii.co.id.warehouseserverside.controller;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import mii.co.id.warehouseserverside.model.History;
import mii.co.id.warehouseserverside.model.dto.response.HistoryResponse;
import mii.co.id.warehouseserverside.service.HistoryService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USER
 */
@AllArgsConstructor
@RestController
@RequestMapping("/history")
public class HistoryController {

    private final HistoryService historyService;
   private final ModelMapper ModelMapper;
    
@GetMapping
    public ResponseEntity<List<History>> getAll(){
        return new ResponseEntity(historyService.getAll(),HttpStatus.OK);
    }
    
//    return new ResponseEntity(countryService.getAllDto().stream().map(respons ->modelMapper.map(respons, CountryRespons.class))
//                .collect(Collectors.toList()), HttpStatus.OK);
//    
    @GetMapping("/dto")
    public ResponseEntity<List<History>> getAllDto(){
        return new ResponseEntity(historyService.getAllDto().stream().map(mapper->ModelMapper.map(mapper, HistoryResponse.class))
                .collect(Collectors.toList()),HttpStatus.OK);
    }
   
    @GetMapping("/{id}")
    public ResponseEntity<History> getById(@PathVariable Long id){
        return new ResponseEntity(historyService.getById(id),HttpStatus.OK);
    }
    
    @GetMapping("/pengajuan/{pId}")
    public ResponseEntity<List<History>> getByIdPengajuan(@PathVariable Long pId){
        return new ResponseEntity(historyService.getByIdPengajuan(pId),HttpStatus.OK);
    }
    
}
