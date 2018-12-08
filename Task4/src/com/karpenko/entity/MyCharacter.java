package com.karpenko.entity;

public class MyCharacter {
    private char character;

    public MyCharacter(char character) {
        this.character = character;
    }

    public char getСharacter() {
        return character;
    }

    public void setСharacter(char myChar) {
        this.character = myChar;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        MyCharacter myCharacter = (MyCharacter) obj;
        return character == myCharacter.character;
    }

    @Override
    public int hashCode() {
        return Character.hashCode(character);
    }

    @Override
    public String toString() {
        return Character.toString(character);
    }
}
