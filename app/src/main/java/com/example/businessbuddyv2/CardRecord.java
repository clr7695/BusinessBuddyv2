package com.example.businessbuddyv2;

import java.io.FileReader;
import java.util.ArrayList;

public class CardRecord {
    ArrayList<BusinessCard> cards;

    public CardRecord(){
        cards  = new ArrayList<BusinessCard>();
    }

    public void addCard(BusinessCard card){
        cards.add(card);
    }

}
