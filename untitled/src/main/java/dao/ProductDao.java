package dao;

import base.BaseDao;
import dto.ProductDetailDto;
import dto.ProductReviewAllDto;
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
                " new dto.ProductDetailDto( urun.adi, kategori.adi, urun.fiyat ) " +
                " from Product urun " +
                " left join Category kategori  on urun.kategori.id = kategori.id " +
                " where kategori.kirilim = :kirilim ";

        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("kirilim", kirilim);

        return query.list();
    }

    public ProductReview findAllReview(Long ida) {
//        String sql = "select urunyorum from ProductReview urunyorum where urunyorum.id = :id"  ;
//        String sql = "select urunyorum from ProductReview urunyorum where urunyorum.id = :givenId"  ;

        String sql = "select urun " +
                //"new dto.ProductReviewDto(urun.adi, urunyorum.yorum) " +
                "from Product urun " +
                "left join ProductReview urunyorum on urun.id = urunyorum.urunId " +
                "where urun.id = :givenId" ;


        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("givenId",ida);

        return (ProductReview) query.uniqueResult();
    }

    public List<ProductReviewAllDto> findAllProductsWithReview(){

        String sql = "select urun " +
                //"new dto.ProductReviewDto(urun.adi, urunyorum.yorum) " +
                "from ProductReview urunyorum " +
                "left join Product urun on urun.id = urunyorum.urunId " ;

        Query query = getCurrentSession().createQuery(sql);

        return query.list();

    }




}
