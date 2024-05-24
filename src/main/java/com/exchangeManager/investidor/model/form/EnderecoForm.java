package com.exchangeManager.investidor.model.form;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class EnderecoForm {

    private Long cep;
    private String rua;
    private String complemento;
    private String bairro;
    private String cidade;
}
