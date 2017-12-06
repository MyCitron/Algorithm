import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 *  根据输入和输出的ip段，自动生成正则表达式(如果对效率要求很高，可以手动将正则语句写成静态变量)
 *  并个根据正则表达式匹配输入的ip是否在这个ip段中
 *  @author:dengchengchao
 *  @time:2017-12-5
 */

public class RexMatch {

    private  String _beginIp;
    private  String _endIp;
    private  String _rexStr;
    private  int _diffBegin;
    private  int _diffEnd;

    public RexMatch(String beginIp,String endIp)
    {
        this._beginIp=beginIp;
        this._endIp=endIp;
        this._rexStr=getRexString();
    }

    public  Boolean isMath(String ip){
        return  isRexMatch(ip)&&isBetweenBeginAndEnd(ip);
    }

   //若匹配再检查是否是在这个数据段上
  private Boolean isBetweenBeginAndEnd(String ip){
        int betweenDigit=getBetweenDigit(ip);
        return  betweenDigit<=_diffEnd&&betweenDigit>=_diffBegin;
  }


  // 通过正则表达式提取需要检查的字段
  private  int getBetweenDigit(String ip)
  {
      Pattern pattern=Pattern.compile(_rexStr);
      Matcher matcher=pattern.matcher(ip);
      while (matcher.find()) {
          String digitStr= matcher.group(1);
          return  Integer.parseInt(digitStr);
      }
      return  -1;
  }

  //是否在简单的正则上匹配这个字符串
   private Boolean isRexMatch(String ip){
       return Pattern.matches(_rexStr, ip);
   }


   //生成ip的正则表达式
    private String getRexString() {
        String [] beiginList=_beginIp.split("\\.");
        String [] endList=_endIp.split("\\.");
        if (beiginList.length!=4 || endList.length!=4 ) {
            throw new IllegalArgumentException(String.format("argument is not a ip address: %s %s", _beginIp, _endIp));
        }
        String rexStr="";
        Boolean isMatch=false;
        for(int i=0;i<4;i++){
            if(beiginList[i].equals(endList[i])) {
                if(isMatch){
                    rexStr+="\\d*";
                }
                else{
                    rexStr+=beiginList[i];
                }
            }
            else{
                isMatch=true;
                _diffBegin=Integer.parseInt(beiginList[i]);
                _diffEnd=Integer.parseInt(endList[i]);
                rexStr+="(\\d*)";
            }
            if (i!=3){
                rexStr+=".";
            }
        }
        return "^"+rexStr+"$";
    }

    public static void main( String args[] ){

        // 按指定模式在字符串查找
        String line = "192.16.111.4";
        String pattern = "^192.16.(\\d*)..$";
        System.out.println(Pattern.matches(pattern, line));
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        while (m.find()) {
            System.out.println("Found value: " + m.group(1) );
           // System.out.println("Found value: " + m.group(1) );

        }



        }
    }





