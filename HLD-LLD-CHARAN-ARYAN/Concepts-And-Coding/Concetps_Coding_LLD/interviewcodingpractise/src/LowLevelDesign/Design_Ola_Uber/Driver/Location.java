package LowLevelDesign.Design_Ola_Uber.Driver;

public class Location {

    int zipCode;
    String city;

    public Location(int zipCode, String city) {
        this.zipCode = zipCode;
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }
}
