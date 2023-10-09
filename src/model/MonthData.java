package model;

import service.StepTracker;

import java.util.HashMap;

public class MonthData {

    public HashMap<Integer, Integer> dataToStep = new HashMap<>();
    public MonthData(){
        for (int i = 0; i <= StepTracker.getDayInMonth(); i++) {
            dataToStep.put(i,0);

        }
    }
}
