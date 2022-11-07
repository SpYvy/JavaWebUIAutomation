package ru.gb.homework4;

public class NotAnPositiveNumberException extends Exception{
    //comment
    public NotAnPositiveNumberException(){
        System.out.println("Одна из сторон имеет отрицательное значение или равна нулю.");
    }
}
