package com.report.service.manage;

import org.springframework.web.multipart.MultipartFile;

public interface ReportService {
    public boolean addReport(String name, MultipartFile sourceFile);

    public Object selectReport(String tubeId);
}
