package com.smbms.bill.dao;

import java.util.List;

import com.smbms.bill.pojo.SparePart;

/**
 * @author:Houchen
 * @Email:hc_1609@163.com
 * @version:
 * @createTime:2018/12/08 14:42:33
 */
public interface SparePartMapper {
	public int addOne(SparePart spare);

	public List<SparePart> selSome();
}
