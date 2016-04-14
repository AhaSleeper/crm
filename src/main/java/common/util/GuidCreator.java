package common.util;

import java.util.*;

import org.apache.commons.lang.StringUtils;
/**
 * guid生成类
* Copyright  schoolguard All right reserved.
* @ClassName: GuidCreator 
* @author zhuojh
* @since 2014-2-20 下午3:01:04 
* Description:  // guid生成类
* Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述
 */
public class GuidCreator {

	/**
	 * 生成UUID线程同步方法
	* Copyright  schoolguard All right reserved.
	* @Title: getUUID  
	* @author zhuojh
	* @since 2014-2-20 下午3:01:29
	* @return  
	* @return String    返回类型  
	* @throws 
	* Description:  // 用于详细说明此程序文件完成的主要功能
	* Modify History: // 修改历史记录列表，每条修改记录应包括修改日期、修改者及内容简述
	 */
	public static synchronized String getUUID(){
		return StringUtils.remove(UUID.randomUUID().toString(), '-');
	}

}
