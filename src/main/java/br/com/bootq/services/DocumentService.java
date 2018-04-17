package br.com.bootq.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bootq.domain.Document;
import br.com.bootq.domain.enums.Status;
import br.com.bootq.repositories.DocumentRepository;
import br.com.bootq.services.exceptions.ObjectNotFoundException;


@Service
public class DocumentService {
	@Autowired
	private DocumentRepository documentRepository;
	
	public Document insert (Document obj) {
		obj.setId(null);
		Date toDay = new Date();
		obj.setDate(toDay);
		obj.setStatus(Status.WAITING.name());
		return documentRepository.save(obj);
	}
	
	public List<Document> findAll(){
		return documentRepository.findAll();
	}
	
	
	public Document find(Integer id) {
		Optional<Document>document= documentRepository.findById(id);
		return document.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id:"+id+", Tipo: "+Document.class.getName()));
	}
	
	public Document findNewest() {
		List<Document> findNewest = documentRepository.findAllByOrderByDateAsc();
		return findNewest.get(findNewest.size()-1);
	}
	
	public Document findOlder() {
		List<Document> findOlder = documentRepository.findAllByOrderByDateAsc();
		Document older = findOlder.get(0);
		older.setStatus(Status.EXECUTING.name());;
		documentRepository.save(older);
		return older;
	}
	
	public Document update(Document obj) {
		find(obj.getId());
		return documentRepository.save(obj);
	}

}
