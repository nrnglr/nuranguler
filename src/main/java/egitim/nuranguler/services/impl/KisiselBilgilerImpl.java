package egitim.nuranguler.services.impl;

import egitim.nuranguler.entitys.KisiselBilgiler;
import egitim.nuranguler.repository.KisiselBilgilerRepo;
import egitim.nuranguler.services.KisiselBilgilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KisiselBilgilerImpl implements KisiselBilgilerService {
    @Autowired
    KisiselBilgilerRepo kisiselbilgilerrepo;

    public List<KisiselBilgiler> getAll(){
        List<KisiselBilgiler> Kisisebilgilerlist = kisiselbilgilerrepo.findAll();
        return Kisisebilgilerlist ;
    }



}
