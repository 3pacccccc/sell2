package com.imooc.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class ProductVo {

    @JsonProperty("name")
    private String productCategoryName;

    @JsonProperty("type")
    private Integer productCategoryType;

    @JsonProperty("foods")
    private List<ProductInfoVo> productInfoVoList;

}
