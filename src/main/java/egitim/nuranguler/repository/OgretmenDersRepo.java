package egitim.nuranguler.repository;

import egitim.nuranguler.entitys.Ogrenci;
import egitim.nuranguler.entitys.Ogretmen;
import egitim.nuranguler.entitys.OgretmenDers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface OgretmenDersRepo extends JpaRepository<OgretmenDers, Integer> {

    @Query("select ods from OgretmenDers ods")
    List<OgretmenDers> findAll();



}
