package za.ac.cput.school_management.factory;

import za.ac.cput.school_management.helper.StringHelper;
import za.ac.cput.school_management.domain.Student;

/* StudentFactory.Java
 *  Author: Tim Davids 219296219
 *  Entity for Student
 *  June Assignment
 *  Date: 09 June 2022
 * */
public class StudentFactory {

    public static Student build(String StudentID, String Studentemail, String name) {
        StringHelper.checkStringParam("", StudentID);
        StringHelper.checkStringParam("", Studentemail);
        StringHelper.checkStringParam("", name);
        return new Student.builder()
                .StudentID(StudentID)
                .Studentemail(Studentemail)
                .Name(name)
                .build();
    }



}
