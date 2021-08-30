package com.summerschool.icecreamshop.configuration;

import com.summerschool.icecreamshop.model.Product;
import com.summerschool.icecreamshop.model.dto.ProductDTO;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        Converter<ProductDTO, Product> productConverter = context -> {
            ProductDTO productDTO = context.getSource();
            Product product = new Product();
            product.setId(productDTO.getId());
            product.setTitle(productDTO.getTitle());
            product.setShortDescription(productDTO.getShortDescription());
            product.setLongDescription(productDTO.getLongDescription());
            product.setAlergens(productDTO.getAlergens());
            product.setPrice(productDTO.getPrice());
            product.setPhoto_urls(productDTO.getPhoto_urls());
            product.setType(productDTO.getType());
            return product;
        };

        modelMapper.addConverter(productConverter);
        return modelMapper;
    }
}
