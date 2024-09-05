package egitim.nuranguler.repository;

import egitim.nuranguler.entitys.Ogrenci;
import egitim.nuranguler.entitys.OgrenciDers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OgrenciDersRepo extends JpaRepository<OgrenciDers,Integer> {
    List<OgrenciDers> findAll();

}
