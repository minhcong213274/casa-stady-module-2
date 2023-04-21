package view;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    private ArrayList<Student> students;
    private Scanner scanner;
    private Student currentStudent;

    public static void main(String[] args) {
        StudentManagement management = new StudentManagement();
        management.showMainMenu();
    }

    public StudentManagement() {
        students = new ArrayList<>();
        students.add(new Student("111", "John", "Doe"));
        students.add(new Student("222", "Jane", "Doe"));
        scanner = new Scanner(System.in);
        currentStudent = null;
    }

    private void showMainMenu() {
        boolean running = true;

        while (running) {
            System.out.println("---- Student Management System ----");
            System.out.println("Please choose an option:");
            System.out.println("1. Login");
            System.out.println("2. View student list");
            System.out.println("3. Add student");
            System.out.println("4. Delete student");
            System.out.println("5. Logout");
            System.out.println("-----------------------------------");
            System.out.print("Option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    login();
                    break;
                case "2":
                    viewStudentList();
                    break;
                case "3":
                    addStudent();
                    break;
                case "4":
                    deleteStudent();
                    break;
                case "5":
                    currentStudent = null;
                    System.out.println("Logged out.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

            System.out.println();
        }
    }

    private void login() {
        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (currentStudent == null && username.equals("admin") && password.equals("password")) {
            currentStudent = new Student("admin", "", "");
            System.out.println("Logged in.");
        } else {
            System.out.println("Invalid username or password.");

        }

    }private void viewStudentList() {
        if (currentStudent == null) {
            System.out.println("Please log in first.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    private void addStudent() {
        if (currentStudent == null) {
            System.out.println("Please log in first.");
            return;
        }

        System.out.print("ID: ");
        String id = scanner.nextLine();

        System.out.print("First name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last name: ");
        String lastName = scanner.nextLine();

        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.out.println("Student ID already exists.");
                return;
            }
        }

        students.add(new Student(id, firstName, lastName));
        System.out.println("Student added.");
    }

    private void deleteStudent() {
        if (currentStudent == null) {
            System.out.println("Please log in first.");
            return;
        }

        System.out.print("ID: ");
        String id = scanner.nextLine();

        for (Student student : students) {
            if (student.getId().equals(id)) {
                students.remove(student);
                System.out.println("Student deleted.");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    private static class Student {
        private String id;
        private String firstName;
        private String lastName;

        public Student(String id, String firstName, String lastName) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getId() {
            return id;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        @Override
        public String toString() {
            return firstName + " " + lastName + " (" + id + ")";
        }
    }}


