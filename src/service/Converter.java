package service;

public class Converter {
    double lengthSteps;
    double caloriesPerStep;

    public  Converter(double length, double calories) {
        lengthSteps = length / 1000;
        caloriesPerStep = calories / 1000;
    }
}
