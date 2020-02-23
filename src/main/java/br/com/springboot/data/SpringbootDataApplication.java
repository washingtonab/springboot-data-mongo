package br.com.springboot.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootDataApplication implements CommandLineRunner {

	@Autowired
	private PessoaRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Pessoa p = new Pessoa();
		p.setNome("Henrique");
		p.setIdade(10);
		p.setSexo("M");
		
		repository.save(p);
		
		List<Pessoa> pessoas = repository.findAll();
		
		pessoas.stream().forEach(e -> System.out.println(e.getId()));
		
	}

}
