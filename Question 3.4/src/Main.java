import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src\\20180221.txt"));
            PrintWriter pw = new PrintWriter(new FileWriter("src\\reportSale.txt"));

            pw.printf("%-20s%-20s%-20s%-20s\n", "Item", "Quantity", "Price (RM)", "Sub Total(RM)");
            Supermarket[] arrStore = new Supermarket[100];
            int count = 0;
            double totalSale = 0;
            String line = null;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String itemName = data[0];
                int quantity = Integer.parseInt(data[1]);
                double price = Double.parseDouble(data[2]);
                arrStore[count] = new Supermarket(itemName, quantity, price);
                count++;
                totalSale += quantity * price;
                pw.printf("%-20s%-20d%-20.2f%-20.2f\n", itemName, quantity, price, quantity * price);
            }

            pw.printf("%-20s%-20.2f\n", "Total Sale for date: 21st, February 2018 is: RM", totalSale);
            pw.close();
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}