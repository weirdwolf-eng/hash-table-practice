
public class Problem8ParkingLot {

    static String[] parkingLot = new String[10];

    public static int hash(String licensePlate) {
        return Math.abs(licensePlate.hashCode()) % parkingLot.length;
    }

    public static void parkVehicle(String licensePlate) {

        int index = hash(licensePlate);

        while (parkingLot[index] != null) {
            index = (index + 1) % parkingLot.length;
        }

        parkingLot[index] = licensePlate;

        System.out.println("Vehicle " + licensePlate + " parked at spot " + index);
    }

    public static void exitVehicle(String licensePlate) {

        for (int i = 0; i < parkingLot.length; i++) {
            if (licensePlate.equals(parkingLot[i])) {
                parkingLot[i] = null;
                System.out.println("Vehicle " + licensePlate + " exited from spot " + i);
                return;
            }
        }

        System.out.println("Vehicle not found");
    }

    public static void displayParking() {

        System.out.println("Parking Lot Status:");

        for (int i = 0; i < parkingLot.length; i++) {
            System.out.println("Spot " + i + " → " + parkingLot[i]);
        }
    }

    public static void main(String[] args) {

        parkVehicle("ABC123");
        parkVehicle("XYZ999");
        parkVehicle("CAR456");

        displayParking();

        exitVehicle("XYZ999");

        displayParking();
    }
}
