package br.com.pehenmo.spring.data.orm;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cargos")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cargo;

    private String descricao;

    @OneToMany(mappedBy = "cargo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Funcionario> funcionario;

    public Cargo(String descricao) {
        this.descricao = descricao;
    }

    public Cargo(String descricao, List<Funcionario> funcionario) {
        this.descricao = descricao;
        this.funcionario = funcionario;
    }

    public Cargo() {}

    public Integer getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(Integer id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Funcionario> getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(List<Funcionario> funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id_cargo=" + id_cargo +
                ", descricao='" + descricao + '\'' +
                ", funcionario=" + funcionario +
                '}';
    }
}
