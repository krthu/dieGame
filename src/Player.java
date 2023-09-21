import java.util.ArrayList;

public class Player {
    private String name;
    private int score;

    private ArrayList<Die> dice;

    public Player(String name) {
        this.name = name;
        this.dice = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void rollDice() {
        for (Die die : dice) {
            die.roll();
        }
    }

    public int getDieValue() {
        int sum = 0;
        for (Die die : dice) {
            sum += die.getCurrentValue();
        }
        return sum;
    }

    public void increaseScore() {
        score++;
    }

    public void addDie(int sides){
        Die newDie = new Die(sides);
        dice.add(newDie);
    }

    public String toString(){

        return "Name: " + name + " Score: " + score + " Number of Dice:  " + dice.size() + " " + dice;

    }

}

