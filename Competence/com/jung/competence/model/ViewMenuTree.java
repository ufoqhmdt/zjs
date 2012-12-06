package com.jung.competence.model;

import java.util.ArrayList;
import java.util.List;

import com.jung.common.Constants;


/**
 * 
 * @author longjw 详情 菜单树
 * 
 */
public class ViewMenuTree {
	private String menuID;// 菜单ID
	private String name;// 菜单名
	private String menupath;// 菜单路径
	private String menulevel;// 菜单层级
	private List<ViewMenuTree> chidren;// 子节点
	private String chidrenStr;// 子节点代码
	private String rolecID;// 公司模板ID

	static List<ViewMenuTree> listF = new ArrayList<ViewMenuTree>();// 第1层菜单节点list
	static List<ViewMenuTree> listS = new ArrayList<ViewMenuTree>();// 第2层菜单节点list
	static List<ViewMenuTree> listT = new ArrayList<ViewMenuTree>();// 第3层菜单节点list
	static List<ViewMenuTree> listFour = new ArrayList<ViewMenuTree>();// 第4层菜单节点list

	public String getRolecID() {
		return rolecID;
	}

	public void setRolecID(String rolecID) {
		this.rolecID = rolecID;
	}

	public String getChidrenStr() {
		return chidrenStr;
	}

	public void setChidrenStr(String chidrenStr) {
		this.chidrenStr = chidrenStr;
	}

	public List<ViewMenuTree> getChidren() {
		return chidren;
	}

	public void setChidren(List<ViewMenuTree> chidren) {
		this.chidren = chidren;
	}

	public String getMenuID() {
		return menuID;
	}

	public void setMenuID(String menuID) {
		this.menuID = menuID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMenupath() {
		return menupath;
	}

	public void setMenupath(String menupath) {
		this.menupath = menupath;
	}

	public String getMenulevel() {
		return menulevel;
	}

	public void setMenulevel(String menulevel) {
		this.menulevel = menulevel;
	}

	/**
	 * 
	 * @Description: 将字符串拼装成层级树
	 * @param:@param listViewMenuTree
	 * @param:@return 第1层菜单节点list
	 * @author YINYU mailto: yinyu@highcolu.com
	 */
	public static List<ViewMenuTree> composteMenuTree(
			List<ViewMenuTree> listViewMenuTree) {
		listF.clear();
		listS.clear();
		listT.clear();
		listFour.clear();
		
		if (listViewMenuTree != null) {
			for (ViewMenuTree viewt : listViewMenuTree) {
				if (viewt.getMenulevel().equals(
						Constants.CompetenceConst.FIRST_MENU_LEVEL)) {
					listF.add(viewt);
				}
				if (viewt.getMenulevel().equals(
						Constants.CompetenceConst.SECOND_MENU_LEVEL)) {
					listS.add(viewt);
				}
				if (viewt.getMenulevel().equals(
						Constants.CompetenceConst.THIRD_MENU_LEVEL)) {
					listT.add(viewt);
				}
				if (viewt.getMenulevel().equals(
						Constants.CompetenceConst.FOUR_MENU_LEVEL)) {
					listFour.add(viewt);
				}
			}
		}
		// 循环第4层菜单，放入匹配的第3层菜单子节点中
		if (listT.size() > 0 && listFour.size() > 0) {
			for (int i = 0; i < listFour.size(); i++) {
				for (int j = 0; j < listT.size(); j++) {
					if (listFour.get(i).getMenupath().substring(0,
							listFour.get(i).getMenupath().lastIndexOf("-"))
							.equals(listT.get(j).getMenupath())) {
						if (listT.get(j).getChidren() == null) {
							listT.get(j).setChidren(
									new ArrayList<ViewMenuTree>());

						}
						listT.get(j).getChidren().add(listFour.get(i));
						break;
					}
				}
			}

		}
		// 循环第3层菜单，放入匹配的第2层菜单子节点中
		if (listS.size() > 0 && listT.size() > 0) {
			for (int i = 0; i < listT.size(); i++) {
				for (int j = 0; j < listS.size(); j++) {
					if (listT.get(i).getMenupath().substring(0,
							listT.get(i).getMenupath().lastIndexOf("-"))
							.equals(listS.get(j).getMenupath())) {
						if (listS.get(j).getChidren() == null) {
							listS.get(j).setChidren(
									new ArrayList<ViewMenuTree>());

						}
						listS.get(j).getChidren().add(listT.get(i));
						break;
					}
				}
			}

		}
		// 循环第2层菜单，放入匹配的第1层菜单子节点中
		if (listS.size() > 0 && listF.size() > 0) {
			for (int i = 0; i < listS.size(); i++) {
				for (int j = 0; j < listF.size(); j++) {
					if (listS.get(i).getMenupath().substring(0,
							listS.get(i).getMenupath().lastIndexOf("-"))
							.equals(listF.get(j).getMenupath())) {
						if (listF.get(j).getChidren() == null) {
							listF.get(j).setChidren(
									new ArrayList<ViewMenuTree>());
						}
						listF.get(j).getChidren().add(listS.get(i));
						break;
					}
				}
			}
		}
		return listF;
	}

	/**
	 * 
	 * @Description: 将层级树转换成json格式的字符串
	 * @param:@param list
	 * @param:@param listChecked
	 * @param:@return {id:3,name:"3层节点",open:true}
	 * @author yinyu mailto: yinyu@highcolu.com
	 */
	public static String convertMenuTreeToString(List<ViewMenuTree> list,
			List<ViewMenuTree> listChecked) {
		String zNodes = "";
		if (list == null) {
			return null;
		}

		for (int i = 0; i < list.size(); i++) {
			ViewMenuTree vmt = list.get(i);
			zNodes = zNodes + "{id:" + vmt.getMenuID() + ",name:\""
					+ vmt.getName() + "\",open:true";
			if (listChecked != null) {
				for (ViewMenuTree vtc : listChecked) {
					if (vtc.getMenuID().equals(vmt.getMenuID())) {
						zNodes = zNodes + ",checked:true";
						break;
					}
				}
			}
			if (vmt.getChidren() != null) {
				String str;
				if (listChecked == null) {
					str = convertMenuTreeToString(vmt.getChidren(), null);
				} else {
					str = convertMenuTreeToString(vmt.getChidren(), listChecked);
				}
				zNodes = zNodes + ",children:[" + str + "]";

			}
			if (i < list.size() - 1) {
				zNodes = zNodes + "},";
			} else {
				zNodes = zNodes + "}";
			}
		}
		return zNodes;
	}

}
