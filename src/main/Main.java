package main;

import api.LCS;

public class Main {

    public static void main(String[] args) {
        String s1 = "acggcggatacg";
        String s2 = "ggcaccacg";
        System.out.printf("LCS ---> %d\n", LCS.calculate(s1, s2));
    }
}
