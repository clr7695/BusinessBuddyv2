package com.example.businessbuddyv2;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class CardRecord {
    ArrayList<BusinessCard> cards;

    public CardRecord(){
        cards  = new ArrayList<BusinessCard>();
        updateList();
    }

    public void addCard(BusinessCard card){
        cards.add(card);
    }

    public void updateList(){
        JSONParser parser = new JSONParser();
        try {
            JSONArray cardList = (JSONArray) parser.parse(new FileReader("cards.json"));
            for(Object o : cardList){

                JSONObject card = (JSONObject)o;
                String firstName = (String) card.get("firstName");
                String lastName = (String) card.get("lastName");
                String email = (String) card.get("email");
                String company = (String) card.get("company");
                String bio = (String) card.get("bio");
                Boolean myCard = (Boolean) card.get("myCard");
                JSONArray pronounsJSON = (JSONArray) card.get("pronouns");
                Iterator<String> iterator_p = pronounsJSON.iterator();
                String[] pronouns = new String[4];
                int n = 0;
                while (iterator_p.hasNext()) {
                    pronouns[n] = iterator_p.next();
                    n += 1;
                }
                JSONArray skillsJSON = (JSONArray) card.get("skills");
                Iterator<String> iterator_s = skillsJSON.iterator();
                String[] skills = new String[5];
                n = 0;
                while (iterator_s.hasNext()) {
                    skills[n] = iterator_s.next();
                    n += 1;
                }
                //TODO implement way to get education info from JSON
                HashMap<String, String> education = new HashMap<String, String>();

                BusinessCard cardDone = new BusinessCard(firstName, lastName, pronouns, email, company,
                    education, skills, bio, myCard);
                cards.add(cardDone);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void updateFile(){
        try {
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
            }
        }catch(Exception e) {
            e.printStackTrace();
        }

    }
}
