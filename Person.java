package ru.gb;

import jakarta.persistence.*;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Имя")
    private String name;
    @Column(name = "Возраст")
    private int age;

    public Person() {
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String toString() {
        String personInfo = "";
        personInfo += "имя: " + name + System.lineSeparator()
                + "возраст: " + age + System.lineSeparator();
        return personInfo;
    }
}
