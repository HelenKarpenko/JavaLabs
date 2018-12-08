package com.karpenko.entity;

public class MyWord {
    private MyCharacter[] word;

    public MyWord(MyCharacter[] characters) {
        word = characters;
    }

    public MyCharacter[] getWord() {
        return word;
    }

    public void setWord(MyCharacter[] word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        MyWord myWord = (MyWord) obj;
        if (word.length != myWord.word.length) return false;
        for (int i = 0; i < word.length; i++) {
            if (word[i].equals(myWord.word[i])) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 27;
        for (MyCharacter ch : word) {
            hash += 17 * ch.hashCode();
        }
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        for (MyCharacter ch : word) {
            strBuilder.append(ch);
        }
        return strBuilder.toString();
    }
}
