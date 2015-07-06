package com.atishay.TestAnalyzer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ATISHAY on 02-07-2015.
 */
public class replaceWord {
    public void removeAbusiveWords (String Sentence, List<String> abuseWords) {

        // Get words of the Sentence

        String[] SentenceUnitWords = Sentence.split(" ");
        List<String> SentenceWordsList = new ArrayList<>(Arrays.asList(SentenceUnitWords));

        for (int i=0; i<SentenceWordsList.size();i++) {

            for (int j = 0;j<abuseWords.size();j++) {
                // compare words
                if (abuseWords.get(j).equals(SentenceWordsList.get(i))) {
                    SentenceWordsList.remove(i);
                    i--;
                    break;
                }
            }
        }

        for (int x=0 ; x<SentenceWordsList.size(); x++) {
            System.out.print(SentenceWordsList.get(x).toString() + " ");
        }
    }

    public static void main (String args[]) {
        replaceWord replaceWord = new replaceWord();
        List<String>  abuseWords = new ArrayList<>();
        abuseWords.add("porn");
        abuseWords.add("fucking");
        replaceWord.removeAbusiveWords("This is fucking porn movie" , abuseWords);
    }
}
