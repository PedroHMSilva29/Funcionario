package br.com.pehenmo.spring.data.orm;

import javax.persistence.*;
import java.util.List;

@Entity
public class UnidadeTrabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_unidade_trabalho;

    private String descricao;
    private String endereco;

    @ManyToMany(mappedBy = "unidadeTrabalho", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Funcionario> funcionario;

    public UnidadeTrabalho() {}

    public UnidadeTrabalho(String descricao, String endereco, List<Funcionario> funcionario) {
        this.descricao = descricao;
        this.endereco = endereco;
        this.funcionario = funcionario;
    }

    public Integer getId_unidade_trabalho() {
        return id_unidade_trabalho;
    }

    public void setId_unidade_trabalho(Integer id_unidade_trabalho) {
        this.id_unidade_trabalho = id_unidade_trabalho;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Funcionario> getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(List<Funcionario> funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {
        return "UnidadeTrabalho{" +
                "id_unidade_trabalho=" + id_unidade_trabalho +
                ", descricao='" + descricao + '\'' +
                ", endereco='" + endereco + '\'' +
                ", funcionario=" + funcionario +
                '}';
    }
}
