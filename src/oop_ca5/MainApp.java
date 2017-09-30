/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_ca5;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author lizhengxing
 */
public class MainApp {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException,NoSuchElementException {
        LocalStore l = new LocalStore();
        Scanner sc = new Scanner(System.in);

        int option = 0;
        while (option != 7) {
            option = displayMenu();
            if (option < 0 || option > 7) {
                System.out.print("Check your input!");
            } else if (option == 1) {
                System.out.println("Person name:");
                String name = sc.next();
                ArrayList<Person> p = l.searchPerson(name);
                for (Person pp : p) {
                    System.out.println(pp.toString());
                }
                printStars();

            } else if (option == 2) {
                l.listAll();
                printStars();

            } else if (option == 3) {
                l.listByID();
                printStars();

            } else if (option == 4) {
                l.listByRating();
                printStars();

            } else if (option == 5) {
                System.out.println("Person name:");
                String name = sc.next();
                l.editPerson(name);
                l.saveLocalRecords();
                printStars();

            } else if (option == 6) {
                System.out.print("\nEnter the path: ");
                String path = sc.nextLine();
                System.out.print("\nEnter the file name: ");
                String fn = sc.nextLine();
                l.exportToHtml(path, fn);
                System.out.println("Exported!");
                printStars();

            } else if (option == 7) {
                
                l.saveLocalRecords();
                System.out.print("\nGoodbye!\n");
                printStars();

            }
        }
    }

    public static int displayMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n1. Search for Persons");
        System.out.println("2. List All Persons");
        System.out.println("3. List Persons sorted by Person ID");
        System.out.println("4. List Persons by Rating");
        System.out.println("5. Edit Person");
        System.out.println("6. Export search results to HTML file");
        System.out.println("7. Save and Exit");
        System.out.print("\nOption: ");
        int option = sc.nextInt();

        return option;
    }

    public static void printStars() {
        System.out.print("\n****************************************\n");
    }

}
