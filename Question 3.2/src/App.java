import java.util.*;
import java.io.*;
public class App {
    public static void main(String[] args) {
        try {
            Vehicle[] vehicle = new Vehicle[10];
            String[] arrCar = new String[10];

            BufferedReader br = new BufferedReader(new FileReader("src\\car.txt"));
            PrintWriter pw = new PrintWriter(new FileWriter("src\\selangor.txt"));
            PrintWriter pw2 = new PrintWriter(new FileWriter("src\\terengganu.txt"));

            pw.printf("%-15s %-15s %-15s\n", "Car Type", "Car Plate Number", "Car Price");
            pw.printf("%-15s %-15s %-15s\n", "========", "================", "=========");

            pw2.printf("%-15s %-15s %-15s\n", "Car Type", "Car Plate Number", "Car Price");
            pw2.printf("%-15s %-15s %-15s\n", "========", "================", "=========");

            String line = null;
            int i = 0;
            double totalSelangorCarPrice = 0.0;
            double totalTerengganuCarPrice = 0.0;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(";");

                String carType = arr[0];
                String carPlateNumber = arr[1];
                String carPrice = arr[2];

                vehicle[i] = new Vehicle(carType, carPlateNumber, carPrice);

                if (vehicle[i].getCarPlateNumber().startsWith("B")) {
                    pw.printf("%-15s %-15s %-15s\n", vehicle[i].getCarType(), vehicle[i].getCarPlateNumber(), vehicle[i].getCarPrice());
                    totalSelangorCarPrice += Double.parseDouble(vehicle[i].getCarPrice());
                }

                if (vehicle[i].getCarPlateNumber().startsWith("T")) {
//                    pw2.println(arrCar[i]);
                    pw2.printf("%-15s %-15s %-15s\n", vehicle[i].getCarType(), vehicle[i].getCarPlateNumber(), vehicle[i].getCarPrice());
                    totalTerengganuCarPrice += Double.parseDouble(vehicle[i].getCarPrice());
                }
                i++;
            }
            pw.printf("Total Price: RM %,.2f", totalSelangorCarPrice);
            pw2.printf("Total Price: RM %,.2f", totalTerengganuCarPrice);
            br.close();
            pw.close();
            pw2.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


    }
}
