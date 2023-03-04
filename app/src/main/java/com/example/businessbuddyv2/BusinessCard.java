package com.example.businessbuddyv2;
import com.example.businessbuddyv2.Pronoun;
public class BusinessCard {
    String lastName;
    String firstName;
    Pronoun pronouns;
    String email;
    String company;
    String[] skills;

    public BusinessCard(String firstName, String lastName, String email, String company,
                        Pronoun pronouns, String[] skills){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.company = company;
        this.pronouns = pronouns;
        this.skills = skills;
    }
}
