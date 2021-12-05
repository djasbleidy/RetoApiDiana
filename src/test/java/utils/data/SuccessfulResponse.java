package utils.data;

import org.apache.hc.core5.http.HttpStatus;



public enum SuccessfulResponse {
    ANGOLA( HttpStatus.SC_OK,20, "AO",1, 1, "Africa/Luanda",1,"Angola", -10),
    GUATEMALA( HttpStatus.SC_OK,-91.13049, "GT",-6, -6, "America/Guatemala",-6,"Guatemala", 14.968519),
    LAGOS( HttpStatus.SC_OK,7, "NG",1, 1, "Africa/Lagos",1,"Nigeria", 8.74),
    BOGOTA( HttpStatus.SC_OK,-75.92495, "CO",-5, -5, "America/Bogota",-5,"Colombia", 8.73389);
    private int httpStatus;
    private Number lng;
    private String countryCode;
    private int gmtOffset;
    private int rawOffset;
    private String timezoneId;
    private int dstOffset;
    private String countryName;
    private Number lat;

    SuccessfulResponse(int httpStatus, Number lng, String  countryCode, int gmtOffset, int rawOffset, String timezoneId , int dstOffset, String countryName, Number lat) {
        this.httpStatus=httpStatus;
        this.lng= lng;
        this.countryCode=countryCode;
        this.gmtOffset=gmtOffset;
        this.rawOffset=rawOffset;
        this.timezoneId=timezoneId;
        this.dstOffset=dstOffset;
        this.countryName=countryName;
        this.lat=lat;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public Number  getLng() {
          return (lng.doubleValue() % 1!=0)?lng.floatValue():lng;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public int getGmtOffset() {
        return gmtOffset;
    }

    public int getRawOffset() {
        return rawOffset;
    }

    public String getTimezoneId() {
        return timezoneId;
    }

    public int getDstOffset() {
        return dstOffset;
    }

    public String getCountryName() {
        return countryName;
    }

    public Number getLat() {
        return (lat.doubleValue() % 1!=0)?lat.floatValue():lat;
    }
}
