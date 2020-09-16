package com.example.bmi_calculator.data;

import com.example.bmi_calculator.utils.Constants;

import java.io.Serializable;

public class BmiModel implements Serializable {
    private Constants.Gender gender;
    private int height;
    private int weight;
    private int age;
    private int bmi;

    public BmiModel(Constants.Gender gender, int height, int weight, int age) {
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.age = age;

    }



    public Constants.Gender getGender() {
        return gender;
    }

    public void setGender(Constants.Gender gender) {
        this.gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }
    public int getBmi(){return this.bmi;}

    public void setAge(int age) {
        this.age = age;
    }
    public void setBmi(int bmi)
    {
        this.bmi=bmi;
    }

}
