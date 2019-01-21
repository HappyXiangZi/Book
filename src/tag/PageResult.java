package tag;

import java.util.ArrayList;
import java.util.List;
public class PageResult<E> {
	private List<E> list = new ArrayList<E>(); //��ѯ���
	private int pageNo = 1; //ʵ��ҳ��
	private int pageSize = 4; //ÿҳ��¼��
	private int recTotal = 0; //�ܼ�¼��
	
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
	public int getPageTotal() {  //���ݼ�¼�������ܵ�ҳ��
		int ret = (this.getRecTotal() - 1) / this.getPageSize() + 1;
		ret = (ret<1)?1:ret;
		return ret;
	}
	public int getFirstRec()  //�����һҳ�ļ�¼��
	{
		int ret = (this.getPageNo()-1) * this.getPageSize();// + 1;
		ret = (ret < 1)?0:ret;
		return ret;
	}	
}
