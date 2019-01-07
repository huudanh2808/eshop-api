package hcmus.ktpm.eshop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    @JsonProperty("id_product")
    private String id;

    private String name;

    private String description;

    private Integer price;

    private Integer viewCount;

    private Integer sellAmount;

    private Double rating;

    private Integer ratingCount;

    private LocalDate publishDate;

    private Integer inStock;

    private Integer importPrice;

    private Integer manufacturerId;

    private Integer classProductId;

    private Integer authorId;

    private String manufacturerName;

    private String classProductName;

    private String authorName;

    @JsonProperty("out_of_stock")
    private boolean isOutOfStock;
}
