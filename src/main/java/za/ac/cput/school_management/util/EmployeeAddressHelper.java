package za.ac.cput.school_management.util;

import java.util.UUID;

public class EmployeeAddressHelper {
    public static String generateStaffID(){
        return UUID.randomUUID().toString();
    }
}
