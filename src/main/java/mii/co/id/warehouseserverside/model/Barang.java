
package mii.co.id.warehouseserverside.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
    
    @Column
    private String nama_barang;
    
    @Column
    private String kategory;
    
    @Column
    private Long stock;
    
    @Column
    private Long harga;
    
    @Column
    private Date tanggal;
        
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "barang")
    private Collection<PengajuanBarang> quantitys = new ArrayList<>();
    
}
