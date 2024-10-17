package com.juanmi_roig;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String menu[] = { "1. Show all contacts", "2. Add new contact", "3. Save and exit" };
        Scanner input = new Scanner(System.in);
        int option;

        System.out.println("Welcome to Juanmi's agenda!\nSelect an option:");

        do {
            for (int i = 0; i < menu.length; i++) {
                System.out.println(menu[i]);
            }
            option = input.nextInt();
            if (option <= 0 || option > 3) {
                System.out.println("Invalid option.");
            }
        } while (option <= 0 || option > 3);

        switch (option) {
            case 1: //Show all contacts

                break;

            case 2: //Add new contact

                break;

            case 3: //Save and exit

                break;

            default:
                break;
        }

        input.close();

    }
}