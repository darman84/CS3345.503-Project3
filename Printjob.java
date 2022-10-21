
public class Printjob implements Comparable<Printjob>
{

    private String username;
    private int userpriority;
    private int numPages;

    // constructor
    public Printjob(String username, int userpriority, int numPages)
    {
        this.username = username;
        this.userpriority = userpriority;
        this.numPages = numPages;
    }

    public String getusername()
    {
        return username;
    }
    public int getuserpriority()
    {
        return userpriority;
    }
    public int getnumpages()
    {
        return numPages;
    }


    // a necessary method for the comparable interface
    @Override
    public int compareTo(Printjob myJob)
    {   // calculating the job priority
        int priorityOne, priorityTwo;
        priorityOne = this.getnumpages() * this.getuserpriority();
        priorityTwo = myJob.getnumpages() * myJob.getuserpriority();


        if(priorityOne > priorityTwo)
            return 1;
        else if(priorityOne == priorityTwo)
            return 0;
        else 
            return -1;
    }


}
