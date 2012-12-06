package com.jung.competence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.jung.common.Constants;
import com.jung.common.HibernateEntityManagerImpl;
import com.jung.competence.dao.UserCompetenceHibernateDao;
import com.jung.competence.model.Menu;
import com.jung.competence.model.RoleForUser;
import com.jung.competence.model.RoleForUserLinkMenu;
import com.jung.competence.model.RoleLinkUser;
import com.jung.competence.model.UserLinkMenu;
import com.jung.competence.model.ViewMenuTree;
import com.jung.exception.SkeletonException;
import com.jung.exception.SkeletonSystemException;


public class UserCompetenceHibernateDaoImpl extends
		HibernateEntityManagerImpl<ViewMenuTree> implements
		UserCompetenceHibernateDao {

	@Override
	public void addCLM(List<UserLinkMenu> clml) {
		// TODO Auto-generated method stub
		for (UserLinkMenu clm : clml) {
			try {
				super.save(clm);
			} catch (SkeletonSystemException e) {

				e.printStackTrace();
			}
		}
	}

	@Override
	public void addRoleForUser(RoleForUser roleForUser,
			List<RoleForUserLinkMenu> listRCM) {
		// TODO Auto-generated method stub
		try {
			super.save(roleForUser);
			for (RoleForUserLinkMenu roleForUserLinkMenu : listRCM) {
				super.save(roleForUserLinkMenu);
			}
		} catch (SkeletonSystemException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void addMoreM(List<RoleForUserLinkMenu> rcml,
			List<UserLinkMenu> clmlt) {
		// TODO Auto-generated method stub
		for (RoleForUserLinkMenu rcm : rcml) {
			try {
				super.save(rcm);
			} catch (SkeletonSystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		for (UserLinkMenu clm : clmlt) {
//			try {
//				super.save(clm);
//			} catch (SkeletonSystemException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}

	@Override
	public void addRoleForUserLinkMenu(List<RoleForUserLinkMenu> rfcmList) {
		// TODO Auto-generated method stub
		for (RoleForUserLinkMenu rfum : rfcmList) {
			try {
				super.save(rfum);
			} catch (SkeletonSystemException e) {

				e.printStackTrace();
			}
		}

	}

	@Override
	public void addRoleLinkUser(List<RoleLinkUser> rlcl) {
		// TODO Auto-generated method stub
		for (RoleLinkUser rlc : rlcl) {
			try {
				super.save(rlc);
			} catch (SkeletonSystemException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteUserLinkMenu(List<UserLinkMenu> cml) {
		// TODO Auto-generated method stub
		for (UserLinkMenu cm : cml) {
			try {
				super.remove(cm);
			} catch (SkeletonSystemException e) {

				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteRoleForUserLinkMenu(List<RoleForUserLinkMenu> listRCM) {
		// TODO Auto-generated method stub
		try {
			for (RoleForUserLinkMenu rfcM : listRCM) {
				super.remove(rfcM);
			}

		} catch (SkeletonException e) {

			e.printStackTrace();
		}
	}

	@Override
	public List<ViewMenuTree> getCF(Integer rolecID) {
		String sql = "select distinct(roleforuserlinkmenu.menuID) from roleforuserlinkmenu where roleforuserlinkmenu.roleID in ("
				+ "select rc.roleID from rolelinkuser rc where rc.userID=("
				+ "select rolelinkuser.userID from rolelinkuser where roleID="
				+ rolecID + ")" + "and rc.roleID!=" + rolecID + ")";
		List<ViewMenuTree> viewMenuTreeList = new ArrayList<ViewMenuTree>();
		ViewMenuTree viewMenuTree;
		try {
			List<Object[]> viewMenuTreeLists = super.executeSQL(sql);
			if (viewMenuTreeLists.size() < 1) {
				return null;
			}
			for (int i = 0; i < viewMenuTreeLists.size(); i++) {
				viewMenuTree = new ViewMenuTree();
				if (!String.valueOf(viewMenuTreeLists.get(i)).equals("")
						&& viewMenuTreeLists.get(i) != null) {
					viewMenuTree.setMenuID(String.valueOf(viewMenuTreeLists
							.get(i)));
				}
				viewMenuTreeList.add(viewMenuTree);
				viewMenuTree = null;
			}
		} catch (SkeletonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return viewMenuTreeList;
	}

	@Override
	public List<UserLinkMenu> getUserLinkMenu(Integer userID, Integer companyID) {
		String hql = "from UserLinkMenu where userID=" + userID
				+ " and companyID=" + companyID;
		List<UserLinkMenu> clml = new ArrayList<UserLinkMenu>();
		UserLinkMenu clm = null;
		try {
			List cml = super.executeHql(hql);
			if (cml.size() < 1) {
				return null;
			} else {
				for (int i = 0; i < cml.size(); i++) {
					clm = (UserLinkMenu) cml.get(i);
					clml.add(clm);
					clm = null;
				}
			}
		} catch (SkeletonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clml;
	}

	@Override
	public List<UserLinkMenu> getCLML(List<String> IDStr) {
		String hql = "from UserLinkMenu where menuID in(";
		for (int i = 0; i < IDStr.size(); i++) {
			if (i == 0) {
				hql = hql + IDStr.get(i);
			} else {
				hql = hql + "," + IDStr.get(i);
			}
		}
		hql = hql + ")";
		List<UserLinkMenu> cml = new ArrayList<UserLinkMenu>();
		UserLinkMenu cm = null;
		try {
			List cmlt = super.executeHql(hql);
			if (cmlt.size() < 1) {
				return null;
			} else {
				for (int i = 0; i < cmlt.size(); i++) {
					cm = (UserLinkMenu) cmlt.get(i);
					cml.add(cm);
					cm = null;
				}
			}
		} catch (SkeletonException e) {

			e.printStackTrace();
		}
		return cml;
	}

	@Override
	public List<ViewMenuTree> getCheckedM(Integer roleID) {
		String sql = "select rcm.menuID,rc.roleSimp from roleforuserlinkmenu rcm  inner join menu on rcm.menuID = menu.menuID inner join roleforuser rc on rc.roleID = rcm.roleID  where rcm.roleID="
				+ roleID;
		List<ViewMenuTree> viewMenuTreeList = new ArrayList<ViewMenuTree>();
		ViewMenuTree viewMenuTree;
		try {
			List<Object[]> viewMenuTreeLists = super.executeSQL(sql);
			if (viewMenuTreeLists.size() < 1) {
				return null;
			}
			for (Object[] object : viewMenuTreeLists) {
				viewMenuTree = new ViewMenuTree();
				if (!String.valueOf(object[0]).equals("") && object[0] != null) {
					viewMenuTree.setMenuID(String.valueOf(object[0]));
				}
				if (!String.valueOf(object[1]).equals("") && object[1] != null) {
					viewMenuTree.setName(String.valueOf(object[1]));
				}
				viewMenuTreeList.add(viewMenuTree);
				viewMenuTree = null;
			}
		} catch (SkeletonException e) {

			e.printStackTrace();
		}
		return viewMenuTreeList;
	}

	@Override
	public List<ViewMenuTree> getMByR(String[] rolecIDs) {
		String sql = "select menu.menuID,menunameSimp,menupath,menulevel from menu where menu.menuID in (select menuID from roleforuserlinkmenu where roleID in(";
		for (int i = 0; i < rolecIDs.length; i++) {
			if (i == 0) {
				sql = sql + rolecIDs[i];
			} else {
				sql = sql + "," + rolecIDs[i];
			}

		}
		sql = sql + "))";

		List<ViewMenuTree> viewMenuTreeList = new ArrayList<ViewMenuTree>();
		ViewMenuTree viewMenuTree = null;
		try {
			List<Object[]> ml = super.executeSQL(sql);

			if (ml.size() < 1) {
				return null;
			} else {
				for (Object[] object : ml) {
					System.out.println(object.length + "---------------------");
					viewMenuTree = new ViewMenuTree();
					if (!String.valueOf(object[0]).equals("")
							&& object[0] != null) {
						viewMenuTree.setMenuID(String.valueOf(object[0]));
					}
					if (!String.valueOf(object[1]).equals("")
							&& object[1] != null) {
						viewMenuTree.setName(String.valueOf(object[1]));
					}
					if (!String.valueOf(object[2]).equals("")
							&& object[2] != null) {
						viewMenuTree.setMenupath(String.valueOf(object[2]));
					}
					if (!String.valueOf(object[3]).equals("")
							&& object[3] != null) {
						viewMenuTree.setMenulevel(String.valueOf(object[3]));
					}
					viewMenuTreeList.add(viewMenuTree);
					viewMenuTree = null;
				}
			}
		} catch (SkeletonException e) {

			e.printStackTrace();
		}
		System.out.println("------------------------");
		return viewMenuTreeList;
	}

	@Override
	public List<ViewMenuTree> getMByRL(List<String> rolecIDs) {
		String sql = "select menu.menuID,menunameSimp,menupath,menulevel from menu where menu.menuID in (select menuID from roleforuserlinkmenu where roleID in(";
		for (int i = 0; i < rolecIDs.size(); i++) {
			if (i == 0) {
				sql = sql + rolecIDs.get(i);
			} else {
				sql = sql + "," + rolecIDs.get(i);
			}

		}
		sql = sql + "))";
		List<ViewMenuTree> viewMenuTreeList = new ArrayList<ViewMenuTree>();
		ViewMenuTree viewMenuTree = null;
		try {
			List<Object[]> ml = super.executeSQL(sql);

			if (ml.size() < 1) {
				return null;
			} else {
				for (Object[] object : ml) {

					viewMenuTree = new ViewMenuTree();
					if (!String.valueOf(object[0]).equals("")
							&& object[0] != null) {
						viewMenuTree.setMenuID(String.valueOf(object[0]));
					}
					if (!String.valueOf(object[1]).equals("")
							&& object[1] != null) {
						viewMenuTree.setName(String.valueOf(object[1]));
					}
					if (!String.valueOf(object[2]).equals("")
							&& object[2] != null) {
						viewMenuTree.setMenupath(String.valueOf(object[2]));
					}
					if (!String.valueOf(object[3]).equals("")
							&& object[3] != null) {
						viewMenuTree.setMenulevel(String.valueOf(object[3]));
					}
					viewMenuTreeList.add(viewMenuTree);
					viewMenuTree = null;
				}
			}
		} catch (SkeletonException e) {

			e.printStackTrace();
		}

		return viewMenuTreeList;
	}

	@Override
	public List<ViewMenuTree> getMTreeByRC(String[] rcStr) {
		String sql = "select menu.menuID,menunameSimp,menupath,menulevel from Menu where menuID in (select distinct(menuID) from RoleForUserLinkMenu where RoleForUserLinkMenu.roleID in (";
		for (int i = 0; i < rcStr.length; i++) {
			if (i == 0) {
				sql = sql + rcStr[i];
			} else {
				sql = sql + "," + rcStr[i];
			}

		}
		sql = sql + "))";
		List<ViewMenuTree> viewMenuTreeList = new ArrayList<ViewMenuTree>();
		ViewMenuTree viewMenuTree;
		try {
			List<Object[]> viewMenuTreeLists = super.executeSQL(sql);
			if (viewMenuTreeLists.size() < 1) {
				return null;
			}
			for (Object[] object : viewMenuTreeLists) {
				viewMenuTree = new ViewMenuTree();
				if (!String.valueOf(object[0]).equals("") && object[0] != null) {
					viewMenuTree.setMenuID(String.valueOf(object[0]));
				}
				if (!String.valueOf(object[1]).equals("") && object[1] != null) {
					viewMenuTree.setName(String.valueOf(object[1]));
				}
				if (!String.valueOf(object[2]).equals("") && object[2] != null) {
					viewMenuTree.setMenupath(String.valueOf(object[2]));
				}
				if (!String.valueOf(object[3]).equals("") && object[3] != null) {
					viewMenuTree.setMenulevel(String.valueOf(object[3]));
				}
				viewMenuTreeList.add(viewMenuTree);
				viewMenuTree = null;
			}
		} catch (SkeletonException e) {
			e.printStackTrace();
		}
		return viewMenuTreeList;
	}

	@Override
	public List<RoleForUser> getRCByUser() {
		List<RoleForUser> rcl = new ArrayList<RoleForUser>();
		RoleForUser rc = null;
		String hql = "from RoleForUser";
		try {
			List cmlt = super.executeHql(hql);
			if (cmlt.size() < 1) {
				return null;
			} else {
				for (int i = 0; i < cmlt.size(); i++) {
					rc = (RoleForUser) cmlt.get(i);
					rcl.add(rc);
					rc = null;
				}
			}
		} catch (SkeletonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rcl;
	}

	@Override
	public List<RoleLinkUser> getRCCByUser(Integer userID) {
		String hql = "from RoleLinkUser where userID =" + userID;
		List<RoleLinkUser> rlcl = new ArrayList<RoleLinkUser>();
		RoleLinkUser rlc = null;

		try {
			List rlclt = super.executeHql(hql);
			if (rlclt.size() < 1) {
				return null;
			} else {
				for (int i = 0; i < rlclt.size(); i++) {
					rlc = (RoleLinkUser) rlclt.get(i);
					rlcl.add(rlc);
					rlc = null;
				}
			}
		} catch (SkeletonException e) {
			e.printStackTrace();
		}
		return rlcl;
	}

	@Override
	public List<RoleForUserLinkMenu> getRCML(List<String> IDStr, String roleID) {
		String hql = "from RoleForUserLinkMenu where roleID=" + roleID
				+ " and menuID in(";
		for (int i = 0; i < IDStr.size(); i++) {
			if (i == 0) {
				hql = hql + IDStr.get(i);
			} else {
				hql = hql + "," + IDStr.get(i);
			}
		}
		hql = hql + ")";
		List<RoleForUserLinkMenu> rcml = new ArrayList<RoleForUserLinkMenu>();
		RoleForUserLinkMenu rcm = null;
		try {
			List cml = super.executeHql(hql);
			if (cml.size() < 1) {
				return null;
			} else {
				for (int i = 0; i < cml.size(); i++) {
					rcm = (RoleForUserLinkMenu) cml.get(i);
					rcml.add(rcm);
					rcm = null;
				}
			}
		} catch (SkeletonException e) {

			e.printStackTrace();
		}
		return rcml;
	}

	@Override
	public List<RoleForUserLinkMenu> getRFCMR(Integer roleID) {
		String hql = "from RoleForUserLinkMenu where roleID=" + roleID;
		List<RoleForUserLinkMenu> rfcmList = new ArrayList<RoleForUserLinkMenu>();
		RoleForUserLinkMenu rfcm = null;
		try {
			List rfcml = super.executeHql(hql);
			if (rfcml.size() < 1) {
				return null;
			} else {
				for (int i = 0; i < rfcml.size(); i++) {
					rfcm = (RoleForUserLinkMenu) rfcml.get(i);
					rfcmList.add(rfcm);
					rfcm = null;
				}
			}
		} catch (SkeletonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rfcmList;
	}

	@Override
	public RoleLinkUser getRLC(Integer rolecID) {
		String hql = "from RoleLinkUser where roleID=" + rolecID;
		RoleLinkUser rlc = null;
		try {
			List rlcl = super.executeHql(hql);
			if (rlcl.size() < 1) {
				return null;
			}
			rlc = (RoleLinkUser) rlcl.get(0);
		} catch (SkeletonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rlc;
	}

	@Override
	public Class<ViewMenuTree> getEntityType() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @Description: TODO
	 * @param:@param userID
	 * @author Yin Yu
	 */
	@Override
	public void deleteUserMenusByUserID(Integer userID) {
		// TODO Auto-generated method stub
		String sql = "delete from userlinkmenu where userID=" + userID;
		try {
			super.executeSQLUpdate(sql);
		} catch (SkeletonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addRLM(List<RoleLinkUser> rlcs) {
		for (RoleLinkUser rlc : rlcs) {
			try {
				super.save(rlc);
			} catch (SkeletonSystemException e) {

				e.printStackTrace();
			}
		}
	}

	public void deleteCR(List<String> lessS, Integer userID) {
		String sql = "delete from rolelinkuser where userID=" + userID
				+ " and roleID in (";
		for (int i = 0; i < lessS.size(); i++) {
			if (i == 0) {
				sql = sql + lessS.get(i);
			} else {
				sql = sql + "," + lessS.get(i);
			}
		}
		sql = sql + ")";
		try {
			super.executeSQLUpdate(sql);
		} catch (SkeletonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteCMByS(List<ViewMenuTree> vmtl, Integer userID) {
		String sql = "delete from  userlinkmenu where userID =" + userID
				+ " and menuID in(";
		for (int i = 0; i < vmtl.size(); i++) {
			if (i == 0) {
				sql = sql + vmtl.get(i).getMenuID();
			} else {
				sql = sql + "," + vmtl.get(i).getMenuID();
			}
		}
		sql = sql + ")";
		try {
			super.executeSQLUpdate(sql);
		} catch (SkeletonException e) {
			e.printStackTrace();
		}
	}

	public void deleteRoleForUser(Integer roleID, Integer userID) {
		String sql = "delete from roleforuser where userID=" + userID
				+ " and roleID=" + roleID;
		try {
			super.executeSQLUpdate(sql);
		} catch (SkeletonException e) {

			e.printStackTrace();
		}
	}

	public void deleteRoleLinkUser(Integer roleID, Integer userID) {
		String sql = "delete from rolelinkuser where roleID=" + roleID
				+ " and userID=" + userID;
		try {
			super.executeSQLUpdate(sql);
		} catch (SkeletonException e) {

			e.printStackTrace();
		}
	}

	public void deleteRoleForUserLinkMenu(Integer roleID) {
		String sql = "delete from roleforuserlinkmenu where roleID=" + roleID;
		try {
			super.executeSQLUpdate(sql);
		} catch (SkeletonException e) {

			e.printStackTrace();
		}
	}

	public String checkUserRoleName(String roleName) {
		String sql = "select roleSimp from roleforuser where roleSimp='"
				+ roleName + "'";
		try {
			List<Object[]> objects = super.executeSQL(sql);
			if (objects != null && objects.size() > 0) {
				return String.valueOf(objects.get(0));
			}
		} catch (SkeletonException e) {

			e.printStackTrace();
		}
		return null;

	}

	// modify by xie xiumei
	public List<Menu> getMenuByID(List<String> menuIDs) {
		String hql = "from Menu where Status=" + Constants.Number.ZERO
				+ "and menutype=" + Constants.Number.ONE + "  and menuID in(";
		for (int i = 0; i < menuIDs.size(); i++) {
			if (i == 0) {
				hql = hql + menuIDs.get(i);
			} else {
				hql = hql + "," + menuIDs.get(i);
			}
		}
		hql = hql + ")";
		List<Menu> menus = new ArrayList<Menu>();
		try {
			List menuList = super.executeHql(hql);
			if (menuList != null && menuList.size() > 0) {
				for (int i = 0; i < menuList.size(); i++) {
					Menu menu = (Menu) menuList.get(i);
					menus.add(menu);
				}
			}
		} catch (SkeletonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menus;
	}

	// 根据菜单ID获取菜单 add by xie xiumei
	public Object[] getMenu(Integer menuID) {
		Object[] attr = null;
		String sql = "select SUBSTRING_INDEX(ml.menupath,'-',(ml.menulevel-1)) fathermenupath,"
				+ "(select count(*) from menu where menupath like ml.menupathlike AND menutype="
				+ Constants.Number.ONE
				+ ") chilnum ,ml.menupath "
				+ "from (select CONCAT(munulike.menupath , '-%') menupathlike,menupath,menulevel from menu munulike "
				+ "WHERE munulike.menuID="
				+ menuID
				+ " AND munulike.Status="
				+ Constants.Number.ZERO + ") ml";
		try {
			List temp = super.executeSQL(sql);
			if (temp != null && temp.size() > 0) {
				attr = (Object[]) temp.get(0);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return attr;
	}

	// 根据菜单level获取菜单
	public List<Menu> getMenuByLevel(Integer level) {
		String hql = "from Menu menu where menu.menulevel=" + level;
		List<Menu> menus = new ArrayList<Menu>();
		try {
			List menuList = super.executeHql(hql);
			if (menuList != null && menuList.size() > 0) {
				for (int i = 0; i < menuList.size(); i++) {
					Menu menu = (Menu) menuList.get(i);
					menus.add(menu);
				}
			}
		} catch (SkeletonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menus;
	}

	public List<ViewMenuTree> getViewMenuTreeByCompanyID(Integer companyID) {
		String sql = "select menuID,menunameSimp,menupath,menulevel from menu where menuID in (select menuID from companylinkmenu where companylinkmenu.companyID="
				+ companyID + ")";
		List<ViewMenuTree> viewMenuTreeList = new ArrayList<ViewMenuTree>();
		ViewMenuTree viewMenuTree;
		try {
			List<Object[]> viewMenuTreeLists = super.executeSQL(sql);
			if (viewMenuTreeLists.size() < 1) {
				return null;
			}
			for (Object[] object : viewMenuTreeLists) {
				viewMenuTree = new ViewMenuTree();
				if (!String.valueOf(object[0]).equals("") && object[0] != null) {
					viewMenuTree.setMenuID(String.valueOf(object[0]));
				}
				if (!String.valueOf(object[1]).equals("") && object[1] != null) {
					viewMenuTree.setName(String.valueOf(object[1]));
				}
				if (!String.valueOf(object[2]).equals("") && object[2] != null) {
					viewMenuTree.setMenupath(String.valueOf(object[2]));
				}
				if (!String.valueOf(object[3]).equals("") && object[3] != null) {
					viewMenuTree.setMenulevel(String.valueOf(object[3]));
				}
				viewMenuTreeList.add(viewMenuTree);
				viewMenuTree = null;
			}
		} catch (SkeletonException e) {
			e.printStackTrace();
		}
		return viewMenuTreeList;
	}

	@Override
	public RoleForUser getRoleForUserByRoleID(Integer roleID) {
		// TODO Auto-generated method stub
		List<UserLinkMenu> cml = new ArrayList<UserLinkMenu>();
		UserLinkMenu cm = null;
		try {
			List roleForUserList = super.executeHql("from RoleForUser as roleForUser where roleForUser.roleID="+roleID);
		      if(roleForUserList!=null&&roleForUserList.size()>0){
		    	  return  (RoleForUser) roleForUserList.get(0);
		      }
		} catch (SkeletonException e) {

			e.printStackTrace();
		}
		return null;
	}
	public List<ViewMenuTree> getTree(){
		String sql = "select menuID,menunameSimp,menupath,menulevel from Menu";
		List<ViewMenuTree> viewMenuTreeList = new ArrayList<ViewMenuTree>();
		ViewMenuTree viewMenuTree;
		try {
			List<Object[]> viewMenuTreeLists = super.executeSQL(sql);
			if (viewMenuTreeLists.size() < 1) {
				return null;
			}
			for (Object[] object : viewMenuTreeLists) {
				viewMenuTree = new ViewMenuTree();
				if (!String.valueOf(object[0]).equals("") && object[0] != null) {
					viewMenuTree.setMenuID(String.valueOf(object[0]));
				}
				if (!String.valueOf(object[1]).equals("") && object[1] != null) {
					viewMenuTree.setName(String.valueOf(object[1]));
				}
				if (!String.valueOf(object[2]).equals("") && object[2] != null) {
					viewMenuTree.setMenupath(String.valueOf(object[2]));
				}
				if (!String.valueOf(object[3]).equals("") && object[3] != null) {
					viewMenuTree.setMenulevel(String.valueOf(object[3]));
				}
				viewMenuTreeList.add(viewMenuTree);
				viewMenuTree = null;
			}
		} catch (SkeletonException e) {
			e.printStackTrace();
		}
		return viewMenuTreeList;
	}

}
