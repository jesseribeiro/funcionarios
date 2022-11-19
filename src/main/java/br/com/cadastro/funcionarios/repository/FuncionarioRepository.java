package br.com.cadastro.funcionarios.repository;

import br.com.cadastro.funcionarios.bean.FuncionarioBean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FuncionarioRepository extends CrudRepository<FuncionarioBean, Long>, GenericRepository {

    @Query("Select case when (count(x) > 0)  then true else false end From Funcionario x where x.email =:email")
    boolean existFuncionarioEmail(@Param("email") String email);
}
