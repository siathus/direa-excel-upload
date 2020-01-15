package com.direa.excelupload.controller;

import com.direa.excelupload.CustomException;
import com.direa.excelupload.elastic.ElasticAPI;
import com.direa.excelupload.vo.CommuteVO;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ExcelUploadController {

    @Autowired
    private ElasticAPI elasticAPI;

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

                    for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
                        // 현재 Sheet 반환
                        currentSheet = workbook.getSheetAt(sheetIndex);

                        System.out.println("=========== 현 시트의 총 Row 수 (컬럼명 포함) : " + currentSheet.getPhysicalNumberOfRows() + " ==============");
                        // row 탐색 for문
                        for (int rowIndex = 0; rowIndex < currentSheet.getPhysicalNumberOfRows(); rowIndex++) {
                            // row 0은 헤더정보이기 때문에 무시
                            if (rowIndex != 0) {
                                // 현재 row 반환
                                currentRow = currentSheet.getRow(rowIndex);
                                String value = "";

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
                                    // VO 생성 후 list에 추가
                                    try {
                                        commuteVO.setField(cellIndex, value);
                                    } catch (CustomException ce) {
                                        ce.printStackTrace();
                                    }
                                }
                                // 한 시트 내의 commuteVO 정보 저장
                                commuteList.add(commuteVO);

                            }
                        }
                        // 개발 시 검증용 전체목록 출력 메소드
//                        printCommuteVO(commuteList);

                        System.out.println("========== Sheet 내용 => CommuteVO 변환 완료 ===========");
                    }
                    // 파일 리스트에 commute 추가
                    excelFileList.add(commuteList);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("============================================");
        }

        // TODO Elastic API 구축되면 할 것
        /*
        for (List<CommuteVO> commuteVOList : excelFileList) {
            PrintWriter out = null;
            try {
                out = response.getWriter();
                out.println("<script>");

                // Elastic API 호출 후 boolean 결과값 받아옴

                if (elasticAPI.putCommuteIndex(commuteVOList)) {
                    out.println("alert('완료되었습니다.');");
                    out.println("location.href='/'");
                } else {
                    out.println("alert('실패했습니다.')");
                    out.println("location.href='/excelUpload.do'");
                }
                out.println("</script>");
            } catch (CustomException ce) {
                ce.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                out.close();
            }
        }
        */
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.println("<script>");
            out.println("alert('업로드가 완료됐습니다. index 페이지로 돌아갑니다.')");
            out.println("location.href='/'");
            out.println("</script>");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
        return null;
    }

    private void printCommuteVO(List<CommuteVO> commuteVOList) {
        for (int i = 0; i < commuteVOList.size(); i++) {
            CommuteVO commuteVO = commuteVOList.get(i);
            System.out.println((i + 1) + "번째 열 : " + commuteVO.toString());
        }
    }
}
