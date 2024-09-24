package com.hcl.hackathon.devlopment.LLD.parking_lot;

import com.hcl.hackathon.devlopment.LLD.parking_lot.enums.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    String name;
    String address;
    ParkingRate parkingRate;
    int carSpotCount = 0;
    int largeSpotCount = 0;
    int motorBikeSpotCount = 0;
    int electricSpotCount = 0;
    int maxCarCount = 0;
    int maxLargeCount = 0;
    int maxMotorBikeCount = 0;
    int maxElectricCount = 0;
    Map<String,Object> entrancePanels = new HashMap<>();
    Map<String,Object> exitPanels = new HashMap<>();
    Map<String,Object> parkingFloors = new HashMap<>();
    Map<String,Object> activeTickets = new HashMap<>();
    
    public synchronized ParkingTicket getNewParkingTicket(Vehicle vehicle) throws Exception {
        if(isFull(vehicle.getType())){
            throw new Exception("parking is full!!");
        }
        ParkingTicket ticket = new ParkingTicket();
        vehicle.assignedTicket(ticket);
        Ticket.parkingTicketMap.put(ticket.getId(),ticket);
        incrementSpotCount(vehicle.getType());
        return ticket;
    }
    
    private void incrementSpotCount(String type) {
        if(type.equalsIgnoreCase(VehicleType.Truck.name()) || type.equalsIgnoreCase(VehicleType.Van.name())){
            largeSpotCount += 1;
        }
        else if(type.equalsIgnoreCase(VehicleType.MotorBike.name())){
            motorBikeSpotCount += 1;
        }
        else if(type.equalsIgnoreCase(VehicleType.Car.name())){
            if(carSpotCount<maxCarCount)
                carSpotCount += 1;
            else
                largeSpotCount += 1;
        }
        else if(type.equalsIgnoreCase(VehicleType.ElectricCar.name())){
            if(electricSpotCount<maxElectricCount){
                electricSpotCount+=1;
            }else if(carSpotCount<maxCarCount){
                carSpotCount+=1;
            }else {
                largeSpotCount += 1;
            }
        }
    }
    
    boolean isFull(String type) throws Exception {
        if(type.equalsIgnoreCase(VehicleType.Truck.name()) || type.equalsIgnoreCase(VehicleType.Van.name())){
            if(largeSpotCount>=maxLargeCount){
                return true;
            }else {
                return false;
            }
        }
        if(type.equalsIgnoreCase(VehicleType.MotorBike.name())){
            if(motorBikeSpotCount>=maxMotorBikeCount){
                return false;
            }
            else {
                return true;
            }
        }
        if(type.equalsIgnoreCase(VehicleType.Car.name())){
            if(carSpotCount+largeSpotCount>=maxCarCount+maxLargeCount){
                return false;
            }
            else {
                return true;
            }
        }
        if(type.equalsIgnoreCase(VehicleType.ElectricCar.name())){
            if(carSpotCount+largeSpotCount+electricSpotCount>=maxCarCount+maxLargeCount+maxElectricCount){
                return false;
            }else {
                return true;
            }
        }
        throw new Exception("vehicle type does not support");
    }
}
