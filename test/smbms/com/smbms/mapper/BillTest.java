package smbms.com.smbms.mapper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.smbms.bill.dao.BillMapper;
import com.smbms.bill.pojo.Bill;
import com.smbms.unit.MybatisUtil;

/**
 * @author:Houchen
 * @Email:hc_1609@163.com
 * @version:
 * @createTime:2018/12/11 11:14:55
 */
public class BillTest {
	Logger log = Logger.getLogger(BillTest.class);

	/**
	 * 根据商品名称、供应商id、是否支付模糊查询商品订单
	 */
	@Test
	public void testSelByNameId() {
		// Bill bill = new Bill();
		// bill.setIsPayment(2);
		// bill.setProviderId(3);
		// bill.setProductName("米");
		// SqlSession sql = MybatisUtil.createSqlSeion();
		// List<Bill> list = sql.getMapper(BillMapper.class).selByNameId(bill);
		// for (Bill b : list) {
		// log.info("订单编码：" + b.getBillCode() + "，商品名称：" + b.getProductName() +
		// "，供应商名称：" + b.getProviderName()
		// + "，账单金额：" + b.getTotalPrice() + "，是否付款：" + (b.getIsPayment() == 1 ?
		// "未支付" : "已支付") + "，创建时间："
		// + new SimpleDateFormat("yyyy-MM-dd
		// HH:mm:ss").format(b.getCreationDate()));
		// }
	}

	/**
	 * 使用动态sql,根据（商品名称、供应商id、是否支付）组合模糊查询商品订单
	 */
	@Test
	public void testSelByLike() {
		String name = "海";
		Integer id = null;
		int isPay = 1;
		SqlSession sql = MybatisUtil.createSqlSeion();
		List<Bill> list = sql.getMapper(BillMapper.class).selByLike(name, isPay, id);
		for (Bill b : list) {

			log.info(b.getId() + "订单编码：" + b.getBillCode() + "，商品名称：" + b.getProductName() + b.getProv().getId()
					+ "，供应商名称：" + b.getProv().getProName() + "，账单金额：" + b.getTotalPrice() + "，是否付款："
					+ (b.getIsPayment() == 1 ? "未支付" : "已支付") + "，创建时间："
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(b.getCreationDate()));
		}
	}

	/**
	 * 使用foreach根据（商品名称、供应商id、是否支付）组合模糊查询商品订单，分页显示
	 */
	@Test
	public void testSelByCodeProvIds() {
		String code = "2016";
		List<Integer> idList = new ArrayList<Integer>();
		idList.add(1);
		idList.add(2);
		idList.add(3);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("billCode", code);
		map.put("idList", idList);
		map.put("currentNo", 0);
		map.put("page", 5);
		SqlSession sql = MybatisUtil.createSqlSeion();
		List<Bill> list = sql.getMapper(BillMapper.class).selByCodeProvIds(map);
		for (Bill b : list) {

			log.info(b.getId() + "订单编码：" + b.getBillCode() + "，商品名称：" + b.getProductName() + "供应商编号："
					+ b.getProv().getId() + "，供应商名称：" + b.getProv().getProName() + "，账单金额：" + b.getTotalPrice()
					+ "，是否付款：" + (b.getIsPayment() == 1 ? "未支付" : "已支付") + "，创建时间："
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(b.getCreationDate()));
		}
	}
}
