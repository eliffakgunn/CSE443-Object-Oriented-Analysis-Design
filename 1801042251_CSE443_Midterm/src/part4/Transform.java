package part4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Abstract class for transform
 */
public abstract class Transform {
    /**
     * List of all numbers
     */
    ArrayList<Double> numbers = new ArrayList<>();
    /**
     * List of real part of transformed numbers
     */
    ArrayList<Double> realPart = new ArrayList<>();
    /**
     * List of imaginary part of transformed numbers
     */
    ArrayList<Double> imagPart = new ArrayList<>();


    /**
     * Procedure of transform
     * This method can not change by subclasses
     * @param input input file
     * @param output output file
     * @throws IOException throws IOException if error occurs while file operations
     */
    public final void procedure(String input, String output) throws IOException {
        readFile(input);
        transform();
        writeFile(output);
        if(printScreen())
            printTime();
    }

    /**
     * Reads the input file and adds numbers to numbers list
     * @param filename input file name
     */
    private void readFile(String filename){
        try{
            BufferedReader buffer = new BufferedReader(new FileReader(filename));

            String line = buffer.readLine();
            String[] strNum = line.split("\t");

            for (String s : strNum) {
                numbers.add(Double.parseDouble(s));
            }
            buffer.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Writers transformed numbers to output file
     * @param filename output file name
     * @throws IOException throws IOException if error occurs while file operations
     */
    private void writeFile(String filename) throws IOException {
        FileWriter fileWriter = new FileWriter(filename);
        for(int i=0; i<numbers.size(); ++i) {
            fileWriter.write(String.format("%.3f\t",realPart.get(i)));

            if(imagPart != null) {
                if (imagPart.get(i) >= 0)
                    fileWriter.write("+");
                fileWriter.write(String.format("%.3f", imagPart.get(i)) + "j");
            }
            fileWriter.write("\n");
        }
        fileWriter.close();
    }

    /**
     * If user enter Y, it returns true
     * @return It returns false as default. If user enters Y, it returns true
     */
    boolean printScreen(){
        return false;
    }

    /**
     * Transforms number with proper method
     */
    abstract void transform();

    /**
     * Prints execution time on the screen
     */
    abstract void printTime();

}
