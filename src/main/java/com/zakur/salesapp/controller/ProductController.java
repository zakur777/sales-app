package com.zakur.salesapp.controller;

import com.zakur.salesapp.dto.ProductDTO;
import com.zakur.salesapp.model.Product;
import com.zakur.salesapp.service.IProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService service;

    @Qualifier("productMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<ProductDTO>>  readAll() throws Exception{
        List<ProductDTO> list = service.readAll().stream().map(this::convertToDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO>  readById(@PathVariable("id") Integer id) throws Exception{
        Product obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> create(@Valid @RequestBody ProductDTO dto) throws Exception {
        Product obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody ProductDTO dto) throws Exception {
        dto.setIdProduct(id);
        Product obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private ProductDTO convertToDto(Product product) {
        return mapper.map(product, ProductDTO.class);
    }

    private Product convertToEntity(ProductDTO productDTO) {
        return mapper.map(productDTO, Product.class);
    }
}
