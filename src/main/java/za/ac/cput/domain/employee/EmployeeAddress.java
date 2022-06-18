package za.ac.cput.domain.employee;
/* EmployeeAddress.java
   Author: Yasmeen Nel
   Student Number : 219250553
   Date: June 2022
*/

import za.ac.cput.domain.address.Address;

public class EmployeeAddress {
    //Entity Attributes
    private  String staffId;
    private  Address address;


    protected EmployeeAddress() { }

    public EmployeeAddress(EmployeeAddressBuilder builder){
        this.staffId = EmployeeAddressBuilder.staffId;
        this.address = EmployeeAddressBuilder.address;
    }

    //Getters
    public String getStaffId() {
        return staffId;
    }

    public Address getAddress() {
        return address;
    }

    //toString
    @Override
    public String toString() {
        return "EmployeeAddress{" +
                "staffId='" + staffId + '\'' +
                ", address=" + address +
                '}';
    }

    //Builder class for EmployeeAddress
    public static class EmployeeAddressBuilder{
        // Attributes
        public static String staffId;
        public static Address address;

        public EmployeeAddressBuilder createStaffId(String staffId){
            this.staffId = staffId;
            return this;
        }

        public EmployeeAddressBuilder createAddress(Address address){
            this.address = address;
            return this;
        }

        public EmployeeAddress build(){
            //validation
            if(this.staffId.equals(null)){throw new IllegalArgumentException("Staff ID is null.");}
            if(address.equals(null)){throw new IllegalArgumentException("Address object is null.");}
            return new EmployeeAddress(this);
        }
    }
}
