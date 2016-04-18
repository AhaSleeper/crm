package common.util;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.List;

/**  
  * 通用检查工具类
  * Copyright  schoolguard All right reserved.
  * @ClassName: PublicUtil 
  * @author zhuojh
  * @since 2014-2-20 下午1:05:18 
  * Description:  // 用于详细说明此程序文件完成的主要功能
  * Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述  
*/

public class PublicUtil {
	
    /**  
      * 检查邮件格式是否正确
      * Copyright  schoolguard All right reserved.
      * @Title: checkEmail  
      * @author zhuojh
      * @since 2014-2-20 下午1:05:56
      * @param email   邮箱地址
      * @return  
      * @return boolean    返回类型  
      * @throws 
      * Description:  // 用于详细说明此程序文件完成的主要功能
      * Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述  
    */
    public static boolean checkEmail (String email) {
    	return RegexpUtils.isEmail(email);
//        Pattern p = Pattern.compile("^[_\\.0-9a-z-]+@([0-9a-z][0-9a-z-]+\\.)+[a-z]{2,3}$");
//        return p.matcher(email).matches();
    }
    /**  
     * 检查是否是空的list
      * Copyright  schoolguard All right reserved.
      * @Title: checkEmptyList  
      * @author zhuojh
      * @since 2014-2-20 下午1:06:33
      * @param list
      * @return  
      * @return boolean    返回类型  
      * @throws 
      * Description:  // 用于详细说明此程序文件完成的主要功能
      * Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述  
    */
    public static boolean checkEmptyList (List list) {
        if ((list == null) || (list.size() == 0)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**  
      * 检查字符串是否为空
      * Copyright  schoolguard All right reserved.
      * @Title: checkEmptyString  
      * @author zhuojh
      * @since 2014-2-20 下午1:06:45
      * @param str
      * @return  
      * @return boolean    返回类型  
      * @throws 
      * Description:  // 用于详细说明此程序文件完成的主要功能
      * Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述  
    */
    public static boolean checkEmptyString (String str) {
        if(((str == null) || (str.trim().length() == 0))||"null".equals(str)) {
            return true;
        }else{
            return false;
        }
    }

    /**  
     * 转换字符串编码
      * Copyright  schoolguard All right reserved.
      * @Title: convertStringEncode  
      * @author zhuojh
      * @since 2014-2-20 下午1:07:12
      * @param str
      * @param encode
      * @return  
      * @return String    返回类型  
      * @throws 
      * Description:  // 用于详细说明此程序文件完成的主要功能
      * Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述  
    */
    public static String convertStringEncode (String str, String encode) {
        // Not in use but interesting
        try {
            byte bytes[] = str.getBytes(encode);    // "ISO-8859-1");
            String UTFtekst = new String(bytes);
            return UTFtekst;
        }
        catch (UnsupportedEncodingException w) {
            System.out.println("cannot get this charset");
            return "error";
        }
    }

    /**  
      * 格式化float型数据
      * Copyright  schoolguard All right reserved.
      * @Title: formatFloat  
      * @author zhuojh
      * @since 2014-2-20 下午1:07:24
      * @param source
      * @return  
      * @return String    返回类型  
      * @throws 
      * Description:  // 用于详细说明此程序文件完成的主要功能
      * Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述  
    */
    public static String formatFloat (float source) {
        return new DecimalFormat("######0.00").format(source);
    }

}
