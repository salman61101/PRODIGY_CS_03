/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.task3;
import java.util.Scanner;
import java.util.regex.Pattern;
/**
 *
 * @author salma
 */
public class PasswordStrengthChecker {
       public static String checkPasswordStrength(String password) {

        int minLength = 8;
        Pattern uppercase = Pattern.compile("[A-Z]");
        Pattern lowercase = Pattern.compile("[a-z]");
        Pattern digits = Pattern.compile("[0-9]");
        Pattern specialCharacters = Pattern.compile("[^a-zA-Z0-9]");


        StringBuilder feedback = new StringBuilder();


        if (password.length() < minLength) {
            feedback.append("Password should be at least ").append(minLength).append(" characters long.\n");
        }
        
        if (!uppercase.matcher(password).find()) {
            feedback.append("Password should contain at least one uppercase letter.\n");
        }

        if (!lowercase.matcher(password).find()) {
            feedback.append("Password should contain at least one lowercase letter.\n");
        }

        if (!digits.matcher(password).find()) {
            feedback.append("Password should contain at least one digit.\n");
        }

        if (!specialCharacters.matcher(password).find()) {
            feedback.append("Password should contain at least one special character.\n");
        }


        String strength;
        if (feedback.length() == 0) {
            strength = "Strong";
        } else if (feedback.toString().split("\n").length == 1) {
            strength = "Moderate";
        } else {
            strength = "Weak";
        }

        return "Password Strength: " + strength + "\n" + feedback.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print("Enter a password to check its strength (or type 'exit' to quit): ");
            String password = scanner.nextLine();


            if (password.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program.");
                break;
            }


            String result = checkPasswordStrength(password);


            System.out.println(result);
        }

        scanner.close();
    }
    
}
