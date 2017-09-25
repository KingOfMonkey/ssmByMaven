package org.bb.ssm.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.bb.ssm.mapper.UserInfoMapper;
import org.bb.ssm.model.UserInfo;
import org.bb.ssm.service.UserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//可以消除xml中对bean的配置
@Service
// 此处使用spring的声明式事务，不在使用sqlsession和提交事务了
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

	@Resource
	/**
	 * @Resource的作用相当于@Autowired，只不过@Autowired按byType自动注入，
	 * 而@Resource默认按 byName自动注入罢了。@Resource有两个属性是比较重要的，
	 * 分是name和type，Spring将@Resource注解的name属性解析为bean的名字，
	 * 而type属性则解析为bean的类型。所以如果使用name属性，则使用byName的自动注入策略，
	 * 而使用type属性时则使用byType自动注入策略。如果既不指定name也不指定type属性，
	 * 这时将通过反射机制使用byName自动注入策略。 @Resource装配顺序
	 *                                                                  
	 *1.如果同时指定了name和type，则从Spring上下文中找到唯一匹配的bean进行装配，找不到则抛出异常
	 *2.
	 *如果指定了name，则从上下文中查找名称（id）匹配的bean进行装配，找不到则抛出异常
	 *3.
	 *如果指定了type，则从上下文中找到类型匹配的唯一bean进行装配，找不到或者找到多个，都会抛出异常
	 *4.
	 *如果既没有指定name，又没有指定type，则自动按照byName方式进行装配；如果没有匹配，则回退为一个原始类型进行匹配，如果匹配则自动装配；
	 */
	private UserInfoMapper mapper;

	/**
	 * 查询UserInfo表所有数据
	 */
	@Override
	public List<UserInfo> findAll() {
		List<UserInfo> list = mapper.findAll();
		return list;
	}
	
	@Override
	public int deleteByPrimaryKey(Integer userId) {
		return mapper.deleteByPrimaryKey(userId);
	}

	@Override
	public int insert(UserInfo record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(UserInfo record) {
		return mapper.insertSelective(record);
	}

	@Override
	public UserInfo selectByPrimaryKey(Integer userId) {
		return mapper.selectByPrimaryKey(userId);
	}

	@Override
	public int updateByPrimaryKeySelective(UserInfo record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(UserInfo record) {
		return mapper.updateByPrimaryKey(record);
	}

}
