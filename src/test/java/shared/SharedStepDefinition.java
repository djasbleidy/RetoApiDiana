package shared;

import exceptions.UserNotFoundException;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import utils.DataUserInstance;
import utils.TestData;

public class SharedStepDefinition {
    private EnvironmentVariables environmentVariables;
    private static Actor andres= Actor.named("Andres the supervisor");
    @Steps
    TestData testData;

    @Given("que Andres desea localizar un lugar {string}")
    @Given("que Andres desea localizar un lugar como: {string}")
    public void loadingData(String dataUser) throws UserNotFoundException {
        DataUserInstance.getInstance().setDataUser(testData.iniDataService());
        DataUserInstance.getInstance().getData(dataUser);
    }
    @Before
    public void configureActor(){
        andres.whoCan(CallAnApi.at(
                environmentVariables.optionalProperty("base.url")
                        .orElse("http://api.geonames.org/")
        ));
        OnStage.setTheStage(new OnlineCast());

    }
    public static Actor  getActor(){
        return andres;
    }
}
