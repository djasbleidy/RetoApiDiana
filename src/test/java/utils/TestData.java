package utils;

import configuration.Environment;
import org.aeonbits.owner.ConfigFactory;

import java.util.HashMap;
import java.util.Map;

public class TestData {
    private Map<String, String> dataUser = new HashMap<>();

    public Map<String, String> iniDataService() {
        Environment environment = ConfigFactory.create(Environment.class);
        dataUser.put("Angola",environment.cityAngola());
        dataUser.put("Guatemala",environment.cityGuatemala());
        dataUser.put("Lagos",environment.cityLagos());
        dataUser.put("Bogota",environment.cityBogota());
        dataUser.put("inexistente",environment.inexistente());
        dataUser.put("en especifico",environment.cityBogota());

        return dataUser;
    }
}
