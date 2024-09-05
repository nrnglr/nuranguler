package egitim.nuranguler.services.impl;

import egitim.nuranguler.dto.OgretmenDto;
import egitim.nuranguler.entitys.Ogretmen;
import egitim.nuranguler.entitys.OgretmenDers;
import egitim.nuranguler.repository.OgretmenDersRepo;
import egitim.nuranguler.services.OgretmenDersService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class OgretmenDersImpl implements OgretmenDersService {

    @Autowired
    OgretmenDersRepo ogretmenDersRepo;

    @Override
    public List<OgretmenDers> getAll(){
        List<OgretmenDers> ogretmenders =ogretmenDersRepo.findAll();
        return ogretmenders;
    }




}
