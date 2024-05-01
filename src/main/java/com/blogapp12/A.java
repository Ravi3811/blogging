package com.blogapp12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class A {
    public static void main(String[] args) {
  /*
     String str="I live in India";
        long count1 = str.chars().filter(ch -> ch == ' ').count();
        //System.out.println(count1);
        Map<Character, Long> collect = str.toLowerCase().chars().filter(ch -> !isVowel(ch)&&ch!=' ').mapToObj(c -> (char) c).collect(Collectors.groupingBy(chh -> chh, Collectors.counting()));
        collect.forEach((c,s)-> System.out.println(c+":"+s));
        // long count = str.toLowerCase().chars().filter(ch -> !isVowel(ch)).count();
        //System.out.println(count-count1);
/*
        String str= "I live in india";
        Map<Character, Long> collect = str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        collect.forEach((character, count) -> {
            System.out.println(character+" "+count);
        });
        List<Integer> arr = Arrays.asList(2, 4, 5, 6, 3, 8);
        // List<Integer> collect = arr.stream().filter(c -> c % 2 != 0).collect(Collectors.toList());
        Integer i = arr.stream().min((a, b) -> Integer.compare(a,b)).get();
        System.out.println(i);
        // collect.stream().sorted().forEach(c-> System.out.println(c));
        Map<Integer,Character> ans=new HashMap<>();
        ans.put(1,'A');
        ans.put(2,'B');
        ans.forEach((i,c)-> System.out.println(i+":"+c));

       String str="I live in india";
        long count = str.chars().mapToObj(c -> (char) c).filter(ch -> "aeiouAEIOU".indexOf(ch)!=-1).count();
     System.out.println(count);


    }
    public static Boolean isVowel(int c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
            return true;
        }
        else
            return false;
        */

    }

}
