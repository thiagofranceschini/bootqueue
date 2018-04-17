package br.com.bootq.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.bootq.domain.Document;
import br.com.bootq.services.DocumentService;

@RestController
@RequestMapping("/documents")
public class DocumentResource {
	@Autowired
	private DocumentService documentService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?>findAll(){
		List <Document> list= documentService.findAll();
		return ResponseEntity.ok(list);
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void>insert(@RequestBody Document document){
		documentService.insert(document);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(document.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value="/older", method=RequestMethod.GET)
	public ResponseEntity<?>findOlder(){
		Document older= documentService.findOlder();
		return ResponseEntity.ok(older);
	}
	
	
	@RequestMapping(value="/newest", method=RequestMethod.GET)
	public ResponseEntity<?>findNewest(){
		Document newest= documentService.findNewest();
		return ResponseEntity.ok(newest);
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Document obj, @PathVariable Integer id){
		obj.setId(id);
		obj =documentService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
}