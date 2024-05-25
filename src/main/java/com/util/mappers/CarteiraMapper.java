package com.util.mappers;

import com.exchangeManager.carteira.model.dto.CarteiraRecord;
import com.exchangeManager.carteira.model.entity.Carteira;

import java.util.ArrayList;
import java.util.List;

public class CarteiraMapper {

    public static CarteiraRecord convert(Carteira carteiraEntity){
        CarteiraRecord carteiraRecord = new CarteiraRecord(carteiraEntity.getNumeroConta());
        return carteiraRecord;
    }

    public static List<CarteiraRecord> convert(List<Carteira> carteiraEntities){
        List<CarteiraRecord> carteiraRecords = new ArrayList<CarteiraRecord>();
         carteiraEntities.forEach(
                 (carteira) -> {
                     carteiraRecords.add(new CarteiraRecord(carteira.getNumeroConta()));
                 }
         );

        return carteiraRecords;
    }

    public static Carteira convertCarteira(CarteiraRecord carteiraRecord){
        Carteira carteira = new Carteira(carteiraRecord.numeroConta());
        return carteira;
    }
}
