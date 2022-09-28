
package mii.co.id.warehouseserverside.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import mii.co.id.warehouseserverside.model.Barang;
import mii.co.id.warehouseserverside.model.Pengajuan;
import mii.co.id.warehouseserverside.model.PengajuanBarang;
import mii.co.id.warehouseserverside.repository.BarangRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


 
@AllArgsConstructor
@Service
public class BarangService {

    private BarangRepository barangRepository;
    
    public List<Barang> getAll(){
        return barangRepository.findAll();
    }
    
    public Barang getById(Long id){
        return barangRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Data Barang Not Found"));
    }
    
//    public Barang findBarangId(Long id){
//        return barangRepository.findByBarangId(id);
//    }
    
//    public Barang saveBarang (Barang barang){
//        Barang newBarang = new Barang();
//        newBarang.setNama(barang.getNama());
//        newBarang.getQuantitys().addAll((barang.getQuantitys()
//                .stream()
//                .map(quantity->{
//                    Pengajuan pengajuan = pengajuanService.getById(quantity.getPengajuan().getId());
//                    PengajuanBarang newPengajuanBarang = new PengajuanBarang();
//                    newPengajuanBarang.setPengajuan(pengajuan);
//                    newPengajuanBarang.setBarang(newBarang);
//                    newPengajuanBarang.setQuantity(quantity.getQuantity());
//                    return newPengajuanBarang;
//                })
//                .collect(Collectors.toList())
//                ));
//        return barangRepository.save(newBarang);
//    }
    
    public Barang create(Barang barang){
        if (barang.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Data sudah ada");
        }
        return barangRepository.save(barang);
    }
    

    public Barang update(Long id,Barang barang){
        getById(id);
        barang.setId(id);
        return barangRepository.save(barang);
    }
    
    public Barang delete(Long id){
        Barang barang = getById(id);
        barangRepository.delete(barang);
        return barang;
    }

}
