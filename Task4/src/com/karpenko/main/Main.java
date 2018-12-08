package com.karpenko.main;

import com.karpenko.cui.CUI;
import com.karpenko.entity.MyCharacter;
import com.karpenko.entity.MyString;
import com.karpenko.entity.MyWord;

public class Main {
    public static void main(String[] args) {
        MyCharacter ch1 = new MyCharacter('a');
        MyCharacter ch2 = new MyCharacter('b');
        MyCharacter ch3 = new MyCharacter('c');

        MyWord word1 = new MyWord(new MyCharacter[] {ch1, ch2});
        MyWord word2 = new MyWord(new MyCharacter[] {ch2, ch3});
        MyWord word3 = new MyWord(new MyCharacter[] {ch1, ch3});
        MyWord word4 = new MyWord(new MyCharacter[] {ch1, ch2, ch3});

        MyString string = new MyString(new MyWord[] {word1, word2, word3, word4});
        CUI.showMyString(string);
    }
}
