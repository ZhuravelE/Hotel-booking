package com.zhuravel.service;

import com.zhuravel.model.BaseModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BaseService<M extends BaseModel> {

    M findById(Long id);

    List<M> findAll();

    M save(M user);

    void delete(Long id);
}
