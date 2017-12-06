import java.util.*;

public class IPSearch {
    private String beginIp;
    private String endIp;
    private String key;
    public static final String  __NOTFOUND__ = "__NOTFOUND__";
    private LinkedHashMap<Integer,Integer> diffMap;
    public IPSearch(String beginIp,String endIp,String key){
           this.beginIp=beginIp;
           this.endIp=endIp;
           this.key=key;
           diffMap =new LinkedHashMap<Integer,Integer>();
           InitListMap();
    }

    private void InitListMap()
    {
        String []  beginIpList=beginIp.split("\\.");
        String[]   endIpList=endIp.split("\\.");
        if (beginIpList.length!=4 || endIpList.length!=4){
            throw new IllegalArgumentException(String.format("argument is not a ip address: %s %s", beginIp, endIp));
        }
        for(int i=0;i<4;i++){
            diffMap.put(Integer.parseInt(beginIpList[i]),Integer.parseInt(endIpList[i]));
            if(!beginIpList[i].equals(endIpList[i])){
                break;
            }
        }
    }

    public  String getKey(String ip)
    {
        String[] ipList=ip.split("\\.");
        int length=diffMap.size();
        int index=0;
        for(Map.Entry<Integer,Integer> entry: diffMap.entrySet()){
            Integer ipSection=Integer.parseInt(ipList[index++]);
           if (index<length){
               if (!ipSection.equals(entry.getKey()))
               {
                   return __NOTFOUND__;
               }
           }
           if(index==length){
               if (ipSection<entry.getKey()||ipSection>=entry.getValue()){
                   return __NOTFOUND__;
               }
           }
        }
               return this.key;
    }





}
