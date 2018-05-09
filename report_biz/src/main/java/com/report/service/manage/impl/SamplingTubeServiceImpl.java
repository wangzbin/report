package com.report.service.manage.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.report.common.constant.SamplingTubeConstants;
import com.report.common.pojo.SamplingTube;
import com.report.common.util.DateFormatUtil;
import com.report.common.util.ExcelUtils;
import com.report.common.util.StringUtil;
import com.report.common.util.WDWUtil;
import com.report.mapper.manage.SamplingTubeMapper;
import com.report.service.manage.SamplingTubeService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class SamplingTubeServiceImpl implements SamplingTubeService {


    @Autowired
    SamplingTubeMapper samplingTubeMapper;

    @Override
    public boolean addSamplingTubes(String name, MultipartFile sourceFile) {

        try {
            //转成file类型
            File file = ExcelUtils.multipartToFile(sourceFile);
            // 用来保存数据的集合
            ArrayList<SamplingTube> list = new ArrayList<>();


            String originalFilename = sourceFile.getOriginalFilename();


            //判断类型
            boolean isExcel2003 = WDWUtil.isExcel2003(originalFilename);
            Workbook wb = null;
            //当excel是2003时
            if(isExcel2003){
                wb = new HSSFWorkbook(new FileInputStream(file));
            }
            else{//当excel是2007时
                wb = new XSSFWorkbook(new FileInputStream(file));
            }

            // 读取工作簿
            Sheet sheet = wb.getSheetAt(0);
            // 遍历行
            for (Row row : sheet) {
                // 第一行是标题,这一行的数据不要
                if (row.getRowNum() == 0) {
                    continue;
                }
                SamplingTube samplingTube = new SamplingTube();
                samplingTube.setTubeNumber( row.getCell(0).getStringCellValue());
                samplingTube.setTubeState(SamplingTubeConstants.UNUSED);
                samplingTube.setTubeBinding(SamplingTubeConstants.UNBUND);
                samplingTube.setCreaterTime(DateFormatUtil.transForMilliSecond(new Date()));
                samplingTubeMapper.insertSelective(samplingTube);

            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int addSamplingTube(String tubeNumber) {

        //封装数据
        SamplingTube tube = new SamplingTube();
        tube.setTubeNumber(tubeNumber);
        tube.setTubeState(SamplingTubeConstants.UNUSED);
        tube.setTubeBinding(SamplingTubeConstants.UNBUND);
        tube.setCreaterTime(DateFormatUtil.transForMilliSecond(new Date()));
        //添加采样管
        int count = samplingTubeMapper.insertSelective(tube);
        return count;
    }

    @Override
    public void deleteTube(Integer id) {

        //废除采样管
        int count = samplingTubeMapper.deleteTube(id);



    }

    @Override
    public PageInfo<SamplingTube> getPageList(int page, int size,SamplingTube samplingTube) {

       //分页查询
        PageHelper.startPage(page, size);

        List<SamplingTube> samplingTubes = samplingTubeMapper.selectSamplingTubeByPaging(samplingTube);
        PageInfo<SamplingTube> pageInfo = new PageInfo<>(samplingTubes);
        return pageInfo;
    }


}