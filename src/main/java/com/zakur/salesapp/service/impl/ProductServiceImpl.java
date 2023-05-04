package com.zakur.salesapp.service.impl;

import com.zakur.salesapp.model.Product;
import com.zakur.salesapp.repository.IGenericRepository;
import com.zakur.salesapp.repository.IProductRepository;
import com.zakur.salesapp.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends CRUDImpl<Product, Integer> implements IProductService {
    
    private final IProductRepository repository;

    @Override
    protected IGenericRepository<Product, Integer> getRepository() {
        return repository;
    }
}
