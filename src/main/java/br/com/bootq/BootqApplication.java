package br.com.bootq;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.bootq.domain.Document;
import br.com.bootq.domain.enums.DocumentType;
import br.com.bootq.repositories.DocumentRepository;

@SpringBootApplication
public class BootqApplication implements CommandLineRunner{
	
	@Autowired
	private DocumentRepository documentoRepository;

	
	
	public static void main(String[] args) {
		SpringApplication.run(BootqApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// teste para popular banco em memória
		
		Date hoje = new Date();
		
		//Document(String cnpjMaster, DocumentType docType, String docNumber, String nameInDoc, String researchWeb) 
		Document documento0 = new Document("01.468.594/0001-22", DocumentType.CNPJ, "01.468.594/0001-22", "TFO mini fundo de investimentos e outros", "www.serasaexperian.com.br");
		Document documento1 = new Document("01.468.594/0001-22", DocumentType.CNPJ, "01.468.594/0001-22", "TFO mini fundo de investimentos e outros", "www.serasaexperian.com.br");
		Document documento2 = new Document("01.468.594/0001-22", DocumentType.CNPJ, "01.468.594/0001-22", "TFO mini fundo de investimentos e outros", "www.serasaexperian.com.br");
		Document documento3 = new Document("01.468.594/0001-22", DocumentType.CNPJ, "01.468.594/0001-22", "TFO mini fundo de investimentos e outros", "www.serasaexperian.com.br");
		Document documento4 = new Document("01.468.594/0001-22", DocumentType.CNPJ, "01.468.594/0001-22", "TFO mini fundo de investimentos e outros", "www.serasaexperian.com.br");
		Document documento5 = new Document("01.468.594/0001-22", DocumentType.CNPJ, "01.468.594/0001-22", "TFO mini fundo de investimentos e outros", "www.serasaexperian.com.br");
		Document documento6 = new Document("01.468.594/0001-22", DocumentType.CNPJ, "01.468.594/0001-22", "TFO mini fundo de investimentos e outros", "www.serasaexperian.com.br");
		Document documento7 = new Document("01.468.594/0001-22", DocumentType.CNPJ, "01.468.594/0001-22", "TFO mini fundo de investimentos e outros", "www.serasaexperian.com.br");
		Document documento8 = new Document("01.468.594/0001-22", DocumentType.CNPJ, "01.468.594/0001-22", "TFO mini fundo de investimentos e outros", "www.serasaexperian.com.br");
		Document documento9 = new Document("01.468.594/0001-22", DocumentType.CNPJ, "01.468.594/0001-22", "TFO mini fundo de investimentos e outros", "www.serasaexperian.com.br");
		
		Document documento10 = new Document("01.468.594/0001-22", DocumentType.CNPJ, "01.468.594/0001-22", "TFO mini fundo de investimentos e outros", "www.serasaexperian.com.br",5);
		Document documento11 = new Document("01.468.594/0001-22", DocumentType.CNPJ, "01.468.594/0001-22", "TFO mini fundo de investimentos e outros", "www.serasaexperian.com.br",4);
		Document documento12 = new Document("01.468.594/0001-22", DocumentType.CNPJ, "01.468.594/0001-22", "TFO mini fundo de investimentos e outros", "www.serasaexperian.com.br",3);
		Document documento13 = new Document("01.468.594/0001-22", DocumentType.CNPJ, "01.468.594/0001-22", "TFO mini fundo de investimentos e outros", "www.serasaexperian.com.br",2);
		Document documento14 = new Document("01.468.594/0001-22", DocumentType.CNPJ, "01.468.594/0001-22", "TFO mini fundo de investimentos e outros", "www.serasaexperian.com.br",1);
		Document documento15 = new Document("01.468.594/0001-22", DocumentType.CNPJ, "01.468.594/0001-22", "TFO mini fundo de investimentos e outros", "www.serasaexperian.com.br",1);
		
		Document documento16 = new Document("01.468.594/0001-22", DocumentType.CNPJ, "01.468.594/0001-22", "TFO mini fundo de investimentos e outros", "www.serasaexperian.com.br",5, "12122000", "SP", "RJ");
		Document documento17 = new Document("01.468.594/0001-22", DocumentType.CNPJ, "01.468.594/0001-22", "TFO mini fundo de investimentos e outros", "www.serasaexperian.com.br",4, "12122000", "SP", "RJ");
		Document documento18 = new Document("01.468.594/0001-22", DocumentType.CNPJ, "01.468.594/0001-22", "TFO mini fundo de investimentos e outros", "www.serasaexperian.com.br",3, "12122000", "SP", "RJ");
		Document documento19 = new Document("01.468.594/0001-22", DocumentType.CNPJ, "01.468.594/0001-22", "TFO mini fundo de investimentos e outros", "www.serasaexperian.com.br",2, "12122000", "SP", "RJ");
		Document documento20 = new Document("01.468.594/0001-22", DocumentType.CNPJ, "01.468.594/0001-22", "TFO mini fundo de investimentos e outros", "www.serasaexperian.com.br",1, "12122000", "SP", "RJ");
		Document documento21 = new Document("01.468.594/0001-22", DocumentType.CNPJ, "01.468.594/0001-22", "TFO mini fundo de investimentos e outros", "www.serasaexperian.com.br",1, "12122000", "SP", "RJ");
		//documento16, documento17,documento18, documento19, documento20, documento21
										
		
		
		
		
		documentoRepository.saveAll(Arrays.asList(documento0, documento1, documento2, documento3, documento4, documento5, documento6,
										documento7, documento8, documento9, documento10, documento11, documento12, documento13, documento14, documento15,documento16, documento17,documento18, documento19, documento20, documento21));
	}
}
