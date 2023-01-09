import java.util.Scanner;

public class DepositCalculator {
    /* название переменных рекомендуется называть в соответствии со смыслом предназначения переменных */
    double calculateComplexPercent(double a, double y, int d) {
        /* 12 - можно вынести в константу для лучшей читаемости кода,
         чтобы лучше понимать какую функцию она несет. */
        double pay = a * Math.pow((1 + y/ 12), 12 *d);
        return rnd(pay, 2);
    }

    /* нет смысла передавать значение - 2, так как это неизменная константа для формулы в методе rnd*/
    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return rnd(amount+amount * yearRate *depositPeriod, 2);
    }

    double rnd(double value, int places) {
        /* Во всех случаях scale не изменим и равен 100,
         ее можно вынести в константу для лучшей читаемости кода,
         чтобы лучше понимать какую функцию она несет. */
        double scaLe= Math.pow
                (10, places);
        return Math.round(value*scaLe)
                /scaLe;
    }

    void getDepositDetails() {
        /* Переменные желательного объявлять отдельно на каждой строчке, это повышает читабельность кода */
        int period, action ;
        /* после объявления переменных рекомендуется оставлять одну пустую строку */

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:") ;
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        period = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        /* название переменной не совсем отражает смысл, рекомендую переимменовать,
         для большей читаемости кода рекомендую перенести объявление переменной
         в начало метода к остальным переменным */
        double out = 0;

        if (action ==1) {
            /* процентную ставку можно вынести в константу для лучшей читаемости кода,
            чтобы лучше понимать какую функцию она несет,
             сейчас она как будто из воздуха,
             при этом, нет смысла передавать константу как параметр метода,
             ее можно перенести в класс DepositCalculator */
            out = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            /* здесь опечатка в названии метода, должен быть вызов
             calculateComplexPercent() */
            out= calculateSimplePercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

    public static void main(String[] args) {
        new DepositCalculator().getDepositDetails();
    }
}

