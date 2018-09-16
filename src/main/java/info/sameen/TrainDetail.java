package info.sameen;

public class TrainDetail {

    private String trainType;
    private int gear;
    private int speed;
    private int energy;

    TrainDetail(String trainType, int gear, int speed, int energy) {
        this.trainType = trainType;
        this.gear = gear;
        this.speed = speed;
        this.energy = energy;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
