package egitim.nuranguler.services.impl;
import egitim.nuranguler.dto.OgretmenDto;
import egitim.nuranguler.entitys.KisiselBilgiler;
import egitim.nuranguler.entitys.Ogrenci;
import egitim.nuranguler.entitys.Ogretmen;
import egitim.nuranguler.repository.KisiselBilgilerRepo;
import egitim.nuranguler.repository.OgrenciRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import egitim.nuranguler.repository.OgretmenRepo;

import egitim.nuranguler.services.OgretmenService;


import java.util.Date;
import java.util.List;

@Transactional
@Service
public class OgretmenImpl implements OgretmenService {

    @Autowired
    KisiselBilgilerRepo kisiselBilgilerRepo;
    @Autowired
    OgretmenRepo ogretmenRepo;
    @Autowired
    private OgrenciRepo ogrenciRepo;

    public List<Ogretmen> getAll(){
        List<Ogretmen> ogretmenler = ogretmenRepo.findAll();
        return ogretmenler;

    }

    @Override
    public ResponseEntity ogretmenKaydet(OgretmenDto ogretmenDto){

        if(ogretmenDto.getOgretmenAd() == null) {
            throw new RuntimeException("öğretmen ad girmek zorunlu!!");
        }
        if(ogretmenDto.getOgretmenSoyad() == null) {
            throw new RuntimeException("öğretmen soyad girmek zorunlu!!");
        }
//        if(ogretmenDto.getKisiselBilgiId() == null) {
//            throw new RuntimeException("girmek zorunlu!!");
//        }

        Ogretmen ogretmen = new Ogretmen();
        ogretmen.setOgretmenAd(ogretmenDto.getOgretmenAd());
        ogretmen.setOgretmenSoyad(ogretmenDto.getOgretmenSoyad());


        ogretmen.setStatu(1);
        ogretmen.setKayitEklenmeTarihi(new Date());
        ogretmen.setKisiselBilgiId(ogretmenDto.getKisiselBilgiId());


       ogretmenRepo.save(ogretmen);

        return new ResponseEntity<>("kayıt başarılı", HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity ogretmenGuncelle(OgretmenDto ogretmenDto){

        if (ogretmenDto.getOgretmenAd() == null && ogretmenDto.getOgretmenSoyad() == null) {
        throw new RuntimeException("girmek zorunlu!!");
        }
        Ogretmen ogretmen= null;
        ogretmen = ogretmenRepo.findById(ogretmenDto.getId());
        if(ogretmen == null) {return ResponseEntity.ok(ogretmenDto.getId() + " idli ogretmen bulunamadi!");};

        ogretmenDto.setId(ogretmenDto.getId());
        ogretmen.setOgretmenAd(ogretmenDto.getOgretmenAd());
        ogretmen.setOgretmenSoyad(ogretmenDto.getOgretmenSoyad());

        ogretmenRepo.save(ogretmen);

        return ResponseEntity.ok("ogretmen başarıyla güncellendi.");


    }


}
