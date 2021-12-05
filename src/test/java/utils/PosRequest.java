package utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

import java.util.Map;


public class PosRequest implements Task {
    private final Map<String , String> headers;
    private final String body;
    private final String path;


    public PosRequest(Map<String,String> headers, String body , String path) {
        this.headers=headers;
        this.body=body;
        this.path=path;
    }

    @Override
    @Step("{0} fetches the user with id #valide")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Post.to(path).with(resquest->
                resquest
                    .headers(headers)
                    .body(body)
            ));
    }
}
