package com.company;

public class Testings {

    public static void main(String[] args){
        System.out.println(solution("abccac"));
    }

    public static int solution (String S){
        Integer countOfStr = 0;

        StringBuilder sb = new StringBuilder();

        char c = S.charAt(0);
        Integer k = 1;

        while (c != S.charAt(k)){
            sb.append(S.charAt(k));
            k++;
        }

        System.out.println(sb.toString());

        return countOfStr;
    }
}
