package com.shaangroups.practice.codingtests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//flixbus test
public class FlixBus {
	
	static int tillWhen(char[] charArray, int index, char temp) {
		if(index < charArray.length) {
            if (charArray[index] == temp)
                return tillWhen(charArray, index + 1, temp) + 1;
            else
                return 0;
        }
        else
            return 0;
	}
	
	static String compressedString(String message) {
		char[] charArray = message.toCharArray();
		StringBuilder sb = new StringBuilder(String.valueOf(charArray[0]));
		char temp = charArray[0];
		for (int i = 1; i <= message.length() - 1; i++) {			
			if (charArray[i] == temp) {
				int t1 = tillWhen(charArray, i, temp);
				sb.append(String.valueOf(t1+1));
				i = i + t1 - 1;
			} else {
				temp = charArray[i];
				sb.append(String.valueOf(temp));
			}			
		}
		
		return sb.toString();

    }
	
    // Complete the electionWinner function below.
    static String electionWinner(String[] votes) {
    	
        Map<String, Integer> map = new HashMap<>();
        
        for (String vote : votes) {
            if (map.containsKey(vote)) {
                int temp = map.get(vote);
                temp++;
                map.put(vote, temp);
            } else {
                map.put(vote, new Integer("1"));
            }
        }
        
        int max = 0;
        for(String key : map.keySet()) {
        	if (max < map.get(key)) {
        		max = map.get(key);
        	}
        }
        
        List<String> keyList = new ArrayList<>();
        for (String key : map.keySet()) {
        	if (map.get(key) == max) {
        		keyList.add(key);
        	}
        }
        
        Collections.sort(keyList);
        
        System.out.println(keyList.get(keyList.size() - 1));
        
        return "HEllo";

    }
    
    // Complete the electionWinner function below.
    static String electionWinner1(String[] votes) {
    	
        Map<String, Integer> map = new HashMap<>();
        
        for (String vote : votes) {
            if (map.containsKey(vote)) {
                int temp = map.get(vote);
                temp++;
                map.put(vote, temp);
            } else {
                map.put(vote, new Integer("1"));
            }
        }
        
        int max = map.values().stream().max(Comparator.naturalOrder()).get();
        System.out.println(max);
        List<String> winner = map.entrySet().stream().filter(m -> m.getValue() == max).map(Map.Entry::getKey).collect(Collectors.toList());
        winner.forEach(m -> {
        	System.out.println(m);
        });
        return "HEllo";

    }
    
    public static void main(String[] args) {
    	String[] val = {"Alex", "Michael", "Harry", "Dave", "Michael", "Victor", "Harry", "Alex", "Mary", "Mary"};
    	electionWinner1(val);
    	//System.out.println(compressedString("alaasass"));
    }

}
