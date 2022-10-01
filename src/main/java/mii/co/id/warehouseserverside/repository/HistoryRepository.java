 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mii.co.id.warehouseserverside.repository;

import java.util.List;
import java.util.Optional;
import javax.websocket.server.PathParam;
import mii.co.id.warehouseserverside.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author USER
 */
@Repository
public interface HistoryRepository  extends JpaRepository<History, Long>{
    
    //native query
    @Query(value = "SELECT * FROM tb_history WHERE pengajuan_id= :pId " , nativeQuery = true)
    public List<History> findIdPengajuan(Long pId);
}
