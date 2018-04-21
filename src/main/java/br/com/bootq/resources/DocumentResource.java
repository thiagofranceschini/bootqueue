package br.com.bootq.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bootq.DTO.DocumentDTO;
import br.com.bootq.DTO.IdRobotDTO;
import br.com.bootq.DTO.ReturnDTO;
import br.com.bootq.domain.Document;
import br.com.bootq.services.DocumentService;

@RestController
@RequestMapping("rest/documents")
public class DocumentResource {
	@Autowired
	private DocumentService documentService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?>findById(@PathVariable Integer id){
		Document obj=documentService.findById(id);
		return ResponseEntity.ok(obj);
	}
	
	@RequestMapping(value="list",method=RequestMethod.GET)
	public ResponseEntity<?>findAll(){
		List <Document> list= documentService.findAll();
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping(value="/list/{task}", method=RequestMethod.GET )
	public ResponseEntity<?>findByTaskWaiting(@PathVariable String task){
		List<Document> docList = documentService.findByTaskWaiting(task);
		return ResponseEntity.ok(docList);
	}
	
	@RequestMapping(value="insert",method=RequestMethod.POST)
	public ResponseEntity<Document> insert(@Valid @RequestBody DocumentDTO documentDTO){
		Document document = documentService.fromDTOInsert(documentDTO);
		Document insert = documentService.insert(document);
		return ResponseEntity.ok(insert);
	}
	
	@RequestMapping(value="/take", method=RequestMethod.POST)
	public ResponseEntity<?>updateOlder(@Valid @RequestBody IdRobotDTO idRobotDTO){
		Document updateOlder = documentService.updateOlder(idRobotDTO);
		return ResponseEntity.ok(updateOlder);
	}
	
	@RequestMapping(value="/updatestatus",method=RequestMethod.PUT)
	public ResponseEntity<Document> updateCompleted(@Valid@RequestBody ReturnDTO returnDTO){
		Document documentUpdated = documentService.updateExecuted(returnDTO);
		return ResponseEntity.ok(documentUpdated);
	}
}