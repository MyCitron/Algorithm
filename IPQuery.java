

import java.util.*;



public class IPQuery {

private static List<IPList> ipLists= Arrays.asList(
        new IPList("129.2.0.0","129.2.255.0","2"),
	    new IPList("193.2.0.0","193.2.15.0","12"),
	    new IPList("193.3.0.0","193.3.31.0","13"),
	    new IPList("193.3.32.0","193.3.47.0","15"),
	    new IPList("193.3.48.0","193.3.63.0","16"),
	    new IPList("193.3.64.0","193.3.79.0","17"),
	    new IPList("193.3.80.0","193.3.95.0","18"),
	    new IPList("193.3.96.0","193.3.111.0","19"),
	    new IPList("193.3.112.0","193.3.127.0","20"),
	    new IPList("193.3.128.0","193.3.143.0","21"),
	    new IPList("193.4.0.0","193.4.15.0","22"),
	    new IPList("193.1.0.0","193.1.15.0","6"),
	    new IPList("193.7.1.0","193.7.255.0","29"),
	    new IPList("193.5.1.0","193.5.255.0","30"),
	    new IPList("193.1.16.0","193.1.47.0","3"),
	    new IPList("193.1.48.0","193.1.63.0","5"),
	    new IPList("193.1.64.0","193.1.79.0","7"),
	    new IPList("193.1.80.0","193.1.95.0","8"),
	    new IPList("193.1.96.0","193.1.111.0","9"),
	    new IPList("193.1.112.0","193.1.127.0","10"),
	    new IPList("193.1.128.0","193.1.143.0","11")
);

private static Map<RexMatch,String> rexMap=new HashMap<RexMatch,String>();
private static final IPQuery _instance=new IPQuery();
public  static final IPQuery getInstance()
    {
        return _instance;
    }

private IPQuery()
{
    for(IPList ipItem :ipLists)
    {
        RexMatch rexMatch=new RexMatch(ipItem.ipBeigin,ipItem.ipEnd);
        rexMap.put(rexMatch,ipItem.ipKey);
    }
}

public   String  getCourId(String ip) {
    for (Map.Entry<RexMatch, String>  rex: rexMap.entrySet()) {
          if (rex.getKey().isMath(ip)){
              return rex.getValue();
          }
    }

    return  "__NOTFOUND__";
}


    public static void main( String args[] ){

        String key= IPQuery.getInstance().getCourId("193.1.127.23");
        System.out.println(key);

    }
}


