package utils.data;

import org.apache.hc.core5.http.HttpStatus;

public enum UnsuccessfulResponse {
    PARAMETER( HttpStatus.SC_OK,"missing parameter ",14),//vacio y incorrecto lat y lng
    COORDENADAS( HttpStatus.SC_OK,"invalid lat/lng",14),
    USERNAMENULL( HttpStatus.SC_UNAUTHORIZED, "Please add a username to each call in order for geonames to be able to identify the calling application and count the credits usage.",10),
    USERNAME( HttpStatus.SC_UNAUTHORIZED, "user does not exist.",10),
    COORERROR( HttpStatus.SC_OK,"error parsing parameter",14);

    private int httpStatus;
    private String message;
    private int value;


    UnsuccessfulResponse(int httpStatus, String  message, int value) {
        this.httpStatus=httpStatus;
        this.message= message;
        this.value=value;
    }

    public int getHttpStatus() {return httpStatus;}

    public String getMessage() {
        return message;
    }

    public int getValue() {
        return value;
    }
}
