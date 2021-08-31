package com.summerschool.icecreamshop.init;

import com.summerschool.icecreamshop.model.Category;
import com.summerschool.icecreamshop.model.Product;
import com.summerschool.icecreamshop.model.Rate;
import com.summerschool.icecreamshop.model.Type;
import com.summerschool.icecreamshop.repository.CategoryRepository;
import com.summerschool.icecreamshop.repository.ProductRepository;
import com.summerschool.icecreamshop.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements ApplicationRunner {

    private CategoryRepository categoryRepository;

    private ProductRepository productRepository;

    private RateRepository rateRepository;

    @Autowired
    public DataInitializer(
            CategoryRepository categoryRepository,
            ProductRepository productRepository,
            RateRepository rateRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.rateRepository = rateRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Category category1 = new Category();
        category1.setName("Gelato");
        category1.setDescription("Cool yourself on a hot summer day with our gelato!");

        Category category2 = new Category();
        category2.setName("Donuts");
        category2.setDescription("Treat yourself with one of our various donuts!");

        categoryRepository.saveAll(Arrays.asList(category1, category2));

        Product product1 = new Product();
        product1.setTitle("Chocolate Mix Donuts");
        product1.setShortDescription("Treat yourself to ice cream infused with smooth Bourbon sprinkled");
        product1.setLongDescription("Donut with chocolate icing, dark chocolate curls, Kinder Bueno™ wafers and delicate milk chocolate lines");
        product1.setIngredients(Arrays.asList("Cream", "Milk", "Cane Sugar", "Cake Pieces", "Cake Base", "Sprinkles (Sugar, Coconut Oil, Buttermilk Powder, Natural Flavor, Spirulina Extract, Skim Milk)", "Eggs"));
        product1.setQuantity(100);
        product1.setAlergens(Arrays.asList("Milk", "Egg", "Soy", "Wheat"));
        product1.setPrice(2.5);
        product1.setCurrency("USD");
        product1.setPhotoUrls(Arrays.asList("url-small", "url-medium", "url-large"));
        product1.setType(Type.DONUTS);
        product1.setCategory(category2);

        Product product2 = new Product();
        product2.setTitle("Chocolate Donuts");
        product2.setShortDescription("Treat yourself to ice cream infused with smooth Bourbon sprinkled");
        product2.setLongDescription("Donut with chocolate icing");
        product2.setIngredients(Arrays.asList("Cream", "Milk", "Cane Sugar", "Cake Pieces", "Cake Base", "Eggs"));
        product2.setQuantity(100);
        product2.setAlergens(Arrays.asList("Milk", "Egg", "Soy", "Wheat"));
        product2.setPrice(2.5);
        product2.setCurrency("USD");
        product2.setPhotoUrls(Arrays.asList("url-small", "url-medium", "url-large"));
        product2.setType(Type.DONUTS);
        product2.setCategory(category2);

        Product product3 = new Product();
        product3.setTitle("Strawberry Donuts");
        product3.setShortDescription("Treat yourself to ice cream infused with smooth Bourbon sprinkled");
        product3.setLongDescription("Donut with strawberry icing and sprinkles");
        product3.setIngredients(Arrays.asList("Cream", "Milk", "Cane Sugar", "Cake Pieces", "Cake Base", "Sprinkles (Sugar, Coconut Oil, Buttermilk Powder, Natural Flavor, Spirulina Extract, Skim Milk)", "Strawberry extract", "Eggs"));
        product3.setQuantity(100);
        product3.setAlergens(Arrays.asList("Milk", "Egg", "Soy", "Wheat"));
        product3.setPrice(2.5);
        product3.setCurrency("USD");
        product3.setPhotoUrls(Arrays.asList("url-small", "url-medium", "url-large"));
        product3.setType(Type.DONUTS);
        product3.setCategory(category2);

        Product product4 = new Product();
        product4.setTitle("Toffee Donuts");
        product4.setShortDescription("Treat yourself to ice cream infused with smooth Bourbon sprinkled");
        product4.setLongDescription("Donut with milk chocolate icing, a Toffifee™ caramel candy and delicate chocolate lines");
        product4.setIngredients(Arrays.asList("Cream", "Milk", "Cane Sugar", "Cake Pieces", "Cake Base", "Toffifee candy", "Eggs"));
        product4.setQuantity(110);
        product4.setAlergens(Arrays.asList("Milk", "Egg", "Soy", "Wheat"));
        product4.setPrice(2.5);
        product4.setCurrency("USD");
        product4.setPhotoUrls(Arrays.asList("url-small", "url-medium", "url-large"));
        product4.setType(Type.DONUTS);
        product4.setCategory(category2);

        Product product5 = new Product();
        product5.setTitle("Banana Combo Donuts");
        product5.setShortDescription("Treat yourself to ice cream infused with smooth Bourbon sprinkled");
        product5.setLongDescription("Donut with milk chocolate icing, chocolate filling and banana slices");
        product5.setIngredients(Arrays.asList("Cream", "Milk", "Cane Sugar", "Cake Pieces", "Cake Base", "Bananas)", "Eggs"));
        product5.setQuantity(120);
        product5.setAlergens(Arrays.asList("Milk", "Egg", "Soy", "Wheat"));
        product5.setPrice(2.5);
        product5.setCurrency("USD");
        product5.setPhotoUrls(Arrays.asList("url-small", "url-medium", "url-large"));
        product5.setType(Type.DONUTS);
        product5.setCategory(category2);

        Product product6 = new Product();
        product6.setTitle("Bittersweet Mint Gelato");
        product6.setShortDescription("Treat yourself to ice cream infused with smooth Bourbon sprinkled");
        product6.setLongDescription("Gelato with mint, dark chocolate pieces and chocolate topping");
        product6.setIngredients(Arrays.asList("Cream", "Milk", "Cane Sugar", "Skimmed milk powder", "Eggs", "Mint", "Dark chocolate", "Chocolate topping"));
        product6.setQuantity(110);
        product6.setAlergens(Arrays.asList("Milk", "Egg", "Soy", "Wheat"));
        product6.setPrice(3);
        product6.setCurrency("USD");
        product6.setPhotoUrls(Arrays.asList("url-small", "url-medium", "url-large"));
        product6.setType(Type.GELATO);
        product6.setCategory(category1);

        Product product7 = new Product();
        product7.setTitle("Tiramisu Gelato");
        product7.setShortDescription("Treat yourself to ice cream infused with smooth Bourbon sprinkled");
        product7.setLongDescription("Tiramisu Gelato with coffee and cocoa");
        product7.setIngredients(Arrays.asList("Cream", "Milk", "Cane Sugar", "Skimmed milk powder", "Eggs", "Cocoa powder", "Coffee", "Ladyfingers"));
        product7.setQuantity(130);
        product7.setAlergens(Arrays.asList("Milk", "Egg", "Soy", "Wheat"));
        product7.setPrice(3.5);
        product7.setCurrency("USD");
        product7.setPhotoUrls(Arrays.asList("url-small", "url-medium", "url-large"));
        product7.setType(Type.GELATO);
        product7.setCategory(category1);

        Product product8 = new Product();
        product8.setTitle("Paradise Donuts");
        product8.setShortDescription("Treat yourself to ice cream infused with smooth Bourbon sprinkled");
        product8.setLongDescription("Donut with blue icing, star-shaped sprinkles, and Kinder Chocolate");
        product8.setIngredients(Arrays.asList("Cream", "Milk", "Cane Sugar", "Cake Pieces", "Cake Base", "Sprinkles (Sugar, Coconut Oil, Buttermilk Powder, Natural Flavor, Spirulina Extract, Skim Milk)", "Eggs"));
        product8.setQuantity(110);
        product8.setAlergens(Arrays.asList("Milk", "Egg", "Soy", "Wheat"));
        product8.setPrice(2.5);
        product8.setCurrency("USD");
        product8.setPhotoUrls(Arrays.asList("url-small", "url-medium", "url-large"));
        product8.setType(Type.DONUTS);
        product8.setCategory(category2);

        Product product9 = new Product();
        product9.setTitle("Ferrero Donuts");
        product9.setShortDescription("Treat yourself to ice cream infused with smooth Bourbon sprinkled");
        product9.setLongDescription("Donut with white chocolate icing, chocolate filling and Ferrero crumbles on top");
        product9.setIngredients(Arrays.asList("Cream", "Milk", "Cane Sugar", "Cake Pieces", "Cake Base", "Ferrero", "Sprinkles (Sugar, Coconut Oil, Buttermilk Powder, Natural Flavor, Spirulina Extract, Skim Milk)", "Eggs"));
        product9.setQuantity(100);
        product9.setAlergens(Arrays.asList("Milk", "Egg", "Soy", "Wheat"));
        product9.setPrice(2.5);
        product9.setCurrency("USD");
        product9.setPhotoUrls(Arrays.asList("url-small", "url-medium", "url-large"));
        product9.setType(Type.DONUTS);
        product9.setCategory(category2);

        Product product10 = new Product();
        product10.setTitle("Marshmallow Donuts");
        product10.setShortDescription("Treat yourself to ice cream infused with smooth Bourbon sprinkled");
        product10.setLongDescription("Donut with strawberry icing, and marshmallows");
        product10.setIngredients(Arrays.asList("Cream", "Milk", "Cane Sugar", "Cake Pieces", "Cake Base", "Marshmallows", "Eggs"));
        product10.setQuantity(110);
        product10.setAlergens(Arrays.asList("Milk", "Egg", "Soy", "Wheat"));
        product10.setPrice(2.5);
        product10.setCurrency("USD");
        product10.setPhotoUrls(Arrays.asList("url-small", "url-medium", "url-large"));
        product10.setType(Type.DONUTS);
        product10.setCategory(category2);

        Product product11 = new Product();
        product11.setTitle("Chocolate Sprinkled Donuts");
        product11.setShortDescription("Treat yourself to ice cream infused with smooth Bourbon sprinkled");
        product11.setLongDescription("Donut with chocolate icing, sprinkles and delicate white chocolate lines");
        product11.setIngredients(Arrays.asList("Cream", "Milk", "Cane Sugar", "Cake Pieces", "Cake Base", "Sprinkles (Sugar, Coconut Oil, Buttermilk Powder, Natural Flavor, Spirulina Extract, Skim Milk)", "Eggs"));
        product11.setQuantity(100);
        product11.setAlergens(Arrays.asList("Milk", "Egg", "Soy", "Wheat"));
        product11.setPrice(2.5);
        product11.setCurrency("USD");
        product11.setPhotoUrls(Arrays.asList("url-small", "url-medium", "url-large"));
        product11.setType(Type.DONUTS);
        product11.setCategory(category2);

        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5, product6, product7, product8, product9, product10, product11));

        Rate rate1 = new Rate();
        rate1.setProduct(product1);
        rate1.setRate(5);

        Rate rate2 = new Rate();
        rate2.setProduct(product1);
        rate2.setRate(4);

        Rate rate3 = new Rate();
        rate3.setProduct(product2);
        rate3.setRate(5);

        Rate rate4 = new Rate();
        rate4.setProduct(product3);
        rate4.setRate(5);

        Rate rate5 = new Rate();
        rate5.setProduct(product3);
        rate5.setRate(2);

        Rate rate6 = new Rate();
        rate6.setProduct(product4);
        rate6.setRate(3);

        Rate rate7 = new Rate();
        rate7.setProduct(product5);
        rate7.setRate(5);

        Rate rate8 = new Rate();
        rate8.setProduct(product5);
        rate8.setRate(5);

        Rate rate9 = new Rate();
        rate9.setProduct(product5);
        rate9.setRate(4);

        Rate rate10 = new Rate();
        rate10.setProduct(product6);
        rate10.setRate(5);

        Rate rate11 = new Rate();
        rate11.setProduct(product6);
        rate11.setRate(3);

        Rate rate12 = new Rate();
        rate12.setProduct(product7);
        rate12.setRate(4);

        rateRepository.saveAll(Arrays.asList(rate1, rate2, rate3, rate4, rate5, rate6, rate7, rate8, rate9, rate10, rate11, rate12));
    }

}
