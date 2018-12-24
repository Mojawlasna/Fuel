package com.company;

import java.util.Scanner;

public class App {

	private final String welcomeMessage = "App for calculating fuel consumption";
	private final String requestControlInteger = "Enter any number to calculate or -1 to exit";
	private final String requestKilometersMessage = "Please enter number of kilometers";
	private final String requestLitersMessage = "Please enter number of liters used";
	private final String dataMessage = "Kilometers covered: %d, fuel used: %d";
	private final String consumptionMessage = "\nFuel consumption per 1 km, %.2f liters\n";
	private final String averageconsumptionMessage = "\nAverage Fuel consumption per 1 km, %.2f liters\n";

	private final Trip totalTrip = new Trip(0, 0);
	private Trip currentTrip;

	private final int exitNumber = -1;

	public void run() {
		System.out.println(welcomeMessage);
		performLoop();
	}

	private void performLoop() {
		while (askForIntegerControl() != exitNumber) {
			currentTrip = askForKilometerAndFuel();
			displayDataInConsole(currentTrip.getKilometers(), currentTrip.getFuel());
			totalTrip.sumTrips(currentTrip);
			askForConsumptionAndDisplay();
		}
	}

	private Trip askForKilometerAndFuel() {
		int kilometers = askForIntegerInput(requestKilometersMessage);
		int fuel = askForIntegerInput(requestLitersMessage);
		return new Trip(fuel, kilometers);
	}

	private void askForConsumptionAndDisplay() {

		float Average = totalTrip.calculateConsumptionPerKilometer();
		float consumption = currentTrip.calculateConsumptionPerKilometer();
		displayFloatAndMessage(consumption, consumptionMessage);
		displayFloatAndMessage(Average, averageconsumptionMessage);

	}

	private int askForIntegerInput(String message) {
		System.out.println(message);
		Scanner input = new Scanner(System.in);
		return input.nextInt();
	}

	private void displayDataInConsole(int kilometers, int fuel) {
		System.out.printf(dataMessage, kilometers, fuel);
	}

	private void displayFloatAndMessage(float value, String message) {
		System.out.printf(message, value);

	}

	private int askForIntegerControl() {
		int control = askForIntegerInput(requestControlInteger);
		return control;
	}
}
