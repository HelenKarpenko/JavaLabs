package com.karpenko.entity;

public class MyString {

    private MyWord[] string;

    public MyString(MyWord[] words) {
        string = words;
    }

    public MyWord[] getString() {
        return string;
    }

    public void setString(MyWord[] string) {
        this.string = string;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        MyString myString = (MyString) obj;
        if (string.length != myString.string.length) return false;

        for (int i = 0; i < string.length; i++) {
            if (string[i].equals(myString.string[i])) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 27;
        for (MyWord word : string) {
            hash += 17 * word.hashCode();
        }
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        for (MyWord word : string) {
            strBuilder.append(word);
            strBuilder.append(" ");
        }
        return strBuilder.toString();
    }
}
