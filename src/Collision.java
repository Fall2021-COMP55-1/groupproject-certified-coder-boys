//
//
//import java.awt.event.*;
//import javax.swing.*;
//
///**
// * 
// */
//public class Collision {
//
//    private PlayerCar[] cars;
//
//    public Collision(PlayerCar[] cars) {
//        this.cars = cars;
//    }
//
//    public void checkCollision(PlayerCar car) {
//
//        for (PlayerCar c : cars) {
//
//            if (c instanceof EnemyCar) {
//
//                if (car == c) {
//                    continue;
//                }
//                if (car.comparePosition(c)) {
//                    car.setCrashed(true);
//                    //still need to be fixed
//                }
//                c.setCrashed(false);
//                //still need to be fixed
//            }
//            else {
//                if (car == c) {
//                    continue;
//                }
//
//                if (car.comparePosition(c)) {
//                    c.setCrashed(true);
//                    car.setCrashed(true);
//                    //still need to be fixed
//                }
//
//            }
//
//        }
//    }
//
//}
