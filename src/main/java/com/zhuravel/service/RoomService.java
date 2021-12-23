package com.zhuravel.service;

import com.zhuravel.model.Room;
import com.zhuravel.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService implements BaseService<Room>{

    private final RoomRepository repository;

    public RoomService(RoomRepository repository) {
        this.repository = repository;
    }

    @Override
    public Room findById(Long id){
        return repository.findById(id).get();
    }

    @Override
    public List<Room> findAll(){
        return repository.findAll();
    }

    @Override
    public Room save(Room user){
        return repository.save(user);
    }

    @Override
    public void delete(Long id){
        repository.deleteById(id);
    }
}
