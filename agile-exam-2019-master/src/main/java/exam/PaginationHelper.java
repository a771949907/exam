package exam;

import java.util.List;

// TODO: 完成这个类

public class PaginationHelper<I> {

	private List<I> hehe=null;
	private int k; //每页元素个数
	private int p; //页数
    /**
     * 构造函数包含
     * 1）数组collection，表示需要分页的所有元素
     * 2）数字itemsPerPage，表示每页的元素个数
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
    	hehe=collection;
    	k=itemsPerPage;
    	p=hehe.size()/k;
    	p+=hehe.size()==p*k?0:1;
    }

    /**
     * 返回collection中所有元素的个数
     */
    public int itemCount() {
        return hehe.size();
    }

    /**
     * 返回页数
     */
    public int pageCount() {
        return p;
    }

    /**
     * 返回当前页pageIndex中所包含的元素个数
     * pageIndex从0开始计数
     * 如果pageIndex为非法值则返回-1
     */
    public int pageItemCount(int pageIndex) {
        int rs;
        if(pageIndex>=p||pageIndex<0) {
        	rs=-1;
        }else if(pageIndex==p-1){
        	rs=hehe.size()-k*(p-1);
        }else {
        	rs=k;
        }
        return rs;
    }

    /**
     * 返回第itemIndex个元素所在的页数
     * pageIndex从0开始计数
     * 如果itemIndex为非法值则返回-1
     */
    public int pageIndex(int itemIndex) {
    	int rs;
    	if(itemIndex>=hehe.size()||itemIndex<0) {
        	rs=-1;
        }
        else {
        	rs=(itemIndex+1)/k;
        	rs+=itemIndex+1==rs*k?0:1;  
        	rs--;  //因为pageIndex从0开始计数,所以要减去1
        }
    	return rs;
    }
}