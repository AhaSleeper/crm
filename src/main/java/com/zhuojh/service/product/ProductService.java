package com.zhuojh.service.product;

import com.zhuojh.model.product.Product;
import com.zhuojh.model.product.ProductStore;
import common.page.Pagination;

/**
 * Created by Administrator on 2016/5/25.
 */
public interface ProductService {
    Pagination selectProductsByPage(Product product, Integer pageNo, Integer pageSize);
    Pagination selectProductStoreByPage(ProductStore productStore, Integer pageNo, Integer pageSize);
}
