package com.hcl.hackathon.devlopment.LLD.parking_lot;

import com.hcl.hackathon.devlopment.LLD.parking_lot.enums.VehicleType;

public class Vehicle {
    String type;
    ParkingTicket ticket;
    String licenseNumber;
    
    public Vehicle(String type, ParkingTicket ticket, String licenseNumber) {
        this.type = type;
        this.ticket = ticket;
        this.licenseNumber = licenseNumber;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public void assignedTicket(ParkingTicket ticket){
        this.ticket = ticket;
    }
}
class Car extends Vehicle{
    public Car(ParkingTicket ticket, String licenseNumber){
        super(VehicleType.Car.name(),ticket,licenseNumber);
    }
}
class Van extends Vehicle{
    public Van(ParkingTicket ticket, String licenseNumber){
        super(VehicleType.Van.name(), ticket,licenseNumber);
    }
}
class MotorBike extends Vehicle{
    public MotorBike(ParkingTicket ticket, String licenseNumber){
        super(VehicleType.MotorBike.name(), ticket,licenseNumber);
    }
}
class Truck extends Vehicle{
    public Truck(ParkingTicket ticket, String licenseNumber){
        super(VehicleType.Truck.name(), ticket,licenseNumber);
    }
}
