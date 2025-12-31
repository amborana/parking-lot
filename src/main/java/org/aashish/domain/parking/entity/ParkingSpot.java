package org.aashish.domain.parking.entity;

import lombok.Data;
import org.aashish.domain.parking.valueobject.Vehicle;

import java.util.concurrent.locks.ReentrantLock;

@Data
public abstract class ParkingSpot {
    protected volatile boolean occupied;
    protected final ReentrantLock lock = new ReentrantLock();

    public boolean tryOccupy(Vehicle vehicle) {
        lock.lock();
        try {
            if (occupied || !canFit(vehicle)) return false;
            occupied = true;
            return true;
        } finally {
            lock.unlock();
        }
    }

    public void vacate() {
        lock.lock();
        try {
            occupied = false;
        } finally {
            lock.unlock();
        }
    }

    protected abstract boolean canFit(Vehicle vehicle);
}
