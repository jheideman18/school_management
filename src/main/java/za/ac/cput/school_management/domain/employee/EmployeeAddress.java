package za.ac.cput.school_management.domain.employee;

import za.ac.cput.school_management.domain.address.Address;

public class EmployeeAddress {
    //Entity Attributes
    private final String staffId;
    private final Address address;

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
