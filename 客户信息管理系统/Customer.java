package com.seven;

/**
 * ClassName:Customer
 * Package:com.seven
 * Description:
 *
 * @Author mzy
 * @Create 2024/11/8 15:58
 * @Version 1.0
 */
public class Customer {
    private String name;
    private char gender;
    private int age;
    private String phone;
    private String email;
    public Customer(){

    }

    public Customer(String name, char gender, int age, String phone, String email) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getDetails(){
        return "姓名："+name+"\t性别："+gender+"\t年龄："+age+"\t电话："+phone+"\t邮箱："+email;
    }
}
