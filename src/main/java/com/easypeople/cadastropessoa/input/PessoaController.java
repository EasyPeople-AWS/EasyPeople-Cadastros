package com.easypeople.cadastropessoa.input;

import com.easypeople.cadastropessoa.model.Pessoa;
import com.easypeople.cadastropessoa.service.CadastroService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@NoArgsConstructor
public class PessoaController {

    @Autowired
    CadastroService cadastroService;

    @PostMapping("/cadastro")
    public String cadastraPessoa(@RequestBody @Validated Pessoa pessoa){
        try{
            log.info("Pessoa Recebida: {}", pessoa);
            cadastroService.cadastraPessoa(pessoa);
            log.info("CPF: {} cadastrado com sucesso ", pessoa.getCpf());
            return "Pessoa cadastrada com sucesso";

        }catch (BadRequestException e){
            log.info("Cpf ja cadastrado: {}", pessoa.getCpf());
            return "Cpf ja cadastrado";
        }catch (RuntimeException e){
            log.info("Ocorreu um erro ao cadastrar pessoa: {}", pessoa);
            return "Ocorreu um erro ao cadastrar a pessoa";
        }
    }
    @GetMapping("/cadastrados")
    public List<Pessoa> mostraCadastro(){
        try{
            log.info("Solicitação de retorno de cadastros");
            return cadastroService.mostraPessoa();
        }catch (RuntimeException e){
            return null;
        }
    }

    @DeleteMapping("/excluiCadastro")
    public String deletaCadastro(@RequestHeader @Validated String cpf){
        try{
            log.info("Tentando excluir cadastro");
            cadastroService.excluiCadastro(cpf);
            return "Cadastro " + cpf + " excluido com sucesso!";
        }catch (RuntimeException e){
            return "Ocorreu um erro ao deletar o cadastro";
        }
    }
}
