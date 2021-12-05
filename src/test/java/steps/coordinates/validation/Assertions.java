package steps.coordinates.validation;

import shared.SharedStepDefinition;
import net.serenitybdd.screenplay.rest.interactions.Ensure;
import utils.data.SuccessfulResponse;

import static org.hamcrest.Matchers.equalTo;

public class Assertions {

    public void validateCodeEn(SuccessfulResponse transactionResponse) {

        SharedStepDefinition.getActor().attemptsTo(
                Ensure.that( "Validación cordenadas",
                        response -> response.statusCode(transactionResponse.getHttpStatus()
                        ).body("lng",equalTo(transactionResponse.getLng()),
                                "countryCode",equalTo(transactionResponse.getCountryCode()),
                                "lat",equalTo(transactionResponse.getLat()),
                                "gmtOffset",equalTo(transactionResponse.getGmtOffset()),
                                "rawOffset",equalTo(transactionResponse.getRawOffset()),
                                "dstOffset",equalTo(transactionResponse.getDstOffset()),
                                "countryName",equalTo(transactionResponse.getCountryName())))
        );
    }
}
