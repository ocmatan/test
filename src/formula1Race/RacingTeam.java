package formula1Race;

public class RacingTeam {

    private String name;
    private RacingCar racingCar1;
    private RacingCar racingCar2;
    private PitStop pitStop;


    public RacingTeam(String name) {
        this.name = name;
        this.pitStop = new PitStop();
        this.racingCar1 = new RacingCar(name + "_" + 1, pitStop);
        this.racingCar2 = new RacingCar(name + "_" + 2, pitStop);

    }

    public String getName() {
        return name;
    }

    public RacingCar getRacingCar1() {
        return racingCar1;
    }

    public RacingCar getRacingCar2() {
        return racingCar2;
    }
}
