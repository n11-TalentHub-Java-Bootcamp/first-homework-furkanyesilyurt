package dto;

import java.math.BigDecimal;

public class ProductReviewAllDto {

    private Long urunId;
    private String urunAdi;
    private BigDecimal urunFiyati;
    private int yorumSayisi;

    public ProductReviewAllDto() {
    }

    public ProductReviewAllDto(Long urunId, String urunAdi, BigDecimal urunFiyati, int yorumSayisi) {
        this.urunId = urunId;
        this.urunAdi = urunAdi;
        this.urunFiyati = urunFiyati;
        this.yorumSayisi = yorumSayisi;
    }

    public Long getUrunId() {
        return urunId;
    }

    public void setUrunId(Long urunId) {
        this.urunId = urunId;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public BigDecimal getUrunFiyati() {
        return urunFiyati;
    }

    public void setUrunFiyati(BigDecimal urunFiyati) {
        this.urunFiyati = urunFiyati;
    }

    public int getYorumSayisi() {
        return yorumSayisi;
    }

    public void setYorumSayisi(int yorumSayisi) {
        this.yorumSayisi = yorumSayisi;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
