package com.exchangeManager.carteira.model.entity;

import com.exchangeManager.carteira.model.dto.CarteiraRecord;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.security.SecureRandom;

@SqlResultSetMapping(
        name = "CarteiraRecordMapping",
        classes = @ConstructorResult(
                targetClass = CarteiraRecord.class,
                columns = {
                        @ColumnResult(name = "numeroConta", type = String.class)
                }
        )
)

@Data
@AllArgsConstructor
@Entity(name = "carteira")
public class Carteira {

    @Id
    private String numeroConta;

    public Carteira() {
        final int NUMBER_OF_CHARACTERS = 16;
        final int NUMBER_OF_CHARACTERS_BY_GROUP = 4;
        final int INITIAL_INDEX = 0;

        SecureRandom secureRandom = new SecureRandom();
        StringBuilder cardNumberBuilder = new StringBuilder(NUMBER_OF_CHARACTERS);

        for (int i = 0; i < NUMBER_OF_CHARACTERS; i++) {
            int digit = secureRandom.nextInt(10);
            cardNumberBuilder.append(digit);
        }

        String cardNumberString = cardNumberBuilder.toString();

        StringBuilder cardNumberFormatted = new StringBuilder();
        for (int i = INITIAL_INDEX; i < cardNumberString.length(); i += NUMBER_OF_CHARACTERS_BY_GROUP) {
            cardNumberFormatted.append(cardNumberString, i, Math.min(i + NUMBER_OF_CHARACTERS_BY_GROUP, cardNumberString.length())).append("-");
        }

        cardNumberFormatted.setLength(cardNumberFormatted.length() - 1);

        setNumeroConta(cardNumberFormatted.toString());
    }


}
