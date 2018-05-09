package com.report.common.util;

import com.report.common.pojo.BacterialReport;
import com.report.common.pojo.BigReport;
import com.report.common.pojo.PylumResult;
import com.report.common.pojo.UserReport;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by ling.zhang on 2016/12/29.
 */
public class ExcelUtils {


    //错误信息接收器
    private String errorMsg;

    //构造方法
    public ExcelUtils() {
    }

    //获取错误信息
    public String getErrorInfo() {
        return errorMsg;
    }

    /**
     * MultipartFile 转换成File
     *
     * @param multfile 原文件类型
     * @return File
     * @throws IOException
     */
    public static File multipartToFile(MultipartFile multfile) throws IOException {
        CommonsMultipartFile cf = (CommonsMultipartFile) multfile;
        //这个myfile是MultipartFile的
        DiskFileItem fi = (DiskFileItem) cf.getFileItem();
        File file = fi.getStoreLocation();
        //手动创建临时文件
        if (file.length() < 10240000) {
            File tmpFile = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") +
                    file.getName());
            multfile.transferTo(tmpFile);
            return tmpFile;
        }
        return file;
    }

    /**
     * 读EXCEL文件，获取报告信息集合
     *
     * @param
     * @return
     */
    public Map<String,Object> getExcelInfo(String fileName, MultipartFile Mfile) throws IOException {

        //转成file类型
        File file = multipartToFile(Mfile);
        //初始化
        Map<String, Object> hashMap = new HashMap<>();
        //初始化输入流
        InputStream is = null;
        try {
            //验证文件名是否合格
            if (!validateExcel(fileName)) {
                return null;
            }
            //根据文件名判断文件是2003版本还是2007版本
            boolean isExcel2003 = true;
            if (WDWUtil.isExcel2007(fileName)) {
                isExcel2003 = false;
            }
            //根据新建的文件实例化输入流
            is = new FileInputStream(file);
            //根据excel里面的内容读取报告信息
            hashMap = getExcelInfo(is, isExcel2003);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    is = null;
                    e.printStackTrace();
                }
            }
        }
        return hashMap;
    }


    /**
     * 验证EXCEL文件
     *
     * @param filePath
     * @return
     */
    public boolean validateExcel(String filePath) {
        if (filePath == null || !(WDWUtil.isExcel2003(filePath) || WDWUtil.isExcel2007(filePath))) {
            errorMsg = "文件名不是excel格式";
            return false;
        }
        return true;
    }


    /**
     * 根据excel里面的内容读取报告信息
     *
     * @param is          输入流
     * @param isExcel2003 excel是2003还是2007版本
     * @return
     * @throws IOException
     */
    public Map<String,Object> getExcelInfo(InputStream is, boolean isExcel2003) {

        //封装从excel读取的数据
        Map<String, Object> hashMap = new HashMap<>();
        //菌种表
        List<BigReport> bigReportList = null;
        //pylum表
        List<PylumResult> pylumResultList = null;

        try {
            // 根据版本选择创建Workbook的方式
            Workbook wb = null;
            //当excel是2003时
            if (isExcel2003) {
                wb = new HSSFWorkbook(is);
            } else {//当excel是2007时
                wb = new XSSFWorkbook(is);
            }
            //读取Excel里面客户的信息
            bigReportList = readSheetOneValue(wb);
            pylumResultList = readSheetTwoValue(wb);
            hashMap.put("bigReportList",bigReportList);
            hashMap.put("pylumResultList",pylumResultList);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    /**
     * 读取Excel里面species的信息
     *
     * @param wb
     * @return
     */
    private List<BigReport> readSheetOneValue(Workbook wb) {
        //初始化
        List<BigReport> bigReportList = new ArrayList<BigReport>();
        BigReport bigReport;


        //得到第一个shell
        Sheet sheet = wb.getSheetAt(0);
        for (Row row : sheet) {
            //第一行是标题。不要
            if (row.getRowNum() == 0) {
                continue;
            }


            //读取表格的数据
            bigReport = new BigReport();
            UserReport ur = new UserReport();
            ur.setReportTubeId(row.getCell(0).getStringCellValue());
            //待审核
            ur.setReportStatus(0);
            ur.setReportCreateTime(DateFormatUtil.transForMilliSecond(new Date()));


            //有益菌
            BacterialReport br = new BacterialReport();
            br.setBacteroidesUniformis(row.getCell(72).getNumericCellValue());
            br.setLactobacillusSalivarius(row.getCell(269).getNumericCellValue());
            br.setLactobacillusAcidophilus(row.getCell(241).getNumericCellValue());
            br.setLactobacillusFermentum(row.getCell(255).getNumericCellValue());

            br.setStreptococcusThermophilus(row.getCell(465).getNumericCellValue());
            br.setLactobacillusHelveticus(row.getCell(257).getNumericCellValue());
            br.setFaecalibacteriumPrausnitzii(row.getCell(205).getNumericCellValue());
            br.setLactobacillusJohnsonii(row.getCell(261).getNumericCellValue());

            br.setLactobacillusCasei(row.getCell(248).getNumericCellValue());
            br.setRoseburiaInulinivorans(row.getCell(407).getNumericCellValue());
            br.setLactococcusLactis(row.getCell(274).getNumericCellValue());
            br.setLactobacillusReuteri(row.getCell(265).getNumericCellValue());

            br.setClostridiumButyricum(row.getCell(117).getNumericCellValue());
            br.setBifidobacteriumAdolescentis(row.getCell(75).getNumericCellValue());
            br.setBifidobacteriumBifidum(row.getCell(78).getNumericCellValue());
            br.setBifidobacteriumAngulatum(row.getCell(76).getNumericCellValue());

            //有害菌


            br.setSalmonellaEnterica(row.getCell(415).getNumericCellValue());
            br.setCampylobacterJejuni(row.getCell(101).getNumericCellValue());
            br.setClostridiumPerfringens(row.getCell(126).getNumericCellValue());

            br.setKlebsiellaPneumoniae(row.getCell(237).getNumericCellValue());
            br.setBacteroidesFragilis(row.getCell(64).getNumericCellValue());
            br.setEnterobacterAerogenes(row.getCell(174).getNumericCellValue());

            //中性菌


            br.setBacteroidesStercoris(row.getCell(70).getNumericCellValue());
            br.setEscherichiaColi(row.getCell(191).getNumericCellValue());
            br.setStaphylococcusAureus(row.getCell(432).getNumericCellValue());

            br.setEnterococcusFaecium(row.getCell(181).getNumericCellValue());
            br.setEnterococcusFaecalis(row.getCell(180).getNumericCellValue());
            br.setVeillonellaParvula(row.getCell(489).getNumericCellValue());

            br.setStreptococcusSuis(row.getCell(464).getNumericCellValue());
            br.setStreptococcusAnginosus(row.getCell(437).getNumericCellValue());
            br.setFusobacteriumNucleatum(row.getCell(210).getNumericCellValue());

            bigReport.setUserReport(ur);
            bigReport.setBacterialReport(br);

            bigReportList.add(bigReport);
        }
        return bigReportList;
    }

    /**
     * 读取Excel的pylum的信息
     *
     * @param wb
     * @return
     */
    private List<PylumResult> readSheetTwoValue(Workbook wb) {
        //初始化
        List<PylumResult> pylumResultList = new ArrayList<PylumResult>();

        PylumResult pylumResult;
        //得到第二个Sheet
        Sheet sheet = wb.getSheetAt(1);
        for (Row row : sheet) {
            //第一行是标题。不要
            if (row.getRowNum() == 0) {
                continue;
            }
            pylumResult = new PylumResult();

            pylumResult.setTubeNumber(row.getCell(0).getStringCellValue());
            pylumResult.setSpirochaetes(row.getCell(1).getNumericCellValue());
            pylumResult.setVerrucomicrobia(row.getCell(2).getNumericCellValue());
            pylumResult.setLentisphaerae(row.getCell(3).getNumericCellValue());
            pylumResult.setChlamydiae(row.getCell(4).getNumericCellValue());

            pylumResult.setDeinococcusThermus(row.getCell(5).getNumericCellValue());
            pylumResult.setProteobacteria(row.getCell(6).getNumericCellValue());
            pylumResult.setFirmicutes(row.getCell(7).getNumericCellValue());
            pylumResult.setNitrospirae(row.getCell(8).getNumericCellValue());
            pylumResult.setBacteroidetes(row.getCell(9).getNumericCellValue());

            pylumResult.setChloroflexi(row.getCell(10).getNumericCellValue());
            pylumResult.setActinobacteria(row.getCell(11).getNumericCellValue());
            pylumResult.setTenericutes(row.getCell(12).getNumericCellValue());
            pylumResult.setUnknown(row.getCell(13).getNumericCellValue());
            pylumResult.setSynergistetes(row.getCell(14).getNumericCellValue());

            pylumResult.setFusobacteria(row.getCell(15).getNumericCellValue());
            pylumResult.setCyanobacteria(row.getCell(16).getNumericCellValue());
            pylumResult.setFibrobacteres(row.getCell(17).getNumericCellValue());
            pylumResult.setEuryarchaeota(row.getCell(18).getNumericCellValue());


            pylumResultList.add(pylumResult);

        }


        return pylumResultList;
    }
}