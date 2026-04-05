// package DifferenceObjectsClasses;

import java.util.Arrays;
import java.util.Scanner;

// This is the blueprint of the "Car" class that was mentioned
class Car {
    private String _name = null;
    private boolean _is_driving = false;
    private float _speed = 0;
    // This is the internal method for handling driving
    // Would have preferred to multi-thread this, but that is beyond the scope of this so keeping it public.
    // This accelerates the speed each entry the user performs, regardless of if they are "using" the car
    public void driving() {
        if (_is_driving) {
            if (_speed < 60) {
                _speed = _speed + (_speed/2) + 1;
            } else {
                _speed = _speed + 1;
            }
            if (_speed > 120) {
                stop();
                System.out.println(String.format("Car %s crashes! *CRASH! SMASH!*", _name));
            }
        }
    }
    // Drive sets the state of the car, and the initial speed
    public void drive() {
        _is_driving = true;
        _speed = 1;
    }
    // stops the car, setting it back to base state
    public void stop() {
        _is_driving = false;
        _speed = 0;
    }
    // just honks the horn! *BEEP BEEP*
    public void honk() {
        System.out.println(String.format("Car %s honks! *HONK*", _name));
    }
    public float mph() {
        return _speed;
    }
    Car(String car_name) {
        _name = car_name;
    }
}
// Defining the main progrm
public class DifferenceObjectsClasses {
    public static void main(String[] args) {
        // main instantiates the two instances of "Car" blueprint (class) in memory for use
        String _selection = null;
        Car car_a = new Car("A");
        Car car_b = new Car("B");

        Scanner scanner = new Scanner(System.in);

        String input = null;
        while (input != "fin") {
            if (_selection == null) {
                // Select which instance of the car to use
                System.out.println("What car would you like to control ?");
                System.out.println(" - A ");
                System.out.println(" - B ");
            } else {
                System.out.println("What would you like to do ?");
                System.out.println(" - Honk ");
                System.out.println(" - Drive ");
                System.out.println(" - Stop ");
                System.out.println(" - Swap (Change Car) ");
            }
            input = scanner.nextLine().trim();
            if (input.equals("fin")) {
                break;
            }
            if (input.equals("A") || input.equals("B")) {
                    _selection = input;
                }
                // Breaking DRY principals for reduces complexity
                // implements use of the car functions while driving.
                if (_selection.equals("A")) {
                    if (input.equals("honk")) {
                        car_a.honk();
                    }
                    if (input.equals("start") || input.equals("drive")) {
                        car_a.drive();
                    }
                    if (input.equals("stop")) {
                        car_a.stop();
                    }
                }
                if (_selection.equals("B")) {
                    if (input.equals("honk")) {
                        car_b.honk();
                    }
                    if (input.equals("start") || input.equals("drive")) {
                        car_b.drive();
                    }
                    if (input.equals("stop")) {
                        car_b.stop();
                    }
                }
                // Select which instance of the car to use
                if (input.equals("swap")) {
                    _selection = (_selection.equals("A")) ? "B" : "A";
                }
            // Using this rather then doing multi-threading to reduce complexity
            car_a.driving();
            car_b.driving();
            System.out.println(String.format("Car A speed: %s | Car B speed: %s", car_a.mph(), car_b.mph()));
        }
    }
}
