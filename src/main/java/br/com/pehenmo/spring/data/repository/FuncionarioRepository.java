package br.com.pehenmo.spring.data.repository;

import br.com.pehenmo.spring.data.orm.Funcionario;
import br.com.pehenmo.spring.data.projecao.FuncionarioProjecao;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer>, JpaSpecificationExecutor<Funcionario> {

    List<Funcionario> findByNome(String nome);

    @Query("SELECT f FROM Funcionario f WHERE f.nome = :nome AND f.cpf = :cpf")
    List<Funcionario> findNomeAndCpfComJPQL(String nome, String cpf);

    @Query(value = "SELECT f FROM funcionario f WHERE f.nome = :nome AND f.cpf = :cpf", nativeQuery = true)
    List<Funcionario> findNomeAndCpfComNativeQuery(String nome, String cpf);

    @Query(value = "SELECT f.id_funcionario, f.nome, f.salario FROM funcionario f", nativeQuery = true)
    List<FuncionarioProjecao> findFuncionarioSalario();

}
