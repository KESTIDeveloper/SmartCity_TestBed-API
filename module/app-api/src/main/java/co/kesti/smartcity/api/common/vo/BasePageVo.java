package co.kesti.smartcity.api.common.vo;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

/**
 * 기본 페이지 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class BasePageVo extends BaseVo {

    private static final long serialVersionUID = 1L;

    /* 행번호 */
    @Setter(AccessLevel.NONE)
    private int rowNum = 0;

    /* 현재인덱스 */
    @Setter(AccessLevel.NONE)
    private int rowIdx = 0;

    /* 행수 */
    private int rowCnt = 10;

    /* 전체건수 */
    private int totCnt = 0;

    /* 전체페이지 */
    @Setter(AccessLevel.NONE)
    private int totPage = 0;

    /* 현재페이지 */
    private int curPage = 1;

    /* 노출페이지 */
    private int dispPage = 5;

    /* 기준페이지 */
    @Setter(AccessLevel.NONE)
    private int stdPage = 0;

    /* 이전페이지 */
    @Setter(AccessLevel.NONE)
    private int prevPage = 0;

    /* 다음페이지 */
    @Setter(AccessLevel.NONE)
    private int nextPage = 0;

    /* 내비페이지목록 */
    @Setter(AccessLevel.NONE)
    private List<Integer> naviPageList;

    /**
     * 행번호 구하기
     */
    public int getRowNum() {
        if (this.totCnt > 0) {
            this.rowNum = this.totCnt - ((this.curPage - 1) * this.rowCnt);
        }

        return this.rowNum;
    }

    /**
     * 행인덱스 구하기 - 페이징 처리 offset
     */
    public int getRowIdx() {
        return (this.curPage - 1) * this.rowCnt;
    }

    /**
     * 행수 설정
     */
    public void setRowCnt(int rowCnt) {
        if (rowCnt < 1) {
            rowCnt = 10;
        }

        this.rowCnt = rowCnt;
    }

    /**
     * 전체페이지 구하기
     */
    public int getTotPage() {
        int totPage = 0;

        if (this.totCnt > 0 && this.rowCnt > 0) {
            totPage = (int) Math.ceil((double) this.totCnt / this.rowCnt);
        }

        return totPage;
    }

    /**
     * 현재페이지 설정
     */
    public void setCurPage(int curPage) {
        if (curPage < 1) {
            curPage = 1;
        }

        this.curPage = curPage;
    }

    /**
     * 노출페이지 설정 - 페이지 내비 노출수
     */
    public void setDispPage(int dispPage) {
        if (dispPage < 1) {
            dispPage = 5;
        }

        this.dispPage = dispPage;
    }

    /**
     * 기준페이지 구하기
     */
    public int getStdPage() {
        int stdPage = 0;

        if (this.curPage > 0 && this.dispPage > 0) {
            stdPage = ((int) Math.ceil((double) this.curPage / this.dispPage)) * this.dispPage - (this.dispPage - 1);
        }

        return stdPage;
    }

    /**
     * 이전페이지 구하기
     */
    public int getPrevPage() {
        return this.getStdPage() - 1;
    }

    /**
     * 다음페이지 구하기
     */
    public int getNextPage() {
        return this.getStdPage() + this.dispPage;
    }

    /**
     * 내비페이지목록 구하기
     */
    public List<Integer> getNaviPageList() {
        this.naviPageList = new ArrayList<>();
        int frstPage = this.getStdPage();
        int lastPage = this.getNextPage() - 1;
        int totPage = this.getTotPage();

        if (lastPage > totPage) {
            lastPage = totPage;
        }

        int pageCnt = lastPage - frstPage + 1;

        if (pageCnt > 0) {
            int m = 0;

            for (m = frstPage; m <= lastPage; m++) {
                this.naviPageList.add(m);
            }
        }

        return this.naviPageList;
    }

}
