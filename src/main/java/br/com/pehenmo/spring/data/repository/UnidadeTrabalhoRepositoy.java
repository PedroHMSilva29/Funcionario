package br.com.pehenmo.spring.data.repository;

import br.com.pehenmo.spring.data.orm.UnidadeTrabalho;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeTrabalhoRepositoy extends CrudRepository<UnidadeTrabalho, Integer> {
}
