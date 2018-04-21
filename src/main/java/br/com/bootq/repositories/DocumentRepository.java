package br.com.bootq.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bootq.domain.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document , Integer> {

	List<Document> findByTaskStatusOrderByDate(String taskstatus);
	
	
}
