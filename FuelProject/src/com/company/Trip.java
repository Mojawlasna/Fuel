package com.company;

public class Trip {
    private int fuel;
    private int kilometers;

    public Trip(int fuel, int kilometers) {
        this.fuel = fuel;
        this.kilometers = kilometers;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public void sumTrips(Trip trip) {
        this.fuel += trip.getFuel();
        this.kilometers += trip.getKilometers();
    }

    public float calculateConsumptionPerKilometer() {
        if (kilometers != 0) {
            return (float) fuel / kilometers;
        }
        return 0;
    }
}
