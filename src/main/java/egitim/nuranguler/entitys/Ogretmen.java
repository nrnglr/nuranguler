package egitim.nuranguler.entitys;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Where;

import java.util.Date;

@Data
@Entity
@Where(clause = "statu = 1")
@Table(name="ogretmen")
public class Ogretmen {
    @Id
    //@Basic(optional = false),
    @SequenceGenerator(name="ogretmen_id_seq", sequenceName = "ogretmen_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ogretmen_id_seq")
    @Column(name = "id")
    private int id;

    @Column(name = "ogretmen_ad")
    private String ogretmenAd;

    @Column(name = "ogretmen_soyad")
    private String ogretmenSoyad;

    @Column(name = "statu")
    private Integer statu ;

    @Column (name="kayit_eklenme_tarihi")
    private Date kayitEklenmeTarihi;

    @Column (name="kisisel_bilgi_id")
   private int kisiselBilgiId;



//    @ManyToOne
//    @JoinColumn(name ="kisisel_bilgi_id" )
//    private KisiselBilgiler kisiselBilgiler;


}
