package com.smbms.provider.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.smbms.provider.pojo.Provider;

/**
 * @author Houchen E-mail:hc_1609@163.com
 * @version createTime:2018/12/07 11:02:46����11:02:46
 */
public interface ProviderMapper {
	public int count();

	public List<Provider> queryAll();

	public int addOne(Provider prov);

	public int updateOne(Provider prov);

	/**
	 * 使用动态sql if-set修改供应商表
	 * 
	 * @param provider
	 * @return
	 */
	public int updateOneIfSet(Provider provider);

	/**
	 * 使用动态sql if-trim修改供应商表
	 * 
	 * @param provider
	 * @return
	 */
	public int updateOneIfTrim(Provider provider);

	public int deleteOne(@Param("id") Integer id);

	public Provider selBillById(@Param("id") Integer id);

	/**
	 * 使用if-where查询供应商表，分页显示
	 * 
	 * @param proCode
	 * @param proName
	 * @return List<Provider>
	 */
	public List<Provider> selByCodeNameIfWhere(@Param("proCode") String proCode, @Param("proName") String proName,
			@Param("currentNo") Integer currentNo, @Param("page") Integer page);

	/**
	 * 使用if-choose查询供应商表
	 * 
	 * @param proCode
	 * @param proName
	 * @return List<Provider>
	 */
	public List<Provider> selByCodeNameContactIfChoose(@Param("proCode") String proCode,
			@Param("proName") String proName, @Param("proContact") String proContact);
}
