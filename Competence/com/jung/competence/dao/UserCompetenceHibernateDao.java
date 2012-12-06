package com.jung.competence.dao;

import java.util.List;

import com.jung.competence.model.Menu;
import com.jung.competence.model.RoleForUser;
import com.jung.competence.model.RoleForUserLinkMenu;
import com.jung.competence.model.RoleLinkUser;
import com.jung.competence.model.UserLinkMenu;
import com.jung.competence.model.ViewMenuTree;


public interface UserCompetenceHibernateDao {
	
	//插入新的用户角色
	public void addRoleForUser(RoleForUser roleForUser,List<RoleForUserLinkMenu> listRCM);
	//根据角色Id获取选中的菜单ID
	public List<ViewMenuTree> getCheckedM(Integer roleID);
	//根据角色ID删除该角色的所有菜单记录
	public void deleteRoleForUserLinkMenu(List<RoleForUserLinkMenu> listRCM);
	//插入角色修改记录
	public void addRoleForUserLinkMenu(List<RoleForUserLinkMenu> rfcmList);
	//根据角色ID获取该角色与菜单记录
	public List<RoleForUserLinkMenu> getRFCMR(Integer rolecID);
	//根据用户角色获取角色与用户关联的记录
	public RoleLinkUser getRLC(Integer rolecID);
	//根据用户ID查出所有该用户的菜单
	public List<UserLinkMenu> getUserLinkMenu(Integer userID,Integer companyID);
	//插入多的菜单部分
	public void addMoreM(List<RoleForUserLinkMenu> rcml,List<UserLinkMenu> clmlt);
	//根据库用户角色查出用户在查出用户绑定的角色不包含该角色的对应的菜单
	public List<ViewMenuTree> getCF(Integer rolecID);
	//根据 菜单和用户ID查出角色与菜单关联的记录
	public List<RoleForUserLinkMenu> getRCML(List<String> IDStr,String rolecID);
	//根据菜单ID查出用户于菜单关联的Id
	public List<UserLinkMenu> getCLML(List<String> IDStr);
	//删除用户与菜单关联的记录
	public void deleteUserLinkMenu(List<UserLinkMenu> cml);
	public List<RoleForUser> getRCByUser();
	//根据角色获取ID 获取与子对应的菜单
	public List<ViewMenuTree> getMTreeByRC(String[] rcStr);
	//插入用户与角色的关联
	public void addRoleLinkUser(List<RoleLinkUser> rlcl);
	//插入用户与菜单的关联
	public void addCLM(List<UserLinkMenu> clml);
	//根据用户ID获取用户绑定的角色
	public List<RoleLinkUser> getRCCByUser(Integer userID);
	//根据用户角色ID集合查菜单
	public List<ViewMenuTree> getMByR(String[] rolecIDs);
	//根据用户角色ID集合查菜单
	public List<ViewMenuTree> getMByRL(List<String> rolecIDs);
	public void deleteUserMenusByUserID(Integer userID);
	public void addRLM(List<RoleLinkUser> rlcs);
	public void deleteCR(List<String> lessS,Integer companyID);
	public void deleteCMByS(List<ViewMenuTree> vmtl, Integer userID);
	
	public void deleteRoleForUser(Integer roleID,Integer userID);
	public void deleteRoleLinkUser(Integer roleID,Integer userID);
	public void deleteRoleForUserLinkMenu(Integer roleID);
	public String checkUserRoleName(String roleName);
	public List<Menu> getMenuByID(List<String> menuIDs);
	
	//根据菜单ID获取菜单
	public Object[] getMenu(Integer menuID);
	//根据菜单level获取菜单
	public List<Menu> getMenuByLevel(Integer level);
	//根据用户所属公司ID查询该公司有哪些菜单
	public List<ViewMenuTree> getViewMenuTreeByCompanyID(Integer companyID);
	//根据角色ID查找用户角色
	public RoleForUser getRoleForUserByRoleID(Integer roleID);
	public List<ViewMenuTree> getTree();
}
