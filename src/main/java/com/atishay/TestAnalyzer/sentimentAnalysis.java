package com.atishay.TestAnalyzer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ATISHAY on 06-07-2015.
 */
public class sentimentAnalysis {

    public void sentimentScore(String Sentence, List<String> positiveWords, List<String> negativeWords) {

        int postScore = 0;
        int negtScore = 0;

        String[] words = Sentence.split(" ");
        List<String> sentenceWordsList = new ArrayList<>(Arrays.asList(words));

        // Read the list of words in sentence

        for (int i = 0; i < sentenceWordsList.size(); i++) {
            for (int j = 0;  j < positiveWords.size();  j++) {
                if (positiveWords.get(j).equals(sentenceWordsList.get(i))) {
                    postScore++;
                    break;
                }
            }
        }
        System.out.println(postScore);

        for (int x=0; x < sentenceWordsList.size(); x++) {
            for ( int y = 0; y < negativeWords.size(); y++) {
                if (negativeWords.get(y).equals(sentenceWordsList.get(x))) {
                    negtScore++;
                    break;
                }
            }
        }
        System.out.println(negtScore);
    }

    

    public static void main (String[] args) {
        sentimentAnalysis sa = new sentimentAnalysis();
        List<String>  positiveWords = new ArrayList<>();
        positiveWords.add("Happy");
        positiveWords.add("cheer");
        List<String> negativeWords = new ArrayList<>();
        negativeWords.add("hate");
        sa.sentimentScore("I am Happy and cheer and I cry plus hate" ,positiveWords, negativeWords);
    }
}
