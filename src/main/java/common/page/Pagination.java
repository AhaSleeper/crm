package common.page;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/4/16.
 */
public class Pagination extends SimplePage implements Serializable{
    /**
     * 当前页的数据
     */
    private List<?> list;

    public Pagination(){
    }

    public Pagination(int pageNo, int pageSize, int totalCount){
        super(pageNo, pageSize, totalCount);
    }

    public Pagination(int pageNo, int pageSize, int totalCount, List<?> list){
        super(pageNo, pageSize, totalCount);
        this.list = list;
    }

    /**
     * 第一条数据的位置
     * @return
     */
    public int getFirstResult(){
        return (pageNo-1) * pageSize;
    }
    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}


