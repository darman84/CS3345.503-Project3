

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

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

            readprintList.close();

            while (!h.isEmpty()) 
            {
                Printjob printEntry =  h.deleteMin();
                System.out.print(printEntry.getusername() + " " + printEntry.getuserpriority() + " " + printEntry.getnumpages());
                if(printEntry instanceof OutsidePrintjob)   // checking if this is an outside print job
                {
                    OutsidePrintjob printOutsideEntry = (OutsidePrintjob) printEntry;   // must downcast here
                    System.out.print(" " + printOutsideEntry.getcost());
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