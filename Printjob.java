import javax.lang.model.util.ElementScanner6;

public class Printjob implements Comparable<Printjob>
{

    private String username;
    private int userpriority;
    private int numPages;

    public Printjob(String username, int userpriority, int numPages)
    {
        this.username = username;
        this.userpriority = userpriority;
        this.numPages = numPages;
    }

    @Override
    public int compareTo(Printjob myJob)
    {
        if(this.userpriority > myJob.userpriority)
            return 1;
        else if(this.userpriority == myJob.userpriority)
            return 0;
        else 
            return -1;
    }


}
