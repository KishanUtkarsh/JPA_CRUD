package jpa_crud.repository;
import java.math.BigDecimal;
import java.util.List;
import jpa_crud.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod(){
        // creating product and its object
        Product product = new Product();
        product.setSku("100abc2");
        product.setName("Hair gel");
        product.setDescription("Used for Styling mens Hair and can be used by women with short hairs.");
        product.setPrice(new BigDecimal("450"));
        product.setActive(true);
        product.setImgUrl("hair_gel.png");

        // saving the data for product
        Product testObject = productRepository.save(product);

        // display product information
        System.out.println(testObject.getId());
        System.out.println(testObject.toString());


    }

    @Test
    void updateUsingSaveMethod(){
        // retrieve the entity object from the table
        Long a = 1L;
        Product product = productRepository.findById(a).get();

        // update the entity data

        product.setPrice(new BigDecimal(560));


        // update the database using save method

        Product obj = productRepository.save(product);

        System.out.println(obj.toString());
        System.out.println(obj.getPrice());

    }

    @Test
    void findByIdMethod(){
        Product product = productRepository.findById(1L).get();
        System.out.println(product.toString());
    }

    @Test
    void saveAllMethod(){
        Product product = new Product();
        product.setName("Test Product");
        product.setDescription("This is a test product");
        product.setPrice(BigDecimal.valueOf(10.99));
        product.setActive(true);
        product.setImgUrl("https://example.com/image.jpg");
        product.setSku("SKU123");


        Product product2 = new Product();
        product2.setName("Test Product2");
        product2.setDescription("This is a test product2");
        product2.setPrice(BigDecimal.valueOf(102.99));
        product2.setActive(false);
        product2.setImgUrl("https://example.com/image2.jpg");
        product2.setSku("SKU1232");

        productRepository.saveAll(List.of(product,product2));
    }

    @Test
    void showAllMethod(){
        List<Product> list = productRepository.findAll();

        list.forEach((product)->
                        System.out.println(product.toString())
                );
    }

    @Test
    void deleteByIdMethod(){
        Long id = 1L;

        productRepository.deleteById(id);
        List<Product> list = productRepository.findAll();

        list.forEach((product)->
                System.out.println(product.toString())
        );
    }

    @Test
    void deleteAllMethod(){
        productRepository.deleteAll();

        List<Product> list = productRepository.findAll();

        list.forEach((product)->
                System.out.println(product.toString())
        );
    }

    @Test
    void countMethod(){
        // Hard coded for 3 test case
        assertEquals(3,productRepository.count());
    }

}