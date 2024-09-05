package egitim.nuranguler.entitys;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@Entity
@Table(name ="OgrenciDers")
public class OgrenciDers {
    @Id
    @SequenceGenerator(name="ogrenci_id_seq", sequenceName = "ogrenci_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ogrenci_id_seq")
    @Basic(optional = false)
    @Column(name="id")
    private Integer id;


   @Column(name="ogrenci_id")
    private Integer ogrenciId;

   @Column(name="ogretmen_ders_id")
    private Integer ogretmenDersId;

   @ManyToOne
   @JoinColumn(name ="ogrenci_id", insertable = false,updatable = false)
    private Ogrenci ogrenci;









}
