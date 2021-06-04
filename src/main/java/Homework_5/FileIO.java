package Homework_5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FileIO {

    public static void main(String[] args) {
        File file = new File("src/main/java/Homework_5/hw5.csv");
        List<AppData> dataSet = new ArrayList<>();

        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String[] header = new String[0];
            String h1 = in.readLine();
            if (h1 != null) {
                header = h1.split(";");
            }
            int[][] value = new int[header.length][];

            String line;

            int[]x = new int[value.length];
            while ((line = in.readLine()) != null) {
                String[] tokens = line.split(";");
                for (int i = 0; i < value.length; i++) {
                    x[i] = Integer.parseInt(tokens[i]);
                    for (int j = 0; j < tokens.length; j++) {
                        value[j] = x;
                    }
                }

            }
            AppData data = new AppData(header, value);
            data.setHeader(header);
            data.setData(value);
            dataSet.add(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (AppData data : dataSet) {
            System.out.println(data);
        }
    }
}
