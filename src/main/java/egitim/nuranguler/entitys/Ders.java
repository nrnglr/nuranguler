package egitim.nuranguler.entitys;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Where;

import java.util.Date;

@Data
@Entity
@Where(clause = "statu = 1")
@Table(name="Ders")
public class Ders {

    @Id
    @SequenceGenerator(name="ders_id_seq", sequenceName = "ders_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ders_id_seq")
    @Column(name="id")
    private Long id;

    @Column(name="ders_adi")
    private String dersAdi;

    @Column(name="ders_kredisi")
    private String dersKredisi;

    @Column(name="kayit_ekleme_tarihi")
    private Date kayitEklemeTarihi;

    @Column(name="statu")
    private Integer statu;



}
