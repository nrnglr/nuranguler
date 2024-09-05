package egitim.nuranguler.controllers;


import egitim.nuranguler.dto.OgrenciDersDto;
import egitim.nuranguler.entitys.OgrenciDers;
import egitim.nuranguler.services.OgrenciDersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class OgrenciDersController {
    @Autowired
    OgrenciDersService ogrenciDersService;
    @GetMapping(value = "ogrenciders")

    public ResponseEntity ogrenciders() {
        List<OgrenciDers> ogrenciderslist= ogrenciDersService.getAll();
        return new ResponseEntity<>(ogrenciderslist, HttpStatus.OK);

    }

    @PostMapping(value = "/kaydet")
    public ResponseEntity ogrenciDersKaydet(@RequestBody OgrenciDersDto ogrenciDersDto) {

        return new ogrenciDersService.ogrenciDersKaydet(ogrenciDersDto);
    }
}
