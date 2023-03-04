package com.example.businessbuddyv2;

import java.util.Arrays;
import java.util.HashMap;

public class BusinessCard {
    String lastName;
    String firstName;
    String[] pronouns = new String[4];
    String email;
    String company;
    String[] skills = new String[5];

    //Education formatted in <"level", "location">
    HashMap<String, String> education = new HashMap<String, String>();

    String bio;

    public BusinessCard(String firstName, String lastName, String[] pronouns, String email, String company,
                        HashMap<String, String> education, String[] skills, String bio){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.company = company;
        this.pronouns = pronouns;
        this.skills = skills;
        this.education = education;
        this.bio = bio;
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
}
