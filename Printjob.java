public class Printjob implements Comparable<Printjob>
{

    public Printjob(String name, int priority, int numPages)
    {
        this.name = name;
        this.priority = priority;
        this.numPages = numPages;
    }

    private String name;
    private int priority;
    private int numPages;
}
