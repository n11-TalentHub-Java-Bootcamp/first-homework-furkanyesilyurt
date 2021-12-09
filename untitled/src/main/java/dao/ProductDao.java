package dao;

import base.BaseDao;
import dto.ProductDetailDto;
import dto.ProductReviewDto;
import entity.Product;
import entity.ProductReview;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;

public class ProductDao extends BaseDao {

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
                " new dto.UrunDetayDto( urun.adi, kategori.adi, urun.fiyat ) " +
                " from Product urun " +
                " left join Category kategori  on urun.kategori.id = kategori.id " +
                " where kategori.kirilim = :kirilim ";

        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("kirilim", kirilim);

        return query.list();
    }

    public ProductReview findAllReview(Long id) {
//        String sql = "select urunyorum from ProductReview urunyorum where urunyorum.id = :id"  ;

        String sql = "select " +
                "new dto.ProductReviewDto( urunyorum.id, urunyorum.yorum ) " +
                "from ProductReview urunyorum " +
                "left join Product urun on urun.id = urunyorum.urunId " +
                "where urunyorum.id = :givenid"  ;

//        String sql = "select urunyorum from ProductReview urunyorum where urunyorum.id = :givenId"  ;

        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("givenId",id);

        return (ProductReview) query.uniqueResult();
    }

}
