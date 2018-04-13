//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.crm.base.utils.excel;

import com.crm.base.utils.Encodes;
import com.crm.base.utils.Reflections;
import com.crm.base.utils.excel.annotation.ExcelField;
import com.google.common.collect.Lists;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExportExcel {
    private static Logger log = LoggerFactory.getLogger(ExportExcel.class);
    private SXSSFWorkbook wb;
    private Sheet sheet;
    private Map<String, CellStyle> styles;
    private int rownum;
    List<Object[]> annotationList;

    public ExportExcel(String title, Class<?> cls) {
        this(title, cls, 1);
    }

    public ExportExcel(String title, Class<?> cls, int type, int... groups) {
        this.annotationList = Lists.newArrayList();
        Field[] fs = cls.getDeclaredFields();
        Field[] var9 = fs;
        int var8 = fs.length;

        int g;
        int var14;
        int efg;
        int var18;
        for(int var7 = 0; var7 < var8; ++var7) {
            Field f = var9[var7];
            ExcelField ef = (ExcelField)f.getAnnotation(ExcelField.class);
            if (ef != null && (ef.type() == 0 || ef.type() == type)) {
                if (groups != null && groups.length > 0) {
                    boolean inGroup = false;
                    int[] var15 = groups;
                    var14 = groups.length;

                    for(g = 0; g < var14; ++g) {
                        g = var15[g];
                        if (inGroup) {
                            break;
                        }

                        int[] var19;
                        var18 = (var19 = ef.groups()).length;

                        for(efg = 0; efg < var18; ++efg) {
                            efg = var19[efg];
                            if (g == efg) {
                                inGroup = true;
                                this.annotationList.add(new Object[]{ef, f});
                                break;
                            }
                        }
                    }
                } else {
                    this.annotationList.add(new Object[]{ef, f});
                }
            }
        }

        Method[] ms = cls.getDeclaredMethods();
        Method[] var27 = ms;
        int var25 = ms.length;

        for(var8 = 0; var8 < var25; ++var8) {
            Method m = var27[var8];
            ExcelField ef = (ExcelField)m.getAnnotation(ExcelField.class);
            if (ef != null && (ef.type() == 0 || ef.type() == type)) {
                if (groups != null && groups.length > 0) {
                    boolean inGroup = false;
                    int[] var33 = groups;
                    int var32 = groups.length;

                    for(var14 = 0; var14 < var32; ++var14) {
                        g = var33[var14];
                        if (inGroup) {
                            break;
                        }

                        int[] var20;
                        int var34 = (var20 = ef.groups()).length;

                        for(var18 = 0; var18 < var34; ++var18) {
                            efg = var20[var18];
                            if (g == efg) {
                                inGroup = true;
                                this.annotationList.add(new Object[]{ef, m});
                                break;
                            }
                        }
                    }
                } else {
                    this.annotationList.add(new Object[]{ef, m});
                }
            }
        }

        Collections.sort(this.annotationList, new Comparator<Object[]>() {
            public int compare(Object[] o1, Object[] o2) {
                return (new Integer(((ExcelField)o1[0]).sort())).compareTo(new Integer(((ExcelField)o2[0]).sort()));
            }
        });
        List<String> headerList = Lists.newArrayList();

        String t;
        for(Iterator var26 = this.annotationList.iterator(); var26.hasNext(); headerList.add(t)) {
            Object[] os = (Object[])var26.next();
            t = ((ExcelField)os[0]).title();
            if (type == 1) {
                String[] ss = StringUtils.split(t, "**", 2);
                if (ss.length == 2) {
                    t = ss[0];
                }
            }
        }

        this.initialize(title, headerList);
    }

    public ExportExcel(String title, String[] headers) {
        this.annotationList = Lists.newArrayList();
        this.initialize(title, Lists.newArrayList(headers));
    }

    public ExportExcel(String title, List<String> headerList) {
        this.annotationList = Lists.newArrayList();
        this.initialize(title, headerList);
    }

    private void initialize(String title, List<String> headerList) {
        this.wb = new SXSSFWorkbook(500);
        this.sheet = this.wb.createSheet("Export");
        this.styles = this.createStyles(this.wb);
        Row headerRow;
        if (StringUtils.isNotBlank(title)) {
            headerRow = this.sheet.createRow(this.rownum++);
            headerRow.setHeightInPoints(30.0F);
            Cell titleCell = headerRow.createCell(0);
            titleCell.setCellStyle((CellStyle)this.styles.get("title"));
            titleCell.setCellValue(title);
            this.sheet.addMergedRegion(new CellRangeAddress(headerRow.getRowNum(), headerRow.getRowNum(), headerRow.getRowNum(), headerList.size() - 1));
        }

        if (headerList == null) {
            throw new RuntimeException("headerList not null!");
        } else {
            headerRow = this.sheet.createRow(this.rownum++);
            headerRow.setHeightInPoints(16.0F);

            int i;
            for(i = 0; i < headerList.size(); ++i) {
                Cell cell = headerRow.createCell(i);
                cell.setCellStyle((CellStyle)this.styles.get("header"));
                String[] ss = StringUtils.split((String)headerList.get(i), "**", 2);
                if (ss.length == 2) {
                    cell.setCellValue(ss[0]);
                    Comment comment = this.sheet.createDrawingPatriarch().createCellComment(new XSSFClientAnchor(0, 0, 0, 0, 3, 3, 5, 6));
                    comment.setString(new XSSFRichTextString(ss[1]));
                    cell.setCellComment(comment);
                } else {
                    cell.setCellValue((String)headerList.get(i));
                }

                this.sheet.autoSizeColumn(i);
            }

            for(i = 0; i < headerList.size(); ++i) {
                int colWidth = this.sheet.getColumnWidth(i) * 2;
                this.sheet.setColumnWidth(i, colWidth < 3000 ? 3000 : colWidth);
            }

            log.debug("Initialize success.");
        }
    }

    private Map<String, CellStyle> createStyles(Workbook wb) {
        Map<String, CellStyle> styles = new HashMap();
        CellStyle style = wb.createCellStyle();
        style.setAlignment((short)2);
        style.setVerticalAlignment((short)1);
        Font titleFont = wb.createFont();
        titleFont.setFontName("Arial");
        titleFont.setFontHeightInPoints((short)16);
        titleFont.setBoldweight((short)700);
        style.setFont(titleFont);
        styles.put("title", style);
        style = wb.createCellStyle();
        style.setVerticalAlignment((short)1);
        style.setBorderRight((short)1);
        style.setRightBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setBorderLeft((short)1);
        style.setLeftBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setBorderTop((short)1);
        style.setTopBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setBorderBottom((short)1);
        style.setBottomBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        Font dataFont = wb.createFont();
        dataFont.setFontName("Arial");
        dataFont.setFontHeightInPoints((short)10);
        style.setFont(dataFont);
        styles.put("data", style);
        style = wb.createCellStyle();
        style.cloneStyleFrom((CellStyle)styles.get("data"));
        style.setAlignment((short)1);
        styles.put("data1", style);
        style = wb.createCellStyle();
        style.cloneStyleFrom((CellStyle)styles.get("data"));
        style.setAlignment((short)2);
        styles.put("data2", style);
        style = wb.createCellStyle();
        style.cloneStyleFrom((CellStyle)styles.get("data"));
        style.setAlignment((short)3);
        styles.put("data3", style);
        style = wb.createCellStyle();
        style.cloneStyleFrom((CellStyle)styles.get("data"));
        style.setAlignment((short)2);
        style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setFillPattern((short)1);
        Font headerFont = wb.createFont();
        headerFont.setFontName("Arial");
        headerFont.setFontHeightInPoints((short)10);
        headerFont.setBoldweight((short)700);
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(headerFont);
        styles.put("header", style);
        return styles;
    }

    public Row addRow() {
        return this.sheet.createRow(this.rownum++);
    }

    public Cell addCell(Row row, int column, Object val) {
        return this.addCell(row, column, val, 0, Class.class);
    }

    public Cell addCell(Row row, int column, Object val, int align, Class<?> fieldType) {
        Cell cell = row.createCell(column);
        CellStyle style = (CellStyle)this.styles.get("data" + (align >= 1 && align <= 3 ? align : ""));

        try {
            if (val == null) {
                cell.setCellValue("");
            } else if (val instanceof String) {
                cell.setCellValue((String)val);
            } else if (val instanceof Integer) {
                cell.setCellValue((double)((Integer)val).intValue());
            } else if (val instanceof Long) {
                cell.setCellValue((double)((Long)val).longValue());
            } else if (val instanceof Double) {
                cell.setCellValue(((Double)val).doubleValue());
            } else if (val instanceof Float) {
                cell.setCellValue((double)((Float)val).floatValue());
            } else if (val instanceof Date) {
                DataFormat format = this.wb.createDataFormat();
                style.setDataFormat(format.getFormat("yyyy-MM-dd"));
                cell.setCellValue((Date)val);
            } else if (fieldType != Class.class) {
                cell.setCellValue((String)fieldType.getMethod("setValue", Object.class).invoke((Object)null, val));
            } else {
                cell.setCellValue((String)Class.forName(this.getClass().getName().replaceAll(this.getClass().getSimpleName(), "fieldtype." + val.getClass().getSimpleName() + "Type")).getMethod("setValue", Object.class).invoke((Object)null, val));
            }
        } catch (Exception var9) {
            log.info("Set cell value [" + row.getRowNum() + "," + column + "] error: " + var9.toString());
            cell.setCellValue(val.toString());
        }

        cell.setCellStyle(style);
        return cell;
    }

    /**
     * 添加数据（通过annotation.ExportField添加数据）
     * @return list 数据列表
     */
    public <E> ExportExcel setDataList(List<E> list){
        for (E e : list){
            int colunm = 0;
            Row row = this.addRow();
            StringBuilder sb = new StringBuilder();
            for (Object[] os : annotationList){
                ExcelField ef = (ExcelField)os[0];
                Object val = null;
                // Get entity value
                try{
                    if (StringUtils.isNotBlank(ef.value())){
                        val = Reflections.invokeGetter(e, ef.value());
                    }else{
                        if (os[1] instanceof Field){
                            val = Reflections.invokeGetter(e, ((Field)os[1]).getName());
                        }else if (os[1] instanceof Method){
                            val = Reflections.invokeMethod(e, ((Method)os[1]).getName(), new Class[] {}, new Object[] {});
                        }
                    }
                    // If is dict, get dict label
                    if (StringUtils.isNotBlank(ef.dictType())){
                        //val = DictUtils.getDictLabel(val==null?"":val.toString(), ef.dictType(), "");
                    }
                }catch(Exception ex) {
                    // Failure to ignore
                    log.info(ex.toString());
                    val = "";
                }
                this.addCell(row, colunm++, val, ef.align(), ef.fieldType());
                sb.append(val + ", ");
            }
            log.debug("Write success: ["+row.getRowNum()+"] "+sb.toString());
        }
        return this;
    }

    public ExportExcel write(OutputStream os) throws IOException {
        this.wb.write(os);
        return this;
    }

    public ExportExcel write(HttpServletResponse response, String fileName) throws IOException {
        response.reset();
        response.setContentType("application/octet-stream; charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=" + Encodes.urlEncode(fileName));
        this.write(response.getOutputStream());
        return this;
    }

    public ExportExcel writeFile(String name) throws FileNotFoundException, IOException {
        FileOutputStream os = new FileOutputStream(name);
        this.write(os);
        return this;
    }

    public ExportExcel dispose() {
        this.wb.dispose();
        return this;
    }
}
