package za.ac.cput.school_management.factory.student;

import za.ac.cput.school_management.domain.student.StudentAddress;
import za.ac.cput.school_management.util.Stringhelper;

/*
Entity for StudentAddress
Chulumanco Buhle Nkwindana
219390983
11 June 2022 */
public class StudentAddressFactory {
    public static StudentAddress build (String studentID, String studentAddress){
        Stringhelper.checkStringParam( "studentID", studentID);
        Stringhelper.checkStringParam( "student address", studentAddress);
        return new StudentAddress.Builder().studentID(studentID)
                .address(studentAddress).build();

}}
