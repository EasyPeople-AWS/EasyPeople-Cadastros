package com.easypeople.cadastropessoa.service;

import com.easypeople.cadastropessoa.model.Pessoa;
import com.easypeople.cadastropessoa.repository.CadastroRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroService {

    @Autowired
    CadastroRepository cadastroRepository;

    public void cadastraPessoa(Pessoa pessoa) throws BadRequestException {
        try {
            Pessoa pessoaJaExistente = cadastroRepository.findByCpf(pessoa.getCpf());
            if (pessoaJaExistente == null){
                cadastroRepository.save(pessoa);
            }else {
                throw new BadRequestException();
            }
        } catch (BadRequestException e) {
            throw new BadRequestException();
        }catch (Exception e) {
            throw new RuntimeException();
        }

    }

    public List<Pessoa> mostraPessoa() {
        try {
            return (List<Pessoa>) cadastroRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void excluiCadastro(String cpf) {
        try {
            Pessoa pessoa = cadastroRepository.findByCpf(cpf);
            if (pessoa == null){
                throw new RuntimeException();
            }else {
                cadastroRepository.delete(pessoa);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
