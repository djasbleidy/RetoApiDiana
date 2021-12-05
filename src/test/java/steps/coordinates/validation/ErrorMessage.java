package steps.coordinates.validation;

import net.serenitybdd.screenplay.rest.interactions.Ensure;
import shared.SharedStepDefinition;
import utils.data.UnsuccessfulResponse;

import static org.hamcrest.Matchers.equalTo;

public class ErrorMessage {
    public void errorStreams(UnsuccessfulResponse unsuccessfulResponse) {
        SharedStepDefinition.getActor().attemptsTo(
                Ensure.that( "Casos alternos flujos de error",
                        response -> response.statusCode(unsuccessfulResponse.getHttpStatus()
                        ).body("status.message",equalTo(unsuccessfulResponse.getMessage()),
                                "status.value",equalTo(unsuccessfulResponse.getValue()))));
    }
}
