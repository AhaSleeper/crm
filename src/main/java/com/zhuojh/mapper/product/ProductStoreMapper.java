package com.zhuojh.mapper.product;

import com.zhuojh.model.product.ProductStore;
import common.page.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductStoreMapper {
    int deleteByPrimaryKey(Integer storeId);

    int insert(ProductStore record);

    int insertSelective(ProductStore record);

    ProductStore selectByPrimaryKey(Integer storeId);

    int updateByPrimaryKeySelective(ProductStore record);

    int updateByPrimaryKey(ProductStore record);

    List<ProductStore> selectByPage(@Param("productStore") ProductStore productStore,@Param("page") Pagination page);
}