/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mii.co.id.warehouseserverside.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author USER
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_pengajuan_barang")
public class PengajuanBarang {
    
    @EmbeddedId
    private PengajuanBarangKey id = new PengajuanBarangKey();
    

    @ManyToOne
    @MapsId("barangId")
    @JoinColumn(name = "barang_id")
    private Barang barang;
    
     @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @MapsId("pengajuanId")
    @JoinColumn(name = "pengajuan_id")
    private Pengajuan pengajuan;
    
    private Long quantity;

    
}
