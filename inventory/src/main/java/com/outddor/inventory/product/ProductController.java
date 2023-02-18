package com.outddor.inventory.product;

import com.outddor.inventory.feign.ProductFeign;
import com.outddor.inventory.objects.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
public class ProductController {
    final ProductFeign productFeign;

    @Autowired
    public ProductController(ProductFeign productFeign) {
        this.productFeign = productFeign;
    }

    @GetMapping("/product")
    public List<Product> getProducts() {
        return productFeign.getProducts();
    }

    @GetMapping("/get/{id}")
    public Boolean getById(@PathVariable Long id){
        Product product = productFeign.checkIfExist(id);
        if(product instanceof Product) return true;
        return false;
    }

    @PutMapping("/get/{id}/{qte}")
    public void checkQte(@PathVariable Long id,@PathVariable Long qte) throws Exception {
        Product product = productFeign.checkIfExist(id);
        if(getById(id)){
            Long res = product.getQte() - qte;
            if (res>=0){
                productFeign.editQte(id,res);
            }
        }else throw new Exception("Product does id "+id+" not exist");
    }

}
