package smbms.com.smbms.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.smbms.role.dao.RoleMapper;
import com.smbms.role.pojo.Role;
import com.smbms.unit.MybatisUtil;

/**
 * @author:Houchen
 * @Email:hc_1609@163.com
 * @version:
 * @createTime:2018/12/13 19:57:40
 */
public class RoleTest {
	Logger log = Logger.getLogger(RoleTest.class);

	@Test
	public void testAddRole() {
		Role r = new Role();
		r.setId(4);
		r.setRoleCode("测试code");
		r.setRoleName("测试name");
		r.setCreatedBy(1);
		r.setCreationDate(new Date());
		SqlSession sql = MybatisUtil.createSqlSeion();
		int count = sql.getMapper(RoleMapper.class).addRole(r);
		log.info("===============>" + count);
	}

	@Test
	public void testUpdateRole() {
		Role r = new Role();
		r.setId(4);
		r.setRoleCode("testcode");
		r.setRoleName("testname");
		r.setModifyBy(2);
		r.setModifyDate(new Date());
		SqlSession sql = MybatisUtil.createSqlSeion();
		int count = sql.getMapper(RoleMapper.class).updateRole(r);
		log.info("===============>" + count);
	}

	@Test
	public void testDeleteRole() {
		SqlSession sql = MybatisUtil.createSqlSeion(true);
		int count = sql.getMapper(RoleMapper.class).deleteRole(4);
		log.info("===============>" + count);
	}

	@Test
	public void testSelectByName() {
		SqlSession sql = MybatisUtil.createSqlSeion(true);
		String roleName = "员";
		Integer currentNo = 0;
		Integer page = 1;
		List<Role> roleList = sql.getMapper(RoleMapper.class).selectByName(roleName, currentNo, page);
		for (Role role : roleList) {
			log.info("角色名称：" + role.getRoleName() + "角色编号:" + role.getRoleCode());
		}
	}
}
