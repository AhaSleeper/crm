/**
 * name:
 * Copyright  jeisai All right reserved.
 * @Title:BpmTypeTreeVo.java
 * @Package com.jiesai.issp.vo.bpm
 * @author zhangsj
 * @since 2014-3-27 涓婂崍1:37:02
 * Description:  // 璇︽儏
 * Modify History: // 淇敼鍘嗗彶璁板綍鍒楄〃锛?
 */

package com.zhuojh.vo;

import java.util.List;
import java.util.Map;


/**
 * name: 流程分类Vo
 * Copyright  schoolguard All right reserved.
 * @ClassName: BpmTypeTreeVo
 * Description:  // 详情
 * Modify History: // 修改历史记录列表
 */

public class TreeView {

	private String id;
	private String pId;
	private String name;// 树节点名称
	private String iconCls;// 前面的小图标样式
	private Boolean checked = false;// 是否勾选状态
	private Map<String, Object> attributes;// 其他参数
	private List<TreeView> children;// 子节点
	private String open = "true";

	public String getId() {
		return id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	public List<TreeView> getChildren() {
		return children;
	}
	public void setChildren(List<TreeView> children) {
		this.children = children;
	}
	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}
}
