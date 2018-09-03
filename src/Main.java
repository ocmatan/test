import formula1Race.Race;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] racingTeamsInput = {"Ferrari", "Mercedes", "Red Bull", "McLaren", "Haas", "Renault", "Sauber", "Toro Rosso"};
        Race race = new Race(Arrays.asList(racingTeamsInput));
        race.race();
        System.out.println(race.scores);

    }
}
