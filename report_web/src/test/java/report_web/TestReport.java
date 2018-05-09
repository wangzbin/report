package report_web;

import com.report.service.frontend.IUserReportService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class TestReport extends BaseTest {
    @Autowired
    private IUserReportService userReportService;

    @Test
    public void testReport() {
        userReportService.addCreateReport("SRR413588");
    }
}