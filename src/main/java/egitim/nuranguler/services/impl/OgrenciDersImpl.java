package egitim.nuranguler.services.impl;


import egitim.nuranguler.dto.OgrenciDersDto;
import egitim.nuranguler.entitys.OgrenciDers;
import egitim.nuranguler.repository.OgrenciDersRepo;
import egitim.nuranguler.services.OgrenciDersService;
import org.hibernate.engine.spi.Resolution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OgrenciDersImpl implements OgrenciDersService{
    @Autowired
    OgrenciDersRepo ogrencidersrepo;

    public List<OgrenciDers> getAll(){

        List<OgrenciDers> ogrencidersliste = ogrencidersrepo.findAll();
        return ogrencidersliste;

    }
    @Override
    public ResponseEntity ogrenciDersKaydet (OgrenciDersDto ogrenciDersDto) {
        if(ogrenciDersDto.getOgrenciId()==null){
            throw new RuntimeException("OgrenciId zorunlu");
        }
        if(ogrenciDersDto.getOgretmenDersId()==null){
            throw new RuntimeException("OgretmenDersId zorunlu");
        }
        if(ogrenciDersDto.getId()==null){
            throw new RuntimeException("Id zorunlu");
        }
        OgrenciDers ogrenciDers = new OgrenciDers();
        ogrenciDers.setId(ogrenciDersDto.getId());
        ogrenciDers.setOgrenciId(ogrenciDersDto.getOgrenciId());
        ogrencidersrepo.save(ogrenciDers);
        return new ResponseEntity<>("kayıt başarılı", HttpStatus.ACCEPTED);


    }


}