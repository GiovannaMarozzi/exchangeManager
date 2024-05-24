package com.util.mappers;


import com.exchangeManager.investidor.model.dto.InvestidorCarteiraRecord;
import com.exchangeManager.investidor.model.dto.InvestidorRecord;
import com.exchangeManager.investidor.model.dto.interfaces.InvestidorRecordI;
import com.exchangeManager.investidor.model.entity.Investidor;
import com.exchangeManager.investidor.model.form.InvestidorForm;

import java.util.ArrayList;
import java.util.List;

public class InvestidorMapper {

    public static InvestidorRecordI converterComCarteira(InvestidorForm investidor) {
        InvestidorCarteiraRecord investidorCarteiraRecord = new InvestidorCarteiraRecord(
                investidor.getNome()
                , DocumentoMapper.convert(investidor.getDocumentos())
                , investidor.getCelular()
                , investidor.getEmail()
                , SexoMapper.convert(investidor.getSexo())
                , investidor.getProfissao()
                , investidor.getDataNascimento()
                , investidor.getRenda()
                , EnderecoMapper.convert(investidor.getEndereco())
                , CarteiraMapper.convert(investidor.getCarteira())
        );

        return investidorCarteiraRecord;
    }

    public static Investidor converter(InvestidorForm investidorForm) {
        Investidor investidor = new Investidor();

        investidor.setDocumentos(investidorForm.getDocumentos());
        investidor.setNome(investidorForm.getNome());
        investidor.setCelular(investidorForm.getCelular());
        investidor.setEmail(investidorForm.getEmail());
        investidor.setSexo(Investidor.Sexo.valueOf(String.valueOf(investidorForm.getSexo())));
        investidor.setProfissao(investidorForm.getProfissao());
        investidor.setDataNascimento(investidorForm.getDataNascimento());
        investidor.setRenda(investidorForm.getRenda());
        investidor.setEndereco(investidorForm.getEndereco());
        investidor.setCarteira(investidorForm.getCarteira());
        investidor.setCarteira(investidorForm.getCarteira());

        return investidor;
    }

    public static InvestidorRecordI converterComCarteira(Investidor investidor) {
        InvestidorCarteiraRecord investidorCarteiraRecord = new InvestidorCarteiraRecord(
                investidor.getNome()
                , DocumentoMapper.convert(investidor.getDocumentos())
                , investidor.getCelular()
                , investidor.getEmail()
                , SexoMapper.convert(investidor.getSexo())
                , investidor.getProfissao()
                , investidor.getDataNascimento()
                , investidor.getRenda()
                , EnderecoMapper.convert(investidor.getEndereco())
                , CarteiraMapper.convert(investidor.getCarteira())
        );

        return investidorCarteiraRecord;
    }

    public static List<InvestidorRecordI> converterComCarteira(List<Investidor> investidores) {

        List<InvestidorRecordI> investorRecords = new ArrayList<InvestidorRecordI>();

        investidores.forEach(
                investidor -> {
                    InvestidorRecordI investidorRecordI = converterComCarteira(investidor);
                    investorRecords.add(investidorRecordI);
                }
        );

        return investorRecords;
    }


    public static InvestidorRecordI converterSemCarteira(InvestidorForm investidor) {
        InvestidorRecord investidorCarteiraRecord = new InvestidorRecord(
                investidor.getNome()
                ,DocumentoMapper.convert(investidor.getDocumentos())
                ,investidor.getCelular()
                ,investidor.getEmail()
                ,SexoMapper.convert(investidor.getSexo())
                ,investidor.getProfissao()
                ,investidor.getDataNascimento()
                ,investidor.getRenda()
                ,EnderecoMapper.convert(investidor.getEndereco())
        );

        return investidorCarteiraRecord;
    }

    public static InvestidorRecordI converterSemCarteira(Investidor investidor) {
        InvestidorRecord investidoraRecord = new InvestidorRecord(
                investidor.getNome()
                , DocumentoMapper.convert(investidor.getDocumentos())
                , investidor.getCelular()
                , investidor.getEmail()
                , SexoMapper.convert(investidor.getSexo())
                , investidor.getProfissao()
                , investidor.getDataNascimento()
                , investidor.getRenda()
                , EnderecoMapper.convert(investidor.getEndereco())
        );

        return investidoraRecord;
    }

    public static List<InvestidorRecordI> converterSemCarteira(List<Investidor> investidores) {
        List<InvestidorRecordI> investorRecords = new ArrayList<InvestidorRecordI>();

        investidores.forEach(
                investidor -> {
                    InvestidorRecordI investidorRecordI = converterSemCarteira(investidor);
                    investorRecords.add(investidorRecordI);
                }
        );

        return investorRecords;
    }
}
