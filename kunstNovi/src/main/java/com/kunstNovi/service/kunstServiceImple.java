package com.kunstNovi.service;

import com.kunstNovi.repository.kunstRepository;
import com.kunstNovi.model.kunst;
import com.kunstNovi.model.kunstResponse;
import com.kunstNovi.service.kunstService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service(value = "userService")

public class kunstServiceImple implements kunstService {
	
	@Autowired
	private kunstRepository kunsten;

	public List<kunst> findAll() {
		List<kunst> list = new ArrayList<>();
		kunsten.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(int id) {
		kunsten.deleteById(id );
	}

	@Override
	public kunst findOne(String username) {
		return kunsten.findBytitel(username);
	}

	@Override
	public kunst findById(int id) {
		Optional<kunst> optionalUser = kunsten.findById( id);
		return optionalUser.isPresent() ? optionalUser.get() : null;
	}

    @Override
    public kunstResponse update(kunstResponse kunstReponse) {
        kunst kunst = findById(kunstReponse.getId());
        if(kunst != null) {
            BeanUtils.copyProperties(kunstReponse, kunst, "password", "username");
            kunsten.save(kunst);
        }
        return kunstReponse;
    }

    @Override
    public kunst save(kunstResponse kunst) {
	    kunst newKunst = new kunst();
	    newKunst.setBeschrijving(kunst.getBeschrijving());
	    newKunst.setTitel(kunst.getTitel());
	    newKunst.setPrijs(kunst.getPrijs());
	    newKunst.setPeriode(kunst.getPeriode());
		newKunst.setData(kunst.getData());
		newKunst.setFileName(kunst.getFileName());
		
		
		
        return kunsten.save(newKunst);
    }
}