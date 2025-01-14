import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import manager.ParkingLotManager;
import model.ParkingLevel;
import model.spot.LargeSpot;
import model.spot.MediumSpot;
import model.spot.ParkingSpot;
import model.spot.SmallSpot;
import model.vehicle.Bike;
import model.vehicle.Car;
import model.vehicle.Truck;
import model.vehicle.Vehicle;
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

        for(int j=0; j<3; j++){
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
        try{
            Vehicle[] vehicles = new Vehicle[7];
            vehicles[0] = new Bike(generator.generateStringUUID(), "Suvnkr");
            vehicles[1] = new Bike(generator.generateStringUUID(), "Priya");
            vehicles[2] = new Bike(generator.generateStringUUID(), "Subhajyoti");
            vehicles[3] = new Bike(generator.generateStringUUID(), "Biswadeep");
            vehicles[4] = new Bike(generator.generateStringUUID(), "Biswayan");
            vehicles[5] = new Bike(generator.generateStringUUID(), "Bonodeep");
            vehicles[6] = new Bike(generator.generateStringUUID(), "Sagnik");
            System.out.println(manager.allocateSpot(vehicles[0]));
            System.out.println(manager.allocateSpot(vehicles[1]));
            System.out.println(manager.allocateSpot(vehicles[2]));
            System.out.println(manager.allocateSpot(vehicles[3]));
            System.out.println(manager.allocateSpot(vehicles[4]));
            System.out.println(manager.allocateSpot(vehicles[5]));
            System.out.println(manager.allocateSpot(vehicles[6]));
        }catch(IllegalStateException ex){
            System.out.println(ex.toString());
        }
        
        System.out.println(manager);
        
    }
}
