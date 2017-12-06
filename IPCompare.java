/**
 *   将IP转换为Long类型并比较大小，找出对应的IP段
 *   Author:Citron
 *   Time:2017-12-6
 */


public class IPCompare {
    private String beginIp;
    private String endIp;
    private String key;
    private Long minIp;
    private Long maxIp;
    public static final String  __NOTFOUND__ = "__NOTFOUND__";

    public  IPCompare(String beginIp,String endIp,String key){
        this.beginIp=beginIp;
        this.endIp=endIp;
        this.key=key;
        initMinAndMax();
    }

    private  void initMinAndMax() {
        minIp=getInteger(beginIp);
        maxIp=getInteger(endIp);
    }

    public String getKey(String ip){
        Long intIp=getInteger(ip);
        return (minIp<intIp&&maxIp>intIp)?key:__NOTFOUND__;
    }

    private  Long getInteger(String ip) {
        String []  beginIpList=ip.split("\\.");
        if (beginIpList.length!=4){
            throw new IllegalArgumentException(String.format("argument is not a ip address: %s %s", beginIp, endIp));
        }
        String resultInt="";
        for(String item:beginIpList){
            resultInt +=String.format("%03d",Integer.parseInt(item.trim()));
        }
        return  Long.parseLong(resultInt.trim());
    }
}
