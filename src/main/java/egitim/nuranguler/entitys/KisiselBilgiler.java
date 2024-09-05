package egitim.nuranguler.entitys;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="kisisel_bilgiler")
public class KisiselBilgiler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name ="id")
    private Integer id;

    @Column(name="ad_soyad")
    private String adSoyad;

    @Column(name="yas")
    private Integer yas;

    @Column(name="telefon_no")
    private String telefonNo;

    @Column(name="statu")
    private Integer statu;
}
