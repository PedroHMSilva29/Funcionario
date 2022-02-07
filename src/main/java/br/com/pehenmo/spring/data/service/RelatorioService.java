package br.com.pehenmo.spring.data.service;

import br.com.pehenmo.spring.data.orm.Funcionario;
import br.com.pehenmo.spring.data.repository.FuncionarioRepository;
import br.com.pehenmo.spring.data.specification.FuncionarioSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class RelatorioService {

    private FuncionarioRepository repository;

    public RelatorioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    private void menu(){
        System.out.println("Menu");
        System.out.println();
        System.out.println("0 - Sair");
        System.out.println("1 - Buscar Funcionario Pelo Nome");
        System.out.println("2 - Criteria exemple");
    }

    public void inicial(Scanner scanner){

        menu();

        int action = scanner.nextInt();
        switch(action){
            case 0: break;
            case 1: buscaFuncionaroPeloNome(scanner); break;
            case 2: specificationCriteria(scanner); break;
        }
    }
    public void specificationCriteria(Scanner scanner){
        System.out.println("criteria nome: ");
        String nome = null;

        System.out.println("criteria cpf: ");
        String cpf = scanner.next();

        List<Funcionario> list = repository.findAll(Specification
                .where(FuncionarioSpecification.nome(nome))
                .and(FuncionarioSpecification.cpf(cpf)));

        list.forEach(System.out::println);
    }

    public void buscaFuncionaroPeloNome(Scanner scanner){
        System.out.println("Nome do funcionario: ");
        String nome = scanner.next();
        List<Funcionario> list = repository.findByNome(nome);
        list.forEach(System.out::println);

    }
}
