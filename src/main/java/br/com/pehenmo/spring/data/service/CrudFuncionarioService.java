package br.com.pehenmo.spring.data.service;

import br.com.pehenmo.spring.data.orm.Cargo;
import br.com.pehenmo.spring.data.orm.Funcionario;
import br.com.pehenmo.spring.data.orm.UnidadeTrabalho;
import br.com.pehenmo.spring.data.projecao.FuncionarioProjecao;
import br.com.pehenmo.spring.data.repository.CargoRepository;
import br.com.pehenmo.spring.data.repository.FuncionarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Service
public class CrudFuncionarioService {

    private FuncionarioRepository funciarioRepository;
    private CargoRepository cargoRepository;

    public CrudFuncionarioService(FuncionarioRepository funciarioRepository, CargoRepository cargoRepository) {
        this.funciarioRepository = funciarioRepository;
        this.cargoRepository = cargoRepository;
    }

    private void menu(){
        System.out.println("Menu");
        System.out.println();
        System.out.println("0 - Sair");
        System.out.println("1 - Salvar funcionario");
        System.out.println("2 - Remover funcionario");
        System.out.println("3 - Buscar funcionario");
        System.out.println("4 - Lista todos funcionarios pageble");
        System.out.println("5 - Lista todos funcionarios por salario");

    }

    public void inicial(Scanner scanner){

        menu();

        int action = scanner.nextInt();
        switch(action){
            case 0: break;
            case 1: salvar(); break;
            case 2: remover(1); break;
            case 3: buscar(1); break;
            case 4: visualizaPage(); break;
            case 5: projecaoExemplo(); break;

        }
    }

    public void projecaoExemplo() {
        List<FuncionarioProjecao> funcionarios = funciarioRepository.findFuncionarioSalario();
        funcionarios.forEach(f -> System.out.println("id: " +f.getId_funcionario() +" - nome: "+ f.getNome() +" - salario: "+ f.getSalario()));
    }

    public void visualizaPage(){
        //Pageable page = PageRequest.of(0,3, Sort.unsorted());
        Pageable page = PageRequest.of(0,3, Sort.by(Sort.Direction.ASC, "nome"));
        Page<Funcionario> funcionarios = funciarioRepository.findAll(page);
        funcionarios.forEach(System.out::print);
        System.out.println(funcionarios);
        System.out.println("TotalPages: "+ funcionarios.getTotalPages());
        System.out.println("TotalElements: "+ funcionarios.getTotalElements());
    }


    public void salvar(){
        Funcionario funcionario = new Funcionario();
        funcionario.setCpf("38050900000");
        funcionario.setDataContratacao(LocalDate.now());
        funcionario.setNome("Pedro");

        //Cargo
        Cargo cargo = new Cargo();
        cargo.setDescricao("Team member");
        cargo.setFuncionario(Arrays.asList(funcionario));
        //cargoRepository.save(cargo);
        funcionario.setCargo(cargo);

        //Unidade de trabalho
        UnidadeTrabalho unidade = new UnidadeTrabalho();
        unidade.setDescricao("desc_unidade");
        unidade.setEndereco("end");
        unidade.setFuncionario(Arrays.asList(funcionario));

        funcionario.setUnidadeTrabalho(Arrays.asList(unidade));


        funciarioRepository.save(funcionario);
    }

    public void remover(Integer id) {
        funciarioRepository.deleteById(id);
    }

    public Funcionario buscar(Integer id) {
        Funcionario c = funciarioRepository.findById(id).get();
        System.out.println(c);
        return c;
    }
}
