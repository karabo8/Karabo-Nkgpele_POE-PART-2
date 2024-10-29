/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrationandlogin;
//Importing a Java Scanner that allow users to input their details.
import java.util.Scanner;

/**
 *
 * @author nkgap
 */
public class Login {
    public static void main(String[] args) {
        
        //Creating objects for the scanners to allow the user to enter the option and to store their answer.
        Registrationandlogin user = new Registrationandlogin();
        Scanner sc = new Scanner(System.in);

        user.register();

System.out.println("========================================================================");
        
        //A Boolean expression to check whether the user wants to login into the system or not.
        System.out.println("Would you like to login? (yes/no)");
        String choice = sc.nextLine();
        
        //Using an IF statement to processes the option entered by the user.
        if (choice.equalsIgnoreCase("yes")) {
            user.login();
        } else {
            System.out.println("Exiting the program.");
        }
    }

}
