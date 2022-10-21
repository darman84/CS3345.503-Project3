// Zachary Williams
// 10/21/2022
// CS3345.503 - Project 3 - Printer queue

import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner; 

public class Printer {
    public static void main(String[] args) {
        try {
            File printList = new File("input.txt");
            Scanner readprintList = new Scanner(printList);
            BinaryHeap<Printjob> h = new BinaryHeap<>();
           

            while (readprintList.hasNext()) 
            {
                String username = readprintList.next();
                int userpriority = Integer.parseInt(readprintList.next());
                int numPages = Integer.parseInt(readprintList.next());
                String jobType = readprintList.next();

                if(jobType.equals("O")) // checking if the outside flag exists
                {
                    OutsidePrintjob myJob = new OutsidePrintjob(username, userpriority, numPages);
                    h.insert(myJob);
                }
                else
                {
                    Printjob myJob = new Printjob(username, userpriority, numPages);
                    h.insert(myJob);
                }
            }

            readprintList.close();  // closing the file

            while (!h.isEmpty()) 
            {
                Printjob printEntry =  h.deleteMin();
                System.out.print(printEntry.getusername() + " " + printEntry.getuserpriority() + " " + printEntry.getnumpages());
                if(printEntry instanceof OutsidePrintjob)   // checking if this is an outside print job
                {
                    OutsidePrintjob printOutsideEntry = (OutsidePrintjob) printEntry;   // must downcast here
                    System.out.print(" " + printOutsideEntry.getcost());    // if this an OutsidePrintjob, print the cost as well
                }
                System.out.println();
            }

        } catch (FileNotFoundException e) 
        {
            System.out.println("File does not exist");
            e.printStackTrace();
        }



    }
}