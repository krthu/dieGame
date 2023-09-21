public class Main {
    public static void main(String[] args) {
        Die die1 = new Die(6);
        for (int i =0; i <= 10; i++) {
            die1.roll();
            System.out.println(die1);
        }



    }
}