package br.com.bootq;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.bootq.domain.Documento;
import br.com.bootq.repositories.DocumentoRepository;

@SpringBootApplication
public class BootqApplication implements CommandLineRunner{
	
	@Autowired
	private DocumentoRepository documentoRepository;

	
	
	public static void main(String[] args) {
		SpringApplication.run(BootqApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// teste para poppular banco em memória
		
		Date hoje = new Date();
		
		Documento documento0 = new Documento(null, "O Mais antigo","67042992032", hoje);
		Documento documento1 = new Documento(null, "Pedro Toledo","67042992032", hoje);
		Documento documento2 = new Documento(null, "Maria Toledo","67042992344", hoje);
		Documento documento3 = new Documento(null, "Resource It","67042992344", hoje);
		Documento documento4 = new Documento(null, "Concorrente","67042992344", hoje);
		
		documentoRepository.saveAll(Arrays.asList(documento0, documento1, documento2, documento3, documento4));
	}
}
