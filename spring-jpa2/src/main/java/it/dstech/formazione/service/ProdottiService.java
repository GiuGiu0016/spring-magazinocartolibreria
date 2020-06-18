package it.dstech.formazione.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.dstech.formazione.model.Prodotti;
import it.dstech.formazione.repository.ProdottiRepository;

@Service
@Transactional
public class ProdottiService {
	@Autowired ProdottiRepository repo;
	
	public void save(Prodotti p) {
		repo.save(p);
	}
	
	public List<Prodotti> listAll() {
		return (List<Prodotti>) repo.findAll();
	}
	
	public Prodotti get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public List<Prodotti> search(String keyword) {
		return repo.search(keyword);
	}
}
