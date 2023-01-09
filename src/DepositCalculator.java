import java.util.Scanner;

public class DepositCalculator {
    public static final int depositPeriod = 12;
    public static final double yearRate = 0.06;
    public static final double scale= 100;

    /* название переменных рекомендуется называть в соответствии со смыслом предназначения переменных */
    double calculateComplexPercent(int amount) { // два метода, логично было бы назвать переменные одинаково
        /* 12 - можно вынести в константу для лучшей читаемости кода,
         чтобы лучше понимать какую функцию она несет. */

        double pay = amount * Math.pow((1 + yearRate/ depositPeriod), depositPeriod *yearRate);
        return round(pay);
    }

    /* нет смысла передавать значение - 2, так как это неизменная константа для формулы в методе rnd*/
    double calculateSimplePercent(int amount) {
        // два метода, логично было бы назвать переменные одинаково
        return round(amount+amount * yearRate *depositPeriod);
    }

    double round(double value) {
        /* Во всех случаях scale не изменим и равен 100,
         ее можно вынести в константу для лучшей читаемости кода,
         чтобы лучше понимать какую функцию она несет. */
         /* здесь ошибка!!!, на мой взгляд проще scale сделать константой равной 100,
         константы: https://javarush.com/groups/posts/1557-konstantih-i-internacionalizacija */
        return Math.round(value*scale) /scale;
    }

    void getDepositDetails() {
        /* Переменные желательного объявлять отдельно на каждой строчке, это повышает читабельность кода */
        int period;
        int depositType;
        /* после объявления переменных рекомендуется оставлять одну пустую строку */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:") ;
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        period = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();
        /* название переменной не совсем отражает смысл, рекомендую переимменовать,
         для большей читаемости кода рекомендую перенести объявление переменной
         в начало метода к остальным переменным */
        double result = 0; // название непонятное...

        if (depositType ==1) {
            /* процентную ставку можно вынести в константу для лучшей читаемости кода,
            чтобы лучше понимать какую функцию она несет,
             сейчас она как будто из воздуха,
             при этом, нет смысла передавать константу как параметр метода,
             ее можно перенести в класс DepositCalculator */
            result = calculateSimplePercent(amount);
        } else if (depositType == 2) {
            /* здесь опечатка в названии метода, должен быть вызов
             calculateComplexPercent() */
            result = calculateComplexPercent(amount);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + result);
    }
    public static void main(String[] args) {
        new DepositCalculator().getDepositDetails();
    }
}