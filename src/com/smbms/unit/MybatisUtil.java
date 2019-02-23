package com.smbms.unit;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author Houchen
 * @Email:hc_1609@163.com
 * @version
 * @createTime:2018/12/08 12:02:58
 */
public class MybatisUtil {
	private static SqlSessionFactory factory;

	static {
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static public SqlSession createSqlSeion() {
		return factory.openSession(true);
	}

	static public SqlSession createSqlSeion(boolean autoCommit) {
		return factory.openSession(autoCommit);
	}
}
