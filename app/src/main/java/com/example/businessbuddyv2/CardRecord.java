package com.example.businessbuddyv2;
import android.content.Context;

import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class CardRecord {
    ArrayList<BusinessCard> cards;
    String cardFile;

    public CardRecord(String filepath){
        File f = new File(filepath);

        if(!(f.exists() && !f.isDirectory())) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e + ": " + filepath);
            }
        }
        this.cardFile = filepath;
        cards  = new ArrayList<BusinessCard>();
        updateList();
    }

    public void addCard(BusinessCard card){
        cards.add(card);
        updateFile();
    }

    public void updateList(){
        JSONParser parser = new JSONParser();
        try {
            File f = new File(this.cardFile, "cards.json");
            JSONArray cardList = (JSONArray) parser.parse(new FileReader(f));
            for(Object o : cardList){

                JSONObject card = (JSONObject)o;
                String firstName = (String) card.get("firstName");
                String lastName = (String) card.get("lastName");
                String email = (String) card.get("email");
                String company = (String) card.get("company");
                String bio = (String) card.get("bio");
                Boolean myCard = (Boolean) card.get("myCard");
                String pronounsArray = (String) card.get("pronouns");
                JSONArray pronounsJSON = new JSONArray();
                Object obj = parser.parse(pronounsArray);
                pronounsJSON = (JSONArray) obj;
                Iterator<String> iterator_p = pronounsJSON.iterator();
                String[] pronouns = new String[4];
                int n = 0;
                while (iterator_p.hasNext()) {
                    pronouns[n] = iterator_p.next();
                    n += 1;
                }
                String skillsArray = (String) card.get("skills");
                JSONArray skillsJSON = new JSONArray();
                Object obj1 = parser.parse(skillsArray);
                skillsJSON = (JSONArray) obj1;
                Iterator<String> iterator_s = skillsJSON.iterator();
                String[] skills = new String[5];
                n = 0;
                while (iterator_s.hasNext()) {
                    skills[n] = iterator_s.next();
                    n += 1;
                }
                HashMap<String, String> education = new HashMap<String, String>();
                JSONObject educationJSON = (JSONObject) card.get("education");
                try {
                    education.put("highSchool", (String) educationJSON.get("highSchool"));
                    education.put("associates", (String) educationJSON.get("associates"));
                    education.put("bachelors", (String) educationJSON.get("bachelors"));
                    education.put("masters", (String) educationJSON.get("masters"));
                    education.put("doctorate", (String) educationJSON.get("doctorate"));
                }catch(Exception e) {
                    e.printStackTrace();
                }
                BusinessCard cardDone = new BusinessCard(firstName, lastName, pronouns, email, company,
                    education, skills, bio, myCard);
                cards.add(cardDone);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void updateFile(){
        JSONArray cardArray = new JSONArray();
        try {
            FileWriter cardWriter = new FileWriter(this.cardFile + "/cards.json");
            for (int i = 0; i < cards.size(); i++) {

                org.json.JSONObject cardJSON = new org.json.JSONObject();
                cardJSON.put("firstName", cards.get(i).firstName);
                cardJSON.put("lastName", cards.get(i).lastName);
                cardJSON.put("email", cards.get(i).email);
                cardJSON.put("company", cards.get(i).company);
                cardJSON.put("bio", cards.get(i).bio);
                cardJSON.put("myCard", cards.get(i).myCard);
                JSONArray pronouns = new JSONArray();
                for(int j = 0; j < cards.get(i).pronouns.length; j++){
                    pronouns.add(cards.get(i).pronouns[j]);
                }
                cardJSON.put("pronouns", pronouns);
                JSONArray skills = new JSONArray();
                for(int j = 0; j < cards.get(i).skills.length; j++){
                    skills.add(cards.get(i).skills[j]);
                }
                cardJSON.put("skills", skills);

                org.json.JSONObject educationJSON = new org.json.JSONObject(cards.get(i).education);
                cardJSON.put("education", educationJSON);

                cardArray.add(cardJSON);

            }
            cardWriter.write(cardArray.toJSONString());
            cardWriter.close();
        }catch(Exception e) {
            e.printStackTrace();
        }

    }

    public ArrayList<BusinessCard> getMyCards(){
        ArrayList<BusinessCard> myCards = new ArrayList<BusinessCard>();
        for(int i = 0; i < cards.size(); i++){
            if(cards.get(i).myCard){
                myCards.add(cards.get(i));
            }
        }
        return myCards;
    }

    public BusinessCard newCardPartial(String firstName, String lastName, String[] pronouns, String email,
                                      String company, boolean myCard){
        BusinessCard card = new BusinessCard(firstName, lastName, pronouns, email, company, myCard);
        addCard(card);
        return card;
    }

    public BusinessCard newCard(String firstName, String lastName, String[] pronouns, String email,
                                      String company, HashMap<String, String> education, String[] skills, String bio, boolean myCard){
        BusinessCard card = new BusinessCard(firstName, lastName, pronouns, email, company, education, skills, bio, myCard);
        addCard(card);
        return card;
    }
}
