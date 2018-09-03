package formula1Race;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

public class RacingCar implements Runnable {

    private String name;
    private int distance;
    private PitStop pitStop;
    private boolean shouldEnterIntoPitStopNextTime = false;

    public RacingCar(String name, PitStop pitStop) {
        this.name = name;
        this.pitStop = pitStop;
    }

    public void run(){
        System.out.println("Racing car start racing : " + name);
        while( LocalDateTime.now().isBefore(Race.startTime.plusSeconds(1)) ){
            if(shouldGoIntoStopPit()){
                if(this.pitStop.tryToLockPitStop()){
                    this.pitStop.goIntoPitStop(name);
                    shouldEnterIntoPitStopNextTime = false;
                }else{
                    shouldEnterIntoPitStopNextTime = true;
                }
            }else{
                distance ++;
            }
        }
    }

    private boolean shouldGoIntoStopPit(){
        if(shouldEnterIntoPitStopNextTime){
            return true;
        }
        int randomNum = ThreadLocalRandom.current().nextInt(0, 1001);
        if(randomNum < 5){
            return true;
        }else{
            return false;
        }

    }

    public String getName(){
        return this.name;
    }

    public int getDistance(){
        return distance;
    }





}
