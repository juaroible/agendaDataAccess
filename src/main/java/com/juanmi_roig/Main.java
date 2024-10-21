package com.juanmi_roig;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String menu[] = { "1. Show all contacts", "2. Add new contact", "3. Save and exit" };
        Scanner inputInt = new Scanner(System.in);
        int option = -1;
        Agenda agenda = new Agenda();

        agenda.read();

        System.out.println("Welcome to Juanmi's agenda!\nSelect an option:");

        for (int i = 0; i < menu.length; i++) {
            System.out.println(menu[i]);
        }

        do {
            do {
                System.out.print("Option: ");
                option = inputInt.nextInt();
                if (option <= 0 || option > 3) {
                    System.out.println("Invalid option. Select a correct one: ");
                }
            } while (option <= 0 || option > 3);
    
            switch (option) {
                case 1: // * Show all contacts
                    System.out.println(agenda.showContacts());
                    break;
    
                case 2: // * Add new contact
                    System.out.println(agenda.addContact());
                    break;
    
                case 3: // * Save and exit
                    System.out.println(agenda.saveAndExit());
                    break;
    
                default:
                    break;
            }
        } while (option != 3);

        inputInt.close();

    }
}