package ru.gb.homework4;

public class TriangleArea {
    public static double triangleAreaCalculate(Integer a, Integer b, Integer c) throws NotAnPositiveNumberException, ThereIsNoSuchTriangleException {
        if (a <=0 || b <= 0 || c <= 0) {
            throw new NotAnPositiveNumberException();
        } else if (((a + b) <= c) || ((b + c) <= a) || ((c + a) <= b)){
            throw new ThereIsNoSuchTriangleException();
        } else {
            double halfPerimeter = (a + b + c) / 2.00;
            double result = Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
            return Math.round(result * 100) / 100.00;
        }
    }

    public static void main(String[] args) throws NotAnPositiveNumberException, ThereIsNoSuchTriangleException {
        TriangleArea triangleArea = new TriangleArea();
        System.out.println(triangleAreaCalculate(1, 3,2));
    }
}
