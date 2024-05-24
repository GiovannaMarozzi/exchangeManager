package com.exchangeManager.investidor.model.form;

import com.exchangeManager.carteira.model.entity.Carteira;
import com.exchangeManager.investidor.model.entity.Documento;
import com.exchangeManager.investidor.model.entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvestidorForm {

    public enum Sexo {
        MASCULINO,
        FEMININO,
        OUTROS;
    }

    private String nome;
    private List<Documento> documentos;
    private Long celular;
    private String email;
    private Sexo sexo;
    private String profissao;
    private LocalDate dataNascimento;
    private BigDecimal renda;

    private Endereco endereco;
    private Carteira carteira = new Carteira();


}
