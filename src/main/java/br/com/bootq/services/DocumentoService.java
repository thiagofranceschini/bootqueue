package br.com.bootq.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bootq.domain.Documento;
import br.com.bootq.domain.enums.InspectionSet;
import br.com.bootq.repositories.DocumentoRepository;


@Service
public class DocumentoService {
	@Autowired
	private DocumentoRepository documentoRepository;
	
	public List<Documento> findAll(){
		return documentoRepository.findAll();
	}
	
	public Documento insert (Documento obj) {
		obj.setId(null);
		Date hoje = new Date();
		obj.setDate(hoje);
		obj.setInspectionSet(InspectionSet.WAITING);
		return documentoRepository.save(obj);
	}
	
	public Documento findOlder() {
		List<Documento> findOlder = documentoRepository.findAllByOrderByDateAsc();
		Documento older = findOlder.get(0);
		older.setInspectionSet(InspectionSet.EXECUTING);
		documentoRepository.save(older);
		return older;
	}
	
	public Documento findNewest() {
		List<Documento> findNewest = documentoRepository.findAllByOrderByDateAsc();
		return findNewest.get(findNewest.size()-1);
	}

}
