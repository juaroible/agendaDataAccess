package com.juanmi_roig;

public class Contact implements Comparable<Contact> {
    
    private String name;
    private String lastName;
    private String phoneNumber;


    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Contact(String name, String lastName, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {

        if (this.lastName == null) {
            return "Name = " + name + ", Last Name = " + "- " + ", Number = " + phoneNumber;
        } else {
            return "Name = " + name + ", Last Name = " + lastName + ", Number = " + phoneNumber;   
        }
    }

    @Override
    public int compareTo(Contact o) {
        return this.name.compareTo(o.name);
    }

}
