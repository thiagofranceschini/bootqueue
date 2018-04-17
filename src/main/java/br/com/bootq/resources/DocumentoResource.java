package br.com.bootq.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.bootq.domain.Documento;
import br.com.bootq.services.DocumentoService;

@RestController
@RequestMapping("/documents")
public class DocumentoResource {
	@Autowired
	private DocumentoService documentoService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?>findAll(){
		List <Documento> list= documentoService.findAll();
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void>insert(@RequestBody Documento documento){
		documentoService.insert(documento);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(documento.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/older", method=RequestMethod.GET)
	public ResponseEntity<?>findOlder(){
		Documento older= documentoService.findOlder();
		return ResponseEntity.ok(older);
	}
	
	@RequestMapping(value="/newest", method=RequestMethod.GET)
	public ResponseEntity<?>findNewest(){
		Documento newest= documentoService.findNewest();
		return ResponseEntity.ok(newest);
	}
	
	
}