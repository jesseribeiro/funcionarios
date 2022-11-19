package br.com.cadastro.funcionarios.bean;

import javax.persistence.*;
import java.util.Calendar;

@MappedSuperclass
public abstract class GenericBean {
    @Id
    @Column(
            name = "id"
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    protected Long id;

    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataCadastro;

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
