package com.easypeople.cadastropessoa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    @NonNull
    private String nome;

    private int idade;

    @NonNull
    private String cpf;

    private String email;

    private char sexo;

    private String dtNasc;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
