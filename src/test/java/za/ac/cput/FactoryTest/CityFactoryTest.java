package za.ac.cput.FactoryTest;
/*
Jody Heideman 219307725
CityFactoryTest.java
11/06/22
 */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.address.City;
import za.ac.cput.domain.address.Country;
import za.ac.cput.factory.address.CityFactory;
import za.ac.cput.factory.address.CountryFactory;

import static org.junit.jupiter.api.Assertions.*;

class CityFactoryTest {

   @Test
    public void buildWithSuccess(){
       Country country = CountryFactory.createCountry("15" , "South Africa");
       City city = CityFactory.createCity("15214" ,"Cape Town" , country);

      System.out.println(city);
       assertAll(
               ()-> assertNotNull(city),
               ()-> assertNotNull(city.getName())
       );

   }

   @Test
   public void buildWithError(){


      Country country = CountryFactory.createCountry("15" , "South Africa");
      Exception exception = assertThrows(IllegalArgumentException.class, () ->
              CityFactory
                      .createCity(null , "Cape Town", country));

     String exceptionMessage = exception.getMessage();
     System.out.println(exceptionMessage);
     assertSame("id is required" , exceptionMessage);

   }


}