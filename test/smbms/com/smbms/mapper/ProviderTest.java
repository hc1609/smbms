package smbms.com.smbms.mapper;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.smbms.bill.pojo.Bill;
import com.smbms.provider.dao.ProviderMapper;
import com.smbms.provider.pojo.Provider;
import com.smbms.unit.MybatisUtil;

/**
 * @author Houchen E-mail:hc_1609@163.com
 * @version createTime:2018/12/07 11:27:46����11:27:46
 */
public class ProviderTest {
	Logger log = Logger.getLogger(ProviderTest.class);

	@Test
	public void testCount1() throws IOException {
		SqlSession sql = MybatisUtil.createSqlSeion();
		int count = sql.getMapper(ProviderMapper.class).count();
		log.debug("=========================>" + count);
	}

	@Test
	public void testCount2() throws IOException {
		SqlSession sql = MybatisUtil.createSqlSeion();
		int count = sql.selectOne("com.smbms.dao.ProviderMapper.count");
		log.debug("=========================>" + count);
	}

	@Test
	public void testQueryAll1() {
		SqlSession sql = MybatisUtil.createSqlSeion();
		List<Provider> list = sql.getMapper(ProviderMapper.class).queryAll();
		for (Provider provider : list) {
			log.info("=========================>" + provider.getProName());
		}
	}

	@Test
	public void testQueryAll2() {
		SqlSession sql = MybatisUtil.createSqlSeion();
		List<Provider> list = sql.selectList("com.smbms.dao.ProviderMapper.queryAll");
		for (Provider provider : list) {
			log.info("=========================>" + provider.getProName());
		}
	}

	@Test
	public void testSelBillById() {
		SqlSession sql = MybatisUtil.createSqlSeion();
		Provider prov = sql.getMapper(ProviderMapper.class).selBillById(1);
		log.info("供应商ID：" + prov.getId() + "，供应商名字：" + prov.getProName());
		for (Bill b : prov.getBills()) {
			log.info("商品名：" + b.getProductName());
		}
	}

	@Test
	public void testSelByCodeNameIfWhere() {
		String code = null;
		String name = null;
		SqlSession sql = MybatisUtil.createSqlSeion();
		List<Provider> prov = sql.getMapper(ProviderMapper.class).selByCodeNameIfWhere(code, name, 5, 5);
		for (Provider p : prov) {
			log.info("供应商ID：" + p.getProCode() + "，供应商名字：" + p.getProName());
		}

	}

	@Test
	public void testSelByCodeNameContactIfChoose() {
		String proCode = null;
		String proName = "深圳";
		String proContact = null;
		SqlSession sql = MybatisUtil.createSqlSeion();
		List<Provider> prov = sql.getMapper(ProviderMapper.class).selByCodeNameContactIfChoose(proCode, proName,
				proContact);
		for (Provider p : prov) {
			log.info("供应商ID：" + p.getProCode() + "，供应商名字：" + p.getProName());
		}

	}

	@Test
	public void testAddOne() throws IOException {
		SqlSession sql = MybatisUtil.createSqlSeion();
		Provider prov = new Provider();
		prov.setId(16);
		prov.setProAddress("测试地址");
		prov.setProCode("测试编码");
		prov.setProContact("测试联系人");
		prov.setProDesc("测试描述");
		prov.setProName("测试名称");
		prov.setProPhone("测试号码");
		int count = sql.getMapper(ProviderMapper.class).addOne(prov);
		log.debug("=========================>" + count);
	}

	@Test
	public void testUpdateOne() throws IOException {
		SqlSession sql = MybatisUtil.createSqlSeion();
		Provider prov = new Provider();
		prov.setId(16);
		prov.setProAddress("测试地址");
		prov.setProCode("测试编码");
		prov.setProContact("修改联系人");
		prov.setProDesc("测试描述");
		prov.setProName("修改名称");
		prov.setProPhone("测试号码");
		int count = sql.getMapper(ProviderMapper.class).updateOne(prov);
		log.debug("=========================>" + count);
	}

	@Test
	public void testUpdateOneIfset() throws IOException {
		SqlSession sql = MybatisUtil.createSqlSeion();
		Provider prov = new Provider();
		prov.setId(16);
		prov.setProCode("set修改编码");
		int count = sql.getMapper(ProviderMapper.class).updateOneIfSet(prov);
		log.debug("=========================>" + count);
	}

	@Test
	public void testUpdateOneIfTrim() throws IOException {
		SqlSession sql = MybatisUtil.createSqlSeion();
		Provider prov = new Provider();
		prov.setId(16);
		prov.setProCode("trim修改编码");
		int count = sql.getMapper(ProviderMapper.class).updateOneIfTrim(prov);
		log.debug("=========================>" + count);
	}

	@Test
	public void testDeleteOne() throws IOException {
		SqlSession sql = MybatisUtil.createSqlSeion();
		int count = sql.getMapper(ProviderMapper.class).deleteOne(16);
		log.debug("=========================>" + count);
	}
}
