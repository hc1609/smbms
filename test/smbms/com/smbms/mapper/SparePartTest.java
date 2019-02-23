package smbms.com.smbms.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.smbms.bill.dao.SparePartMapper;
import com.smbms.bill.pojo.SparePart;
import com.smbms.unit.MybatisUtil;

/**
 * @author:Houchen
 * @Email:hc_1609@163.com
 * @version:
 * @createTime:2018/12/08 14:52:03
 */
public class SparePartTest {
	Logger log = Logger.getLogger(SparePart.class);

	@Test
	public void testSelSome() {
		SqlSession sql = MybatisUtil.createSqlSeion();
		List<SparePart> list = sql.getMapper(SparePartMapper.class).selSome();
		for (SparePart sparePart : list) {
			log.info(sparePart.getId() + "  " + sparePart.getType() + "  " + sparePart.getPrice() + "  "
					+ sparePart.getDate());
		}
	}

	@Test
	public void testAddOne() {
		SparePart p = new SparePart();
		p.setType("CDMA-1");
		p.setPrice(new BigDecimal("650.78"));
		p.setDate(new java.sql.Date(new java.util.Date().getTime()));
		SqlSession sql = MybatisUtil.createSqlSeion();
		int i = sql.getMapper(SparePartMapper.class).addOne(p);
		log.info("=====================>" + i);
	}

	@Test
	public void testAddOne1() {
		SparePart p = new SparePart();
		p.setType("CDMA-2");
		p.setPrice(new BigDecimal("2356.23"));
		p.setDate(new java.sql.Date(new java.util.Date().getTime()));
		SqlSession sql = MybatisUtil.createSqlSeion();
		int i = sql.getMapper(SparePartMapper.class).addOne(p);
		log.info("=====================>" + i);
	}

	@Test
	public void testAddOne2() {
		SparePart p = new SparePart();
		p.setType("CDMA-3");
		p.setPrice(new BigDecimal("2200.76"));
		p.setDate(new java.sql.Date(2014 - 1970, 10 - 1, 5));
		SqlSession sql = MybatisUtil.createSqlSeion();
		int i = sql.getMapper(SparePartMapper.class).addOne(p);
		log.info("=====================>" + i);
	}
}
