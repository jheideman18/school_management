/* Name.java
 * Entity for Name
 * Author: Smangele Witness Mabaso (220047154)
 * Date: 14 June 2022
 */
package za.ac.cput.domain.name;

public class Name {

        private String firstName;
        private String middleName;
        private String lastName;


        private Name(Builder builder) {
            this.firstName = builder.firstName;
            this.middleName = builder.middleName;
            this.lastName = builder.lastName;

        }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastname='" + lastName + '\'' +
                '}';
    }

        public static class Builder {

            private String firstName;
            private String middleName;
            private String lastName;

            public Builder firstName(String firstName) {
                this.firstName = firstName;
                return this;
            }

            public Builder middleName(String middleName) {
                this.middleName = middleName;
                return this;
            }

            public Builder lastName(String lastName) {
                this.lastName = lastName;
                return this;
            }

            public Builder copy(Name name){
                this.firstName = name.firstName;
                this.middleName = name.middleName;
                this.lastName = name.lastName;

                return this;
            }

            public Name build() {
                return new Name(this);
            }
        }


}
