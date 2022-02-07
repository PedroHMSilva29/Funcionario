package br.com.pehenmo.spring.data;

import br.com.pehenmo.spring.data.orm.Cargo;
import br.com.pehenmo.spring.data.repository.CargoRepository;
import br.com.pehenmo.spring.data.service.CrudCargoService;
import br.com.pehenmo.spring.data.service.CrudFuncionarioService;
import br.com.pehenmo.spring.data.service.CrudUnidadeTrabalhoService;
import br.com.pehenmo.spring.data.service.RelatorioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private CrudCargoService cargoservice;
	private CrudFuncionarioService funcionarioService;
	private CrudUnidadeTrabalhoService unidadeTrabalhoService;
	private RelatorioService relatorioService;

	public SpringDataApplication(CrudCargoService cargoservice, RelatorioService relatorioService,
								 CrudFuncionarioService funcionarioService, CrudUnidadeTrabalhoService unidadeTrabalhoService){
		this.cargoservice = cargoservice;
		this.relatorioService = relatorioService;
		this.funcionarioService = funcionarioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	public void menu(){
		System.out.println("Menu");
		System.out.println();
		System.out.println("0 - Sair");
		System.out.println("1 - Cargo");
		System.out.println("2 - Funcionario");
		System.out.println("3 - Unidade de trabalho");
		System.out.println("4 - Relatorio");
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		Boolean run = Boolean.TRUE;

		while(run){
			menu();
			int action = scanner.nextInt();
			switch (action){
				case 0: run=false; break;
				case 1: cargoservice.inicial(scanner); break;
				case 2: funcionarioService.inicial(scanner); break;
				case 3: unidadeTrabalhoService.inicial(scanner); break;
				case 4: relatorioService.inicial(scanner); break;
			}
		}
	}
}
