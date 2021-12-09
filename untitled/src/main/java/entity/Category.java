package entity;

import javax.persistence.*;

/**
 * id
 * adi
 * kirilim
 * ustKategoriId
 */
//Veritabanında bir karşılığı olan nesne tanımlamak için @Entity anotasyonu kullanılır.
// Hibernate bu anotasyonu gördüğü an veritabanında bir tablo oluşturacağını bilir.
@Entity
//Veritabanındaki tablonun ismini özelleştirmek için kullanılır. Eğer yazılmazsa class ismi kullanılır.
@Table(name = "KATEGORI")
public class Category {

    @SequenceGenerator(name = "generator", sequenceName = "KATEGORI_ID_SEQ")
    //Primary key. Her entityde olmak zorundadır.İlgili entity’nin uniqe değerini tutar.
    @Id
    //Birbirinden farklı otomatik değerler üretilmesini sağlar.
    @GeneratedValue(generator = "generator")
    //Sütun hakkında ayarlamalar yapılır. Sütun ismi ve notnull özelliği kullanıldı.
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "ADI", nullable = false, length = 50)
    private String adi;

    @Column(name = "KIRILIM")
    private Long kirilim;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_UST_KATEGORI")
    private Category ustKategori;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getUstKategori() {
        return ustKategori;
    }

    public void setUstKategori(Category ustKategori) {
        this.ustKategori = ustKategori;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public Long getKirilim() {
        return kirilim;
    }

    public void setKirilim(Long kirilim) {
        this.kirilim = kirilim;
    }

    @Override
    public String toString() {
        return "Kategori{" +
                "id=" + id +
                ", adi='" + adi + '\'' +
                ", kirilim=" + kirilim +
                ", ustKategori=" + ustKategori +
                '}';
    }
}