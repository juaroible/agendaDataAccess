package com.juanmi_roig;

import java.util.Scanner;
import java.util.TreeSet;

public class Agenda {
    
    private TreeSet<Contact> contacts = new TreeSet<Contact>();

    public String addContact() { //Add a new contact

        Scanner input = new Scanner(System.in);
        
        String msg = "New contact -> ";

        Contact c;

        String name = "";
        String lastName = "";
        boolean hasLastName;
        int number = -1;

        do { //Add name to the contact, it's required
            System.out.print("Name: " );
            name = input.nextLine();
            if (name.length() == 0) {
                System.out.println("Name is a required field.");
            }
        } while (name.length() == 0);
        msg += "Name: " + name + " // ";

        System.out.print("Last name: "); //Add lastName to the contact, it's not required
        lastName = input.nextLine();
        if (lastName.length() == 0) {
            msg += "Last name: ----- // ";
            hasLastName = false;
        } else {
            msg += "Last name: " + lastName + " // ";
            hasLastName = true;
        }

        do { //Add number to the contact, it's required
            System.out.print("Number: ");
            number = input.nextInt();
            if (number <= 0) {
                System.out.println("Unvalid name.");
            }
        } while (number <= 0);
        msg += "Number: " + number;

        input.close();

        if (hasLastName) {
            c = new Contact(name, number);
        } else {
            c = new Contact(name, lastName, number);
        }

        contacts.add(c);

        return msg;

    }

}
