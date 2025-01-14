import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import manager.ParkingLotManager;
import model.ParkingLevel;
import model.ParkingSpot;
import model.spot.LargeSpot;
import model.spot.MediumSpot;
import model.spot.SmallSpot;
import model.vehicle.Bike;
import model.vehicle.Car;
import model.vehicle.Truck;
import util.DefaultFeeCalculator;
import util.ParkingFeeCalculator;
import util.UUIDGenerator;

public class Main {
    public static void main(String args[]){
        Random randInt = new Random();
        UUIDGenerator generator = new UUIDGenerator();
        List<ParkingLevel> levels = new ArrayList<ParkingLevel>();
        ParkingFeeCalculator calculator = new DefaultFeeCalculator();

        ParkingLotManager manager = new ParkingLotManager(levels, calculator);

        for(int j=0; j<2; j++){
            List<ParkingSpot> parkingSpots = new ArrayList<>();
            int uuid = generator.generateIntegerUUID();
            ParkingLevel level = new ParkingLevel(uuid, parkingSpots);
            levels.add(level);
            for(int i=0; i<5; i++){
                int randomSelect = randInt.nextInt(3);
                switch (randomSelect) {
                    case 0:
                        parkingSpots.add(new SmallSpot(generator.generateStringUUID()));
                        break;
                    case 1:
                        parkingSpots.add(new MediumSpot(generator.generateStringUUID()));
                        break;
                    case 2:
                        parkingSpots.add(new LargeSpot(generator.generateStringUUID()));
                        break;
                }
            }
        }
        System.out.println(manager);
        System.out.println(manager.allocateSpot(new Bike(generator.generateStringUUID(), "Suvnkr")));
        System.out.println(manager.allocateSpot(new Car(generator.generateStringUUID(), "Priya")));
        System.out.println(manager.allocateSpot(new Truck(generator.generateStringUUID(), "Subhajyoti")));
        System.out.println(manager.allocateSpot(new Truck(generator.generateStringUUID(), "Biswadeep")));
        System.out.println(manager.allocateSpot(new Truck(generator.generateStringUUID(), "Biswayan")));
        System.out.println(manager.allocateSpot(new Truck(generator.generateStringUUID(), "Bonodeep")));
        System.out.println(manager.allocateSpot(new Truck(generator.generateStringUUID(), "Sagnik")));
        System.out.println(manager);
        
    }
}
