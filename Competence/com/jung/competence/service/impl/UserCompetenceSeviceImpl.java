package com.jung.competence.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.hp.util.PageContext;
import com.jung.common.PageContextNew;
import com.jung.competence.dao.UserCompetenceHibernateDao;
import com.jung.competence.model.Menu;
import com.jung.competence.model.RoleForUser;
import com.jung.competence.model.RoleForUserLinkMenu;
import com.jung.competence.model.RoleLinkUser;
import com.jung.competence.model.UserLinkMenu;
import com.jung.competence.model.ViewMenuTree;
import com.jung.competence.service.UserCompetenceService;

public class UserCompetenceSeviceImpl implements UserCompetenceService{

	@Resource
	private UserCompetenceHibernateDao userCompetenceHibernateDao;
	
	@Override
	public void addCLM(List<UserLinkMenu> clml) {
		// TODO Auto-generated method stub
		userCompetenceHibernateDao.addCLM(clml);
	}

	@Override
	public void addMoreM(List<RoleForUserLinkMenu> rcml,
			List<UserLinkMenu> clmlt) {
		// TODO Auto-generated method stub
		userCompetenceHibernateDao.addMoreM(rcml, clmlt);
	}

	@Override
	public void addRoleForUser(RoleForUser roleForUser,
			List<RoleForUserLinkMenu> listRCM) {
		// TODO Auto-generated method stub
		userCompetenceHibernateDao.addRoleForUser(roleForUser, listRCM);
	}

	@Override
	public void addRoleForUserLinkMenu(List<RoleForUserLinkMenu> rfcmList) {
		// TODO Auto-generated method stub
		userCompetenceHibernateDao.addRoleForUserLinkMenu(rfcmList);
	}

	@Override
	public void addRoleLinkUser(List<RoleLinkUser> rlcl) {
		// TODO Auto-generated method stub
		userCompetenceHibernateDao.addRoleLinkUser(rlcl);
	}

	@Override
	public void deleteRoleForUserLinkMenu(List<RoleForUserLinkMenu> listRCM) {
		// TODO Auto-generated method stub
		userCompetenceHibernateDao.deleteRoleForUserLinkMenu(listRCM);
	}

	@Override
	public void deleteUserLinkMenu(List<UserLinkMenu> cml) {
		// TODO Auto-generated method stub
		userCompetenceHibernateDao.deleteUserLinkMenu(cml);
	}

	@Override
	public List<ViewMenuTree> getCF(Integer rolecID) {
		// TODO Auto-generated method stub
		return userCompetenceHibernateDao.getCF(rolecID);
	}

	@Override
	public List<UserLinkMenu> getCLML(List<String> IDStr) {
		// TODO Auto-generated method stub
		return userCompetenceHibernateDao.getCLML(IDStr);
	}

	@Override
	public List<ViewMenuTree> getCheckedM(Integer roleID) {
		// TODO Auto-generated method stub
		return userCompetenceHibernateDao.getCheckedM(roleID);
	}

	@Override
	public List<ViewMenuTree> getMByR(String[] rolecIDs) {
		return userCompetenceHibernateDao.getMByR(rolecIDs);
	}

	@Override
	public List<ViewMenuTree> getMByRL(List<String> rolecIDs) {
		// TODO Auto-generated method stub
		return userCompetenceHibernateDao.getMByRL(rolecIDs);
	}

	@Override
	public List<ViewMenuTree> getMTreeByRC(String[] rcStr) {
		// TODO Auto-generated method stub
		return userCompetenceHibernateDao.getMTreeByRC(rcStr);
	}

	@Override
	public List<RoleForUser> getRCByUser() {
		// TODO Auto-generated method stub
		return userCompetenceHibernateDao.getRCByUser();
	}

	@Override
	public List<RoleLinkUser> getRCCByUser(Integer userID) {
		// TODO Auto-generated method stub
		return userCompetenceHibernateDao.getRCCByUser(userID);
	}

