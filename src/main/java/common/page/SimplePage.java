package common.page;

/**
 * Created by Administrator on 2016/4/16.
 */
public class SimplePage implements Paginable{

    protected int totalCount = 0;
    protected int pageSize = 20;
    protected int pageNo = 1;

    /**
     * 检查页码 checkPageNo
     * @param pageNo
     * @return
     */
    public static int cpn(Integer pageNo){
        return (pageNo == null || pageNo <1) ? 1 : pageNo;
    }

    public SimplePage(){
    }

    public SimplePage(int pageNo, int pageSize, int totalCount){
        setPageNo(pageNo);
        setPageSize(pageSize);
        setTotalCount(totalCount);
        adjustPageNo();
    }

    public void adjustPageNo(){
        if(pageNo==1){
            return;
        }
        int tp = getTotalPage();
        if(pageNo>tp){
            pageNo = tp;
        }
    }

    @Override
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * 总共多少页
     * @return
     */
    @Override
    public int getTotalPage() {
        int totalPage = totalCount/pageSize;
        if(totalPage==0 || totalCount%pageSize != 0){
            totalPage++;
        }
        return totalPage;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

    @Override
    public int getPageNo() {
        return pageNo;
    }

    @Override
    public boolean isFirstPage() {
        return pageNo <= 1;
    }

    @Override
    public boolean isLastPage() {
        return pageNo == getTotalPage();
    }

    @Override
    public int getNextPage() {
        if(isLastPage()){
            return pageNo;
        }
        return pageNo+1;
    }

    @Override
    public int getPrePage() {
        if (isFirstPage()){
            return pageNo;
        }
        return pageNo-1;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
}
