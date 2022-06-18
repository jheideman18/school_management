package za.ac.cput.domain.student;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.name.Name;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.Objects;
/* Student.Java
 *  Author: Tim Davids 219296219
 *  Entity for Student
 *  June Assignment
 *  Date: 09 June 2022
 * */
@Entity
public class Student {
    @NotNull
    @Id
    private String StudentID;
    @NotNull
    private String Studentemail;
    @OneToOne
    @JoinColumn(name = "name_first_name")
    private Name name;

    public void setName(Name name) {
        this.name = name;
    }


    protected Student(){ }

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

    public Name getName() {
        return name;
    }

    public static class builder
    {
        private String StudentID, Studentemail;
        private Name name;

        public builder StudentID(String StudentID) {
            this.StudentID = StudentID;
            return this;
        }

        public builder Studentemail(String studentemail) {
            this.Studentemail = studentemail;
            return this;
        }

        public builder Name(Name name) {
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
    public String toString() {
        return "Student{" +
                "StudentID='" + StudentID + '\'' +
                ", Student email='" + Studentemail + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
