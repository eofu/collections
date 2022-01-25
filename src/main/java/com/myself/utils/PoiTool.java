package com.myself.utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PoiTool {
    public static void main(String[] args) {
        poi();
    }
    
    public static void poi() {
        String fileName = "工作簿1.xlsx";
        String realPath = "C:\\Users\\yangshuai\\Desktop\\" + fileName;
        parseSuccess(realPath, fileName);
    }
    
    private static void parseSuccess(String realPath, String fileName) {
        String[] pfix = fileName.split("\\.");
        String suffix = pfix[pfix.length - 1];
        if ("xlsx".equals(suffix)) {
            poiExcel(realPath);
        }
    }
    
    private static void poiExcel(String realPath) {
        
        try {
            File fileDes = new File(realPath);
            InputStream str = new FileInputStream(fileDes);
            // 利用poi读取excel文件流
            XSSFWorkbook xwb = new XSSFWorkbook(str);
            // 读取sheet的第一个工作表
            XSSFSheet st = xwb.getSheetAt(0);
    
            StringBuffer stringBuffer = new StringBuffer();
            String template = "    /**\n" +
                    "     * %s\n" +
                    "     */\n" +
                    "    @JSONField(name = \"%s\")\n" +
                    "    private %s %s;\n" +
                    "\n";
            for (int i = 0; i <= st.getLastRowNum(); i++) {
                XSSFRow row = st.getRow(i);
                String.format(
                        template,
                        row.getCell(2),
                        row.getCell(0),
                        row.getCell(1),
                        row.getCell(0).toString().substring(0, 1).toLowerCase() + row.getCell(0).toString().substring(1)
                );
                stringBuffer.append(String.format(
                        template,
                        row.getCell(2),
                        row.getCell(0),
                        row.getCell(1),
                        row.getCell(0).toString().substring(0, 1).toLowerCase() + row.getCell(0).toString().substring(1)
                ));
            }
            System.out.println(stringBuffer);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
