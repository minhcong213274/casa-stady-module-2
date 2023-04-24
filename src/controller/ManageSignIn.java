package controller;

import model.Account;
import storage.ReadFile;
import storage.WriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageSignIn {
    private ReadFile<Account> readFile = ReadFile.getReadFile();
    private WriteFile<Account> writeFile = WriteFile.getWriteFile();
    private List<Account> signInList;
    private List<Account> lockUpAccount;
    Scanner scanner = new Scanner(System.in);

    public List<Account> getSignInList() {
        return signInList;
    }

    public void setSignInList(List<Account> signInList) {
        this.signInList = signInList;
    }

    private ManageSignIn() {
        lockUpAccount = new ArrayList<>();
        signInList = new ArrayList<>();
        signInList.add(new Account("ADMIN","ADMIN"));
        signInList.get(0).setAccessLevel("");
        signInList=readFile.readFile();
    }
    private static ManageSignIn manageSignIn = null;
    public static ManageSignIn getManageSignIn(){
        if (manageSignIn == null) manageSignIn = new ManageSignIn();
        return manageSignIn;
    }
    public void forgetPassword(){
        System.out.println("Enter your id name:");
        String id = scanner.nextLine();
        for (Account account : signInList) {
            if (account.getId().equals(id)){
                System.out.println("Enter your number phone: ");
                String numberPhone = scanner.nextLine();
                if (account.getNumberPhone().equals(numberPhone)){
                    System.out.println("Your password: ");
                    System.out.println(account.getPassword());
                    writeFile.writeFile(signInList);
                    return;
                }
            }
        }
        System.out.println("Not found id. ");
    }
    public void signUp() {
        Account signUp = new Account();
        boolean isValidUsername = false;
        while (!isValidUsername) {
            System.out.println("Enter user name:");
            signUp.setId(scanner.nextLine());
            for (Account account : signInList) {
                if (signUp.getId().equals(account.getId())) {
                    System.out.println("Please enter again:");
                    isValidUsername = false;
                    break;
                }else {
                    isValidUsername = true;
                }
            }
        }
        System.out.println("Enter password");
        signUp.setPassword(scanner.nextLine());
        signInList.add(signUp);
        writeFile.writeFile(signInList);
    }
    public void login() {
        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();
        int index;
        for (Account account : signInList) {
            if (account.getId().equals(username) && !account.getPassword().equals(password)){
                account.setCountLogin(account.getCountLogin()+1);
                writeFile.writeFile(signInList);
            }
            if (account.getId().equals(username) && account.getCountLogin()>2 && !account.getId().equals("ADMIN")){
                System.out.println("The locked account need contact the admin for help.");
                return;
            }
            if (account.getId().equals(username) && account.getPassword().equals(password) && account.getCountLogin()<4 && account.getAccessLevel().equals("member")){
                account.setCountLogin(0);
                writeFile.writeFile(signInList);
                if(account.getName()==null){
                    System.out.println("Enter your name:");
                    account.setName(scanner.nextLine());
                    System.out.println("Enter your address:");
                    account.setAddress(scanner.nextLine());
                    System.out.println("Enter your age:");
                    account.setAge(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Enter your number phone: ");
                    account.setNumberPhone(scanner.nextLine());
                    writeFile.writeFile(signInList);
                }
                index = signInList.indexOf(account);
                boolean running = true;
                while (running) {
                    System.out.println("---- Member Management System ----");
                    System.out.println("Please choose an option:");
                    System.out.println("1. Pay the tuition.");
                    System.out.println("2. Sign up course.");
                    System.out.println("3. Change password.");
                    System.out.println("4.Exit. ");
                    System.out.println("-----------------------------------");
                    System.out.print("Option: ");

                    String choice = scanner.nextLine();

                    switch (choice) {
                        case "1":
                            payMoney(index);
                            break;
                        case "2":
                            signUpCourse(index);
                            break;
                        case "3":
                            changePassword(index);
                            break;
                        case "4":
                            return;
                        default:
                            System.out.println("Invalid option. Please try again.");
                            break;
                    }

                    System.out.println();
                }
            }
            if (account.getId().equals(username) && account.getPassword().equals(password) && account.getCountLogin()<4 && account.getAccessLevel().equals("mod")){
                account.setCountLogin(0);
                writeFile.writeFile(signInList);
                if(account.getName()==null){
                    System.out.println("Enter your name:");
                    account.setName(scanner.nextLine());
                    System.out.println("Enter your address:");
                    account.setAddress(scanner.nextLine());
                    System.out.println("Enter your age:");
                    account.setAge(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Enter your number phone: ");
                    account.setNumberPhone(scanner.nextLine());
                    writeFile.writeFile(signInList);
                }
                index = signInList.indexOf(account);
                boolean running = true;
                while (running) {
                    System.out.println("---- Member Management System ----");
                    System.out.println("Please choose an option:");
                    System.out.println("1. Display information.");
                    System.out.println("2. Sign up course.");
                    System.out.println("3. Change password.");
                    System.out.println("4.Delete account member. ");
                    System.out.println("5.Exit. ");
                    System.out.println("-----------------------------------");
                    System.out.print("Option: ");

                    String choice = scanner.nextLine();

                    switch (choice) {
                        case "1":
                            displayInformation();
                            break;
                        case "2":
                            signUpCourse(index);
                            break;
                        case "3":
                            changePassword(index);
                            break;
                        case "4":
                            deleteAccountMember(index);
                            break;
                        case "5":
                            return;
                        default:
                            System.out.println("Invalid option. Please try again.");
                            break;
                    }
                    System.out.println();
                }
            }
            if (username.equals("ADMIN") && password.equals("ADMIN")){
                boolean running = true;
                while (running) {
                    System.out.println("---- Member Management System ----");
                    System.out.println("Please choose an option:");
                    System.out.println("1. Display total tuition.");
                    System.out.println("2. Change level.");
                    System.out.println("3. Unlock account.");
                    System.out.println("4.Delete account member. ");
                    System.out.println("5.Exit. ");
                    System.out.println("-----------------------------------");
                    System.out.print("Option: ");

                    String choice = scanner.nextLine();

                    switch (choice) {
                        case "1":
                            System.out.println("Total tuition is: "+account.getTuition());
                            break;
                        case "2":
                            changeLevel();
                            break;
                        case "3":
                            unlockAccount();
                            break;
                        case "4":
                            deleteAccountMember(0);
                            break;
                        case "5":
                            return;
                        default:
                            System.out.println("Invalid option. Please try again.");
                            break;
                    }

                    System.out.println();
                }
            }if (account.getId().equals(username) && account.getCountLogin()==2 && !account.getId().equals("ADMIN")){
                System.out.println("Entering the wrong again will be locked account.");
            }
        }
        System.out.println("This account is Invalid. ");
        }
        public void unlockAccount(){
            System.out.println("The ID is locked: ");
            for (Account account : lockUpAccount) {
                System.out.println(account.getId());
            }
            System.out.println("Enter id need unlock: ");
            String id = scanner.nextLine();
            for (Account account : signInList) {
                if (account.getId().equals(id)){
                    account.setCountLogin(0);
                    writeFile.writeFile(signInList);
                }
            }
        }
        public void changeLevel(){
            System.out.println("Enter id:");
            String id = scanner.nextLine();
            for (Account account : signInList) {
                if(!account.getId().equals("ADMIN")){
                    System.out.println("Enter level account: ");
                    String accessLevel = scanner.nextLine();
                    account.setAccessLevel(accessLevel);
                    System.out.println("Change success.");
                    writeFile.writeFile(signInList);
                    return;
                }
            }
            System.out.println("Not found id");
        }
        public void payMoney(int index){
            System.out.println("Tuition is: " + signInList.get(index).getTuition());
            if (signInList.get(index).getTuition()>0){
                System.out.println("Enter your money: ");
                int money = scanner.nextInt();
                scanner.nextLine();
                signInList.get(index).setTuition(signInList.get(index).getTuition()-money);
                signInList.get(0).setTuition(signInList.get(0).getTuition()+money);
                writeFile.writeFile(signInList);
            }
        }
        public void supportAccount(){
            System.out.println("Enter name id: ");
            String id = scanner.nextLine();
            for (Account account : signInList) {
                if (account.getId().equals(id)){
                    lockUpAccount.add(account);
                    System.out.println("Please wait for admin to unlock: ");
                    writeFile.writeFile(signInList);
                }
            }
        }
        public void deleteAccountMember(int index){
        if (signInList.get(index).getAccessLevel().equals("mod")){
            System.out.println("Enter id you want delete:");
            String id = scanner.nextLine();
            for (Account account : signInList) {
                if (account.getId().equals(id) && account.getAccessLevel().equals("member")){
                    signInList.remove(account);
                    writeFile.writeFile(signInList);
                    return;
                }
            }
            System.out.println("Not found id:");
        }if (signInList.get(index).getAccessLevel().equals("")){
                System.out.println("Enter id you want delete:");
                String id = scanner.nextLine();
                for (Account account : signInList) {
                    if (account.getId().equals(id) && !account.getId().equals("ADMIN")){
                        signInList.remove(account);
                        writeFile.writeFile(signInList);
                        return;
                    }
                }
                System.out.println("Not found id:");
            }
        }
        public void displayInformation(){
            for (Account account : signInList) {
                if (account.getAccessLevel().equals("member")){
                    System.out.println("Name" + account.getName()+" Tuition "+account.getTuition());
                    return;
                }
            }
            System.out.println("No members");
        }
        public void changePassword(int index){
            System.out.println("Enter new password ");
        signInList.get(index).setPassword(scanner.nextLine());
            writeFile.writeFile(signInList);
        }
    public void signUpCourse(int index){
        boolean running = true;
        while (running) {
            System.out.println("Please choose an option:");
            System.out.println("1. Java cost 300$.");
            System.out.println("2. C++ cost 250$.");
            System.out.println("3. Tester cost 500$.");
            System.out.println("4. Exit");
            System.out.println("-----------------------------------");
            System.out.print("Option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    signUpJava(index);
                    break;
                case "2":
                    signUpC(index);
                    break;
                case "3":
                    signUpTester(index);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

            System.out.println();
        }
    }
    public void signUpJava(int index){
        if (!signInList.get(index).isJava()){
            signInList.get(index).setJava(true);
            signInList.get(index).setTuition(signInList.get(index).getTuition()+300);
            System.out.println("Sign Up Success");
            writeFile.writeFile(signInList);
        }else {
            System.out.println("Registration failed");
        }
    }
    public void signUpC(int index){
        if (!signInList.get(index).isC()){
            signInList.get(index).setC(true);
            signInList.get(index).setTuition(signInList.get(index).getTuition()+250);
            System.out.println("Sign Up Success");
            writeFile.writeFile(signInList);
        }else {
            System.out.println("Registration failed");
        }

    }
    public void signUpTester(int index){
        if (!signInList.get(index).isTester()){
            signInList.get(index).setTester(true);
            signInList.get(index).setTuition(signInList.get(index).getTuition()+500);
            System.out.println("Sign Up Success");
            writeFile.writeFile(signInList);
        }else {
            System.out.println("Registration failed");
        }
    }
}
