package com.zakur.salesapp.service.impl;

import com.zakur.salesapp.model.Category;
import com.zakur.salesapp.repository.ICategoryRepository;
import com.zakur.salesapp.repository.IGenericRepository;
import com.zakur.salesapp.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends CRUDImpl<Category, Integer> implements ICategoryService {

    private final ICategoryRepository repository;

    @Override
    protected IGenericRepository<Category, Integer> getRepository() {
        return repository;
    }
}
