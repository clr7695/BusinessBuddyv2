package com.example.businessbuddyv2;

import java.util.Arrays;

public class Pronoun {
    String[] pronouns;
    //0 - she/her
    //1 - he/him
    //2 - they/them
    //3 - custom
    public Pronoun(int pronoun){
        int n = 0;
        while(this.pronouns[n] != null){
            n += 1;
        }
        if(pronoun == 0){
            this.pronouns[n] = "She/Her";
        } else if (pronoun == 1) {
            this.pronouns[n] = "He/Him";
        } else if (pronoun == 2) {
            this.pronouns[n] = "They/Them";
        }
    }
    public Pronoun(int pronoun, String custom){
        int n = 0;
        while(this.pronouns[n] != null){
            n += 1;
        }
        if(pronoun == 3){
            this.pronouns[n] = custom;
        }
    }

    public String getPronouns(){
        return Arrays.toString(pronouns);
    }
}
