package com.ivan.tool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeFormat {

    public static void main(String[] args){
        CodeFormat cf=new CodeFormat();
        String s="002495.XSHE,105\n" +
                "603755.XSHG,108\n" +
                "603317.XSHG,200\n" +
                "603027.XSHG,959\n" +
                "603696.XSHG,1016\n" +
                "603288.XSHG,1465\n" +
                "002650.XSHE,2004\n" +
                "600866.XSHG,3707\n" +
                "600872.XSHG,3707\n" +
                "600186.XSHG,3707\n" +
                "600305.XSHG,3707\n";
        System.out.println(cf.format(s,5));
    }

    public String format(String str,int num){
        Pattern pattern = Pattern.compile("\\d{6}\\.[a-zA-Z]{4}");
        StringBuilder sb=new StringBuilder();
        Matcher matcher=pattern.matcher(str);
        int i=0;
        while (matcher.find()){
            i++;
            String code=matcher.group();
            if(i!=1){
                sb.append(",");
            }
            sb.append("'"+code+"'");
            if(i%num==0){
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
