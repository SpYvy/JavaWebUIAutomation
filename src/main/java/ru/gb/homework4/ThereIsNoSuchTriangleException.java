package ru.gb.homework4;

public class ThereIsNoSuchTriangleException extends Exception{
    //comment
    public ThereIsNoSuchTriangleException(){
        System.out.println("Cумма длин каждых двух сторон должна быть больше длины третьей стороны.");
    }
}
