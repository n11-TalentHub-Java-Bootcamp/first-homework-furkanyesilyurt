package apps;

import entity.ProductReview;
import entityservices.ProductEntityService;

import java.util.List;

public class FindProductWithReviews {

    public static void main(String[] args) {

//        long aid = 1;

        ProductEntityService service = new ProductEntityService();
        ProductReview productReview = service.findAllReview(1L);

        System.out.println(productReview);
    }

}
