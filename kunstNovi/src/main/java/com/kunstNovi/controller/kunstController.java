		package com.kunstNovi.controller;


import com.kunstNovi.model.apiResponse;
import com.kunstNovi.model.kunst;
import com.kunstNovi.model.kunstResponse;
import com.kunstNovi.service.kunstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/kunst")
public class kunstController {

    @Autowired
    private kunstService kunstService;

    @PostMapping
    public apiResponse<kunst> saveUser(@RequestBody kunstResponse kunst){
        return new apiResponse<>(HttpStatus.OK.value(), "User saved successfully.",kunstService.save(kunst));
    }

    @GetMapping
    public apiResponse<List<kunst>> listKunst(){
        return new apiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.",kunstService.findAll());
    }

    @GetMapping("/{id}")
    public apiResponse<kunst> getOne(@PathVariable int id){
        return new apiResponse<>(HttpStatus.OK.value(), "User fetched successfully.",kunstService.findById(id));
    }

    @PutMapping("/{id}")
    public apiResponse<kunstResponse> update(@RequestBody kunstResponse kunstResponse) {
        return new apiResponse<>(HttpStatus.OK.value(), "User updated successfully.",kunstService.update(kunstResponse));
    }

    @DeleteMapping("/{id}")
    public apiResponse<Void> delete(@PathVariable int id) {
        kunstService.delete(id);
        return new apiResponse<>(HttpStatus.OK.value(), "User deleted successfully.", null);
    }
    


}