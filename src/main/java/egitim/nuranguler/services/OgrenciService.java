package egitim.nuranguler.services;

import egitim.nuranguler.dto.OgrenciDto;
import egitim.nuranguler.entitys.Ogrenci;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface OgrenciService  {

    List<Ogrenci> getAll();

    ResponseEntity ogrenciKaydet(OgrenciDto ogrenciDto);

    ResponseEntity ogrenciGuncelle (OgrenciDto ogrenciDto);

    boolean ogrenciSilme (Long id);





}