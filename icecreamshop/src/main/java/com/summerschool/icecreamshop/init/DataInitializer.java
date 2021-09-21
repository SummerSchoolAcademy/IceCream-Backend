package com.summerschool.icecreamshop.init;

import com.summerschool.icecreamshop.model.*;
import com.summerschool.icecreamshop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
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
        category1.setCategoryPhotoBig(Arrays.asList("https://imgur.com/Oz1y33F.png"));
        category1.setCategoryPhotoBig(Arrays.asList("https://imgur.com/iD3N8z9.png"));

        Category category2 = new Category();
        category2.setName("Donuts");
        category2.setDescription("Treat yourself with one of our various donuts!");
        category2.setCategoryPhotoBig(Arrays.asList("https://imgur.com/Q175Rk7.png"));
        category2.setCategoryPhotoBig(Arrays.asList("https://imgur.com/XYuP9bU.png"));

        Category category3 = new Category();
        category3.setName("Family/Corporate");
        category3.setDescription("We'll take care of you as we take for our own family!");
        category3.setCategoryPhotoBig(Arrays.asList("https://imgur.com/5cTilN1.png"));
        category3.setCategoryPhotoBig(Arrays.asList("https://imgur.com/Obw2cHB.png"));

        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));

        Product product1 = new Product();
        product1.setTitle("Chocolate Mix Donuts");
        product1.setShortDescription("Treat yourself to ice cream infused with smooth Bourbon sprinkled");
        product1.setLongDescription("Donut with chocolate icing, dark chocolate curls, Kinder Bueno™ wafers and delicate milk chocolate lines");
        product1.setIngredients(Arrays.asList("Cream", "Milk", "Cane Sugar", "Cake Pieces", "Cake Base", "Sprinkles (Sugar, Coconut Oil, Buttermilk Powder, Natural Flavor, Spirulina Extract, Skim Milk)", "Eggs"));
        product1.setQuantity(100);
        product1.setAlergens(Arrays.asList("Milk", "Egg", "Soy", "Wheat"));
        product1.setPrice(2.5);
        product1.setCurrency("USD");
        product1.setPhotoUrlsBig(Arrays.asList("https://imgur.com/S3X26u2.png"));
        product1.setPhotoUrlsMedium(Arrays.asList("https://imgur.com/maVjPNW.png"));
        product1.setPhotoUrlsSmall(Arrays.asList("https://imgur.com/nT8abHV.png"));
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
        product2.setPhotoUrlsBig(Arrays.asList("https://imgur.com/BtUKmtS.png"));
        product2.setPhotoUrlsMedium(Arrays.asList("https://imgur.com/BiAdGs7.png"));
        product2.setPhotoUrlsSmall(Arrays.asList("https://imgur.com/FXBP37I.png"));
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
        product3.setPhotoUrlsBig(Arrays.asList("https://imgur.com/PM5TYmV.png"));
        product3.setPhotoUrlsMedium(Arrays.asList("https://imgur.com/OWZrVeo.png"));
        product3.setPhotoUrlsSmall(Arrays.asList("https://imgur.com/z8Y393N.png"));
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
        product4.setPhotoUrlsBig(Arrays.asList("https://imgur.com/xbVrajP.png"));
        product4.setPhotoUrlsMedium(Arrays.asList("https://imgur.com/YqdlYPC.png"));
        product4.setPhotoUrlsSmall(Arrays.asList("https://imgur.com/YqdlYPC.png"));
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
        product5.setPhotoUrlsBig(Arrays.asList("https://imgur.com/WI1vGlL.png"));
        product5.setPhotoUrlsMedium(Arrays.asList("https://imgur.com/VNI7O3N.png"));
        product5.setPhotoUrlsSmall(Arrays.asList("https://imgur.com/dHYfOUQ.png"));
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
        product6.setPhotoUrlsBig(Arrays.asList("https://imgur.com/CdFPzfY.png"));
        product6.setPhotoUrlsMedium(Arrays.asList("https://imgur.com/fqoWSkM.png"));
        product6.setPhotoUrlsSmall(Arrays.asList("https://imgur.com/kkZwULZ.png"));
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
        product7.setPhotoUrlsBig(Arrays.asList("https://imgur.com/i5IqV13.png"));
        product7.setPhotoUrlsMedium(Arrays.asList("https://imgur.com/RD6a8lc.png"));
        product7.setPhotoUrlsSmall(Arrays.asList("https://imgur.com/zBf1vY9.png"));
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
        product8.setPhotoUrlsBig(Arrays.asList("https://imgur.com/IwofHb0.png"));
        product8.setPhotoUrlsMedium(Arrays.asList("https://imgur.com/Oq0ZpWd.png"));
        product8.setPhotoUrlsSmall(Arrays.asList("https://imgur.com/KKy7edw.png"));
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
        product9.setPhotoUrlsBig(Arrays.asList("https://imgur.com/fpsz61w.png"));
        product9.setPhotoUrlsMedium(Arrays.asList("https://imgur.com/JYv1ij9.png"));
        product9.setPhotoUrlsSmall(Arrays.asList("https://imgur.com/R2p9MzO.png"));
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
        product10.setPhotoUrlsBig(Arrays.asList("https://imgur.com/tIxdrau.png"));
        product10.setPhotoUrlsMedium(Arrays.asList("https://imgur.com/QUzgKXU.png"));
        product10.setPhotoUrlsSmall(Arrays.asList("https://imgur.com/1I5oI3b.png"));
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
        product11.setPhotoUrlsBig(Arrays.asList("https://imgur.com/uT26ydr.png"));
        product11.setPhotoUrlsMedium(Arrays.asList("https://imgur.com/a4brOA1.png"));
        product11.setPhotoUrlsSmall(Arrays.asList("https://imgur.com/DrdlqGR.png"));
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
        basketProductTest1.setQuantity(1);

        basketProductTest2.setProduct(product2);
        basketProductTest2.setBasket(basketTest);
        basketProductTest2.setQuantity(1);

        basketProductTest3.setProduct(product3);
        basketProductTest3.setBasket(basketTest);
        basketProductTest3.setQuantity(1);

        basketProductTest4.setProduct(product4);
        basketProductTest4.setBasket(basketTest);
        basketProductTest4.setQuantity(1);

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
        basketProduct1.setBasket(basket1);

        BasketProduct basketProduct2 = new BasketProduct();
        basketProduct2.setId(2L);
        basketProduct2.setProduct(product2);
        basketProduct2.setQuantity(3);
        basketProduct2.setBasket(basket1);

        BasketProduct basketProduct3 = new BasketProduct();
        basketProduct3.setId(3L);
        basketProduct3.setProduct(product3);
        basketProduct3.setQuantity(2);
        basketProduct3.setBasket(basket2);

        BasketProduct basketProduct4 = new BasketProduct();
        basketProduct4.setId(4L);
        basketProduct4.setProduct(product4);
        basketProduct4.setQuantity(3);
        basketProduct4.setBasket(basket3);

        basketProductRepository.saveAll(Arrays.asList(basketProduct1,basketProduct2,basketProduct3,basketProduct4));
    }
}
