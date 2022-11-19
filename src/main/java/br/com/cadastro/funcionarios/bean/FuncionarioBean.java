package br.com.cadastro.funcionarios.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

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
    @Size(min = 2, max = 30, message = "Nome deve ter entre 2 e 30 caracteres")
    public String nome;

    @Column(length = 50, nullable = false)
    @Size(min = 2, max = 50, message = "Sobrenome deve ter entre 2 e 50 caracteres")
    public String sobrenome;

    @Email(message = "Email precisa ser válido")
    @Column(name="email", nullable = false)
    public String email;

    @PositiveOrZero(message = "NIS/PIS precisa ser válido")
    @Column(columnDefinition = "int DEFAULT 0")
    public int nisPis;
}
