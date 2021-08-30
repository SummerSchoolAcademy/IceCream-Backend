package com.summerschool.icecreamshop.config;
import com.summerschool.icecreamshop.model.Category;
import com.summerschool.icreamshop.model.Rate;
import com.summerschool.icecreamshop.model.Product;
import com.summerschool.icecreamshop.dto.CategoryDTO;
import com.summerschoo.icecreamshop.dto.RateDTO;
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

        Converter<RateDTO, Rate>rateConverter=context ->
        {
        RateDTO s = context.getSource();
        Rate d = new Rate();
                    d.setId(s.getId());
                    d.setProduct(s.getProduct());
                    d.setRate(s.getRate());
                    return d;
        };

        modelMapper.addConverter(categoryConverter);

        return modelMapper;
    }
}
