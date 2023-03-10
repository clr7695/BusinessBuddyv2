package com.example.businessbuddyv2;
import android.content.Context;

import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;

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


    public CardRecord(String filepath) {
        File f = new File(filepath);

        if (!(f.exists() && !f.isDirectory())) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e + ": " + filepath);
            }
        }
        this.cardFile = filepath;
        cards = new ArrayList<BusinessCard>();
        updateList();
    }

    public void addCard(BusinessCard card) {
        if(!cards.contains(card)){
            cards.add(card);
            updateFile();
        }
    }

    public void updateList() {
        JSONParser parser = new JSONParser();
        try {
            File f = new File(this.cardFile, "cards0.json");
            JSONArray cardList = (JSONArray) parser.parse(new FileReader(f));
            for (Object o : cardList) {
                JSONObject card = (JSONObject) o;
                BusinessCard cardDone = readCard(card);
                cards.add(cardDone);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateFile() {
        JSONArray cardArray = new JSONArray();
        try {
            FileWriter cardWriter = new FileWriter(this.cardFile + "/cards0.json");
            for (int i = 0; i < cards.size(); i++) {
                JSONObject cardJSON = makeJSON(cards.get(i));
                cardArray.add(cardJSON);
            }
            cardWriter.write(cardArray.toJSONString());
            cardWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public JSONObject makeJSON(BusinessCard card) {
        JSONObject cardJSON = new JSONObject();
        try {
            cardJSON.put("firstName", card.firstName);
            cardJSON.put("lastName", card.lastName);
            cardJSON.put("email", card.email);
            cardJSON.put("company", card.company);
            cardJSON.put("bio", card.bio);
            cardJSON.put("myCard", card.myCard);
            cardJSON.put("partial", card.partial);
            JSONArray pronouns = new JSONArray();
            for (int j = 0; j < card.pronouns.length; j++) {
                pronouns.add(card.pronouns[j]);
            }
            cardJSON.put("pronouns", pronouns);
            JSONArray skills = new JSONArray();
            for (int j = 0; j < card.skills.length; j++) {
                skills.add(card.skills[j]);
            }
            cardJSON.put("skills", skills);

            JSONObject educationJSON = new JSONObject(card.education);
            cardJSON.put("education", educationJSON);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cardJSON;
    }

    public ArrayList<BusinessCard> getMyCards() {
        ArrayList<BusinessCard> myCards = new ArrayList<BusinessCard>();
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i) != null) {
                if(cards.get(i).myCard) {
                    myCards.add(cards.get(i));
                }
            }
        }
        return myCards;
    }

    public BusinessCard newCardPartial(String firstName, String lastName, String[] pronouns, String email,
                                       String company, boolean myCard) {
        BusinessCard card = new BusinessCard(firstName, lastName, pronouns, email, company, myCard);
        addCard(card);
        return card;
    }

    public BusinessCard newCard(String firstName, String lastName, String[] pronouns, String email,
                                String company, HashMap<String, String> education, String[] skills, String bio, boolean myCard) {
        BusinessCard card = new BusinessCard(firstName, lastName, pronouns, email, company, education, skills, bio, myCard);
        addCard(card);
        return card;
    }

    public BusinessCard newCardPartial2(String[] skills, String bio) {
        BusinessCard tempCard = getPartial1();
        BusinessCard card = new BusinessCard(tempCard.firstName, tempCard.lastName, tempCard.pronouns, tempCard.email, tempCard.company, skills, bio, tempCard.myCard);
        addCard(card);
        return card;
    }

    public BusinessCard finishCard(HashMap<String, String> education) {
        BusinessCard tempCard = getPartial2();
        BusinessCard card = new BusinessCard(tempCard.firstName, tempCard.lastName, tempCard.pronouns, tempCard.email, tempCard.company, education, tempCard.skills, tempCard.bio, tempCard.myCard);
        addCard(card);
        return card;
    }

    private BusinessCard readCard(JSONObject card) {
        BusinessCard cardDone = null;
        try {
            JSONParser parser = new JSONParser();
            long partial = (long) card.get("partial");
            String firstName = (String) card.get("firstName");
            String lastName = (String) card.get("lastName");
            String email = (String) card.get("email");
            String company = (String) card.get("company");
            String bio = (String) card.get("bio");
            Boolean myCard = (Boolean) card.get("myCard");
            JSONArray pronounsArray = (JSONArray) card.get("pronouns");
            Iterator<String> iterator_p = pronounsArray.iterator();
            String[] pronouns = new String[4];
            int n = 0;
            while (iterator_p.hasNext()) {
                pronouns[n] = iterator_p.next();
                n += 1;
            }
            JSONArray skillsArray = (JSONArray) card.get("skills");
            Iterator<String> iterator_s = skillsArray.iterator();
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
            } catch (Exception e) {
                e.printStackTrace();
            }
            cardDone = new BusinessCard(firstName, lastName, pronouns, email, company,
                    education, skills, bio, myCard, partial);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cardDone;
    }

    public void scanQR(String cardJSON) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject card = (JSONObject) parser.parse(cardJSON);
            addCard(readCard(card));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BusinessCard getPartial1(){
        updateList();
        for(int i = 0; i < cards.size(); i++){
            if(cards.get(i).partial == 1){
                BusinessCard card = cards.get(i);
                cards.remove(i);
                return card;
            }
        }
        return null;
    }

    public BusinessCard getPartial2(){
        updateList();
        for(int i = 0; i < cards.size(); i++){
            if(cards.get(i).partial == 2){
                BusinessCard card = cards.get(i);
                cards.remove(i);
                return card;
            }
        }
        return null;
    }

    public String getString(){
        return this.cards.toString();
    }

}

