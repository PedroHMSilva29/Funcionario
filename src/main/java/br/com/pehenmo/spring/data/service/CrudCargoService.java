package br.com.pehenmo.spring.data.service;

import br.com.pehenmo.spring.data.orm.Cargo;
import br.com.pehenmo.spring.data.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Scanner;

@Service
public class CrudCargoService {

    CargoRepository repository;

    public CrudCargoService(CargoRepository repository){
        this.repository = repository;
    }

    private void menu(){
        System.out.println("Menu/n");
        System.out.println("0 - Sair/n");
        System.out.println("1 - Salvar cargo/n");
        System.out.println("2 - Remover cargo/n");
        System.out.println("3 - Buscar cargo /n");
    }

    public void inicial(Scanner scanner){

        menu();

        int action = scanner.nextInt();
        switch(action){
            case 0: break;
            case 1: salvar(scanner); break;
            case 2: remover(1); break;
            case 3: buscar(1); break;

        }
    }

    public void salvar(Scanner scanner){
        Cargo cargo = new Cargo("Cargo_desc");
        repository.save(cargo);
    }

    public void remover(Integer id) {
        repository.deleteById(id);
    }

    public Cargo buscar(Integer id) {
        Cargo c = repository.findById(id).get();
        System.out.println(c);
        return c;
    }
}
