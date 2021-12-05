package utils;

import exceptions.UserNotFoundException;
import io.cucumber.messages.internal.com.google.gson.JsonObject;
import io.cucumber.messages.internal.com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class DataUserInstance {
    private static DataUserInstance instance;
    private Map<String, String> dataUser = new HashMap<>();
    private JsonObject data;
    private String user;

    private DataUserInstance() {
    }

    public static DataUserInstance getInstance() {
        if (instance == null) {
            instance = new DataUserInstance();
        }
        return instance;
    }

    public JsonObject getData(String user) throws UserNotFoundException {
        this.user=user;
        JsonParser parser = new JsonParser();
        Optional<String> dataOptional = Optional.ofNullable(dataUser.get(user));
        String dataVerified = dataOptional
                .orElseThrow(() -> new UserNotFoundException("Type of user does not exist in the system"));
        data = parser.parse(dataVerified).getAsJsonObject();
        return data;
    }

    public JsonObject getData()  {
        return data;
    }
    public String getUser(){
        return user;
    }

    public void setDataUser(Map<String, String> dataUser) {
        this.dataUser = dataUser;
    }
}
