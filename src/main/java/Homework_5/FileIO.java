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
            String[] header = new String[3];
            int[][] value = new int[header.length][];
            AppData data = new AppData(header,value);
            data.setHeader(header);
            data.setData(value);
            String line = null;
            while ((line = in.readLine()).equals(0)) {
                String[] tokens = line.split(";");
                header[0] = tokens[0];
            }

            while ((line = in.readLine()) != null) {
                for (int i = 0; i < value.length; i++) {
                    String[] tokens = line.split(";");
                    for (int j = 0; j < tokens.length; j++) {
                        value[i][j] = Integer.parseInt(tokens[i]);
                    }
                }
            }
            dataSet.add(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (AppData data: dataSet) {
            System.out.println(data);
        }
    }
}
