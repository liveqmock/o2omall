package com.hbird.common.utils.page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName:PageUtil Function: 分页工具类.
 * 
 * @author libin
 * @version
 * @since Ver 1.1
 * @Date Feb 13, 2012 12:54:28 PM
 */
public class PageUtil {

    private static final int TAIL_PAGE_NUM = -2;

    /** The cur page.当前页 */
    private int curPage = 1;

    /** The next page.下一页 */
    private int nextPage;

    /** The pre page. 上一页 */
    private int prePage;

    /** The total row. 总条数 */
    private int totalRow;

    /** The page size.每页条数 */
    private int pageSize = 10;

    /** The total page.总页数 */
    private int totalPage;

    /** The start. 开始条数 */
    private int start;

    /** The buttons. */
    private int[] buttons;

    /** 当前页条数 */
    private int curPageSize;

    /**
     * Instantiates a new page util.
     */
    public PageUtil() {

    }

    /**
     * Instantiates a new page util.
     * 
     * @param curPage
     *            the cur page
     */
    public PageUtil(int curPage) {
        this.curPage = curPage;
    }

    /**
     * Instantiates a new page util.
     * 
     * @param curPage
     *            the cur page
     * @param pageSize
     *            the page size
     */
    public PageUtil(int curPage, int pageSize) {
        this.curPage = curPage;
        this.pageSize = pageSize;
    }

    public int getCurPageSize() {
        return curPageSize;
    }

    public void setCurPageSize(int curPageSize) {
        this.curPageSize = curPageSize;
    }

    /**
     * Gets the cur page.
     * 
     * @return the cur page
     */
    public int getCurPage() {
        return curPage;
    }

    /**
     * Sets the cur page.
     * 
     * @param curPage
     *            the new cur page
     */
    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    /**
     * Gets the total row.
     * 
     * @return the total row
     */
    public int getTotalRow() {
        return totalRow;
    }

    /**
     * Sets the total row.
     * 
     * @param totalRow
     *            the new total row
     */
    public void setTotalRow(int totalRow) {
        this.totalRow = totalRow;
    }

    /**
     * Gets the page size.
     * 
     * @return the page size
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * Sets the page size.
     * 
     * @param pageSize
     *            the new page size
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * Gets the total page.
     * 
     * @return the total page
     */
    public int getTotalPage() {
        return totalPage;
    }

    /**
     * Sets the total page.
     * 
     * @param totalPage
     *            the new total page
     */
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    /**
     * Gets the next page.
     * 
     * @return the next page
     */
    public int getNextPage() {
        return nextPage;
    }

    /**
     * Sets the next page.
     * 
     * @param nextPage
     *            the new next page
     */
    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    /**
     * Gets the pre page.
     * 
     * @return the pre page
     */
    public int getPrePage() {
        return prePage;
    }

    /**
     * Sets the pre page.
     * 
     * @param prePage
     *            the new pre page
     */
    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    /**
     * Gets the start.
     * 
     * @return the start
     */
    public int getStart() {
        return start;
    }

    /**
     * Sets the start.
     * 
     * @param start
     *            the new start
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * Inits the.
     */
    public void init() {

        totalPage = (totalRow + pageSize - 1) / pageSize;
        if (totalRow == 0) {
            curPage = 1;
            totalPage = 1;
            curPageSize = 0;
        } else if (curPage > totalPage)
            curPage = totalPage;

        if (curPage < 1) {
            curPage = 1;
        }
        nextPage = (curPage < totalPage ? curPage + 1 : totalPage);
        prePage = (curPage - 1 > 1 ? curPage - 1 : 1);
        start = (curPage - 1) * pageSize;
        // curPageSize = totalRow > pageSize ? totalRow - curPage * pageSize
        // : totalRow;

        if (curPage == 1 && totalRow < pageSize) {
            curPageSize = totalRow;
        } else if (curPage == totalPage) {
            curPageSize = totalRow - ((totalPage - 1) * pageSize);

        } else {
            curPageSize = pageSize;
        }

        // if (currentPage > pageCount) currentPage = pageCount;
        initButtons();
    }

    /**
     * Inits the buttons.
     * 
     */
    private void initButtons() {

        List<Integer> list = new ArrayList<Integer>();
        if (prePage != 1) {
            list.add(-1);
        }
        // 添加第一页
        list.add(1);
        // 添加当前页之前页按钮
        if (curPage <= 4) {
            for (int i = 2; i <= curPage; i++) {
                list.add(i);
            }
        } else {
            list.add(0);
            for (int i = curPage - 2; i <= curPage; i++) {
                list.add(i);
            }
        }
        // 添加当前页之后页按钮
        if (curPage < (totalPage - 3)) {
            list.add(curPage + 1);
            list.add(curPage + 2);
            list.add(0);
        } else {
            for (int i = curPage + 1; i < totalPage; i++) {
                list.add(i);
            }
        }
        // 添加尾页
        if (curPage != totalPage) {
            list.add(totalPage);
        }
        if (nextPage != totalPage) {
            list.add(TAIL_PAGE_NUM);
        }
        buttons = convertIntegers(list);
    }

    /**
     * Convert integers.
     * 
     * @param integers
     *            the integers
     * @return the int[]
     */
    public static int[] convertIntegers(List<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

    /**
     * Gets the buttons.
     * 
     * @return the buttons
     */
    public int[] getButtons() {
        return buttons != null ? buttons.clone() : null;
    }

    /**
     * Sets the buttons.
     * 
     * @param buttons
     *            the new buttons
     */
    public void setButtons(int[] buttons) {
        this.buttons = buttons != null ? buttons.clone() : null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final int maxLen = 5;
        return "PageUtil [curPage="
                + curPage
                + ", nextPage="
                + nextPage
                + ", prePage="
                + prePage
                + ", totalRow="
                + totalRow
                + ", pageSize="
                + pageSize
                + ", totalPage="
                + totalPage
                + ", start="
                + start
                + ", "
                + (buttons != null ? "buttons="
                        + Arrays.toString(Arrays.copyOf(buttons, Math.min(buttons.length, maxLen))) : "") + "]";
    }

}
