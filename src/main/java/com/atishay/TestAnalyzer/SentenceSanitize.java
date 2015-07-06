package com.atishay.TestAnalyzer;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by ATISHAY on 30-06-2015.
 */
public class SentenceSanitize {

    public void removeBlackListedWords (List<String> blacklistWords, String Sentence) {
        String word = "";
        String newSentence = "";
        StringTokenizer str = new StringTokenizer(Sentence);
        while (str.hasMoreElements()) {
            word = str.nextToken();  // movie
            for (String badWord: blacklistWords) {
                if (badWord.equals(word)){
                    Sentence = Sentence.replace(word,"");
                } break;
                }
        }
        System.out.println(Sentence);
    }

    public static void main(String args[]){
        SentenceSanitize sentenceSanitize = new SentenceSanitize();
        List<String> abuseWords = new ArrayList<String>();
        abuseWords.add("porn");
        abuseWords.add("abuse");
        sentenceSanitize.removeBlackListedWords(abuseWords,"This is abuse porn status");
    }
}
