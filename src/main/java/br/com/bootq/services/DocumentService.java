package br.com.bootq.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bootq.DTO.DocumentDTO;
import br.com.bootq.DTO.IdRobotDTO;
import br.com.bootq.DTO.ReturnDTO;
import br.com.bootq.domain.Document;
import br.com.bootq.domain.enums.Status;
import br.com.bootq.repositories.DocumentRepository;
import br.com.bootq.services.exceptions.ObjectNotFoundException;


@Service
public class DocumentService {
	@Autowired
	private DocumentRepository documentRepository;
	
	public Document findById(Integer id) {
		Optional<Document>obj=documentRepository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado, id: "+id+", Tipo: "+Document.class.getSimpleName()));
	}
	
	public List<Document> findAll(){
		return documentRepository.findAll();
	}
	
	public Document findOlder() {
		List<Document> older = documentRepository.findByTaskStatusOrderByDate("WAITING");
		return older.get(0);
	}
	
	public List<Document> findByTaskWaiting(String string) {
		return documentRepository.findByTaskStatusOrderByDate(string);
	}
	
	public Document fromDTOInsert(DocumentDTO documentDTO) {
		Document document = new Document(documentDTO.getCnpjMaster(), documentDTO.getDocType(), documentDTO.getDocValue(), 
				documentDTO.getNameInDoc(), documentDTO.getResearchWeb());
		return document;
	}
	
	public Document insert (Document obj) {
		//method for the insertion and self generation of id
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
	
	public Document updateOlder(IdRobotDTO idRobotDTO) {
		Document older=findOlder();
		older.setIdRobot(idRobotDTO.getIdRobot());
		older.setTaskStatus(Status.EXECUTING.name());
		LocalDateTime now= LocalDateTime.now();
		older.setDateStartProcess(now);
		documentRepository.save(older);
		return older;
	}
	
	public Document updateExecuted(ReturnDTO document) {
		Document objectDocument = findById(document.getJobId());
		objectDocument.setResearchStatus(document.getResearchStatus());
		objectDocument.setResultMessage(document.getResultMessage());
		objectDocument.setLinkAtachment(document.getLinkAtachment());
		objectDocument.setTaskStatus(Status.COMPLETED.name());
		documentRepository.save(objectDocument);
		return objectDocument;
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
}
