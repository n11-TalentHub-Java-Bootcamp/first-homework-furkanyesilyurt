package dao;

import base.BaseDao;
import entity.Category;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryDao extends BaseDao {

    public List<Category> findAll(){

        Query query = getCurrentSession().createQuery(
                "select kategori from Kategori kategori");

        return query.list();
    }
}