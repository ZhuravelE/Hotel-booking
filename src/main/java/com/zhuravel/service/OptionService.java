package com.zhuravel.service;

import com.zhuravel.model.Option;
import com.zhuravel.repository.OptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService implements BaseService<Option>{

    private final OptionRepository repository;

    public OptionService(OptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Option findById(Long id){
        return repository.findById(id).get();
    }

    @Override
    public List<Option> findAll(){
        return repository.findAll();
    }

    @Override
    public Option save(Option option){
        return repository.save(option);
    }

    @Override
    public void delete(Long id){
        repository.deleteById(id);
    }
}
