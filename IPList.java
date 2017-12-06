public class IPList {
    public  String ipBeigin;
    public  String ipEnd;
    public  String ipKey;
    public IPList(String ipBeigin,String ipEnd,String ipKey)
    {
        this.ipBeigin=ipBeigin;
        this.ipEnd=ipEnd;
        this.ipKey=ipKey;
    }
    public IPList()
    {
        this.ipBeigin="1";
        this.ipEnd="1";
        this.ipKey="1";
    }
}
