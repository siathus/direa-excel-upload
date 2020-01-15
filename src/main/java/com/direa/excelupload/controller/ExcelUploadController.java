package com.direa.excelupload.controller;

import com.direa.excelupload.CustomException;
import com.direa.excelupload.vo.CommuteVO;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.AutoFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ExcelUploadController {

    @GetMapping("/excelUpload.do")
    public String excelUpload() {
        return "excelUpload";
    }

    @PostMapping("/excelUploadOk.do")
    public String excelUploadOk(HttpServletRequest request, HttpServletResponse response, MultipartFile[] files) {
        response.setContentType("text/html; charset=UTF-8");

        List<List<CommuteVO>> excelFileList = new ArrayList<>();

        for (MultipartFile file : files) {
            System.out.println("업로드된 파일명 : " + file.getOriginalFilename());
            System.out.println("파일의 타입 : " + file.getContentType());

            List<CommuteVO> commuteList = null;
            // 확장자가 xls인 경우에만 로직 수행
            if (file.getOriginalFilename().endsWith(".xls")) {
                try {
                    // Excel 파일
                    HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
                    // Sheet
                    HSSFSheet currentSheet;
                    // Row
                    HSSFRow currentRow;
                    // Cell
                    HSSFCell currentCell;

                    // VO
                    commuteList = new ArrayList<>();

                    for(int sheetIndex = 0 ; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
                        // 현재 Sheet 반환
                        currentSheet = workbook.getSheetAt(sheetIndex);
                        // row 탐색 for문
                        for (int rowIndex = 0; rowIndex < currentSheet.getPhysicalNumberOfRows(); rowIndex++) {
                            // row 0은 헤더정보이기 때문에 무시
//                            if (rowIndex != 0) {
                                // 현재 row 반환
                                currentRow = currentSheet.getRow(rowIndex);
                                String value = "";
                                // row의 첫번째 cell값이 비어있지 않은 경우 만 cell탐색
                                if (!"".equals(currentRow.getCell(0).getStringCellValue())) {
                                    CommuteVO commuteVO = new CommuteVO();
                                    // cell 탐색
                                    for (int cellIndex = 0; cellIndex < currentRow.getPhysicalNumberOfCells(); cellIndex++) {
                                        currentCell = currentRow.getCell(cellIndex);
                                        switch (currentCell.getCellTypeEnum()) {
                                            case FORMULA:
                                                value = currentCell.getCellFormula();
                                                break;
                                            case STRING:
                                                value = currentCell.getStringCellValue();
                                                break;
                                            case NUMERIC:
                                                value = currentCell.getNumericCellValue() + "";
                                                break;
                                            case BLANK:
                                                value = "";
                                                break;
                                            default:
                                                break;
                                        }
                                        System.out.print(value + "\t\t");
                                        // VO 생성 후 list에 추가
                                        try {
                                            commuteVO.setField(cellIndex, value);
                                        } catch (CustomException ce) {
                                            ce.printStackTrace();
                                        }
                                    }
                                    // 한 시트 내의 commuteVo정보 저장
                                    commuteList.add(commuteVO);

                                    System.out.println();
                                }
//                            }
                        }
                    }
                    // 파일 리스트에 commute 추가
                    excelFileList.add(commuteList);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("======================");

        }
        return null;
    }
}
