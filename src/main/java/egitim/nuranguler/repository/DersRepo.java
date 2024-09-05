package egitim.nuranguler.repository;

import egitim.nuranguler.entitys.Ders;
import egitim.nuranguler.entitys.Ogrenci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DersRepo extends JpaRepository<Ders , Integer> {
    @Query("select d from Ders d where d.statu=1 ")
    List<Ders> findAll();

    Ders findById(int id);






}
