package org.aashish.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class Ticket {
    private static UUID uuid;
    private Timestamp entryTime;
    private Timestamp exitTime;
    private ParkingSpot spot;
    private boolean staff;
    private int cost;
    private String message;
}
