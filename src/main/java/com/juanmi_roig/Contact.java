package com.juanmi_roig;

public class Contact {
    
    private String name;
    private String lastName;
    private int number;


    public Contact(String name, int number) { //If lastName is no definied by the user
        this.name = name;
        this.number = number;
    }

    public Contact(String name, String lastName, int number) { //If lastName is definied by the user
        this.name = name;
        this.lastName = lastName;
        this.number = number;
    }

}
