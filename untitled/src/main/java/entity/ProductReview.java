package entity;

import javax.persistence.*;
import java.util.Date;

/* id
yorum
yorum tarihi
urun id
kullanici id
 */

/**
 * Ürünyorum tablosuna ait entity. Ödev-1
 */
@Entity
@Table(name = "urunyorum")
public class ProductReview {

    @SequenceGenerator(name = "generator", sequenceName = "URUNYORUM_ID_SEQ")
    @Id
    @GeneratedValue(generator = "generator")
    private Long id;

    @Column(length = 500, name = "YORUM")
    private String yorum;

    @Column(name = "YORUM_TARIHI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date yorumTarihi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_URUN",
            foreignKey = @ForeignKey(name = "FK_YORUM_URUN_ID")
    )
    private Product urunId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_KULLANICI",
            foreignKey = @ForeignKey(name = "FK_YORUM_KULLANICI_ID")
    )
    private User kullaniciId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYorum() {
        return yorum;
    }

    public void setYorum(String yorum) {
        this.yorum = yorum;
    }

    public Date getYorumTarihi() {
        return yorumTarihi;
    }

    public void setYorumTarihi(Date yorumTarihi) {
        this.yorumTarihi = yorumTarihi;
    }

    public Product getUrunId() {
        return urunId;
    }

    public void setUrunId(Product urunId) {
        this.urunId = urunId;
    }

    public User getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(User kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    @Override
    public String toString() {
        return "UrunYorum{" +
                "id=" + id +
                ", yorum='" + yorum + '\'' +
                ", yorumTarihi=" + yorumTarihi +
                ", urunId=" + urunId +
                ", kullaniciId=" + kullaniciId +
                '}';
    }

}
