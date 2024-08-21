public class ATM {
    private int count100;
    private int count50;
    private int count20;
    private final int[] denominations = {100, 50, 20};

    public ATM(int count100, int count50, int count20) {
        this.count100 = count100;
        this.count50 = count50;
        this.count20 = count20;
    }

    public boolean add(int amount) {
        int[] addCounts = new int[3];

        for (int i = 0; i < denominations.length; i++) {
            addCounts[i] = amount / denominations[i];
            amount -= addCounts[i] * denominations[i];
        }

        if (amount == 0) {
            count100 += addCounts[0];
            count50 += addCounts[1];
            count20 += addCounts[2];

            System.out.println("Внесено купюр номиналом 100: " + addCounts[0]);
            System.out.println("Внесено купюр номиналом 50: " + addCounts[1]);
            System.out.println("Внесено купюр номиналом 20: " + addCounts[2]);

            System.out.println("Оставшееся количество купюр номиналом 100: " + count100);
            System.out.println("Оставшееся количество купюр номиналом 50: " + count50);
            System.out.println("Оставшееся количество купюр номиналом 20: " + count20);
            return true;
        } else {
            System.out.println("Невозможно внести указанную сумму");
            return false;
        }
    }

    public boolean withdraw(int amount) {
        int[] counts = {count100, count50, count20};
        int[] withdrawnCounts = new int[3];

        for (int i = 0; i < denominations.length; i++) {
            if (amount / denominations[i] < counts[i]) {
                withdrawnCounts[i] = amount / denominations[i];
            } else {
                withdrawnCounts[i] = counts[i];
            }
            amount -= withdrawnCounts[i] * denominations[i];
        }

        if (amount == 0) {
            count100 -= withdrawnCounts[0];
            count50 -= withdrawnCounts[1];
            count20 -= withdrawnCounts[2];

            System.out.println("Выдано купюр номиналом 100: " + withdrawnCounts[0]);
            System.out.println("Выдано купюр номиналом 50: " + withdrawnCounts[1]);
            System.out.println("Выдано купюр номиналом 20: " + withdrawnCounts[2]);

            System.out.println("Оставшееся количество купюр номиналом 100: " + count100);
            System.out.println("Оставшееся количество купюр номиналом 50: " + count50);
            System.out.println("Оставшееся количество купюр номиналом 20: " + count20);

            return true;
        } else {
            System.out.println("Невозможно выдать указанную сумму");
            return false;
        }
    }
}
