package com.ivan.sje.degister.test1;

import org.apache.commons.digester.Digester;

import java.io.File;

public class Test1 {

    public static void main(String[] args){
        String className=Employee.class.getName();
        String packageName=Test1.class.getPackage().getName();
//        String path = System.getProperty("user.dir") + File.separator +
//                "etc";
        String path=Test1.class.getResource("").getPath().toString()+"resource";
        File file = new File(path, "employee1.xml");
        Digester digester = new Digester();
        // add rules
        digester.addObjectCreate("employee",className);
        digester.addSetProperties("employee");
        digester.addCallMethod("employee", "printName");
        try {
            Employee employee = (Employee) digester.parse(file);
            System.out.println("First name : " + employee.getFirstName());
            System.out.println("Last name : " + employee.getLastName());
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
