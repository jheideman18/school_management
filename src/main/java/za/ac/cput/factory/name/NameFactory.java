/* NameFacory.java
        * Author: Smangele Witness Mabaso (220047154)
        * Date: 14 June 2022
        */
package za.ac.cput.factory.name;

import za.ac.cput.domain.name.Name;
import za.ac.cput.util.Stringhelper;

public class NameFactory {

    public static Name build(String firstName, String middleName, String lastName){
        if (Stringhelper.isEmptyorNull(firstName))
           throw new IllegalArgumentException("firstName is required");
        if (Stringhelper.isEmptyorNull(middleName))
            throw new IllegalArgumentException("middleName is required");
        if (Stringhelper.isEmptyorNull(lastName))
            throw new IllegalArgumentException("lastName is required");
            return new Name.Builder().firstName(firstName)
                .middleName(middleName)
                .lastName(lastName)
                .build();
    }
}
