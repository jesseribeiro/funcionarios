package br.com.cadastro.funcionarios.service;

import br.com.cadastro.funcionarios.bean.GenericBean;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Getter
@Setter
public class GenericService<T extends GenericBean, DAO extends CrudRepository<T, Long>> {

    @Autowired
    private DAO repository;

    public T save(@Valid T bean) {
        if(bean.getId() != null) {
            return update(bean);
        }
        bean.setDataCadastro(Calendar.getInstance());
        return repository.save(bean);
    }

    public T update(T bean) {
        return repository.save(bean);
    }

    public T getById(Long id) {
        return repository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Entidade não encontrada")
        );
    }

    public List<T> convertIterableToList(Iterable<T> iterable){
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void delete(T bean) {
        repository.delete(bean);
    }
}
