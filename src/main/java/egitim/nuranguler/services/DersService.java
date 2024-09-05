package egitim.nuranguler.services;

import egitim.nuranguler.dto.DersDto;
import egitim.nuranguler.entitys.Ders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DersService {


    List<Ders> getAll();

    ResponseEntity dersKaydet(DersDto dersDto);

    ResponseEntity dersGuncelle(DersDto dersDto);

   Boolean dersSilme(Long id);
}