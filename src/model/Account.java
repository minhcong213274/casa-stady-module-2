package model;

public  class Account {
    private String id;
    private String password;
    private String accessLevel="Member";
    private String name;
    private int age;
    private String address;
    private String numberPhone;
    private int tuition = 0;
    private boolean java;
    private boolean c;
    private boolean tester;
    private int countLogin = 0;

    public int getCountLogin() {
        return countLogin;
    }

    public void setCountLogin(int countLogin) {
        this.countLogin = countLogin;
    }

    public boolean isJava() {
        return java;
    }

    public void setJava(boolean java) {
        this.java = java;
    }

    public boolean isC() {
        return c;
    }

    public void setC(boolean c) {
        this.c = c;
    }

    public boolean isTester() {
        return tester;
    }

    public void setTester(boolean tester) {
        this.tester = tester;
    }

    public int getTuition() {
        return tuition;
    }

    public void setTuition(int tuition) {
        this.tuition += tuition;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getName() {
        return name;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Account(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public Account() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
