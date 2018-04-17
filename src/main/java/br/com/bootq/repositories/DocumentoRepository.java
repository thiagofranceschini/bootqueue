package br.com.bootq.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bootq.domain.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento , Integer> {

	List<Documento> findAllByOrderByDateAsc();
	
}
