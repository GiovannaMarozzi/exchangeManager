package com.util.mappers;

import com.exchangeManager.investidor.model.dto.SexoRecord;
import com.exchangeManager.investidor.model.entity.Investidor;
import com.exchangeManager.investidor.model.form.InvestidorForm;


public class SexoMapper {

    public static SexoRecord convert(Investidor.Sexo sexo) {
        return new SexoRecord(sexo);
    }

    public static SexoRecord convert(InvestidorForm.Sexo sexo) {
        return new SexoRecord(Investidor.Sexo.valueOf(sexo.name()));
    }
}
