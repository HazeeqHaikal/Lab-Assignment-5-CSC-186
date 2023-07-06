import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // STEP 1: EXCEPTION HANDLING
        try {
            // STEP 2: READ FILE
            BufferedReader br = new BufferedReader(new FileReader("FTMSK.txt"));
            PrintWriter cs110male = new PrintWriter(new FileWriter("CS110Male.txt"));
            PrintWriter cs111male = new PrintWriter(new FileWriter("CS111Male.txt"));

            cs110male.println("MALE STUDENT LIST FOR CS110");
            cs110male.printf("%-20s%-30s%-20s%-20s%-20s\n", "Matrix Number", "Name", "Course Code", "Part", "Gender");

            cs111male.println("MALE STUDENT LIST FOR CS111");
            cs111male.printf("%-20s%-30s%-20s%-20s%-20s\n", "Matrix Number", "Name", "Course Code", "Part", "Gender");

            // cs111male.println("Matrix Number\t\t\tName\t\t\tCourse
            // Code\t\t\tPart\t\t\tGender");

            int cs110maleCount = 0;
            int cs111maleCount = 0;

            // STEP 3: READ DATA FROM FILE
            String line = null;
            while ((line = br.readLine()) != null) {
                // STEP 4: TOKENIZE DATA
                StringTokenizer st = new StringTokenizer(line, ";");
                String matrixNum = st.nextToken();
                String name = st.nextToken();
                String courseCode = st.nextToken();
                String part = st.nextToken();
                String gender = st.nextToken();

                // STEP 5: MANIPULATE DATA
                if (courseCode.equalsIgnoreCase("cs110") && gender.equalsIgnoreCase("M")) {
                    cs110male.printf("%-20s%-30s%-20s%-20s%-20s\n", matrixNum, name, courseCode, part, gender);
                    cs110maleCount++;
                }

                if (courseCode.equalsIgnoreCase("cs111") && gender.equalsIgnoreCase("M")) {
                    cs111male.printf("%-20s%-30s%-20s%-20s%-20s\n", matrixNum, name, courseCode, part, gender);
                    cs111maleCount++;
                }

            }

            cs110male.println("Number of male students for CS110: " + cs110maleCount);
            cs111male.println("Number of male students for CS111: " + cs111maleCount);

            br.close();
            cs110male.close();
            cs111male.close();

        } catch (FileNotFoundException fnf) {
            // TODO: handle exception
            System.out.println(fnf.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}