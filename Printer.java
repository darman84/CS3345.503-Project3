

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Printer {
    public static void main(String[] args) {
        try {
            File printList = new File("input.txt");
            Scanner readprintList = new Scanner(printList);
            BinaryHeap<Printjob> h = new BinaryHeap<>();


            while (readprintList.hasNextLine()) 
            {

                Printjob myJob = new Printjob(readprintList.next(), Integer.parseInt(readprintList.next()),
                        Integer.parseInt(readprintList.next()));                
                h.insert(myJob);
            }
            readprintList.close();
        } catch (FileNotFoundException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}