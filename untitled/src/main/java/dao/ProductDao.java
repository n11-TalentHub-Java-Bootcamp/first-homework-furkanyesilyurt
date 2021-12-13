package dao;

import base.BaseDao;
import dto.ProductDetailDto;
import dto.ProductReviewAllDto;
import dto.ProductReviewDto;
import dto.UserReviewsDto;
import entity.Product;
import entity.ProductReview;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;

public class ProductDao extends BaseDao {
    /**   DATA ACCESS LAYER / OBJECT
        Veritabanına bağlantı sağlayıp sorgu yapan classtır.
        ödev kapsamında yazılan metotlar ürüne ilişkin sorgu içerdikleri için bu sınıfa yazılmıştır.
        Yeni oluşturulan entityler için farklı bir dao classı oluşturulup BaseDao sınıfından extends edildikten sonra o class'a ait metotlar yazılabilir.
    */
    public List<Product> findAll() {

        String sql = "select urun from Product urun";

        Query query = getCurrentSession().createQuery(sql);

        return query.list();
    }

    public Product findById(Long id) {

        String sql = "select urun from Product urun where urun.id = :givenId";

        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("givenId", id);

        return (Product) query.uniqueResult();
    }

    public List<Product> findAllUrunListByFiyatGeAndFiyatLe(BigDecimal fiyatGe, BigDecimal fiyatLe) {

        String sql = "select urun from Product urun where 1=1 ";

        if (fiyatGe != null) {
            sql = sql + " and urun.fiyat >= :fiyatGe ";
        }

        if (fiyatLe != null) {
            sql = sql + " and urun.fiyat <= :fiyatLe ";
        }

        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("fiyatLe", fiyatLe);
        query.setParameter("fiyatGe", fiyatGe);

        return query.list();
    }

    public List<Product> findAllUrunListByFiyatBetween(BigDecimal fiyatGe, BigDecimal fiyatLe) {

        String sql = "select urun from Product urun where 1=1 ";

        if (fiyatGe != null && fiyatLe != null) {
            sql = sql + " and urun.fiyat between :fiyatGe and :fiyatLe ";
        }

        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("fiyatLe", fiyatLe);
        query.setParameter("fiyatGe", fiyatGe);

        return query.list();
    }

    public List<Product> findAllUrunByKategoriKirilim(Long kirilim) {

        String sql = " select urun from Product urun " +
                " left join Category kategori  on urun.kategori.id = kategori.id " +
                " where kategori.kirilim = :kirilim ";

        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("kirilim", kirilim);

        return query.list();
    }

    public List<ProductDetailDto> findAllUrunDetayDtoByKategoriKirilim(Long kirilim) {

        String sql = " select " +
                " new dto.ProductDetailDto( urun.adi, kategori.adi, urun.fiyat ) " +
                " from Product urun " +
                " left join Category kategori  on urun.kategori.id = kategori.id " +
                " where kategori.kirilim = :kirilim ";

        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("kirilim", kirilim);

        return query.list();
    }

    public List<ProductReviewDto> findAllReview(Long givenId) {
//        String sql = "select urunyorum from ProductReview urunyorum where urunyorum.id = :id"  ;
//        String sql = "select urunyorum from ProductReview urunyorum where urunyorum.id = :givenId"  ;

        String sql = "select new " +
                ProductReviewDto.class.getName() +
                "(product.adi, category.adi, product.fiyat, user.adi, user.soyadi, user.email, user.telefon, productReview.yorum, productReview.yorumTarihi) " +
                "from Product product " +
                "left join ProductReview productReview on product.id = productReview.urunId " +
                "left join User user on productReview.kullaniciId = user.id " +
                "left join Category category on category.id = product.kategori " +
                "where product.id = :givenId";


        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("givenId", givenId);

        return query.list();
    }

    public List<ProductReviewAllDto> findAllProductsWithReview() {
    //count komutu ile urune ait yapılan yorumları gösteren hql sorgusu.
        String sql = "select new " +
                ProductReviewAllDto.class.getName() +
                "(product.id, product.adi, product.fiyat, count(productReview.id)) " +
                "from Product product " +
                "left join ProductReview productReview on product.id = productReview.urunId " +
                "group by product.id ";

        Query query = getCurrentSession().createQuery(sql);

        return query.list();
    }

    public List<UserReviewsDto> findUsersReview() {
    //tüm yorum yapan kullanıcıların yorumlarının görüldüğü hql sorgusu.
        String sql = "select new " +
                UserReviewsDto.class.getName() +
                "(user.id, user.adi, product.adi, productReview.yorum, productReview.yorumTarihi) " +
                "from User user, Product product " +
                "left join ProductReview productReview on user.id = productReview.kullaniciId " +
                "order by user.id ";

        Query query = getCurrentSession().createQuery(sql);

        return query.list();
    }
}
