public class Spelare {
    String name;
    int score;

    int guesses;

    public Spelare(String name) {
        this.name = name;
        score = 0;
        guesses = 0;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getScore() {

        return score;
    }

    public int increaseScore() {

        return score++;
    }

    public void resetGuesses() {
        guesses = 0;
    }

    public int increaseGuesses() {
        return guesses++;
    }
}