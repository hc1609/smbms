package com.smbms.bill.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.smbms.bill.pojo.Bill;

/**
 * @author:Houchen
 * @Email:hc_1609@163.com
 * @version:
 * @createTime:2018/12/10 12:11:15
 */
public interface BillMapper {
	public List<Bill> selByNameId(Bill bill);

	/**
	 * 使用动态sql根据商品名，是否付款，供应商编号查询订单
	 * 
	 * @param name
	 * @param isPay
	 * @param id
	 * @return List<Bill>
	 */
	public List<Bill> selByLike(@Param("productName") String name, @Param("isPay") Integer isPay,
			@Param("providerId") Integer id);

	/**
	 * foreach 根据订单编号（模糊查询）、和指定的供应商列表查找订单，分页显示
	 * 
	 * @param billCode
	 * @param provList
	 * @return List<Bill>
	 */
	public List<Bill> selByCodeProvIds(Map<String, Object> map);
}
