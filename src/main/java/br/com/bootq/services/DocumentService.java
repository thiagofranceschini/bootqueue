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
		obj.setIdRobot(null);
		obj.setDateStartProcess(null);
		obj.setResearchStatus(null);
		obj.setDateEndProcess(null);
		obj.setResultMessage(null);
		obj.setLinkAtachment(null);
		
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
	
	public Document updateExecuted(Document document) {
		
		Document documentU = findById(document.getJobId());
		if(documentU.getTaskStatus()!="EXECUTING") {
			throw new ObjectNotFoundException("Documento não pode ser atualizado pois não está em execução!");
		}
		documentU.setResearchStatus(document.getResearchStatus());
		documentU.setResultMessage(document.getResultMessage());
		documentU.setLinkAtachment(document.getLinkAtachment());
		documentU.setTaskStatus(Status.COMPLETED.name());
		documentRepository.save(documentU);
		return documentU;
	}
	
	public Document updateOlder(Document idRobot) {
		Document obj=findOlder();
		obj.setIdRobot(idRobot.getIdRobot());
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