	@Override
	public List<RoleForUserLinkMenu> getRCML(List<String> IDStr, String rolecID) {
		// TODO Auto-generated method stub
		return userCompetenceHibernateDao.getRCML(IDStr, rolecID);
	}

	@Override
	public List<RoleForUserLinkMenu> getRFCMR(Integer rolecID) {
		// TODO Auto-generated method stub
		return userCompetenceHibernateDao.getRFCMR(rolecID);
	}

	@Override
	public RoleLinkUser getRLC(Integer rolecID) {
		// TODO Auto-generated method stub
		return userCompetenceHibernateDao.getRLC(rolecID);
	}

	@Override
	public List<UserLinkMenu> getUserLinkMenu(Integer userID,Integer companyID) {
		// TODO Auto-generated method stub
		return userCompetenceHibernateDao.getUserLinkMenu(userID,companyID);
	}

	public PageContext getEntityPage(PageContext pageContext,
			Map<String, String> queryConditions, String orderProperty,
			String orderMode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean support(String entityName) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	*  @Description: TODO
	*  @param:@param pageContext
	*  @param:@param queryConditions
	*  @param:@param orderProperty
	*  @param:@param orderMode
	*  @param:@return
	*  @author GuoJun mailto: jackson@highcolu.com
	*/
	public PageContextNew getEntityPage(PageContextNew pageContext,
			Map<String, String> queryConditions, String orderProperty,
			String orderMode) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	*  @Description: TODO
	*  @param:@param userID
	*  @author yinyu
	*/
	@Override
	public void deleteUserMenusByUserID(Integer userID) {
		// TODO Auto-generated method stub
		userCompetenceHibernateDao.deleteUserMenusByUserID(userID);
	}
	@Override
	public void addRLM(List<RoleLinkUser> rlcs){
		userCompetenceHibernateDao.addRLM(rlcs);
	}
	@Override
	public void deleteCR(List<String> lessS,Integer companyID){
		userCompetenceHibernateDao.deleteCR(lessS,companyID);
	}
	public void deleteCMByS(List<ViewMenuTree> vmtl, Integer userID){
		userCompetenceHibernateDao.deleteCMByS(vmtl,userID);
	}
	public void deleteRoleForUser(Integer roleID,Integer userID){
		userCompetenceHibernateDao.deleteRoleForUser(roleID,userID);
	}
	public void deleteRoleLinkUser(Integer roleID,Integer userID){
		userCompetenceHibernateDao.deleteRoleLinkUser(roleID,userID);
	}
	public void deleteRoleForUserLinkMenu(Integer roleID){
		userCompetenceHibernateDao.deleteRoleForUserLinkMenu(roleID);
	}
	public String checkUserRoleName(String roleName){
		return userCompetenceHibernateDao.checkUserRoleName(roleName);
	}
	public List<Menu> getMenuByID(List<String> menuIDs){
		return userCompetenceHibernateDao.getMenuByID(menuIDs);
	}
	
	/**
	 * 根据菜单ID获取菜单
	 * add by xie xiumei
	 */
	public Object[] getMenu(Integer menuID){
		return userCompetenceHibernateDao.getMenu(menuID);
	}
	//根据菜单level获取菜单
	public List<Menu> getMenuByLevel(Integer level){
		return userCompetenceHibernateDao.getMenuByLevel(level);
	}
	public List<ViewMenuTree> getViewMenuTreeByCompanyID(Integer companyID){
		return userCompetenceHibernateDao.getViewMenuTreeByCompanyID(companyID);
}

	@Override
	public RoleForUser getRoleForUserByRoleID(Integer roleID) {
		// TODO Auto-generated method stub
		return  userCompetenceHibernateDao.getRoleForUserByRoleID(roleID);
	}

	@Override
	public List<ViewMenuTree> getTree() {
		// TODO Auto-generated method stub
		return userCompetenceHibernateDao.getTree();
	}
}
