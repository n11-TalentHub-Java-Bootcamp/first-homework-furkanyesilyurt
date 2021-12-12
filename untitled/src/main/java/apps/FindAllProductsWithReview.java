package apps;

import dto.ProductReviewAllDto;
import entity.Product;
import entity.ProductReview;
import entityservices.ProductEntityService;

import java.util.List;

public class FindAllProductsWithReview {

    public static void main(String[] args) {

        ProductEntityService service = new ProductEntityService();
        List<ProductReviewAllDto> productList = service.findAllProductsWithReview();

        for (ProductReviewAllDto product : productList) {
            System.out.println(product);
        }
    }

}
