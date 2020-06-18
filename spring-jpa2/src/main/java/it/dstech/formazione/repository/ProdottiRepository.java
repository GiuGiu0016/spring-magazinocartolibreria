package it.dstech.formazione.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.dstech.formazione.model.Prodotti;

public interface ProdottiRepository extends CrudRepository<Prodotti, Long> {
	
	@Query(value = "SELECT prodotti FROM Prodotti prodotti WHERE prodotti.name LIKE '%' || :keyword || '%'"
			+ " OR prodotti.quantita LIKE '%' || :keyword || '%'"
			+ " OR prodotti.categoria LIKE '%' || :keyword || '%'")
	public List<Prodotti> search(@Param("keyword") String keyword);
}
