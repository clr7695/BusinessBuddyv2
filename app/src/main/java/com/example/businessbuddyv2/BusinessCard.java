package com.example.businessbuddyv2;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;

public class BusinessCard {
    String lastName;
    String firstName;
    String[] pronouns = new String[4];
    String email;
    String company;
    String[] skills = new String[5];

    public BusinessCard(String firstName, String lastName, String email, String company,
                        String[] pronouns, String[] skills) throws JSONException, IOException {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.company = company;
        this.pronouns = pronouns;
        this.skills = skills;
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
