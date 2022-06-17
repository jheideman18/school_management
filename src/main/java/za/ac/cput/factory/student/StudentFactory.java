package za.ac.cput.factory.student;

import za.ac.cput.util.Stringhelper;
import za.ac.cput.domain.student.Student;

/* StudentFactory.Java
 *  Author: Tim Davids 219296219
 *  Entity for Student
 *  June Assignment
 *  Date: 09 June 2022
 * */
public class StudentFactory {

    public static Student build(String StudentID, String Studentemail, String name) {
        Stringhelper.checkStringParam("", StudentID);
        Stringhelper.checkStringParam("", Studentemail);
        Stringhelper.checkStringParam("", name);
        return new Student.builder()
                .StudentID(StudentID)
                .Studentemail(Studentemail)
                .Name(name)
                .build();
    }



}
