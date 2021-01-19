package com.kunstNovi.repository;

import com.kunstNovi.model.kunst;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface kunstRepository extends CrudRepository<kunst, Integer> {

    kunst findBytitel(String titel);
    
}
