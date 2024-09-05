package egitim.nuranguler.services;

import egitim.nuranguler.dto.OgrenciDersDto;
import egitim.nuranguler.entitys.OgrenciDers;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OgrenciDersService {

    List<OgrenciDers> getAll();

    ResponseEntity ogrenciDersKaydet(OgrenciDersDto ogrenciDersDto);


}
