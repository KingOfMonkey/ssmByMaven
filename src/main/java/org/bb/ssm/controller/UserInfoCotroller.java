package org.bb.ssm.controller;

import java.util.List;
import java.util.Map;

import org.bb.ssm.model.UserInfo;
import org.bb.ssm.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/user")
public class UserInfoCotroller {
	
	@Autowired
	private UserInfoService userInfoService;
	
	/**
	 * 得到所有用户信息
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getAllUser")
	public String getAllUser(Map<String, Object> map){
		List<UserInfo> userList = userInfoService.findAll();
		map.put("ALLUSER", userList);
		return "allUser";
	}
	/**
	 * 通过handler前往添加用户页面
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/addUser",method= RequestMethod.GET)
	public String addUser(Map<String, Object> map){
		//因为页面使用spring的form标签，其中属性modelAttribute需要存在bean 要不会报错
		map.put("command", new UserInfo());
		return "addUser";
	}
	
	/**
	 * 添加用户操作
	 * @param userinfo
	 * @return
	 */
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String save(UserInfo userinfo){
		int result = userInfoService.insert(userinfo);
		System.out.println("添加用户的操作结果为："+result);
		return "redirect:/user/getAllUser";
	}
	/**
	 * 删除用户操作
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = userInfoService.deleteByPrimaryKey(id);
		System.out.println("删除用户的操作结果为："+result+"传递进来的id为："+id);
		return "redirect:/user/getAllUser";
	}
	/**
	 * 更新前先根据id找到用户信息，回显到页面上
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id,Map<String, Object> map){
		map.put("command", userInfoService.selectByPrimaryKey(id));
		return "addUser";
	}
	
	@ModelAttribute
	public void getUserInfo(@RequestParam(value="userId",required=false) Integer id
			,Map<String, Object> map){
		System.out.println("每个controller 方法都会先调用我哦");
		if(id != null){
			System.out.println("update 操作");
			map.put("userInfo", userInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  操作");
	}
	
	@RequestMapping(value="/addUser",method=RequestMethod.PUT)
	public String update(UserInfo userinfo){
		userInfoService.updateByPrimaryKey(userinfo);
		return "redirect:/user/getAllUser";
	}
}
