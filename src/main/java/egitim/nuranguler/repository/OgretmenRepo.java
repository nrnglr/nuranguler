package egitim.nuranguler.repository;

import egitim.nuranguler.entitys.Ders;
import egitim.nuranguler.entitys.Ogrenci;
import egitim.nuranguler.entitys.Ogretmen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OgretmenRepo extends JpaRepository<Ogretmen, Integer> {

    @Query("select o from Ogretmen o where  o.statu = 1")
    List<Ogretmen> findAll();



    Ogretmen findById(int id);



}


