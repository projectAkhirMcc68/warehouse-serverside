/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mii.co.id.warehouseserverside.model.dto.request;

import java.sql.Date;
import javax.persistence.Id;
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
public class PengajuanRequest {
    
    @Id
    private Long id;
    private Date tanggal;
    private Long userId;
    private Long statusId;
//    private Long barangId;
//    private Long quantitys;
    
    
}
