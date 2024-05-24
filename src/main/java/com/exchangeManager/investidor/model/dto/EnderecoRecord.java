package com.exchangeManager.investidor.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


public record EnderecoRecord(Long cep, String rua, String complemento, String bairro, String cidade) { }
