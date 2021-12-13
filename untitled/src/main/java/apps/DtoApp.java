package apps;

import dto.ProductDetailDto;
import entity.Product;
import entityservices.ProductEntityService;

import java.util.List;

public class DtoApp {

    public static void main(String[] args) {

        ProductEntityService service = new ProductEntityService();
        List<ProductDetailDto> productList = service.findAllUrunDetayDtoByKategoriKirilim(3L);

        for (ProductDetailDto productDetayDto : productList) {
            System.out.println(productDetayDto);
        }
    }
}