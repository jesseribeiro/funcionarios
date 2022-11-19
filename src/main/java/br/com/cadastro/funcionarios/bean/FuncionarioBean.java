package br.com.cadastro.funcionarios.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Funcionario")
@Table(name = "funcionario", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class FuncionarioBean extends GenericBean {

    @Column(length = 30, nullable = false)
    @Size(min = 2, max = 30)
    public String nome;

    @Column(length = 50, nullable = false)
    @Size(min = 2, max = 50)
    public String sobrenome;

    @Column(name="email", nullable = false)
    public String email;

    @NotNull
    @Column(columnDefinition = "int DEFAULT 0")
    public int nisPis;
}
