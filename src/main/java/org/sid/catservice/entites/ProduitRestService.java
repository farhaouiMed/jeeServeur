package org.sid.catservice.entites;

import java.util.List;

import org.sid.catservice.dao.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduitRestService {
	
	@Autowired
	private ProduitRepository produitRepository;
	@GetMapping(value = "/listproduits")
	public List<Produit> listProduits(){
		return produitRepository.findAll();
	}
	@GetMapping(value = "/listproduits/{id}")
	public Produit listProduits(@PathVariable(name="id") Long id){
		return produitRepository.findById(id).get();
	}
	@PutMapping(value = "/listproduits/{id}")
	public Produit update(@PathVariable(name="id") Long id,@RequestBody Produit P){
		P.setId(id);
		return produitRepository.save(P);
	}
	@PostMapping(value = "/listproduits")
	public Produit save(@RequestBody Produit P){
		return produitRepository.save(P);
	}
	@DeleteMapping(value = "/listproduits/{id}")
	public void delete(@PathVariable(name="id") Long id){
		produitRepository.deleteById(id);
	}
}
