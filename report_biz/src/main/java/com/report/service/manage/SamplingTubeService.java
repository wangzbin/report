package com.report.service.manage;

import com.github.pagehelper.PageInfo;
import com.report.common.pojo.SamplingTube;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

public interface SamplingTubeService {
    public boolean addSamplingTubes(String name, MultipartFile sourceFile);

    public int addSamplingTube(String tubeNumber);

    void deleteTube(Integer id);

    public PageInfo<SamplingTube> getPageList(int page, int size,SamplingTube samplingTube);
}
