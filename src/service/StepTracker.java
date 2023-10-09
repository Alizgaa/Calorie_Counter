package service;

import model.MonthData;

import static service.Printer.*;

import java.util.HashMap;

public class StepTracker {
    private int goalNumbersOfSteps = 1000;
    private static int dayInMonth = 30;
    private static HashMap<String, MonthData> monthToData = new HashMap<>();
    private static final String[] months = {"Январь", "Февраль", "Март", " Апрель", "Май",
            "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};

    public StepTracker() {
        for (String month : months) {
            monthToData.put(month, new MonthData());
        }
    }

    public int getGoalNumbersOfSteps() {
        return goalNumbersOfSteps;
    }

    public void setGoalNumbersOfSteps(int goal) {
        if (goal < 0) {
            sayNegativeValue();
        } else {
            this.goalNumbersOfSteps = goal;
            saveData();
        }
    }

    public static int getDayInMonth() {
        return dayInMonth;
    }

    public static void setDayInMonth(int day) {
        if (day < 28 || day > 31) {
            print("В месяце не может быть " + day + " дней.");
        } else {
            dayInMonth = day;
        }
    }

    public static HashMap<String , MonthData> getMonthToData() {
        return monthToData;
    }
    public String[] getMonths(){
        return months;
    }
    public void saveSteps(String month, int day, int steps){
        monthToData.get(month).dataToStep.put(day, steps);
        saveData();
    }
    public void getStatistics(String month){
        int maxNumbersOfSteps = 0;
        int sumOfSteps = 0;
        int dayOfMaxNumberOfSteps = 0;
        int countSet = 0;
        int maxSet = 0;
        int countDay =0;
        int daySet = 0;

        Converter converter = new Converter(0.75, 50);

        putLine();
        for(Integer day: monthToData.get(month).dataToStep.keySet()){
            System.out.println(day + " день: " + monthToData.get(month).dataToStep.get(day) + ", ");
            if (monthToData.get(month).dataToStep.get(day) > maxNumbersOfSteps){
                maxNumbersOfSteps = monthToData.get(month).dataToStep.get(day);
                dayOfMaxNumberOfSteps = day;
            }
        }
        print("");

        for (Integer steps: monthToData.get(month).dataToStep.values()){
            countDay ++;
            if (steps >= goalNumbersOfSteps){
                countSet ++;
                if (maxSet < countSet){
                    maxSet = countSet;
                    daySet = countDay;
                }
            }else {
                countSet = 0;
            }
        }
        showStatistics(sumOfSteps, maxNumbersOfSteps,dayOfMaxNumberOfSteps,
                dayInMonth, converter.lengthSteps, converter.caloriesPerStep,
                goalNumbersOfSteps, maxSet, daySet);

    }
}




























