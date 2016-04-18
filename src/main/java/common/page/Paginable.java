package common.page;

/**
 * Created by Administrator on 2016/4/16.
 * 分页接口
 */
public interface Paginable {
    /**
     * 总记录数
     * @return
     */
    int getTotalCount();

    /**
     * 总页数
     * @return
     */
    int getTotalPage();

    /**
     * 每页记录数
     * @return
     */
    int getPageSize();

    /**
     * 当前页号
     * @return
     */
    int getPageNo();

    /**
     * 是否第一页
     * @return
     */
    boolean isFirstPage();

    /**
     * 是否最后一页
     * @return
     */
    boolean isLastPage();

    /**
     *下一页
     * @return
     */
    int getNextPage();

    /**
     * 上一页
     * @return
     */
    int getPrePage();

}
