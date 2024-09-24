package com.hcl.hackathon.devlopment.LLD.parking_lot;

import java.util.UUID;

public class ParkingTicket {
    private Long id;
    ParkingTicket(){
        UUID uuid = UUID.randomUUID();
        long uniqueNumber = uuid.getMostSignificantBits() & Long.MAX_VALUE;
        this.id = uniqueNumber;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
}
