package za.ac.cput.school_management.domain;
/*
Jody Heideman 219307725
Address.java
11/06/22
 */
public class Address {

    private final String unitNumber, complexName, streetNumber, streetName;
    private final int postalCode;
    private City city;

    private Address(Builder builder){

        this.unitNumber = builder.unitNumber;
        this.complexName = builder.complexName;
        this.streetNumber = builder.streetNumber;
        this.streetName = builder.streetName;
        this.postalCode = builder.postalCode;
        this.city = builder.city;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public String getComplexName() {
        return complexName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public City getCity() {
        return city;
    }

    public static class Builder{
        private String unitNumber, complexName, streetNumber, streetName;
        private int postalCode;
        private City city;

        public Builder setUnitNumber(String unitNumber){
            this.unitNumber = unitNumber;
            return this;
        }

        public Builder setComplexName(String complexName){
            this.complexName = complexName;
            return this;
        }
        public Builder setStreetNumber(String streetNumber){
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder setStreetName(String streetName){
            this.streetName = streetName;
            return this;
        }

        public Builder setPostalCode(int postalCode){
            this.postalCode = postalCode;
            return this;
        }

        public Builder setCity(City city){
            this.city = city;
            return this;
        }

        public Builder copy(Address address){
            this.unitNumber = address.unitNumber;
            this.complexName = address.complexName;
            this.streetNumber = address.streetNumber;
            this.streetName = address.streetName;
            this.postalCode = address.postalCode;
            this.city = address.city;
            return this;

        }

        public Address build(){return new Address(this);}
    }

    @Override
    public String toString() {
        return "Address{" +
                "unitNumber='" + unitNumber + '\'' +
                ", complexName='" + complexName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", postalCode=" + postalCode +
                ", city=" + city +
                '}';
    }

}
