package za.ac.cput.school_management.factory;

import za.ac.cput.school_management.domain.StudentAddress;
import za.ac.cput.school_management.helper.StringHelper;

/*
Entity for StudentAddress
Chulumanco Buhle Nkwindana
219390983
11 June 2022 */
public class StudentAddressFactory {
    public static StudentAddress build (String studentID, String studentAddress){
        StringHelper.checkStringParam( "studentID", studentID);
        StringHelper.checkStringParam( "student address", studentAddress);
        return new StudentAddress.Builder().studentID(studentID)
                .address(studentAddress).build();

}}
