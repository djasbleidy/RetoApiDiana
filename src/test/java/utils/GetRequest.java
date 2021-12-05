package utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import java.util.Map;


public class GetRequest implements Task {
    private final Map<String , String> parameters;
    private final Map <String , String> headers;
    private final String path;


    public GetRequest(Map<String,String> parameters, Map<String,String> headers, String path) {
        this.parameters=parameters;
        this.headers=headers;
        this.path=path;

    }

    @Override
    @Step("{0} fetches the user with id #valide")

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Get.resource(path).with(resquest->
                resquest
                    .queryParams(parameters)
                    .headers(headers))
        );
    }
}
