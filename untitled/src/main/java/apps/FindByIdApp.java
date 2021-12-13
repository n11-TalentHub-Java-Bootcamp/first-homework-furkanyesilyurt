package apps;

import entity.Product;
import entityservices.ProductEntityService;

public class FindByIdApp {

    public static void main(String[] args) {

        ProductEntityService service = new ProductEntityService();
        Product product = service.findById(1L);

        System.out.println(product);
    }
}