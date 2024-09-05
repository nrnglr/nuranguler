package egitim.nuranguler.controllers;

import egitim.nuranguler.dto.DersDto;
import egitim.nuranguler.dto.OgrenciDto;
import egitim.nuranguler.dto.OgretmenDto;
import egitim.nuranguler.entitys.Ogrenci;
import egitim.nuranguler.services.OgrenciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/ogrenci")
public class OgrenciController {

    @Autowired
    private OgrenciService ogrenciService;


    @GetMapping(value = "/listele")
    public ResponseEntity<?> ogrenciListele() {
        List<Ogrenci> ogrenciler = ogrenciService.getAll();
        return new ResponseEntity<>(ogrenciler, HttpStatus.OK);
    }

    @PostMapping(value = "/kaydet")
    public ResponseEntity ogrenciKaydet(@RequestBody OgrenciDto ogrenciDto) {

        return ogrenciService.ogrenciKaydet(ogrenciDto);
    }

    @PutMapping(value = "/guncelle")
    public ResponseEntity ogrenciGuncelle(@RequestBody OgrenciDto ogrenciDto) {
        return ogrenciService.ogrenciGuncelle(ogrenciDto);
    }
    @DeleteMapping(value="/silme")
    public ResponseEntity ogrenciSilme(@RequestParam(value = "id") Long id) {
        if (ogrenciService.ogrenciSilme(id)) {
            return new ResponseEntity<>("ogrenci silme başarılı", HttpStatus.OK);
        }
       return new ResponseEntity<>("öğrenci silme hatalı", HttpStatus.NOT_FOUND);
    }




}