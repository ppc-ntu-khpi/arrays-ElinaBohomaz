package domain;

/**
 * Клас для підрахунку щасливих трамвайних квитків.
 * Щасливий квиток - це квиток, у якого сума перших трьох цифр дорівнює сумі останніх трьох.
 */
public class Exercise {

    /**
     * Рахує кількість щасливих квитків серед всіх шестизначних номерів.
     * @return кількість щасливих квитків
     */
    public static int Calculate() {
        // Лічильник щасливих квитків
        int luckyTicketsCount = 0;

        // Перебираємо всі шестизначні номери
        for (int ticketNumber = 0; ticketNumber < 1000000; ticketNumber++) {
            // Розділяємо на перші та останні три цифри
            int firstHalf = ticketNumber / 1000;  // Перші три цифри
            int secondHalf = ticketNumber % 1000; // Останні три цифри

            // Рахуємо суми цифр
            int sumFirst = calculateDigitSum(firstHalf);
            int sumSecond = calculateDigitSum(secondHalf);

            // Перевіряємо чи квиток щасливий
            if (sumFirst == sumSecond) {
                luckyTicketsCount++;
            }
        }

        return luckyTicketsCount;
    }

    /**
     * Підраховує суму цифр числа.
     * @param number число для підрахунку
     * @return сума всіх цифр
     */
    private static int calculateDigitSum(int number) {
        int sum = 0;

        while (number > 0) {
            sum += number % 10;  // Додаємо останню цифру
            number /= 10;        // Видаляємо останню цифру
        }

        return sum;
    }

    /**
     * Підраховує кількість щасливих квитків з певною першою цифрою.
     * @param firstDigit перша цифра квитка (0-9)
     * @return кількість щасливих квитків з цією цифрою
     */
    public static int calculateWithFirstDigit(int firstDigit) {
        int count = 0;
        int start = firstDigit * 100000;
        int end = start + 99999;

        for (int ticket = start; ticket <= end; ticket++) {
            int firstHalf = ticket / 1000;
            int secondHalf = ticket % 1000;

            if (calculateDigitSum(firstHalf) == calculateDigitSum(secondHalf)) {
                count++;
            }
        }

        return count;
    }
}