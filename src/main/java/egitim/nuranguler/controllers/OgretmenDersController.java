package egitim.nuranguler.controllers;

import egitim.nuranguler.entitys.OgretmenDers;
import egitim.nuranguler.services.OgretmenDersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class OgretmenDersController {
    @Autowired
    OgretmenDersService ogretmenDersService;

    @GetMapping(value="ogretmenders")
    public ResponseEntity OgretmendersListele(){

        List<OgretmenDers> ogretmenDersList =ogretmenDersService.getAll();
        return new ResponseEntity<>(ogretmenDersList, HttpStatus.OK);
    }
}
