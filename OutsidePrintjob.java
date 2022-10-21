public class OutsidePrintjob extends Printjob 
{
    private int cents = 10;

    public OutsidePrintjob(String username, int userpriority, int numPages)
    {
        super(username, userpriority, numPages);
    }

    public int getcost()
    {
        return super.getuserpriority() * super.getnumpages() * cents;
    }
}
