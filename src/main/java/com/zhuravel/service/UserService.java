package com.zhuravel.service;

import com.zhuravel.model.User;
import com.zhuravel.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements BaseService<User>{

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User findById(Long id){
        return repository.findById(id).get();
    }

    @Override
    public List<User> findAll(){
        return repository.findAll();
    }

    @Override
    public User save(User user){
        return repository.save(user);
    }

    @Override
    public void delete(Long id){
        repository.deleteById(id);
    }
}
