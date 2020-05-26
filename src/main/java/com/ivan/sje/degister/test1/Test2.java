package com.ivan.sje.degister.test1;

import org.apache.commons.digester.Digester;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class Test2 {
    public static void main(String[] args){
        String path = Test2.class.getResource("").getPath().toString()+"resource";
        File file = new File(path, "employee2.xml");
        Digester digester = new Digester();
        String employeeClassName=Employee.class.getName();
        String officeClassName=Office.class.getName();
        // add rules
        digester.addObjectCreate("employee",employeeClassName);
        digester.addSetProperties("employee");
        digester.addObjectCreate("employee/office",officeClassName);
        digester.addSetProperties("employee/office");
        digester.addSetNext("employee/office", "addOffice");
        digester.addObjectCreate("employee/office/address",
                Address.class.getName());
        digester.addSetProperties("employee/office/address");
        digester.addSetNext("employee/office/address", "setAddress");
        try {
            Employee employee = (Employee) digester.parse(file);
            ArrayList offices = employee.getOffices();
            Iterator iterator = offices.iterator();
            System.out.println(
                    "-------------------------------------------------");
            while (iterator.hasNext()) {
                Office office = (Office) iterator.next();
                Address address = office.getAddress();
                System.out.println(office.getDescription());
                System.out.println("Address : " +
                        address.getStreetNumber() + " " + address.getStreetName());
                System.out.println(" -------------------------------");
            } }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
