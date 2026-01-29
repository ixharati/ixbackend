/*
Problem-3
Build a validation framework that:
Validates username, age, and email
Throws custom exceptions for invalid data
Differentiates checked vs unchecked exceptions
Logs validation completion
Must Use
✔ Checked exceptions
✔ Unchecked exceptions
✔ try-catch-finally
✔ throw vs throws
✔ Custom exception classes
 */

import java.io.*;
import java.util.*;

class invalidUsernameException extends Exception {
    public invalidUsernameException(String msg) {
        super(msg);
    }
}

class invalidAgeException extends RuntimeException {
    public invalidAgeException(String msg) {
        super(msg);
    }
}

class invalidEmailException extends RuntimeException {
    public invalidEmailException(String msg) {
        super(msg);
    }
}

public class problem_3 {
    static void validateUsername(String username)
            throws invalidUsernameException {
        if (username.isEmpty() || username.length() < 5)
            throw new invalidUsernameException("Invalid Username.");
    }

    static void validateAge(int age)
            throws invalidAgeException {
        if (age < 21)
            throw new invalidAgeException("Invalid Age.");
    }

    static void validateEmail(String email)
            throws invalidEmailException {
        if (!email.contains("@") || !email.contains("."))
            throw new invalidEmailException("Invalid Email Id.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Email: ");
        String email = sc.nextLine();
        try {
            validateUsername(username);
        } catch (invalidUsernameException e) {
            System.out.println(e.getMessage());
        }
        try {
            validateAge(age);
        } catch (invalidAgeException e) {
            System.out.println(e.getMessage());
        }

        try {
            validateEmail(email);
        } catch (invalidEmailException e) {
            System.out.println(e.getMessage());
        }

        finally {
            System.out.println("Validation Completed.");
        }

    }

}
