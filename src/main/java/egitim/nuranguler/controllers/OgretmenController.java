package egitim.nuranguler.controllers;

import egitim.nuranguler.dto.OgretmenDto;
import egitim.nuranguler.entitys.Ogretmen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import egitim.nuranguler.services.OgretmenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@Controller
public class OgretmenController {

    @Autowired
    OgretmenService ogretmenService;

    @GetMapping(value = "/ogretmen/listele")
    public ResponseEntity ogretmenListele() {
        List<Ogretmen> ogretmenler = ogretmenService.getAll();
        return new ResponseEntity<>(ogretmenler, HttpStatus.OK);
    }

    @PostMapping(value = "/ogretmen/kaydet")
    public ResponseEntity ogretmenKaydet(@RequestBody OgretmenDto ogretmenDto) {

        return ogretmenService.ogretmenKaydet(ogretmenDto);
    }

    @PutMapping(value="/ogretmen/guncelle")
    public ResponseEntity ogretmenguncelle(@RequestBody OgretmenDto ogretmenDto) {
        return ogretmenService.ogretmenGuncelle(ogretmenDto);


    }



}
