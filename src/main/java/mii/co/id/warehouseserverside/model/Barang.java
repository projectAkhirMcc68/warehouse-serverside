/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.warehouseserverside.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author aditya jalu
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name= "tb_barang")
public class Barang {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 25)
    private String nama_barang;
    
    @Column(nullable = false, length = 50)
    private String kategory;
    
    @Column(nullable = false)
    private Integer stock;
    
    @Column(nullable = false)
    private Integer harga;
    
//    @Column(nullable = false)
    private Date tanggal;
    
//    @OneToMany(mappedBy = "barang")   
//    private Pengajuan pengajuan;
}
