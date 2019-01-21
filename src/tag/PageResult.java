package tag;

import java.util.ArrayList;
import java.util.List;
public class PageResult<E> {
	private List<E> list = new ArrayList<E>(); //查询结果
	private int pageNo = 1; //实际页号
	private int pageSize = 4; //每页记录数
	private int recTotal = 0; //总记录数
	
	public List getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRecTotal() {
		return recTotal;
	}
	public void setRecTotal(int recTotal) {
		this.recTotal = recTotal;
	}
	public int getPageTotal() {  //根据记录数计算总的页数
		int ret = (this.getRecTotal() - 1) / this.getPageSize() + 1;
		ret = (ret<1)?1:ret;
		return ret;
	}
	public int getFirstRec()  //计算第一页的记录数
	{
		int ret = (this.getPageNo()-1) * this.getPageSize();// + 1;
		ret = (ret < 1)?0:ret;
		return ret;
	}	
}
