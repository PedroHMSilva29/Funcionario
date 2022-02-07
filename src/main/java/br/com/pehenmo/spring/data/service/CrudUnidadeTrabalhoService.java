package br.com.pehenmo.spring.data.service;

import br.com.pehenmo.spring.data.orm.Cargo;
import br.com.pehenmo.spring.data.orm.UnidadeTrabalho;
import br.com.pehenmo.spring.data.repository.UnidadeTrabalhoRepositoy;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudUnidadeTrabalhoService {

    private UnidadeTrabalhoRepositoy repository;

    public CrudUnidadeTrabalhoService(){
        this.repository = repository;
    }

    private void menu(){
        System.out.println("Menu/n");
        System.out.println("0 - Sair/n");
        System.out.println("1 - Salvar unidade de trabalho/n");
        System.out.println("2 - Remover unidade de trabalho/n");
        System.out.println("3 - Buscar unidade de trabalho /n");

    }

    public void inicial(Scanner scanner){

        menu();

        int action = scanner.nextInt();
        switch(action){
            case 0: break;
            case 1: salvar(); break;
            case 2: remover(1); break;
            case 3: buscar(1); break;

        }
    }

    public void salvar(){
        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
        unidadeTrabalho.setDescricao("unidade_desc");
        repository.save(unidadeTrabalho);
    }

    public void remover(Integer id) {
        repository.deleteById(id);
    }

    public UnidadeTrabalho buscar(Integer id) {
        UnidadeTrabalho c = repository.findById(id).get();
        System.out.println(c);
        return c;
    }
}
