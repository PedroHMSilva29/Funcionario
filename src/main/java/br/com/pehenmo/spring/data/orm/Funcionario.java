package br.com.pehenmo.spring.data.orm;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_funcionario;

    private String nome;
    private String cpf;
    private BigDecimal salario;
    private LocalDate dataContratacao;

    /**
     * a anotação @JoinColumn indica que a classe na qual você está utilizando-a é a dona ou o lado forte do relacionamento. Isso apenas adciona uma coluna estrangeira ao lado forte.
     *
     * Já o parametro mappedBy que fica dentro do @OneToMany é usado no lado fraco do relacionamento.
     *
     * O mappedBy faz com que o relacionamento fique bidirecional.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cargo", nullable =  false)
    private Cargo cargo;

    /**
     *
     * https://www.baeldung.com/hibernate-fetchmode
     *
     *
     * FetchMode.SELECT
     * Using SELECT indicates that the property should be loaded lazily. No Join or subselects just create when needed
     *
     * FetchMode.JOIN
     * loads them eagerly, say via a join:This results in just one query for both the Customer and their Orders:
     *
     * FetchMode.SUBSELECT
     * We can only use SUBSELECT with collections
     * create sub-select queries
     *
     */
    @Fetch(FetchMode.JOIN)
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    /**
     * https://stackoverflow.com/questions/5478328/in-which-case-do-you-use-the-jpa-jointable-annotation
     *
     * cria uma terceira tabela e associa as chaves primarias das tabelas funcionarios e unidade de trabalho
     */
    @JoinTable(name = "funcionario_unidade",
            joinColumns = { @JoinColumn(name = "fk_funcionario", referencedColumnName = "id_funcionario")},
            inverseJoinColumns = { @JoinColumn(name = "fk_unidade", referencedColumnName = "id_unidade_trabalho")}
    )
    private List<UnidadeTrabalho> unidadeTrabalho;

    public Funcionario() {}

    public Funcionario(String nome, String cpf, BigDecimal salario, LocalDate dataContratacao, Cargo cargo, List<UnidadeTrabalho> unidadeTrabalho) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.dataContratacao = dataContratacao;
        this.cargo = cargo;
        this.unidadeTrabalho = unidadeTrabalho;
    }

    public Integer getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(Integer id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<UnidadeTrabalho> getUnidadeTrabalho() {
        return unidadeTrabalho;
    }

    public void setUnidadeTrabalho(List<UnidadeTrabalho> unidadeTrabalho) {
        this.unidadeTrabalho = unidadeTrabalho;
    }

    @Override
    public String toString() {

        return "Funcionario{" +
                "id_funcionario=" + id_funcionario +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", salario=" + salario +
                ", dataContratacao=" + dataContratacao +
                ", cargo=" + cargo.getDescricao() +
                '}';
    }
}