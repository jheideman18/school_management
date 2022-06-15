package za.ac.cput.school_management.domain;
/*
Jody Heideman 219307725
Country.java
11/06/22
 */
public class Country {

    private String id, name;

    private Country(Builder builder){

        this.id = builder.id;
        this.name = builder.name;

    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static class Builder{
        private String id, name;

        public Builder setId(String id){
            this.id = id;
            return this;
        }

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder copy(Country country){
            this.id = country.id;
            this.name = country.name;
            return this;
        }

        public Country build(){
            return new Country(this);
        }
    }

    @Override
    public String toString() {
        return "Country{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
