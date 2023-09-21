import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int numberOfRounds = 1;

        ArrayList<Player> players = initialize();

        for (int i = 0; i < numberOfRounds; i++){
            System.out.println();
            takeTurn(players);
        }

        ArrayList<Player> winners =  getWinners(players);

        StringBuilder builder = new StringBuilder();
        for (Player player: winners) {
            builder.append(player.getName());
            builder.append(", ");
        }

        String nameOfWinners = builder.toString();

        System.out.println((winners.size() > 1 ?  "The Winners are ": "The Winner is ") + nameOfWinners +
                "with " + winners.get(0).getScore() + " point " + (winners.get(0).getScore() == 1 ? "" : "s"));

    }

    public static ArrayList<Player> initialize(){
        ArrayList<Player> players = new ArrayList<>();

        System.out.println("How many players?");
        int numberOfPlayers = sc.nextInt();
        sc.nextLine();

        System.out.println("How many dice?");
        int numberOfDice = sc.nextInt();
        sc.nextLine();

        System.out.println("How many sides on the dice?");
        int numberOfSides = sc.nextInt();
        sc.nextLine();

        for(int i = 1; i <= numberOfPlayers; i++){
            System.out.println("Name for player " + i);
            String name = sc.nextLine();

            Player player = new Player(name);
            for (int j = 0; j < numberOfDice; j++){
                player.addDie(numberOfSides);
            }
            players.add(player);
        }

        return players;
    }

    public static void takeTurn(ArrayList<Player> players){
        for (Player player: players) {
            System.out.println(player.getName() + " which number will you roll?");
            int guess = sc.nextInt();
            sc.nextLine();

            player.rollDice();
            if (guess == player.getDieValue()){
                player.increaseScore();
                System.out.println( player.getName() + " rolled a " + player.getDieValue() + ". 1 point for you!");
            }
            else {
                System.out.println(player.getName() + " rolled a " + player.getDieValue());
            }
            System.out.println();
        }
    }

    public static ArrayList<Player> getWinners(ArrayList<Player> players){
        ArrayList<Player> winners = new ArrayList<>();
        for(Player player: players){
            if(winners.isEmpty() || player.getScore() == winners.get(0).getScore()){
                winners.add(player);
            } else if (player.getScore() > winners.get(0).getScore()) {
                winners.clear();
                winners.add(player);
            }
        }
        return winners;
    }
}