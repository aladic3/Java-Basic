package org.dmytrenko.lab3.model.People;

import org.apache.commons.beanutils.BeanUtils;

import java.time.LocalDate;

@SuppressWarnings("CopyConstructorMissesField")
public class Human {
    private Sex sex;
    private String firstName;
    private String lastName;
    private String fatherName;
    private LocalDate birthDate;
    private int age;

   public Human(Sex sex, String firstName, String lastName, String fatherName) {
        this.sex = sex;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
    }
    public Human(Human human){
       try {
           BeanUtils.copyProperties(this,human);
       } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // getters and setters
    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
