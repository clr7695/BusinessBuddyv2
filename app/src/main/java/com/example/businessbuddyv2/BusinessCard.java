package com.example.businessbuddyv2;


import java.util.Arrays;
import java.util.HashMap;

public class BusinessCard {
    String lastName;
    String firstName;
    String[] pronouns;
    String email;
    String company;
    String[] skills;

    //Education formatted in <"level", "location">
    HashMap<String, String> education = new HashMap<String, String>();

    String bio;

    Boolean myCard;

    public BusinessCard(String firstName, String lastName, String[] pronouns, String email, String company,
                        HashMap<String, String> education, String[] skills, String bio, Boolean myCard){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.company = company;
        this.pronouns = pronouns;
        this.skills = skills;
        this.education = education;
        this.bio = bio;
        this.myCard = myCard;
    }

    public BusinessCard(String firstName, String lastName, String[] pronouns, String email, String company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.company = company;
        this.pronouns = pronouns;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getEmail(){
        return this.email;
    }

    public String getCompany(){
        return this.company;
    }

    public String getPronouns(){
        return Arrays.toString(this.pronouns);
    }

    public String getSkills(){
        return Arrays.toString(this.skills);
    }

    public String getBio(){
        return bio;
    }

    public HashMap<String, String> getEducation(){
        return education;
    }

    public Boolean getMyCard(){
        return myCard;
    }

    public void isMyCard(){
        myCard = true;
    }

    public void isNotMyCard(){
        myCard = false;
    }
}
