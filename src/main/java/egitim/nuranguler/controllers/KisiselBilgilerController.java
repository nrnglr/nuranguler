package egitim.nuranguler.controllers;

import egitim.nuranguler.entitys.KisiselBilgiler;
import egitim.nuranguler.services.KisiselBilgilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class KisiselBilgilerController {
    @Autowired
    KisiselBilgilerService kisiselbilgilerservice;
    @GetMapping(value="kisiselbilgiler")
    public ResponseEntity kisiselbilgiler(){
        List<KisiselBilgiler> kisiselbilgilerlist  = kisiselbilgilerservice .getAll();
        return new ResponseEntity<>(kisiselbilgilerlist, HttpStatus.OK);
    }
}
