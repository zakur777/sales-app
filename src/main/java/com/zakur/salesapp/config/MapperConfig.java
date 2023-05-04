package com.zakur.salesapp.config;

import com.zakur.salesapp.dto.CategoryDTO;
import com.zakur.salesapp.dto.ProductDTO;
import com.zakur.salesapp.model.Category;
import com.zakur.salesapp.model.Product;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    //configuracion cuando los atributos del dto y el modelo no coinciden
    @Bean("categoryMapper")
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        TypeMap<CategoryDTO, Category> typeMap1 = mapper.createTypeMap(CategoryDTO.class, Category.class);
        TypeMap<Category, CategoryDTO> typeMap2 = mapper.createTypeMap(Category.class, CategoryDTO.class);
        typeMap1.addMapping(CategoryDTO::getNameOfCategory, (dest, v) -> dest.setName((String) v));//dest destino v value
        typeMap2.addMapping(Category::getName, (dest, v) -> dest.setNameOfCategory((String) v));
        return mapper;
    }

    @Bean("productMapper")
    public ModelMapper productMapper(){
        ModelMapper mapper = new ModelMapper();
        TypeMap<ProductDTO, Product> typeMap1 = mapper.createTypeMap(ProductDTO.class, Product.class);
        TypeMap<Product, ProductDTO> typeMap2 = mapper.createTypeMap(Product.class, ProductDTO.class);
        typeMap1.addMapping(ProductDTO::getIdCategory, (dest, v) -> dest.getCategory().setIdCategory((Integer) v));
        typeMap2.addMapping(p -> p.getCategory().getIdCategory(), (dest, v) -> dest.setIdCategory((Integer) v));
        return mapper;
    }
}
