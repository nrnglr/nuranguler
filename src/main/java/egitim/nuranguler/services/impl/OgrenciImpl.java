package egitim.nuranguler.services.impl;
import egitim.nuranguler.dto.OgrenciDto;
import egitim.nuranguler.entitys.Ogrenci;
import egitim.nuranguler.repository.OgrenciRepo;
import egitim.nuranguler.services.OgrenciService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class OgrenciImpl implements OgrenciService {

    @Autowired
    OgrenciRepo ogrenciRepo;
    public List<Ogrenci> getAll(){
        List<Ogrenci> ogrenciList =  ogrenciRepo.findAll();
        return ogrenciList;
    }
    @Override
    public ResponseEntity<?> ogrenciKaydet(OgrenciDto ogrenciDto){

        if(ogrenciDto.getOgrenciAd() == null) {
            throw new RuntimeException("ögrenci ad girmek zorunlu!!");
        }
        if(ogrenciDto.getOgrenciSoyad() == null) {
            throw new RuntimeException("ögrenci soyad girmek zorunlu!!");
        }
        if(ogrenciDto.getKisiselBilgiId() == null) {
            throw new RuntimeException("girmek zorunlu!!");
        }

        Ogrenci ogrenci = new Ogrenci();
        ogrenci.setOgrenciAd(ogrenciDto.getOgrenciAd());
        ogrenci.setOgrenciSoyad(ogrenciDto.getOgrenciSoyad());

        ogrenci.setStatu(1);
        ogrenci.setKayitEklenmeTarihi(new Date());
        ogrenci.setKisiselBilgilerId(ogrenciDto.getKisiselBilgiId());


        ogrenciRepo.save(ogrenci);

        return new ResponseEntity<>("kayıt başarılı", HttpStatus.ACCEPTED);
    }
    @Override
    public ResponseEntity ogrenciGuncelle(OgrenciDto ogrenciDto)
    {

        if(ogrenciDto.getOgrenciAd() == null) {
            throw new RuntimeException("girmek zorunlu!!");
        }
        if(ogrenciDto.getOgrenciSoyad() == null) {
            throw new RuntimeException("girmek soyad girmek zorunlu!!");

        }

        Ogrenci ogrenci =null;
        ogrenci = ogrenciRepo.findById(ogrenciDto.getId());

        if(ogrenci == null) {return ResponseEntity.ok(ogrenciDto.getId() + " idli ogrenci bulunamadi!");};


        ogrenciDto.setId(ogrenciDto.getId());
        ogrenci.setOgrenciAd(ogrenciDto.getOgrenciAd());
        ogrenci.setOgrenciSoyad(ogrenciDto.getOgrenciSoyad());

        ogrenciRepo.save(ogrenci);

        return ResponseEntity.ok("Öğrenci başarıyla güncellendi.");

    }
    @Override
    public boolean ogrenciSilme(Long id){
        try{
            Ogrenci ogrenci = ogrenciRepo.findById(Math.toIntExact(id));
            if(ogrenci==null){
                return true;

        }ogrenci.setStatu(1);
            ogrenciRepo.saveAndFlush(ogrenci);

            return true;
        }catch (Exception e){
            return false;
        }
    }










}

