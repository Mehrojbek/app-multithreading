package uz.pdp.appmultithreading.concurrency;

public class Address implements Cloneable {
    private String addressLine;
    private String city;
    private Region region;

    public Address(String addressLine, String city, Region region) {
        this.addressLine = addressLine;
        this.city = city;
        this.region = region;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressLine='" + addressLine + '\'' +
                ", city='" + city + '\'' +
                ", region=" + region +
                '}';
    }

    @Override
    public Address clone() {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
