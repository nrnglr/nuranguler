package egitim.nuranguler.services.impl;

import egitim.nuranguler.dto.DersDto;
import egitim.nuranguler.entitys.Ders;
import egitim.nuranguler.repository.DersRepo;
import egitim.nuranguler.services.DersService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class DersImpl implements DersService {
    @Autowired
    DersRepo dersRepo;

    public List<Ders> getAll() {
        List<Ders> Dersler = dersRepo.findAll();
        return Dersler;
    }

    @Override
    public ResponseEntity dersKaydet(DersDto dersDto) {

        try {
            if (dersDto.getDersAdi() == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "DersAdi is null");
            }
            if (dersDto.getDersKredisi() == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "DersKredisi is null");
            }

            Ders ders = new Ders();
            // ders = dersRepo.findById(dersDto.getId());

            // if(dersDto.getId() == null) {return ResponseEntity.ok(dersDto.getId() + " idli ders bulunamadi!");

            // ders.setId(dersDto.getId());
            ders.setDersAdi(dersDto.getDersAdi());
            ders.setDersKredisi(dersDto.getDersKredisi());
            ders.setKayitEklemeTarihi(new Date());
            ders.setStatu(1);

            dersRepo.save(ders);
            return new ResponseEntity("kayıt başarılı", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("kayıt başarılı", HttpStatus.OK);
        }


    }

    @Override
    public ResponseEntity dersGuncelle(DersDto dersDto) {


        if (dersDto.getDersAdi() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "DersAdi is null");
        }


        if (dersDto.getDersKredisi() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "DersKredisi is null");

        }

            Ders ders = null;
            ders = dersRepo.findById(dersDto.getId());

            if(ders == null) {return ResponseEntity.ok(dersDto.getId() + " idli ders bulunamadi!");};

//
            dersDto.setId(dersDto.getId());
            ders.setDersAdi(dersDto.getDersAdi());
            ders.setDersKredisi(dersDto.getDersKredisi());
            ders.setKayitEklemeTarihi(new Date());
            ders.setStatu(1);
            dersRepo.save(ders);
            return ResponseEntity.ok("ders güncellendi :)");





    }
    @Override
    public Boolean dersSilme(Long id){
        try{
            Ders ders =dersRepo.findById(Math.toIntExact(id));
            if(ders==null){
                return true;
            }ders.setStatu(1);
            dersRepo.saveAndFlush(ders);
            return true;
        }catch(Exception e){
            return false;

        }
    }


}
