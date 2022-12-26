import java.util.Scanner;
import java.lang.Math;

public class Pyramid2 {
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

        //count max number of digits we'll need per spot in pyramid
        int maxValue = (int)Math.pow(2, numLines - 1);
        int numSlots = ("" + maxValue).length() + 1;

        //nextNumber is the printed number, position keeps track what power of 2 we're using
        int currentLine = 0;
        int nextNumber;
        int position;

        //print pyramid: print gap, then the spaces for numbers and then the numbers
        for(int i = 0; i < numLines; i++){
            currentLine += 1;
            position = -(currentLine - 1);
            System.out.print(getCurrentGap(numSlots, numLines, currentLine));  //print the gap for that line

            while(position != currentLine){  //keep printing numbers until end
                nextNumber = (int)Math.pow(2, (currentLine - 1) - Math.abs(position));  //calculate the right power of 2
                System.out.print(getSpaces(nextNumber, numSlots) + nextNumber);  //spaces between numbers
                position += 1;
            }
            System.out.println();
        }
    }
    //get correct-sized gap for beginning of a new line
    public static String getCurrentGap(int digits, int lines, int currentLine){
        String gap = "";
        for(int i = 0; i < (lines - currentLine)*(digits); i++){
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
