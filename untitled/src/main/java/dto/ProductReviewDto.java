package dto;

import java.math.BigDecimal;
import java.util.Date;

public class ProductReviewDto {
//tüm ürenlere ait yorumları gösteren dto classı.

    private String urunAdi;
    private String kategoriAdi;
    private BigDecimal urunFiyati;
    private String kullaniciAdi;
    private String kullaniciSoyadi;
    private String kullaniciEmail;
    private String kullaniciTelefon;
    private String yorum;
    private Date yorumTarihi;

    public ProductReviewDto() {
    }

    public ProductReviewDto(String urunAdi, String kategoriAdi, BigDecimal urunFiyati, String kullaniciAdi, String kullaniciSoyadi, String kullaniciEmail, String kullaniciTelefon, String yorum, Date yorumTarihi) {
        this.urunAdi = urunAdi;
        this.kategoriAdi = kategoriAdi;
        this.urunFiyati = urunFiyati;
        this.kullaniciAdi = kullaniciAdi;
        this.kullaniciSoyadi = kullaniciSoyadi;
        this.kullaniciEmail = kullaniciEmail;
        this.kullaniciTelefon = kullaniciTelefon;
        this.yorum = yorum;
        this.yorumTarihi = yorumTarihi;
    }

    public String getUrunAdi() {return urunAdi;}

    public void setUrunAdi(String urunAdi) {this.urunAdi = urunAdi;}

    public String getKategoriAdi() {return kategoriAdi;}

    public void setKategoriAdi(String kategoriAdi) {this.kategoriAdi = kategoriAdi;}

    public BigDecimal getUrunFiyati() {return urunFiyati;}

    public void setUrunFiyati(BigDecimal urunFiyati) {this.urunFiyati = urunFiyati;}

    public String getKullaniciAdi() {return kullaniciAdi;}

    public void setKullaniciAdi(String kullaniciAdi) {this.kullaniciAdi = kullaniciAdi;}

    public String getKullaniciSoyadi() {return kullaniciSoyadi;}

    public void setKullaniciSoyadi(String kullaniciSoyadi) {this.kullaniciSoyadi = kullaniciSoyadi;}

    public String getKullaniciEmail() {return kullaniciEmail;}

    public void setKullaniciEmail(String kullaniciEmail) {this.kullaniciEmail = kullaniciEmail;}

    public String getKullaniciTelefon() {return kullaniciTelefon;}

    public void setKullaniciTelefon(String kullaniciTelefon) {this.kullaniciTelefon = kullaniciTelefon;}

    public String getYorum() {return yorum;}

    public void setYorum(String yorum) {this.yorum = yorum;}

    public Date getYorumTarihi() {return yorumTarihi;}

    public void setYorumTarihi(Date yorumTarihi) {this.yorumTarihi = yorumTarihi;}

    @Override
    public String toString() {
        return  "ProductReviewDto{" +
                "urunAdi='" + urunAdi + '\'' +
                ", kategoriAdi='" + kategoriAdi + '\'' +
                ", urunFiyati=" + urunFiyati + '\'' +
                ", kullaniciAdi=" + kullaniciAdi + '\'' +
                ", kullaniciSoyadi=" + kullaniciSoyadi + '\'' +
                ", kullaniciEmail=" + kullaniciEmail + '\'' +
                ", kullaniciTelefon=" + kullaniciTelefon + '\'' +
                ", yorum=" + yorum + '\'' +
                ", yorumTarihi=" + yorumTarihi +
                '}';
    }

}
