package br.com.bootq.services;

import java.time.LocalDateTime;
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
		obj.setJobId(null);
		LocalDateTime toDay = LocalDateTime.now();
		obj.setDate(toDay);
		obj.setTaskStatus(Status.WAITING.name());
		return documentRepository.save(obj);
	}
	
	public Document findById(Integer id) {
		Optional<Document>obj=documentRepository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado, id: "+id+", Tipo: "+Document.class.getSimpleName()));
	}
	
	public List<Document> findAll(){
		return documentRepository.findAll();
	}
	
	
	public Document find(Integer id) {
		Optional<Document>document= documentRepository.findById(id);
		return document.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id:"+id+", Tipo: "+Document.class.getName()));
	}
	
	public Document findNewest() {
		List<Document> findNewest = documentRepository.findByTaskStatusOrderByDate("WAITING");
		return findNewest.get(findNewest.size()-1);
	}
	
	public Document findOlder() {
		List<Document> findOlder = documentRepository.findByTaskStatusOrderByDate("WAITING");
		Document older = findOlder.get(0);
		//older.setTaskStatus(Status.EXECUTING.name());
		//older.setIdRobot(id);
		documentRepository.save(older);
		return older;
	}
	
	public Document update(Document obj) {
		find(obj.getJobId());
		return documentRepository.save(obj);
	}
	
	public Document updateOlder(String agente) {
		Document obj=findOlder();
		obj.setIdRobot(agente);
		obj.setTaskStatus(Status.EXECUTING.name());
		LocalDateTime now= LocalDateTime.now();
		obj.setDateStartProcess(now);
		documentRepository.save(obj);
		return obj;
	}
	
	public Document returnDocument(Document document, Document obj) {
		document.setLinkAtachment(obj.getLinkAtachment());
		document.setResultMessage(obj.getResultMessage());
		document.setResearchStatus(obj.getResearchStatus());
		LocalDateTime now= LocalDateTime.now();
		document.setDateEndProcess(now);
		document.setTaskStatus(Status.COMPLETED.name());
		documentRepository.save(document);
		return document;
	}
	
	public List<Document> findByTaskWaiting(String string) {
		return documentRepository.findByTaskStatusOrderByDate(string);
	}

}
