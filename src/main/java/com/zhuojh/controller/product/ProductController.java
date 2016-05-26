package com.zhuojh.controller.product;

import com.zhuojh.model.product.Product;
import com.zhuojh.model.product.ProductStore;
import com.zhuojh.service.product.ProductService;
import common.page.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/5/26.
 */
@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/productList")
    public String getProductList(Product product, Integer currentIndex, Integer sizePerPage, ModelMap modelMap){
        if(currentIndex == null || currentIndex == 0) currentIndex = 1;
        if(sizePerPage == null || sizePerPage == 0) sizePerPage = 10;
        Pagination page = productService.selectProductsByPage(product,currentIndex, sizePerPage);
        modelMap.addAttribute("page",page);
        return "product/products";
    }

    @RequestMapping("/productStoreList")
    public String getProductStoreList(ProductStore productStore, Integer currentIndex, Integer sizePerPage, ModelMap modelMap){
        if(currentIndex == null || currentIndex == 0) currentIndex = 1;
        if(sizePerPage == null || sizePerPage == 0) sizePerPage = 10;
        Pagination page = productService.selectProductStoreByPage(productStore, currentIndex, sizePerPage);
        modelMap.addAttribute("page",page);
        return "product/productStores";
    }
}
