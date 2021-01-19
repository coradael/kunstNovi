package com.kunstNovi.service;

import com.kunstNovi.model.kunst;
import com.kunstNovi.model.kunstResponse;

import java.util.List;

public interface kunstService{

    kunst save(kunstResponse kunst);
    List<kunst> findAll();
    void delete(int id);

    kunst findOne(String titel);

    kunst findById(int id);

    kunstResponse update(kunstResponse kunstResponse);
}
