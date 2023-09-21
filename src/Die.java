import java.util.Random;

public class Die {
    private int currentValue;
    private int sides;


    public Die(int sides){
        this.sides = sides;

    }

    static Random random = new Random();

    public int getSides(){
        return sides;
    }

    public int getCurrentValue(){
        return currentValue;
    }

    public void roll(){
        currentValue = random.nextInt(sides) + 1;
    }

    public String toString(){
        return "CurrentValue: " + currentValue + " Sides: " + sides;
    }


}
