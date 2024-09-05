package egitim.nuranguler.entitys;

import egitim.nuranguler.services.KisiselBilgilerService;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Where;

import java.util.Date;

@Data
@Entity
@Where(clause = "statu = 1")
@Table(name="ogrenci")
public class Ogrenci {


    @Id
    @SequenceGenerator(name="ogrenci_id_seq", sequenceName = "ogrenci_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ogrenci_id_seq")
    @Basic(optional = false)
    @Column(name="id")
    private int id;

    @Column(name="ogrenci_ad")
    private String ogrenciAd;
    @Column(name="ogrenci_soyad")
    private String ogrenciSoyad;


    @Column(name="kayit_eklenme_tarihi")
    private Date kayitEklenmeTarihi;

    @Column(name="statu")
    private Integer statu;
    @Column(name="kisisel_bilgiler_id")
    private int kisiselBilgilerId;

//    @ManyToOne
//    @JoinColumn(name="kisisel_bilgiler_id", nullable = false)
//    private KisiselBilgiler kisisel_bilgiler;






}
