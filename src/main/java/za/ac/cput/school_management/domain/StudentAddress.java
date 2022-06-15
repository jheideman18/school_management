package za.ac.cput.school_management.domain;

import java.util.Objects;

/*
Entity for StudentAddress
Chulumanco Buhle Nkwindana
219390983
11 June 2022 */
public class StudentAddress {
    private String studentID, address;

    private StudentAddress(){}

    public StudentAddress(Builder builder) {
        this.studentID = builder.studentID;
        this.address = builder.address;

    }

    public String getStudentID() {
        return studentID;
    }

    public String getAddress() {
        return address;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentAddress that = (StudentAddress) o;
        return studentID.equals(that.studentID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID);
    }

    @Override
    public String toString() {
        return "Student Address{" +
                "studentID='" + studentID + '\'' +
                ", address'" + address + '\'' +
                '}';
    }

    public static class Builder{
        private String studentID, address;

        public Builder studentID(String studentID) {
            this.studentID = studentID;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }



        public Builder copy(StudentAddress studentAddress) {
            this.studentID = studentAddress.studentID;
            this.address = studentAddress.address;
            return this;
        }

        public StudentAddress build() {
            return new StudentAddress(this);
        }
}
}
