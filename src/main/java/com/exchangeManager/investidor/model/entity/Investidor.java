package com.exchangeManager.investidor.model.entity;

import com.exchangeManager.carteira.model.entity.Carteira;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name = "investidor")
@NoArgsConstructor
@AllArgsConstructor
public class Investidor {

    public enum Sexo {
        MASCULINO,
        FEMININO,
        OUTROS;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, targetEntity = com.exchangeManager.investidor.model.entity.Documento.class)
    private List<Documento> documentos;
    private Long celular;
    private String email;
    private Sexo sexo;
    private String profissao;
    private LocalDate dataNascimento;
    private BigDecimal renda;

    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "carteira_id", referencedColumnName = "numeroConta")
    private Carteira carteira;


}
