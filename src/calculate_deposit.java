import java.util.Scanner;

public class DepositCalculator{

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return rnd(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return rnd(amount + amount * yearRate * depositPeriod, 2);
    }

    double rnd(double value, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe)/ ScaLe;
    }

    void doImportantJob() {
        int period;
        int action;
        int amount;

        Scanner scaner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        amount = scaner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scaner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scaner.nextInt();
        double out = 0;

        if (action == 1){
            out = calculateSimplePercent(amount, 0.06, period);
        }
        else if (action == 2) {
            out = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

    public static void main(String[] args) {
        new DepositCalculator().doImportantJob();
    }


}
