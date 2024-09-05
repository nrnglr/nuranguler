package egitim.nuranguler.repository;

import egitim.nuranguler.dto.OgrenciDto;
import egitim.nuranguler.dto.OgretmenDto;
import egitim.nuranguler.entitys.Ogrenci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface OgrenciRepo extends JpaRepository<Ogrenci, Integer> {

    @Query("select u from Ogrenci u where u.statu=1")
    List<Ogrenci> findAll();

   // Ogrenci findById(int id);

    Ogrenci findById(int id);





}
