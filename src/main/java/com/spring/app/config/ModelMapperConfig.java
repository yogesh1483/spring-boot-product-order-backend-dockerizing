package com.spring.app.config;

import com.spring.app.dto.ProductDto;
import com.spring.app.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();

        mapper.getConfiguration()
                .setSkipNullEnabled(true)
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

        // Prevent infinite loop (Order ↔ Product)
      /*  mapper.typeMap(ProductDto.class, Product.class)
                .addMappings(m -> m.skip(Product::setOrder));*/

        return mapper;
    }
}
