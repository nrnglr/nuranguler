package egitim.nuranguler.repository;

import egitim.nuranguler.entitys.KisiselBilgiler;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KisiselBilgilerRepo extends JpaRepository<KisiselBilgiler,Integer> {

    List<KisiselBilgiler> findAll();
}
