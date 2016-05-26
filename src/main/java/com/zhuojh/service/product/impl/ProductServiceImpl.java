package com.zhuojh.service.product.impl;

import com.zhuojh.mapper.product.ProductMapper;
import com.zhuojh.mapper.product.ProductStoreMapper;
import com.zhuojh.model.product.Product;
import com.zhuojh.model.product.ProductStore;
import com.zhuojh.service.product.ProductService;
import common.page.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/5/26.
 */
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductStoreMapper productStoreMapper;

    /**
     * 查询产品信息
     * @param product
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public Pagination selectProductsByPage(Product product, Integer pageNo, Integer pageSize) {
        Pagination page = new Pagination();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        List<Product> list = productMapper.selectByPage(product, page);
        page.setList(list);
        return page;
    }

    /**
     * 查询产品库存
     * @param productStore
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public Pagination selectProductStoreByPage(ProductStore productStore, Integer pageNo, Integer pageSize) {
        Pagination page = new Pagination();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        List<ProductStore> list = productStoreMapper.selectByPage(productStore, page);
        page.setList(list);
        return page;
    }
}
