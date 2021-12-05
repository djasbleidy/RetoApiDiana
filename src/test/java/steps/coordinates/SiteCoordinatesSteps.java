package steps.coordinates;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import shared.SharedStepDefinition;
import steps.coordinates.validation.ErrorMessage;
import steps.coordinates.validation.Assertions;
import utils.DataUserInstance;
import utils.data.SuccessfulResponse;
import utils.data.UnsuccessfulResponse;

public class SiteCoordinatesSteps {
    @Steps
    Assertions assertionsUtil;
    @Steps
    ErrorMessage errorMessage;

    @When("ingrese las coordenadas de búsqueda")
    public void searchCoordinates() {
        SharedStepDefinition.getActor().attemptsTo(
                SiteCoordinatesRequest.getSiteCoordinatesRequest());
    }
    @When("ingrese las coordenadas de búsqueda sin {string}")
    public void enterCoordinates(String value) {
        SharedStepDefinition.getActor().attemptsTo(
                SiteCoordinatesRequest.parametersRemoved(value));
    }
    @When("ingrese el parametro {string} incorrecto")
    public void enterIncorrectParameter(String value) {
        SharedStepDefinition.getActor().attemptsTo(
                SiteCoordinatesRequest.wrongParameters(value));
    }
    @Then("mostrara el sitio con la hora actual de ese lugar")
    public void willShowTheSite() {
        assertionsUtil.validateCodeEn(SuccessfulResponse.valueOf(
                DataUserInstance.getInstance().getUser().toUpperCase()
        ));
    }
    @Then("generara un error de {string} en la consulta")
    public void queryError(String data) {
        errorMessage.errorStreams(UnsuccessfulResponse.valueOf(
                data.toUpperCase()
        ));
    }
}
