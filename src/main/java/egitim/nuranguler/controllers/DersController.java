package egitim.nuranguler.controllers;

import egitim.nuranguler.dto.DersDto;
import egitim.nuranguler.entitys.Ders;
import egitim.nuranguler.services.DersService;
import egitim.nuranguler.services.OgrenciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DersController {
    @Autowired
    DersService dersService;


    @GetMapping(value ="/ders")
    public ResponseEntity  DersListele(){
        List<Ders> dersler = dersService. getAll();
        return new ResponseEntity(dersler, HttpStatus.OK);


    }
    @PostMapping(value = "/ders/kaydet")
    public ResponseEntity  DersKaydet(@RequestBody DersDto dersDto){
        return dersService.dersKaydet(dersDto);
    }
    @PutMapping(value="/ders/guncelle")
    public ResponseEntity dersGuncelle(@RequestBody DersDto dersDto){
        return dersService.dersGuncelle(dersDto);
    }
    @DeleteMapping(value ="/ders/silme")
    public ResponseEntity dersSilme(@RequestParam (value = "id") Long id){
        if(dersService.dersSilme(id)){
            return new ResponseEntity("ders silme başarılı", HttpStatus.OK);
        }
        return new ResponseEntity("ders silme başarısız",HttpStatus.NOT_FOUND);

    }






}
