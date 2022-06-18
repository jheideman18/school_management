package za.ac.cput.domain.address;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/*
Jody Heideman 219307725
City.java
11/06/22
 */
@Entity
public class City implements Serializable {
    @NotNull
    @Id
    private  String id;
    @NotNull
    private String name;

    @OneToOne
    @JoinColumn(name = "country_id")
    private Country country;

    protected City(){ }

    private City (Builder builder){

        this.id = builder.id;
        this.name = builder.name;
        this.country = builder.country;
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public static class Builder{
        private String id, name;
        private Country country;

        public Builder setId(String id){
            this.id = id;
            return this;
        }
        public Builder setName(String name){
            this.name = name;
            return this;
        }
        public Builder setCountry(Country country){
            this.country = country;
            return this;
        }

        public Builder copy(City city){

            this.id = city.id;
            this.name = city.name;
            this.country = city.country;
            return this;
        }

        public City build(){
            return new City(this);
        }

    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}
