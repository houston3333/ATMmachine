public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM(30, 20, 10);

        atm.add(220);
        System.out.println();
        atm.withdraw(300);
        System.out.println();
        atm.add(2573);
        System.out.println();
        atm.withdraw(2743);
    }
}
