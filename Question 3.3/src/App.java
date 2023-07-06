import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args)  {
        try {
            BufferedReader br = new BufferedReader(new FileReader("deliveroo.txt"));
            PrintWriter pw = new PrintWriter(new FileWriter("earnings.txt"));

            pw.println("Profit earned for each delivery");
            pw.printf("%-20s%-20s\n", "Date(Day)", "Profit (RM)");
            pw.println("================================");
            double total = 0;
            double average = 0;
            int numRecords = 0;
            int countAfter9PM = 0;
            
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String date = data[0];
                String day = data[1].substring(0, 3);
                double price = Double.parseDouble(data[5]);
                double deliveryDistanceInKM = Double.parseDouble(data[6]);
                double priceMultiplier = Double.parseDouble(data[7]);
                double profit = (price * priceMultiplier) - price;
                String profitString = String.format("%.2f", profit);
                // pw.println(date+ "(" + day + ")" + "\t\t" + profitString);
                pw.printf("%-20s%-20s\n", date+ "(" + day + ")", profitString);
                total += profit;
                numRecords++;
            }
            
            average = total / numRecords;
            String averageString = String.format("%.2f", average);
            pw.println("\nAverage profit per delivery: RM " + averageString);
            pw.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // TODO: handle exception
        }
    }
}
