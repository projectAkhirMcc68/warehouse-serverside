/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mii.co.id.warehouseserverside.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;
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
public class HistoryResponse {
    
    private Long id;
    private Long pengajuanId;
    private String nameStatus;
    private Date date;
    private String notes;
    
}
