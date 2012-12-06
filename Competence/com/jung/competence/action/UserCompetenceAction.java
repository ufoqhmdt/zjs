package com.jung.competence.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;

import com.jung.common.Constants;
import com.jung.common.ConvertUtil;
import com.jung.common.IDGenerator;
import com.jung.common.JqueryGridAction;
import com.jung.competence.model.RoleForUser;
import com.jung.competence.model.RoleForUserLinkMenu;
import com.jung.competence.model.RoleLinkUser;
import com.jung.competence.model.UserLinkMenu;
import com.jung.competence.model.ViewMenuTree;
import com.jung.competence.service.UserCompetenceService;
import com.jung.competence.util.CompetenceUtil;
import com.jung.employee.model.Employee;
import com.opensymphony.xwork2.ActionContext;


@Controller
public class UserCompetenceAction extends JqueryGridAction {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;
	private static final Log logger = LogFactory
			.getLog(UserCompetenceAction.class);
	private String menuTree;// 菜单树
	private String roleForUserMenus;// 创建角色时勾选的菜单
	private String roleName;// 角色名称
	private String roleID;// 用户角色ID

	private String checkedMenusID;// 用户角色已经拥有的菜单ID
	private String modifyCode;// 记录修改角色是否影响到使用该角色的用户
	private String userOwnRoleID;// 用户已经绑定的角色ID
	private String userID;// 用户ID
	private String result;// json result
	private List<RoleForUser> roleForUsers;// 能够分配给用户的所有角色
	private List<RoleLinkUser> userOwnedRoles;// 用户已经绑定的角色

//	private static final String FORWARD_MODIFY = "forwardModify";// 跳转到修改用户绑定的角色页面
	@Resource
	private UserCompetenceService userCompetenceService;
//	@Resource
//	private UserService userService;
	
	
	// 获取所有菜单，并封装成父、子菜单形式，最后转换为json格式传到前台页面
	public String getAllMenus() {
		menuTree = ViewMenuTree.convertMenuTreeToString(ViewMenuTree
				.composteMenuTree(userCompetenceService.getTree()), null);
		if (!menuTree.equals("")) {
			menuTree = CompetenceUtil.addSymbol(menuTree, '[', ']');
			return SUCCESS;
		}
		return FAIL;
	}

