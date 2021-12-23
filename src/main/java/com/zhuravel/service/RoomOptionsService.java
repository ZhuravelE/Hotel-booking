package com.zhuravel.service;

import com.zhuravel.model.RoomOption;
import com.zhuravel.repository.RoomOptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomOptionsService implements BaseService<RoomOption>{

    private final RoomOptionRepository repository;

    public RoomOptionsService(RoomOptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public RoomOption findById(Long id){
        return repository.findById(id).get();
    }

    @Override
    public List<RoomOption> findAll(){
        return repository.findAll();
    }

    @Override
    public RoomOption save(RoomOption user){
        return repository.save(user);
    }

    @Override
    public void delete(Long id){
        repository.deleteById(id);
    }
}
