package com.zhuravel.service;

import com.zhuravel.model.RoomCategory;
import com.zhuravel.repository.RoomCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomCategoryService implements BaseService<RoomCategory>{

    private final RoomCategoryRepository repository;

    public RoomCategoryService(RoomCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public RoomCategory findById(Long id){
        return repository.findById(id).get();
    }

    @Override
    public List<RoomCategory> findAll(){
        return repository.findAll();
    }

    @Override
    public RoomCategory save(RoomCategory user){
        return repository.save(user);
    }

    @Override
    public void delete(Long id){
        repository.deleteById(id);
    }
}
