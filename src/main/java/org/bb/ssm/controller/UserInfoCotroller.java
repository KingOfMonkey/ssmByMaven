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
	 * �õ������û���Ϣ
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
	 * ͨ��handlerǰ������û�ҳ��
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/addUser",method= RequestMethod.GET)
	public String addUser(Map<String, Object> map){
		//��Ϊҳ��ʹ��spring��form��ǩ����������modelAttribute��Ҫ����bean Ҫ���ᱨ��
		map.put("command", new UserInfo());
		return "addUser";
	}
	
	/**
	 * ����û�����
	 * @param userinfo
	 * @return
	 */
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String save(UserInfo userinfo){
		int result = userInfoService.insert(userinfo);
		System.out.println("����û��Ĳ������Ϊ��"+result);
		return "redirect:/user/getAllUser";
	}
	/**
	 * ɾ���û�����
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") int id){
		int result = userInfoService.deleteByPrimaryKey(id);
		System.out.println("ɾ���û��Ĳ������Ϊ��"+result+"���ݽ�����idΪ��"+id);
		return "redirect:/user/getAllUser";
	}
	/**
	 * ����ǰ�ȸ���id�ҵ��û���Ϣ�����Ե�ҳ����
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
		System.out.println("ÿ��controller ���������ȵ�����Ŷ");
		if(id != null){
			System.out.println("update ����");
			map.put("userInfo", userInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  ����");
	}
	
	@RequestMapping(value="/addUser",method=RequestMethod.PUT)
	public String update(UserInfo userinfo){
		userInfoService.updateByPrimaryKey(userinfo);
		return "redirect:/user/getAllUser";
	}
}
