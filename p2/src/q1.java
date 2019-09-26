class Vehicle{
    float speed;
    int color;
    float direction;
    public Vehicle(float speed, int color) {
        this.speed = speed;
        this.color = color;
    }
    void turnLeft(int value){
        direction+=value;
    }
    void turnRight(int value){
        direction-=value;
    }
}
class Bicycle extends Vehicle{
    public Bicycle(float speed, int color) {
        super(speed, color);
    }
}
class MotorVehicle extends Vehicle {
    double engineNo;
    int LicencePlates;

    public MotorVehicle(float speed, int color, double engineNo, int licencePlates) {
        super(speed, color);
        this.engineNo = engineNo;
        LicencePlates = licencePlates;
    }

}
class MotorBike extends MotorVehicle{
    public MotorBike(float speed, int color, double engineNo, int licencePlates) {
        super(speed, color, engineNo, licencePlates);
    }
}
class car extends MotorVehicle{
    public car(float speed, int color, double engineNo, int licencePlates) {
        super(speed, color, engineNo, licencePlates);
    }
}

public class q1 {
}
