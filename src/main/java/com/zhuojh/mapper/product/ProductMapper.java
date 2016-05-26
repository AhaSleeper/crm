package com.zhuojh.mapper.product;

import com.zhuojh.model.product.Product;
import common.page.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> selectByPage(@Param("product") Product product, @Param("page") Pagination page);
}