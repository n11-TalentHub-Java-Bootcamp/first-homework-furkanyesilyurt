package apps;

import entity.Product;
import entityservices.ProductEntityService;

import java.util.List;

public class FindAllApp {

    public static void main(String[] args) {

        ProductEntityService service = new ProductEntityService();
        List<Product> productList = service.findAll();

        for (Product product : productList) {
            System.out.println(product);
        }
    }
}