package model;

public class Student {
    private int id;
    private String name;
    private String rollNo;
    private String password;

    // ✅ No-argument constructor (Add this)
    public Student() {
    }

    // Constructor without ID (for registration)
    public Student(String name, String rollNo, String password) {
        this.name = name;
        this.rollNo = rollNo;
        this.password = password;
    }

    // Constructor with ID (for retrieving from DB)
    public Student(int id, String name, String rollNo, String password) {
        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
        this.password = password;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRollNo() {
        return rollNo;
    }
    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
