import java.util.Scanner;

public class Lab1 {
    private String sentence;
    private int[] frequencyArray;
    private String[] binaryArray;
    public Lab1() {        
       Scanner sc = new Scanner(System.in);
       sentence = sc.nextLine();
       frequencyArray = new int[128];
       binaryArray = new String[sentence.length()];
    }
    public static void main(String args[]) {
        Lab1 myLab = new Lab1();
        myLab.printFrequencyArray();
        myLab.printBinaryArray();
    }
    private void fillFrequencyArray() {
        for(int i = 0; i < sentence.length(); i++) {
            for(int j = 0; j < frequencyArray.length; j++) {
                if((int)sentence.charAt(i) == j) {
                    frequencyArray[j]++;
                }
            }
        }
    }
    private void fillBinaryArray() {
        for(int i = 0; i < sentence.length(); i++) {
            binaryArray[i] = Integer.toBinaryString((int)sentence.charAt(i)); //convert the ASCII number of a character to its binary number representation
        }
        for(int i = 0; i < binaryArray.length; i++) {
            boolean flag = true;
            while(flag) {
                flag = false;
                if(binaryArray[i].length() < 7) {
                    flag = true;
                    binaryArray[i] = "0" + binaryArray[i];
                }
            }
        }
    }
    public void printFrequencyArray() {
        fillFrequencyArray();
        for(int i = 0; i < frequencyArray.length; i++) {
            if(frequencyArray[i] > 0) {
                System.out.println((char)i + " appeared " + frequencyArray[i] + " times");
            }
        }
    }
    public void printBinaryArray() {
        fillBinaryArray();
        for(int i = 0; i < binaryArray.length; i++) {
            System.out.print(binaryArray[i] + " ");
        }
    }
}
