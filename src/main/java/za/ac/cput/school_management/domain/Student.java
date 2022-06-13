package za.ac.cput.school_management.domain;
import java.util.Objects;
/* Student.Java
 *  Author: Tim Davids 219296219
 *  Entity for Student
 *  June Assignment
 *  Date: 09 June 2022
 * */
public class Student {
    private final String StudentID, Studentemail, name;
    private Student(builder builder) {
        this.StudentID = builder.StudentID;
        this.Studentemail = builder.Studentemail;
        this.name = builder.name;
    }
    public String getStudentID() {
        return StudentID;
    }
    public String getStudentemail() {
        return Studentemail;
    }
    public String getName() {
        return name;
    }

    public static class builder
    {
        private String StudentID, Studentemail, name;

        public builder StudentID(String StudentID) {
            this.StudentID = StudentID;
            return this;
        }

        public builder Studentemail(String studentemail) {
            this.Studentemail = studentemail;
            return this;
        }

        public builder Name(String name) {
            this.name = name;
            return this;
        }

        public builder Copy(Student Student){

            this.StudentID = Student.StudentID;
            this.Studentemail = Student.Studentemail;
            this.name = Student.name;

            return this;
        }

        public Student build() {return new Student(this);}
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return StudentID.equals(student.StudentID);
    }
    @Override
    public int hashCode() {return Objects.hash(StudentID, Studentemail, name);}
    @Override
    public String toString() {
        return "Student{" +
                "StudentID='" + StudentID + '\'' +
                ", Student email='" + Studentemail + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
