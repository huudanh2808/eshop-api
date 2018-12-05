package hcmus.ktpm.eshop.mapper;

import hcmus.ktpm.eshop.dao.Product;
import hcmus.ktpm.eshop.dto.ProductDto;

/**
 * An util to map Product DAO to Product DTO
 * */
public class ProductMapper {
    private ProductMapper() {}

    public static ProductDto toProductDto(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .importPrice(product.getImportPrice())
                .inStock(product.getInStock())
                .sellAmount(product.getSellAmount())
                .viewCount(product.getViewCount())
                .rating(product.getRating())
                .ratingCount(product.getRatingCount())
                .publishDate(product.getPublishDate())
                .classProductId(product.getClassProduct().getId())
                .manufacturerId(product.getManufacturer().getId())
                .authorId(product.getAuthor().getId())
                .build();
    }

}
