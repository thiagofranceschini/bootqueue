package br.com.bootq.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bootq.domain.Document;
import br.com.bootq.services.DocumentService;
import br.com.bootq.services.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping("rest/documents")
public class DocumentResource {
	@Autowired
	private DocumentService documentService;
	
	//get para trazer todos os objetos
	@RequestMapping(value="list",method=RequestMethod.GET)
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
	@RequestMapping(value="insert",method=RequestMethod.POST)
	public ResponseEntity<Document> insert(@RequestBody Document document){
		if((document.getCnpjMaster()==null)||(document.getDocType()==null)||(document.getDocValue()==null)||(document.getNameInDoc()==null)||(document.getResearchWeb()==null)) {
			throw new ObjectNotFoundException("Informe: cnpjMaster, docType, docValue, nameInDoc, researchWeb");
		}
		Document insert = documentService.insert(document);
		return ResponseEntity.ok(insert);
	}
	
	//Get para retirar o elemento mais antigo do banco
	@RequestMapping(value="/take", method=RequestMethod.POST)
	public ResponseEntity<?>updateOlder(@RequestBody Document idRobot){
		if (idRobot.getIdRobot()==null) throw new ObjectNotFoundException("O ID do agente não pode ser nulo. Informe no corpo da requisição: 'idRobot' ");
		Document older= documentService.updateOlder(idRobot);
		return ResponseEntity.ok(older);
	}
	
	//get para retirar o elemento mais novo do banco
	@RequestMapping(value="/take/new", method=RequestMethod.GET)
	public ResponseEntity<?>findNewest(){
		Document newest= documentService.findNewest();
		return ResponseEntity.ok(newest);
	}
	
	//put para atualizar o elemento
	
	@RequestMapping(value="/updatestatus",method=RequestMethod.PUT)
	public ResponseEntity<Document> updateCompleted(@RequestBody Document document){
		if((document.getResearchStatus()==null)||(document.getResultMessage()==null)||(document.getJobId()==null)) {
			throw new ObjectNotFoundException("Informe os parâmetros no corpo da requisição. 'jobId','resultMessage','researchStatus'");
		}
		Document documentUpdate = documentService.updateExecuted(document);
		return ResponseEntity.ok(documentUpdate);
	}
	
	@RequestMapping(value="/return", method=RequestMethod.PUT)
	public ResponseEntity<?>resultReturn(@RequestBody Document obj){
		Document document = documentService.findById(obj.getJobId());
		Document returnDocument = documentService.returnDocument(document, obj);
		return ResponseEntity.ok(returnDocument);
	}
	
}