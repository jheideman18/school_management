package za.ac.cput.school_management.repository;

//import za.ac.cput.school_management.domain.EmployeeAddress;

import java.util.HashSet;
import java.util.Set;

/* EmployeeAddressRepository.Java
 *  Entity for EmployeeAddressRepository
 *  Author: Yasmeen Nel (219250553)
 *  Date: 13 June 2022
 * */
/*
public class EmployeeAddressRepository implements IEmployeeAddressRepository{
    private static EmployeeAddressRepository repository = null;
    private Set<EmployeeAddress> staffDB = null;

    private EmployeeAddressRepository(){
        staffDB = new HashSet<EmployeeAddress>();
    }

    public static EmployeeAddressRepository getRepository(){
        if(repository == null){
            repository= new EmployeeAddressRepository();
        }
        return repository;
    }

    @Override
    public EmployeeAddress read(String staffId) {
        for (EmployeeAddress staff : staffDB)
            if (staff.getStaffId().equals(staffId))
                return staff;
        return null;
    }

    @Override
    public EmployeeAddress update(EmployeeAddress employeeAddress) {
        EmployeeAddress oldEmployeeAddress = read(employeeAddress.getStaffId());
        if(oldEmployeeAddress != null){
            staffDB.remove(oldEmployeeAddress);
            staffDB.add(employeeAddress);
            return employeeAddress;
        }
        return null;
    }

    @Override
    public void delete(String staffId) {
        EmployeeAddress deleteEmployeeAddress = read(staffId);
        if (deleteEmployeeAddress== null) {
            System.out.println("Employee Address is null.");
        }
        staffDB.remove(deleteEmployeeAddress);
        System.out.println("Employee Address has been  removed.");

    }

    @Override
    public Set<EmployeeAddress> getAll() {
        return staffDB;
    }
}
*/

