package com.summerschool.icecreamshop.config;

import com.summerschool.icecreamshop.dto.ProductDTO;
import com.summerschool.icecreamshop.model.Category;
import com.summerschool.icecreamshop.model.Product;
import com.summerschool.icecreamshop.dto.CategoryDTO;
import com.summerschool.icecreamshop.model.Rate;
import com.summerschool.icecreamshop.dto.RateDTO;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Collectors;


@Configuration
public class ApplicationConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();


        Converter<CategoryDTO, Category> categoryConverter = context -> {
            CategoryDTO s = context.getSource();
            Category d = new Category();
            d.setId(s.getId());
            d.setName(s.getName());
            d.setDescription(s.getDescription());
            d.setProducts(s.getProducts().stream()
                    .map(x -> modelMapper.map(x , Product.class))
                    .collect(Collectors.toList()));
            return d;
        };

        Converter<ProductDTO,Product> productConverter = context -> {
            ProductDTO s = context.getSource();
            Product d = new Product();
            d.setId(s.getId());
            d.setTitle(s.getTitle());
            d.setShortDescription(s.getShortDescription());
            d.setLongDescription(s.getLongDescription());
            d.setIngredients(s.getIngredients());
            d.setQuantity(s.getQuantity());
            d.setAlergens(s.getAlergens());
            d.setPrice(s.getPrice());
            d.setCurrency(s.getCurrency());
            d.setPhotoUrls(s.getPhotoUrls());
            d.setRates(s.getRates().stream()
                       .map(x -> modelMapper.map(x , Rate.class))
                       .collect(Collectors.toList()));
            return d;
        };

        Converter<RateDTO, Rate> rateConverter = context -> {
            RateDTO s = context.getSource();
            Rate d = new Rate();
            d.setId(s.getId());
            d.setRate(s.getRate());
            return d;
        };

        modelMapper.addConverter(categoryConverter);
        modelMapper.addConverter(productConverter);
        modelMapper.addConverter(rateConverter);

        return modelMapper;
    }
}
