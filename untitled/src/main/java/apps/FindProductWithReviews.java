package apps;

import dto.ProductDetailDto;
import dto.ProductReviewDto;
import entity.ProductReview;
import entityservices.ProductEntityService;

import java.util.List;

public class FindProductWithReviews {

    public static void main(String[] args) {

        ProductEntityService service = new ProductEntityService();
        List<ProductReviewDto> productReviewList = service.findAllReview(1L);

        for (ProductReviewDto productReviewDto : productReviewList) {
            System.out.println(productReviewDto);
        }
    }

}
