package egitim.nuranguler.services;

import egitim.nuranguler.dto.OgrenciDersDto;
import egitim.nuranguler.entitys.OgretmenDers;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OgretmenDersService {

    List<OgretmenDers> getAll();


}
