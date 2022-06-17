package za.ac.cput.factory.student;

import za.ac.cput.domain.student.StudentAddress;
import za.ac.cput.util.Stringhelper;

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
