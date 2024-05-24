package com.util.mappers;

import com.exchangeManager.investidor.model.dto.EnderecoRecord;
import com.exchangeManager.investidor.model.entity.Endereco;

public class EnderecoMapper {

    public static EnderecoRecord convert(Endereco enderecoEntity){
        EnderecoRecord enderecoRecord = new EnderecoRecord(
                 enderecoEntity.getCep()
                ,enderecoEntity.getRua()
                ,enderecoEntity.getComplemento()
                ,enderecoEntity.getBairro()
                ,enderecoEntity.getCidade()
        );

        return enderecoRecord;
    }



}
