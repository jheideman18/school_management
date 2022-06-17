package za.ac.cput.util;

import java.util.UUID;

public class EmployeeAddressHelper {
    public static String generateStaffID(){
        return UUID.randomUUID().toString();
    }
}
