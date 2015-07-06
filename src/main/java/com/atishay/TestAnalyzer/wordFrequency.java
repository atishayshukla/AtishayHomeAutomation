package com.atishay.TestAnalyzer;

import java.util.*;

/**
 * Created by ATISHAY on 06-07-2015.
 */
public class wordFrequency {
    public void getWordsFrequency (String Sentence) {
        String s[] = Sentence.split(" ");
        int count = 0;
        List<String> sentenceWords = new ArrayList<>(Arrays.asList(s));
        // Using Map to store word as key and number as value

        Map<String , Integer> map = new HashMap<>();
        for (String w: sentenceWords) {
            Integer n = map.get(w);
            n = (n == null) ? 1 : ++n;
            map.put (w,n);
        }

        // Read the values from the Map

        Set set = map.entrySet();

        Iterator itr = set.iterator();

        while (itr.hasNext()) {

            Map.Entry me = (Map.Entry)itr.next();
            System.out.print(me.getKey()+ ": ");
            System.out.print(me.getValue());
            System.out.println();
        }
    }

    public static void main (String args[]) {
        wordFrequency wf = new wordFrequency();
        wf.getWordsFrequency("This is the long story and this is pretty wide this");
    }
}
