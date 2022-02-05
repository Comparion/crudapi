package pl.training.crudapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.training.crudapi.entity.Product;
import pl.training.crudapi.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> addProducts(List<Product> products){
        return productRepository.saveAll(products);
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(int id){
        return productRepository.findById(id).orElse(null);
    }

    public Product getProductByName(String name){
        return productRepository.findByName(name);
    }

    public Product updateProduct(Product product){
        Product productFromDB = productRepository.findById(product.getId()).orElse(null);
        productFromDB.setName(product.getName());
        productFromDB.setQuantity(product.getQuantity());
        productFromDB.setPrice(product.getPrice());
        return productRepository.save(productFromDB);
    }

    public String deleteProduct(int id){
        productRepository.deleteById(id);
        return "Delete record with id = " + id;
    }

}
