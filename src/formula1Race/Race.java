package formula1Race;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Race {

    public static LocalDateTime startTime;

    public String scores = "";

    public List<RacingTeam> racingTeams = new ArrayList<>();

    public Race(List<String> teamNames) {
        for(String teamName : teamNames){
            RacingTeam racingTeam = new RacingTeam(teamName);
            racingTeams.add(racingTeam);
        }
    }

    public void race(){
        Race.startTime = LocalDateTime.now();
        ExecutorService executorService = Executors.newFixedThreadPool(this.racingTeams.size() * 2);
        List<Callable<Object>> tasks = new ArrayList<>();
        for(RacingTeam racingTeam : racingTeams){
            tasks.add(Executors.callable(racingTeam.getRacingCar1()));
            tasks.add(Executors.callable(racingTeam.getRacingCar2()));
        }
        try{
            executorService.invokeAll(tasks);
            Thread.sleep(2000);
            executorService.shutdownNow();
            this.scores = getRaceScores();

        }catch (Exception e){
            System.out.println("exception: " + e);
        }

    }

    private String getRaceScores(){
        List<RacingCar> racingCars = new ArrayList<>();
        for(RacingTeam racingTeam : racingTeams){
            racingCars.add(racingTeam.getRacingCar1());
            racingCars.add(racingTeam.getRacingCar2());
        }
        racingCars.sort(Comparator.comparingInt(RacingCar::getDistance));

        StringBuilder sb = new StringBuilder();
        for(RacingCar racingCar : racingCars){
            sb.append(racingCar.getName() + ", distance: " + racingCar.getDistance() + "\n");
        }
        return sb.toString();
    }

}
