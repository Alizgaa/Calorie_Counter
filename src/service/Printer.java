package service;

public class Printer {
    public static void print(String message) {
        System.out.println(message);
    }

    public static void showMenu() {
        print("Введите команду:\n" +
                "1 - Ввести количество шагов за определённый день \n" +
                "2 - Напечатать статистику за определённый месяц \n" +
                "3 - Изменить цель по количеству шагов в день \n" +
                "4 - Выйти из приложения");
    }

    public static void putLine() {
        print("-------------------------");
    }

    public static void exit() {
        print("Программа завершена");
        putLine();
    }

    public static void sayErrorCommand() {
        print("Такой команды нет");
        putLine();
    }

    public static void sayNegativeValue() {
        print("Вы ввели отрицательное число, \n" + "пожалуйста повторите ввод");
    }

    public static void sayErrorValue() {
        print("Вы ввели некорректное значение, \n" + "пожалуйста повторите ввод");
    }

    public static void saveData() {
        print("Данные сохранены");
        putLine();
    }

    public static void showStatistics(int sumOfSteps, int maxNumberOfSteps, int dayOfMaxNumberOfSteps,
                                      int dayInMonth, double lengthOfSteps, double caloriesPerStep,
                                      int goalNumbersOfSteps, int maxSet, int daySet) {
        putLine();
        print("Общее количество шагов за месяц: " + sumOfSteps);
        print("Максимальное пройденное количество шагов в месяце: " + maxNumberOfSteps +
                " (" + dayOfMaxNumberOfSteps + "-го числа");
        print("Среднее количество шагов в месяц: " + sumOfSteps / dayInMonth);
        print("Пройденная дистанция (в км): " + sumOfSteps * lengthOfSteps);
        print("Количество сожженных калорий: " + sumOfSteps * caloriesPerStep);
        print("Лучшая серия: максимальное количество подряд идущих дней,\n" +
                "в течение которых количество шагов за день было равно или выше целевого" +
                " (" + goalNumbersOfSteps + "): " + maxSet-- + " (начиная с " + (daySet - maxSet) + "-го числа)");
        putLine();
    }
}
