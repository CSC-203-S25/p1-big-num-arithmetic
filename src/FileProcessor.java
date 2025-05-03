import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class FileProcessor {

    /**
     * Processes arithmetic expressions line-by-line in the given file.
     *
     * @param filePath Path to a file containing arithmetic expressions.
     */
    public static void processFile(String filePath) {
        File infile = new File(filePath);
        try (Scanner scan = new Scanner(infile)) {
            while (scan.hasNext()) {
                String line = scan.nextLine();
                //Parses the line for extended spaces and separates the
                //characters and will skip if there is a blank line
                String[] parsedLine = line.trim().split("\\s+");
                if (line.trim().isEmpty()) continue;
                //Try catch to make sure the inputs are valid
                try {
                    //Makes linked lists based off the String Array of parsed lines
                    LinkedList number1 = new LinkedList(parsedLine[0]);
                    LinkedList number2 = new LinkedList(parsedLine[2]);
                    //Uses the 2nd spot in tbe array to determine the operation
                    switch (parsedLine[1]) {
                        //Calls and formats the string for addition
                        case "+" -> {
                            LinkedList result = LinkedList.addition(number1, number2);
                            String num1 = number1.toString();
                            String num2 = number2.toString();
                            System.out.println(num1 + " + " + num2 + " = " + result.toString());

                        }
                        case "*" -> {
                            //Calls and formats the string for multiplication
                            LinkedList result = LinkedList.mult(number1, number2);
                            String num1 = number1.toString();
                            String num2 = number2.toString();
                            System.out.println(num1 + " " + num2 + " = " + result.toString());
                        }
                        case "^" -> {
                            //Calls and formats the string for exponentiation
                            LinkedList result = LinkedList.expo(number1, number2);
                            String num1 = number1.toString();
                            String num2 = number2.toString();
                            System.out.println(num1 + " ^ " + num2 + " = " + result.toString());
                        }

                    }
                    //
                } catch (Exception e) {
                    System.out.println("Invalid inputs, please rerun the program");

                }

                // TODO: Process each line of the input file, handling blank
                // lines and spacing differences as appropriate

            }
            //If file is not found, will return error
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
    }
}
