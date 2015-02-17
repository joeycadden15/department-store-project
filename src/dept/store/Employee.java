/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dept.store;

/**
 *
 * @author N00121144
 */
public class Employee {

    private String name;
    private String address;
    private double mobile;
    private String email;
    private String dob;
    private double salary;

    public Employee(String en, String ea, double num, String e, String dob, double s) {
        this.name = en;
        this.address = ea;
        this.mobile = num;
        this.email = e;
        this.dob = dob;
        this.salary = s;

    }

    public String getName() {
        return name;
    }

    public void setName(String en) {
        this.name = en;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String ea) {
        this.address = ea;
    }

    public double getMobile() {
        return mobile;
    }

    public void setMobile(double num) {
       this.mobile = num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String e) {
        this.email = e;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double s) {
        this.salary = s;
    }

}
