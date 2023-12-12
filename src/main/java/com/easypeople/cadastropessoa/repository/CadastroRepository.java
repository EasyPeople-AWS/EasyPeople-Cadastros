package com.easypeople.cadastropessoa.repository;

import com.easypeople.cadastropessoa.model.Pessoa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastroRepository extends CrudRepository<Pessoa, Long> {
    Pessoa findByCpf(String cpf);
}
