package com.crm.base.filter;

import com.crm.base.utils.RRException;
import org.apache.commons.lang.StringUtils;


public class SQLFilter {

    /**
     * SQL注入过滤
     * @param str  待验证的字符串
     */
    public static String sqlInject(String str){
        if(StringUtils.isBlank(str)){
            return null;
        }
        //去掉'|"|;|\字符
        str = StringUtils.replace(str, "'", "");
        str = StringUtils.replace(str, "\"", "");
        str = StringUtils.replace(str, ";", "");
        str = StringUtils.replace(str, "\\", "");

        //转换成小写
        str = str.toLowerCase();
        
    	   //过滤
        if (str.indexOf("create_date") !=-1 || str.indexOf("create_time") != -1) {
           	 return str;
   		 }
     
        //非法字符
        String[] keywords = {"master", "truncate", "insert", "select", "delete", "update", "declare", "alert", "create", "drop"};

        //判断是否包含非法字符
        for(String keyword : keywords){
            if(str.indexOf(keyword) != -1){
                throw new RRException("包含非法字符");
            }
        }

        return str;
    }
 
   public static void main(String[] args) {
	System.out.println("c.create_date".indexOf(".create_date") !=-1);
}
}
