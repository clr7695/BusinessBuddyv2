package com.example.businessbuddyv2;

import java.io.File;
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

    CardRecord cardRecord;

    public BusinessCard(String firstName, String lastName, String[] pronouns, String email, String company,
                        HashMap<String, String> education, String[] skills, String bio, Boolean myCard, String filepath){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.company = company;
        this.pronouns = pronouns;
        this.skills = skills;
        this.education = education;
        this.bio = bio;
        this.myCard = myCard;

        this.cardRecord = new CardRecord(filepath);
        this.cardRecord.addCard(this);
    }

    public BusinessCard(String firstName, String lastName, String[] pronouns, String email, String company, boolean myCard, String filepath) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.company = company;
        this.pronouns = pronouns;
        this.skills = new String[5];
        this.education = new HashMap<String, String>();
        this.bio = "";
        this.myCard = myCard;

        this.cardRecord = new CardRecord(filepath);
        this.cardRecord.addCard(this);
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

    public void setSkills(String skillOne, String skillTwo, String skillThree, String skillFour, String skillFive) {
        this.skills[0] = skillOne;
        this.skills[1] = skillTwo;
        this.skills[2] = skillThree;
        this.skills[3] = skillFour;
        this.skills[4] = skillFive;
    }

    public void setEducation(HashMap<String,String> education) {
        this.education = education;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
