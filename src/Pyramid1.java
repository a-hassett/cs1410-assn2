import java.util.Scanner;
import java.lang.Math;

public class Pyramid1 {
    public static void main(String[] args){
        //get number of desired lines from user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of lines: ");
        int numLines = input.nextInt();

        //error if invalid number of lines
        if (numLines < 0){
            System.out.println("<invalid number of lines>");
            System.exit(0);
        }

        //abs(nextNumber) gets printed, numSlots keeps consistent number of slots for every number in pyramid
        int currentLine = 0;
        int nextNumber;
        int numSlots = ("" + numLines).length() + 1;

        //print pyramid
        for(int i = 0; i < numLines; i++){  //repeat for every line
            currentLine += 1;
            nextNumber = -(currentLine - 1);  //first number in new line
            System.out.print(getCurrentGap(numSlots, numLines, currentLine));  //print big gap

            while(nextNumber != currentLine){  //keep printing numbers until end
                System.out.print(getSpaces(Math.abs(nextNumber) + 1, numSlots) + (Math.abs(nextNumber) + 1));  //spaces between numbers
                nextNumber += 1;
            }
            System.out.println();
        }
    }
    //get correct-sized gap for beginning of a new line
    public static String getCurrentGap(int digits, int lines, int currentLine){
        String gap = "";
        for(int i = 0; i < (lines - currentLine)*digits; i++){
            gap += " ";
        }
        return gap;
    }
    //get correct-sized space for going in front of new number on a line
    public static String getSpaces(int number, int digits){
        int numSpaces = digits - (("" + number).length());
        String spaces = "";
        for(int i = 0; i < numSpaces; i++){
            spaces += " ";
        }
        return spaces;
    }
}
