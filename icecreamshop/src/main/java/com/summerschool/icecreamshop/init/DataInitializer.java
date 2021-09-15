package com.summerschool.icecreamshop.init;

import com.summerschool.icecreamshop.model.*;
import com.summerschool.icecreamshop.repository.*;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements ApplicationRunner {

    private CategoryRepository categoryRepository;

    private ProductRepository productRepository;

    private RateRepository rateRepository;

    private BasketRepository basketRepository;

    private BasketProductRepository basketProductRepository;

    @Autowired
    public DataInitializer(
            CategoryRepository categoryRepository,
            ProductRepository productRepository,
            RateRepository rateRepository,
            BasketRepository basketRepository,
            BasketProductRepository basketProductRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.rateRepository = rateRepository;
        this.basketRepository=basketRepository;
        this.basketProductRepository=basketProductRepository;
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
        product1.setPhotoUrls(Arrays.asList("https://drive.google.com/file/d/1Tk1Imi3-sRNzNeOLi6SuID8yUp-59BI8/view?usp=sharing", "https://drive.google.com/file/d/1sp7d1GYCVy_Ss9E8ij2te1yC74HalBJg/view?usp=sharing"));
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
        product2.setPhotoUrls(Arrays.asList("https://drive.google.com/file/d/1vaXOOdJq-ttzcqWNY9rc4iWn-rZlByQG/view?usp=sharing", "https://drive.google.com/file/d/1hNy3z44jg434o72oeskkLnGLRstKvpVQ/view?usp=sharing"));
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
        product3.setPhotoUrls(Arrays.asList("https://drive.google.com/file/d/1FruboQRUPHzmSxUhUE51mtQ14QnAoUVg/view?usp=sharing", "https://drive.google.com/file/d/1l02N3XRzkKlkSQbZzrgljiRjgdhxSBJ9/view?usp=sharing"));
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
        product4.setPhotoUrls(Arrays.asList("https://drive.google.com/file/d/1WYNrshhg6Q0xSjdY65ZR6Q21sKCWWZis/view?usp=sharing", "https://drive.google.com/file/d/1R0_ns4GAe4Fmn_beQpLIPbCpgXiLThU5/view?usp=sharing"));
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
        product5.setPhotoUrls(Arrays.asList("https://drive.google.com/file/d/1_yJxJbmASaOzjyi2TI755BFjNZxmcWak/view?usp=sharing", "https://drive.google.com/file/d/1t6rX4L1d_e-yAl276d9CJ3cmuxNDwEkx/view?usp=sharing"));
        product5.setType(Type.DONUTS);
        product5.setCategory(category2);

        Product product6 = new Product();
        product6.setTitle("Bittersweet Mint Gelato");
        product6.setShortDescription("Treat yourself to ice cream infused with smooth Bourbon sprinkled");
        product6.setLongDescription("Gelato with mint, dark chocolate pieces and chocolate topping");
        product6.setIngredients(Arrays.asList("Cream", "Milk", "Cane Sugar", "Skimmed milk powder", "Eggs", "Mint", "Dark chocolate", "Chocolate topping"));
        product6.setQuantity(110);
        product6.setAlergens(Arrays.asList("Milk", "Egg", "Soy", "Wheat"));
        product6.setPrice(3.0);
        product6.setCurrency("USD");
        product6.setPhotoUrls(Arrays.asList("https://drive.google.com/file/d/1pU10R0g_t1IHgSBBNMj28mOzORTmZz57/view?usp=sharing", "https://drive.google.com/file/d/1Mgx3bnM8JiM8h8W5rJbzYWljUpvyhURp/view?usp=sharing"));
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
        product7.setPhotoUrls(Arrays.asList("https://drive.google.com/file/d/1Uyl6O_Kd6Oy8F2bWUeGJQcd50v8iRH-8/view?usp=sharing", "https://drive.google.com/file/d/1CSoT-6ehpPdEYtItXW6MkDeLYlX2kSEA/view?usp=sharing"));
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
        product8.setPhotoUrls(Arrays.asList("https://drive.google.com/file/d/1v2aUpOv3Oz77E_VCxDDoiiAx5QRpy612/view?usp=sharing", "https://drive.google.com/file/d/1S97BdZ0z117pGQRFN6eYnltfwYUTa6Cq/view?usp=sharing"));
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
        product9.setPhotoUrls(Arrays.asList("https://drive.google.com/file/d/1boy7veyhZ9OOwIhfcdAAjGEDDt_81AdC/view?usp=sharing", "https://drive.google.com/file/d/1llZjQDcbZp58a-iGj4AnMoVTJ_DAKZhj/view?usp=sharing"));
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
        product10.setPhotoUrls(Arrays.asList("https://drive.google.com/file/d/1I0Cl1GnOpkFieJOsM5rB365w3mxKTZbF/view?usp=sharing", "https://drive.google.com/file/d/1TYkanwveHAE-SUW9Lpj4ZFzsNpwQhenh/view?usp=sharing"));
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
        product11.setPhotoUrls(Arrays.asList("https://drive.google.com/file/d/1VhxtA0xzTVdh5_xFRmnS_ndV9sihXd2w/view?usp=sharing", "https://drive.google.com/file/d/1VhxtA0xzTVdh5_xFRmnS_ndV9sihXd2w/view?usp=sharing"));
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


        BasketProduct basketProductTest1 = new BasketProduct();
        BasketProduct basketProductTest2 = new BasketProduct();
        BasketProduct basketProductTest3 = new BasketProduct();
        BasketProduct basketProductTest4 = new BasketProduct();

        Basket basketTest = new Basket();

        List<BasketProduct> basketProductList = new ArrayList<BasketProduct>();

        basketProductTest1.setProduct(product1);
        basketProductTest1.setBasket(basketTest);
        basketProductTest1.setPrice(product1.getPrice());
        basketProductTest1.setQuantity(1);
        basketProductTest1.setTitle("Chocolate Mix Donuts");
        basketProductTest1.setPhotoUrls(Arrays.asList("https://drive.google.com/file/d/1Tk1Imi3-sRNzNeOLi6SuID8yUp-59BI8/view?usp=sharing", "https://drive.google.com/file/d/1sp7d1GYCVy_Ss9E8ij2te1yC74HalBJg/view?usp=sharing"));

        basketProductTest2.setProduct(product2);
        basketProductTest2.setBasket(basketTest);
        basketProductTest2.setPrice(product2.getPrice());
        basketProductTest2.setQuantity(1);
        basketProductTest2.setTitle("Chocolate Donuts");
        basketProductTest2.setPhotoUrls(Arrays.asList("https://drive.google.com/file/d/1vaXOOdJq-ttzcqWNY9rc4iWn-rZlByQG/view?usp=sharing", "https://drive.google.com/file/d/1hNy3z44jg434o72oeskkLnGLRstKvpVQ/view?usp=sharing"));

        basketProductTest3.setProduct(product3);
        basketProductTest3.setBasket(basketTest);
        basketProductTest3.setPrice(product3.getPrice());
        basketProductTest3.setQuantity(1);
        basketProductTest3.setTitle("Strawberry Donuts");
        basketProductTest3.setPhotoUrls(Arrays.asList("https://drive.google.com/file/d/1FruboQRUPHzmSxUhUE51mtQ14QnAoUVg/view?usp=sharing", "https://drive.google.com/file/d/1l02N3XRzkKlkSQbZzrgljiRjgdhxSBJ9/view?usp=sharing"));

        basketProductTest4.setProduct(product4);
        basketProductTest4.setBasket(basketTest);
        basketProductTest4.setPrice(product4.getPrice());
        basketProductTest4.setQuantity(1);
        basketProductTest4.setTitle("Toffee Donuts");
        basketProductTest4.setPhotoUrls(Arrays.asList("https://drive.google.com/file/d/1WYNrshhg6Q0xSjdY65ZR6Q21sKCWWZis/view?usp=sharing", "https://drive.google.com/file/d/1R0_ns4GAe4Fmn_beQpLIPbCpgXiLThU5/view?usp=sharing"));

        basketProductList.add(basketProductTest1);
        basketProductList.add(basketProductTest2);
        basketProductList.add(basketProductTest3);
        basketProductList.add(basketProductTest4);

        basketTest.setBasketProduct(basketProductList);
        basketTest.setId(5L);
        basketTest.setSessionId("String");

        basketRepository.saveAll(Arrays.asList(basketTest));


        Basket basket1 = new Basket();
        basket1.setSessionId("session1");

        Basket basket2 = new Basket();
        basket2.setId(2L);
        basket2.setSessionId("session2");

        Basket basket3 = new Basket();
        basket3.setId(3L);
        basket3.setSessionId("session3");

        basketRepository.saveAll(Arrays.asList(basket1,basket2,basket3));


        BasketProduct basketProduct1 = new BasketProduct();
        basketProduct1.setId(1L);
        basketProduct1.setProduct(product1);
        basketProduct1.setQuantity(2);
        basketProduct1.setPrice(product1.getPrice());
        basketProduct1.setBasket(basket1);
        basketProduct1.setTitle("Chocolate Mix Donuts");
        basketProduct1.setPhotoUrls(Arrays.asList("https://drive.google.com/file/d/1Tk1Imi3-sRNzNeOLi6SuID8yUp-59BI8/view?usp=sharing", "https://drive.google.com/file/d/1sp7d1GYCVy_Ss9E8ij2te1yC74HalBJg/view?usp=sharing"));

        BasketProduct basketProduct2 = new BasketProduct();
        basketProduct2.setId(2L);
        basketProduct2.setProduct(product2);
        basketProduct2.setQuantity(3);
        basketProduct2.setPrice(product2.getPrice());
        basketProduct2.setBasket(basket1);
        basketProduct2.setTitle("Chocolate Donuts");
        basketProduct2.setPhotoUrls(Arrays.asList("https://drive.google.com/file/d/1vaXOOdJq-ttzcqWNY9rc4iWn-rZlByQG/view?usp=sharing", "https://drive.google.com/file/d/1hNy3z44jg434o72oeskkLnGLRstKvpVQ/view?usp=sharing"));

        BasketProduct basketProduct3 = new BasketProduct();
        basketProduct3.setId(3L);
        basketProduct3.setProduct(product3);
        basketProduct3.setQuantity(2);
        basketProduct3.setPrice(product3.getPrice());
        basketProduct3.setBasket(basket2);
        basketProduct3.setTitle("Strawberry Donuts");
        basketProduct3.setPhotoUrls(Arrays.asList("https://drive.google.com/file/d/1FruboQRUPHzmSxUhUE51mtQ14QnAoUVg/view?usp=sharing", "https://drive.google.com/file/d/1l02N3XRzkKlkSQbZzrgljiRjgdhxSBJ9/view?usp=sharing"));

        BasketProduct basketProduct4 = new BasketProduct();
        basketProduct4.setId(4L);
        basketProduct4.setProduct(product4);
        basketProduct4.setQuantity(3);
        basketProduct4.setPrice(product4.getPrice());
        basketProduct4.setBasket(basket3);
        basketProduct4.setTitle("Toffee Donuts");
        basketProduct4.setPhotoUrls(Arrays.asList("https://drive.google.com/file/d/1WYNrshhg6Q0xSjdY65ZR6Q21sKCWWZis/view?usp=sharing", "https://drive.google.com/file/d/1R0_ns4GAe4Fmn_beQpLIPbCpgXiLThU5/view?usp=sharing"));

        basketProductRepository.saveAll(Arrays.asList(basketProduct1,basketProduct2,basketProduct3,basketProduct4));

    }
}
