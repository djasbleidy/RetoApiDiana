package steps.coordinates;

import net.serenitybdd.core.steps.Instrumented;
import utils.DataUserInstance;
import utils.GetRequest;
import utils.Utility;

import java.util.HashMap;
import java.util.Map;


 class SiteCoordinatesRequest {
     private SiteCoordinatesRequest() {
         throw new IllegalStateException("Utility class");
     }
    private static Map<String, String> parameters = new HashMap<>();
    private static Map<String, String> headers = new HashMap<>();
    private static final String PATH = "timezoneJSON";

    private static void cargarMap() {
        parameters.put("formatted", Utility.FORMATTED);
        parameters.put("lat", DataUserInstance.getInstance().getData().get("lat").getAsString());
        parameters.put("lng", DataUserInstance.getInstance().getData().get("lng").getAsString());
        parameters.put("username", Utility.USER);
        parameters.put("style", Utility.STYLE);
        headers.put("Host", Utility.HOST);
        headers.put("Accept", Utility.ACCEPT);
        headers.put("Postman-Token", Utility.TOKEN);
    }

    public static GetRequest getSiteCoordinatesRequest()  {
        cargarMap();
        return Instrumented.instanceOf(GetRequest.class).withProperties(parameters,headers,PATH);
    }
    public static GetRequest parametersRemoved(String element)  {
        cargarMap();
        parameters.remove(element);
        headers.remove(element);
        return Instrumented.instanceOf(GetRequest.class).withProperties(parameters,headers,PATH);
    }
    public static GetRequest wrongParameters(String element)  {
        cargarMap();
        parameters.computeIfPresent(element,(key, k) -> Utility.WRONGPARAMETER);
        headers.computeIfPresent(element,(key, k) -> Utility.WRONGPARAMETER);
        return Instrumented.instanceOf(GetRequest.class).withProperties(parameters,headers,PATH);
    }
}
