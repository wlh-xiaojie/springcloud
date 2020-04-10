package com.alibaba.goods.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_category_brand")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryBrand {

    //分类id
    @Id
    private Integer categoryId;
    //品牌id
    @Id
    private Integer brandId;

}
