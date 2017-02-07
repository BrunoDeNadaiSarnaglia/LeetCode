//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Sarnaglia on 1/29/17.
// */
//// enum type for Vehicle
//enum VehicleSize {
//    Motorcycle,
//    Compact,
//    Large,
//    Bus,
//}
//
//abstract class Vehicle {
//    public boolean park(VehicleSize size, Row row){
//        if(size == VehicleSize.Motorcycle){
//            return parkInSmall(row);
//        } else if(size == VehicleSize.Compact){
//            return parkInMedium(row);
//        } else if(size == VehicleSize.Large){
//            return parkInLarge(row);
//        } else {
//            return parkInBus(row);
//        }
//    }
//
//    protected abstract boolean parkInSmall(Row row);
//    protected abstract boolean parkInMedium(Row row);
//    protected abstract boolean parkInLarge(Row row);
//    private boolean parkInBus(Row row) {
//        if(row.getNumBusSpots() > 0){
//            int numLarge = row.getNumLargeSpots();
//            row.setNumBusSpots(row.getNumBusSpots() - 1 + (numLarge + 4) / Row.SPOTS_PER_BUS);
//            row.setNumLargeSpots((numLarge + 4) % Row.SPOTS_PER_BUS);
//            return true;
//        }
//        return false;
//    }
//}
//
//class Motorcycle extends Vehicle {
//
//    @Override
//    protected boolean parkInSmall(Row row) {
//        if(row.getNumSmallSpots() > 0){
//            row.setNumSmallSpots(row.getNumSmallSpots() - 1);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    protected boolean parkInMedium(Row row) {
//        if(row.getNumMediumSpots() > 0){
//            row.setNumMediumSpots(row.getNumMediumSpots() - 1);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    protected boolean parkInLarge(Row row) {
//        if(row.getNumLargeSpots() > 0){
//            row.setNumLargeSpots(row.getNumLargeSpots() - 1);
//            return true;
//        }
//        return false;
//    }
//
//}
//
//class Car extends Vehicle {
//    @Override
//    protected boolean parkInSmall(Row row) {
//        return false;
//    }
//
//    @Override
//    protected boolean parkInMedium(Row row) {
//        if(row.getNumMediumSpots() > 0){
//            row.setNumMediumSpots(row.getNumMediumSpots() - 1);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    protected boolean parkInLarge(Row row) {
//        if(row.getNumLargeSpots() > 0){
//            row.setNumLargeSpots(row.getNumLargeSpots() - 1);
//            return true;
//        }
//        return false;
//    }
//
//}
//
//class Bus extends Vehicle {
//
//    @Override
//    protected boolean parkInSmall(Row row) {
//        return false;
//    }
//
//    @Override
//    protected boolean parkInMedium(Row row) {
//        return false;
//    }
//
//    @Override
//    protected boolean parkInLarge(Row row) {
//        return false;
//    }
//
//}
//
///* Represents a level in a parking garage */
//class Level {
//
//    List<Row> rows;
//
//    public Level(int numRows, int quantitySpotsPerRow) {
//        rows = new ArrayList<>();
//        for (int i = 0; i < numRows; i++) {
//            rows.add(new Row(quantitySpotsPerRow));
//        }
//    }
//}
//
//class Row {
//
//    public static final int SPOTS_PER_BUS = 5;
//
//    private int numSmallSpots;
//    private int numMediumSpots;
//    private int numLargeSpots;
//    private int numBusSpots;
//
//
//
//    public Row(int quantitySpots) {
//        numSmallSpots = quantitySpots / 4 + 1;
//        numMediumSpots = quantitySpots * 3 / 4 + 1 - numSmallSpots;
//        numBusSpots = (quantitySpots - numSmallSpots - numMediumSpots) / SPOTS_PER_BUS;
//        numLargeSpots = quantitySpots - numSmallSpots - numMediumSpots - SPOTS_PER_BUS * numBusSpots;
//    }
//
//    public int getNumSmallSpots() {
//        return numSmallSpots;
//    }
//
//    public int getNumMediumSpots() {
//        return numMediumSpots;
//    }
//
//    public int getNumLargeSpots() {
//        return numLargeSpots;
//    }
//
//    public int getNumBusSpots() {
//        return numBusSpots;
//    }
//
//    public void setNumSmallSpots(int numSmallSpots) {
//        this.numSmallSpots = numSmallSpots;
//    }
//
//    public void setNumMediumSpots(int numMediumSpots) {
//        this.numMediumSpots = numMediumSpots;
//    }
//
//    public void setNumLargeSpots(int numLargeSpots) {
//        this.numLargeSpots = numLargeSpots;
//    }
//
//    public void setNumBusSpots(int numBusSpots) {
//        this.numBusSpots = numBusSpots;
//    }
//
//    public boolean park(Vehicle vehicle, VehicleSize size){
//        return vehicle.park(size, this);
//    }
//}
//
////public class ParkingLot {
//
//    List<Level> levels;
//    // @param n number of leves
//    // @param num_rows  each level has num_rows rows of spots
//    // @param spots_per_row each row has spots_per_row spots
//    public ParkingLot(int n, int num_rows, int spots_per_row) {
//        levels = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            levels.add(new Level(num_rows, spots_per_row));
//        }
//    }
//
//    // Park the vehicle in a spot (or multiple spots)
//    // Return false if failed
//    public boolean parkVehicle(Vehicle vehicle) {
//        // Write your code here
//    }
//
//    // unPark the vehicle
//    public void unParkVehicle(Vehicle vehicle) {
//        // Write your code here
//    }
//}
