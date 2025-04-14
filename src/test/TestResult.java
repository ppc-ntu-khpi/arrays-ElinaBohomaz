package test;

import domain.Exercise;

/**
 * Клас для тестування задачі про щасливі трамвайні квитки.
 */
public class TestResult {
    public static void main(String[] args) {
        // Рахуємо загальну кількість щасливих квитків
        int luckyTicketsCount = Exercise.Calculate();
        System.out.println("Загальна кількість щасливих трамвайних квитків: " + luckyTicketsCount);

        // Рахуємо відсоток від загальної кількості квитків
        double percentage = (double) luckyTicketsCount / 1000000 * 100;
        System.out.printf("Відсоток щасливих квитків: %.2f%%\n\n", percentage);

        // Аналізуємо кількість щасливих квитків за першою цифрою
        System.out.println("Розподіл щасливих квитків за першою цифрою:");
        System.out.println("------------------------------------------");
        System.out.println("Цифра | Кількість | % від усіх щасливих");
        System.out.println("------------------------------------------");

        for (int digit = 0; digit < 10; digit++) {
            int countForDigit = Exercise.calculateWithFirstDigit(digit);
            double digitPercentage = (double) countForDigit / luckyTicketsCount * 100;

            System.out.printf("  %d    |   %5d   |      %.2f%%\n", 
                    digit, countForDigit, digitPercentage);
        }

        System.out.println("------------------------------------------");
    }
}