	// 添加用户角色
	public String addRoleForUser() {
		RoleForUser roleForUser = new RoleForUser();
		roleForUser.setRoleID(IDGenerator.getRoleID());
		try {
			roleName = new String(roleName.getBytes("ISO-8859-1"), "UTF-8");// form post提交中文乱码，ajax post不会乱码
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		roleForUser.setRoleSimp(roleName);
		roleForUser.setStatus(Constants.Number.ZERO);
		List<RoleForUserLinkMenu> roleForUserLinkMenus = new ArrayList<RoleForUserLinkMenu>();
		if (!roleForUserMenus.equals("")) {
			String roleForUserMenuArray[] = roleForUserMenus.split(",");
			for (String roleForUserMenu : roleForUserMenuArray) {
				RoleForUserLinkMenu roleForUserLinkMenu = new RoleForUserLinkMenu();
				roleForUserLinkMenu.setRfulmID(IDGenerator.getRfulmID());
				roleForUserLinkMenu.setRoleID(roleForUser.getRoleID());
				roleForUserLinkMenu.setMenuID(ConvertUtil
						.toInt(roleForUserMenu));
				roleForUserLinkMenus.add(roleForUserLinkMenu);
			}
		}
		userCompetenceService.addRoleForUser(roleForUser, roleForUserLinkMenus);
		logger.info("添加用户角色成功！");
		return "addRoleForUserSuccess";
	}

	// 删除角色、用户关联的角色、角色关联的菜单
	public String deleteRoleForUser() {
		userCompetenceService.deleteRoleForUser(Integer.parseInt(roleID),
				1);
		userCompetenceService.deleteRoleLinkUser(Integer.parseInt(roleID),
				1);
		userCompetenceService.deleteRoleForUserLinkMenu(Integer
				.parseInt(roleID));
		return SUCCESS;
	}

	// 检查角色名称是否重名,ajax
	public String checkUserRoleName() {
		String roleN = userCompetenceService.checkUserRoleName(roleName);
		if (roleN != null) {
			this.result = SUCCESS;
			return SUCCESS;
		} else {
			return FAIL;
		}
	}

	// 显示该角色已经拥有的菜单
	public String displayRoleOwnedMenus() {
		List<ViewMenuTree> checkedMenus = userCompetenceService
				.getCheckedM(Integer.parseInt(roleID));
		if (checkedMenus != null && checkedMenus.size() > 0) {
			menuTree = ViewMenuTree.convertMenuTreeToString(ViewMenuTree
					.composteMenuTree(userCompetenceService.getTree()),
					checkedMenus);
			roleName = checkedMenus.get(0).getName();
			// checkedMenusID格式:1,2,4,3
			checkedMenusID = CompetenceUtil.appendComma(checkedMenus);

		} else {
			roleName = userCompetenceService.getRoleForUserByRoleID(Integer.parseInt(roleID)).getRoleSimp();
			menuTree = ViewMenuTree.convertMenuTreeToString(ViewMenuTree
					.composteMenuTree(userCompetenceService.getTree()), null);
		}
		menuTree = CompetenceUtil.addSymbol(menuTree, '[', ']');
		return SUCCESS;
	}

	// 修改用户角色权限
	public String modifyRoleOwnedMenus() {
		String[] rfuMenuArray = null;
		if (!roleForUserMenus.equals("")) {
			rfuMenuArray = roleForUserMenus.split(",");// 获得所有选中的节点ID
		}
		List<RoleForUserLinkMenu> rfcmList = new ArrayList<RoleForUserLinkMenu>();
		List<RoleForUserLinkMenu> listRCM = userCompetenceService
					.getRFCMR(Integer.parseInt(roleID));
			if (listRCM != null) {
				userCompetenceService.deleteRoleForUserLinkMenu(listRCM);
			}
			if (rfuMenuArray != null) {
				for (String rfcm : rfuMenuArray) {
					RoleForUserLinkMenu rfclm = new RoleForUserLinkMenu();
					rfclm.setRfulmID(IDGenerator.getRfulmID());// 设置它的主键ID
					rfclm.setMenuID(Integer.parseInt(rfcm));
					rfclm.setRoleID(Integer.parseInt(roleID));
					rfcmList.add(rfclm);
				}
				userCompetenceService.addRoleForUserLinkMenu(rfcmList);
			}
		return SUCCESS;
	}

	// 显示能够分配给用户的所有角色
	public String displayUserOwnedRoles() {
//		List<RoleLinkUser> roleLinkUsers = userCompetenceService
//				.getRCCByUser(Integer.parseInt(userID));
//		if (roleLinkUsers != null && roleLinkUsers.size() > 0) {
//			return FORWARD_MODIFY;
//		}
		roleForUsers = userCompetenceService.getRCByUser();
		//判断是否有提供给用户绑定的角色
		if (roleForUsers != null) {
//			User user = userService.selByID(Integer.parseInt(userID));
//			if (user != null) {
//				roleName = user.getUserName();// 此处roleName代表userName
//			}
			return SUCCESS;
		} else {
			return FAIL;
		}
	}

	// 显示分配角色后的用户所拥有的菜单(没有点击微调)
	public String displayAssignedRoleMenus() {
		if (!roleName.equals("")) {
			String[] rcStr = roleName.split(",");
			// 根据角色ID查询这些角色的菜单
			listViewMenuTree = userCompetenceService.getMTreeByRC(rcStr);
			menuTree = ViewMenuTree.convertMenuTreeToString(ViewMenuTree
					.composteMenuTree(listViewMenuTree), null);
			menuTree = CompetenceUtil.addSymbol(menuTree, '[', ']');
			roleForUserMenus = CompetenceUtil.appendComma(listViewMenuTree);
		}
		return SUCCESS;
	}

	// 给用户分配角色(插入角色和菜单)
	public String assignRoleForUser() {
		if (!roleName.equals("")) {
			// 插入角色和用户信息
			String[] roleIDS = roleName.split(",");
			List<RoleLinkUser> rlcl = new ArrayList<RoleLinkUser>();
			RoleLinkUser rlc = null;
			for (String roleID : roleIDS) {
				rlc = new RoleLinkUser();
				rlc.setRluID(IDGenerator.getRluID());
				rlc.setUserID(1);
				rlc.setRoleID(Integer.parseInt(roleID));
				rlcl.add(rlc);
				rlc = null;
			}
			userCompetenceService.addRoleLinkUser(rlcl);
		}
//		if (!roleForUserMenus.equals("")) {
//			// 插入菜单和用户信息
//			String[] menuIDS = roleForUserMenus.split(",");
//			List<UserLinkMenu> clml = new ArrayList<UserLinkMenu>();
//			UserLinkMenu clm = null;
//			for (String menuID : menuIDS) {
//				clm = new UserLinkMenu();
//				clm.setUlmID(IDGenerator.getUlmID());
//				clm.setUserID(1);
//			//	clm.setCompanyID(CompetenceUtil.getCompany().getCompanyID());
//				clm.setMenuID(Integer.parseInt(menuID));
//				clml.add(clm);
//			}
//			userCompetenceService.addCLM(clml);
//		}
		logger.info("给用户角色分配成功！");
		return SUCCESS;
	}

	// 显示给用户分配角色后的菜单(点击微调)
	public String displayMinChangeAssignedRoleMenus() {
		if (!roleName.equals("")) {
			String[] rcStr = roleName.split(",");
			listViewMenuTree = userCompetenceService.getMTreeByRC(rcStr);
		}
		menuTree = ViewMenuTree.convertMenuTreeToString(ViewMenuTree
				.composteMenuTree(userCompetenceService.getTree()),
				listViewMenuTree);
		menuTree = CompetenceUtil.addSymbol(menuTree, '[', ']');
		return SUCCESS;
	}

	// 给用户分配,修改角色(微调后)
	public String assignRoleForUserAfterMinChange() {
		// 如果全部取消用户所拥有的角色，则删除RoleLinkMenu里面对应的记录
		if (!userOwnRoleID.equals("")) {
			List<String> userOwnedIDList = new ArrayList<String>();
			String userOwnedIDArray[] = userOwnRoleID.split(",");
			for (String userOwedID : userOwnedIDArray) {
				userOwnedIDList.add(userOwedID);
			}
			userCompetenceService.deleteCR(userOwnedIDList, Integer
					.parseInt(userID));
		}
		if (!roleName.equals("")) {
			String[] rfcNameS = roleName.split(",");// 新选中的角色
			if (roleForUserMenus.equals("")) {
				List<RoleLinkUser> rlcl = new ArrayList<RoleLinkUser>();
				for (String ss : rfcNameS) {
					RoleLinkUser rlc = new RoleLinkUser();
					rlc.setRluID(IDGenerator.getUlmID());
					rlc.setUserID(1);
					rlc.setRoleID(Integer.parseInt(ss));
					rlcl.add(rlc);
				}
				userCompetenceService.addRoleLinkUser(rlcl);
			} else {
				String[] rlcStrS = roleForUserMenus.split(",");// 原先用户具备的角色
				List<String> moreS = new ArrayList<String>();// 增多的角色
				List<String> lessS = new ArrayList<String>();// 减少的角色
				for (String rs : rfcNameS) {
					moreS.add(rs);
				}
				for (String rls : rlcStrS) {
					lessS.add(rls);
				}
				for (String rfcs : rfcNameS) {
					for (String rlcs : rlcStrS) {
						if (rfcs.equals(rlcs)) {
							moreS.remove(rfcs);
							lessS.remove(rlcs);
							break;
						}
					}

				}
				// 角色是否新增>1新增
				if (moreS.size() >= 1) {
					// 插入新增加的角色
					List<RoleLinkUser> rlcl = new ArrayList<RoleLinkUser>();
					for (String ss : moreS) {
						RoleLinkUser rlc = new RoleLinkUser();
						rlc.setRluID(IDGenerator.getUlmID());
						rlc.setUserID(1);
						rlc.setRoleID(Integer.parseInt(ss));
						rlcl.add(rlc);
					}
					userCompetenceService.addRoleLinkUser(rlcl);
				}
				// 角色是否减少!=null减少
				if (lessS.size() >= 1) {
					// 删除用户减少的角色
					userCompetenceService.deleteCR(lessS, Integer
							.parseInt(userID));
				}
			}
		}

		// 根据用户ID删除原用户与菜单关联的数据
		userCompetenceService.deleteUserMenusByUserID(Integer.parseInt(userID));
		if (!checkedMenusID.equals("")) {
			String[] menus = checkedMenusID.split(",");// 微调后用户的菜单
			// 插入用户与菜单 关联的数据
			List<UserLinkMenu> clmls = new ArrayList<UserLinkMenu>();
			for (String str : menus) {
				UserLinkMenu clm = new UserLinkMenu();
				clm.setUlmID(IDGenerator.getUlmID());// 设置主键
//				clm.setUserID(SystemSession.getUser().getUserID());// 设置用户ID
//				clm.setCompanyID(CompetenceUtil.getCompany().getCompanyID());
				clm.setMenuID(Integer.parseInt(str));// 设置菜单ID
				clmls.add(clm);
				clm = null;
			}
			userCompetenceService.addCLM(clmls);
		}
		return SUCCESS;
	}

	// 显示修改用户角色页面
	public String displayModifyUserOwnedRoles() {
		roleForUsers = userCompetenceService.getRCByUser();// 根据用户ID获取该用户的所有角色
		userOwnedRoles = userCompetenceService.getRCCByUser(1);// 根据用户ID获取该用户的所有已绑定的角色
		if (userOwnedRoles != null && userOwnedRoles.size() > 0) {
			roleForUserMenus = CompetenceUtil.appendComma(userOwnedRoles);
			if (roleForUsers != null && roleForUsers.size() > 0) {
				roleName = roleForUsers.get(0).getRoleSimp();
			}
		}
		return SUCCESS;
	}

	// 修改用户角色，没进行微调
	public String modifiyUserRole() {
		// 获取修改后的所有菜单
		String[] rfcNameS = null;
		if (!roleName.equals("")) {
			rfcNameS = roleName.split(",");// 新选中的角色
		}
		if (rfcNameS != null) {
			listViewMenuTree = userCompetenceService.getMByR(rfcNameS);// 获取新选中的角色对应的菜单
		}
		menuTree = ViewMenuTree.convertMenuTreeToString(ViewMenuTree
				.composteMenuTree(listViewMenuTree), null);
		menuTree = CompetenceUtil.addSymbol(menuTree, '[', ']');
		roleForUserMenus = CompetenceUtil.appendComma(listViewMenuTree);
		return SUCCESS;
	}

	// 没进行微调权限改变第二步
	public String modifyUserRoleSecondStep() {
		List<String> lessS = new ArrayList<String>();// 减少的角色
		List<String> moreS = new ArrayList<String>();// 增多的角色
		String[] rfcNameS = null;
		String[] rlcStrS = null;
		if (!roleName.equals("")) {
			rfcNameS = roleName.split(",");// 新选中的角色
			for (String rs : rfcNameS) {
				moreS.add(rs);
			}
		}
		if (!roleForUserMenus.equals("")) {
			rlcStrS = roleForUserMenus.split(",");// 原先用户具备的角色
			for (String rls : rlcStrS) {
				lessS.add(rls);
			}
		}
		if (rfcNameS != null && rlcStrS != null) {
			for (String rfcs : rfcNameS) {
				for (String rlcs : rlcStrS) {
					if (rfcs.equals(rlcs)) {

						moreS.remove(rfcs);

						lessS.remove(rlcs);

						break;
					}
				}
			}
		}
//		List<UserLinkMenu> clml = userCompetenceService.getUserLinkMenu(Integer
//				.parseInt(userID), 49);// 获取该机构原来角色对应的所有菜单
		// 角色是否新增
		if (moreS.size() >= 1) {
//			List<ViewMenuTree> vmtl = userCompetenceService.getMByRL(moreS);// 根据角色id集合查所有新增加的这些角色的菜单
			// 新增加的菜单插入用户中
//			if (vmtl != null && vmtl.size() > 0) {
//				List<Integer> clmlMenuIDList = new ArrayList<Integer>();
//				if (clml != null) {
//					for (UserLinkMenu clm : clml) {
//						clmlMenuIDList.add(clm.getMenuID());
//					}
//				}
//				List<UserLinkMenu> clmls = new ArrayList<UserLinkMenu>();
//				for (ViewMenuTree vmt : vmtl) {
//					if (!clmlMenuIDList.contains(Integer.parseInt(vmt
//							.getMenuID()))) {
//						UserLinkMenu clm = new UserLinkMenu();
//						clm.setUlmID(IDGenerator.getUlmID());
//					//	clm.setUserID(SystemSession.getUser().getUserID());
//						clm.setMenuID(Integer.parseInt(vmt.getMenuID()));
//						clmls.add(clm);
//						clm = null;
//					}
//				}
//				userCompetenceService.addCLM(clmls);
//			}
			List<RoleLinkUser> rlcs = new ArrayList<RoleLinkUser>();
			for (String str : moreS) {
				RoleLinkUser rlc = new RoleLinkUser();
				rlc.setRluID(IDGenerator.getRoleID());// 设置主键
				rlc.setUserID(1);
				rlc.setRoleID(Integer.parseInt(str));
				rlcs.add(rlc);
				rlc = null;
			}
			// 将新增用户角色 插入用户权限中
			userCompetenceService.addRLM(rlcs);
		}
		// 角色是否减少!=null减少
		if (lessS.size() > 0) {
//			List<ViewMenuTree> vmtl = userCompetenceService.getMByRL(lessS);// 根据角色id集合查所有减少的这些角色的菜单
			List<String> rlcStrl = new ArrayList<String>();// 原用户具有的角色
			for (String str : rlcStrS) {
				rlcStrl.add(str);
			}
			for (String str : rlcStrS) {
				for (int i = 0; i < lessS.size(); i++) {
					if (str.equals(lessS.get(i))) {
						rlcStrl.remove(str);
						break;
					}
				}
			}
			if (rlcStrl.size() > 0) {
				List<ViewMenuTree> vmtlo = userCompetenceService
						.getMByRL(rlcStrl);// 根据角色Id查找原角色减去剩余角色的菜单
//				if (vmtl != null && vmtl.size() > 1) {
//					for (int i = 0; i < vmtlo.size(); i++) {
//						for (int j = 0; j < vmtl.size(); j++) {
//							if (vmtl.get(j).getMenuID().equals(
//									vmtlo.get(i).getMenuID())) {
//								vmtl.remove(j);
//								break;
//							}
//						}
//					}
//					if (vmtl.size() > 0) {
//						userCompetenceService.deleteCMByS(vmtl, Integer
//								.parseInt(userID));// 删除公司与菜单
//					}
//				}
				userCompetenceService.deleteCR(lessS, 1);// 删除用户与角色关联的信息
			}
			// 取消绑定的角色
			if (rlcStrl.size() == 0) {
//				userCompetenceService.deleteCMByS(vmtl, Integer
//						.parseInt(userID));// 删除公司与菜单
				userCompetenceService.deleteCR(lessS, Integer.parseInt(userID));// 删除用户与角色关联的信息
			}
		}

		return SUCCESS;
	}

	public void setMenuTree(String menuTree) {
		this.menuTree = menuTree;
	}

	public String getMenuTree() {
		return this.menuTree;
	}

	public void setCheckedMenusID(String checkedMenusID) {
		this.checkedMenusID = checkedMenusID;
	}

	public String getCheckedMenusID() {
		return checkedMenusID;
	}

	public void setModifyCode(String modifyCode) {
		this.modifyCode = modifyCode;
	}

	public String getModifyCode() {
		return modifyCode;
	}

	public void setRoleForUsers(List<RoleForUser> roleForUsers) {
		this.roleForUsers = roleForUsers;
	}

	public List<RoleForUser> getRoleForUsers() {
		return roleForUsers;
	}

	/**
	 * @param userCompetenceService
	 *            the userCompetenceService to set
	 */
	@Resource
	public void setUserCompetenceService(
			UserCompetenceService userCompetenceService) {
		this.userCompetenceService = userCompetenceService;
	}

	/**
	 * @param userOwnRoleID
	 *            the userOwnRoleID to set
	 */
	public void setUserOwnRoleID(String userOwnRoleID) {
		this.userOwnRoleID = userOwnRoleID;
	}

	/**
	 * @return the userOwnRoleID
	 */
	public String getUserOwnRoleID() {
		return userOwnRoleID;
	}

	/**
	 * @return the userOwnedRoles
	 */
	public List<RoleLinkUser> getUserOwnedRoles() {
		return userOwnedRoles;
	}

	/**
	 * @param userOwnedRoles
	 *            the userOwnedRoles to set
	 */
	public void setUserOwnedRoles(List<RoleLinkUser> userOwnedRoles) {
		this.userOwnedRoles = userOwnedRoles;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public void setRoleForUserMenus(String roleForUserMenus) {
		this.roleForUserMenus = roleForUserMenus;
	}

	public String getRoleForUserMenus() {
		return roleForUserMenus;
	}

	List<ViewMenuTree> listViewMenuTree;

	public List<ViewMenuTree> getListViewMenuTree() {
		return listViewMenuTree;
	}

	public void setListViewMenuTree(List<ViewMenuTree> listViewMenuTree) {
		this.listViewMenuTree = listViewMenuTree;
	}

	/**
	 * @param userID
	 *            the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @return the roleID
	 */
	public String getRoleID() {
		return roleID;
	}

	/**
	 * @param roleID
	 *            the roleID to set
	 */
	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}

}
