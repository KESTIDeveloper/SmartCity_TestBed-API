package co.kesti.smartcity.component;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import co.kesti.smartcity.define.Define;

/**
 * 엑셀 뷰
 * @author atom
 * @since 2020.07.30
 */
@Component
public class ExcelView extends AbstractXlsView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) {
        // 헤더 목록
        @SuppressWarnings("unchecked")
        List<String> headList = (List<String>) model.get(Define.EXCEL_HAED_LIST);

        if (headList == null || headList.isEmpty()) {
            return ;
        }

        // 바디 목록
        @SuppressWarnings("unchecked")
        List<List<String>> bodyList = (List<List<String>>) model.get(Define.EXCEL_BODY_LIST);

        if (bodyList == null || bodyList.isEmpty()) {
            return ;
        }

        // 시트 생성
        HSSFSheet sheet = (HSSFSheet) workbook.createSheet();

        // 폰트 설정
        HSSFFont font = (HSSFFont) workbook.createFont();
        font.setFontName("맑은 고딕");
        font.setFontHeightInPoints((short) 9);

        // 헤더 셀 스타일
        HSSFCellStyle headCellStyle = (HSSFCellStyle) workbook.createCellStyle();
        headCellStyle.setBorderTop(BorderStyle.THIN);
        headCellStyle.setBorderLeft(BorderStyle.THIN);
        headCellStyle.setBorderRight(BorderStyle.THIN);
        headCellStyle.setBorderBottom(BorderStyle.THIN);
        headCellStyle.setAlignment(HorizontalAlignment.CENTER);
        headCellStyle.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
        headCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headCellStyle.setFont(font);

        // 바디 셀 스타일
        HSSFCellStyle bodyCellStyle = (HSSFCellStyle) workbook.createCellStyle();
        bodyCellStyle.setBorderTop(BorderStyle.THIN);
        bodyCellStyle.setBorderLeft(BorderStyle.THIN);
        bodyCellStyle.setBorderRight(BorderStyle.THIN);
        bodyCellStyle.setBorderBottom(BorderStyle.THIN);
        bodyCellStyle.setFont(font);

        // 헤더
        HSSFCell cell;
        HSSFRow row = sheet.createRow(0);
        int headCnt = headList.size();
        int m = 0;

        for (m = 0; m < headCnt; m++) {
            cell = row.createCell(m);
            cell.setCellValue(headList.get(m));
            cell.setCellStyle(headCellStyle);

            // 컬럼 넓이
            sheet.autoSizeColumn(m);
            sheet.setColumnWidth(m, (sheet.getColumnWidth(m)) + (8 * 256));
        }

        // 바디
        int dataCnt = 0;
        int rowIdx = 1;

        for (List<String> dataList : bodyList) {
            // 행 생성
            row = sheet.createRow(rowIdx);

            // 셀 설정
            dataCnt = dataList.size();

            for (m = 0; m < dataCnt; m++) {
                cell = row.createCell(m);
                cell.setCellValue(dataList.get(m));
                cell.setCellStyle(bodyCellStyle);
            }

            rowIdx++;
        }
    }

}
