package br.com.bootq.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.bootq.domain.Document;
import br.com.bootq.services.DocumentService;

@RestController
@RequestMapping("/documents")
public class DocumentResource {
	@Autowired
	private DocumentService documentService;
	
	//get para trazer todos os objetos
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?>findAll(){
		List <Document> list= documentService.findAll();
		return ResponseEntity.ok(list);
	}
	
	//get element por id
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?>findById(@PathVariable Integer id){
		Document obj=documentService.findById(id);
		return ResponseEntity.ok(obj);
	}

	//get element by taskStatus=WAITING
	@RequestMapping(value="/list/{task}", method=RequestMethod.GET )
	public ResponseEntity<?>findByTaskWaiting(@PathVariable String task){
		List<Document> docList = documentService.findByTaskWaiting(task);
		return ResponseEntity.ok(docList);
	}
	
	//post para inserir elementos no banco
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Document> insert(@RequestBody Document document){
		Document insert = documentService.insert(document);
		return ResponseEntity.ok(insert);
	}
	
	//Get para retirar o elemento mais antigo do banco
	@RequestMapping(value="/older", method=RequestMethod.POST)
	public ResponseEntity<?>updateOlder(@RequestParam(value="idRobot") String idRobot){
		Document older= documentService.updateOlder(idRobot);
		return ResponseEntity.ok(older);
	}
	
	//get para retirar o elemento mais novo do banco
	@RequestMapping(value="/newest", method=RequestMethod.GET)
	public ResponseEntity<?>findNewest(){
		Document newest= documentService.findNewest();
		return ResponseEntity.ok(newest);
	}
	
	//put para atualizar o elemento
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Document obj, @PathVariable Integer id){
		obj.setJobId(id);
		obj =documentService.update(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getJobId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/return", method=RequestMethod.PUT)
	public ResponseEntity<?>resultReturn(@RequestBody Document obj){
		Document document = documentService.findById(obj.getJobId());
		Document returnDocument = documentService.returnDocument(document, obj);
		return ResponseEntity.ok(returnDocument);
	}
	
}