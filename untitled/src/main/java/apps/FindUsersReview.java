package apps;

import dto.ProductReviewAllDto;
import dto.UserReviewsDto;
import entityservices.ProductEntityService;

import java.util.List;

public class FindUsersReview {

    public static void main(String[] args) {
        //Kullanıcıların yorumlarının görüldüğü uygulama. Ödev-4
        ProductEntityService service = new ProductEntityService();
        List<UserReviewsDto> userReviewsList = service.findUsersReview();

        for (UserReviewsDto userReviewsDto : userReviewsList) {
            System.out.println(userReviewsDto);
        }
    }

}
