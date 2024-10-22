package com.juanmi_roig;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import com.thoughtworks.xstream.XStream;;

public class Agenda {

    private ArrayList<Contact> contacts = new ArrayList<Contact>();
    XStream streamx = new XStream();
    File contactsFile = new File("contacts.xml");

    /**
     * Creates a new contact "c" and adds it to the TreeSet "contacts"
     * 
     * @return "New contact -> " + c.toString()
     */
    public String addContact() { // * Add a new contact

        @SuppressWarnings("resource")
        Scanner inputString = new Scanner(System.in);

        String msg = "New contact -> ";

        Contact c;

        String name = "";
        String lastName = "";
        boolean hasLastName;
        String phoneNumber;
        int number;

        do { // Add name to the contact, it's required
            System.out.print("Name: ");
            name = inputString.nextLine();
            if (name.length() == 0) {
                System.out.println("Name is a required field.");
            }
        } while (name.length() == 0);

        System.out.print("Last name: "); // Add lastName to the contact, it's not required
        lastName = inputString.nextLine();
        if (lastName.length() == 0) {
            hasLastName = false;
        } else {
            hasLastName = true;
        }

        do { // Add number to the contact, it's required
            System.out.print("Number: ");
            phoneNumber = inputString.nextLine();
            number = Integer.parseInt(phoneNumber);
            if (number <= 0) {
                System.out.println("Unvalid number.");
            }
        } while (number <= 0);

        if (hasLastName) {
            c = new Contact(name, lastName, phoneNumber);
        } else {
            c = new Contact(name, phoneNumber);
        }

        if (contacts.size() == 0) {
            contacts.add(c);
            msg += c.toString();
        } else {
            for (Contact contact : contacts) {
                if (contact.getPhoneNumber().equals(c.getPhoneNumber())) {
                    msg += "This number is already registered";
                } else {
                    contacts.add(c);
                    msg += c.toString();
                    break;
                }
            }
        }

        return msg;

    }

    /**
     * Shows a list of all contacts, it takes the info from the "contacts" TreeSet
     * 
     * @return a String with the list of all contacts
     */
    public String showContacts() {

        String msg = "";

        for (Contact contact : contacts) {
            msg += contact.toString() + "\n";
        }

        return msg;

    }

    /**
     * Saves all contacts on a XML file
     * 
     * @return if it has been saved or not
     */
    public String saveAndExit() {
        streamx.allowTypes(new Class[] {Contact.class}); //Allows XStream to work with Contact class.
        try {
            FileOutputStream fos = new FileOutputStream(contactsFile); //Opens a FOS for writting
            streamx.toXML(contacts, fos); //Transforms the ArrayList contacts into a XML file using FOS
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "Failed to save.";
        }
        return "Saved.";
    }

    /**
     * Charges the XML file into the ArrayList contacts
     */
    @SuppressWarnings("unchecked")
    public void read() {
        streamx.allowTypes(new Class[]{Contact.class}); 
        if (contactsFile.exists()) {
            try {
                contacts = (ArrayList<Contact>)streamx.fromXML(contactsFile); //Transforms the XML file into an ArrayList<Contact> Object and casts it into the ArrayList contacts
            } catch (Exception e) {
                e.printStackTrace();
                contacts = new ArrayList<>(); //Creates a new ArrayList for avoiding future problems
            }
        } else {
            contacts = new ArrayList<>();
        }
    }

}
