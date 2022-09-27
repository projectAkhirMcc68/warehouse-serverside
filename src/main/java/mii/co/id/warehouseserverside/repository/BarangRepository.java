/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mii.co.id.warehouseserverside.repository;

import mii.co.id.warehouseserverside.model.Barang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */
@Repository
public interface BarangRepository extends JpaRepository<Barang, Long>{
//  @Query
//  Barang findByBarangId(Long id);    
}
