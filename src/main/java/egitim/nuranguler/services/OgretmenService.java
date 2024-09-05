package egitim.nuranguler.services;

import egitim.nuranguler.dto.OgretmenDto;
import egitim.nuranguler.entitys.Ogretmen;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OgretmenService {

    List<Ogretmen> getAll();

    ResponseEntity ogretmenKaydet(OgretmenDto ogretmenDto);

    ResponseEntity ogretmenGuncelle(OgretmenDto ogretmenDto);



}