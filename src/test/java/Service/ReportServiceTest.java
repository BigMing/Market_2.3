package Service;

import Dao.model.ReportInformation;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml","file:src/main/webapp/WEB-INF/spring-mybatis.xml"})


public class ReportServiceTest extends TestCase {

    @Autowired
    ReportService reportService;

    @Test
    public void testSaveReportInformation() throws Exception {
        ReportInformation reportInformation = new ReportInformation();
        reportInformation.setDescription("质量差");
        reportInformation.setSalegoodsid(1);
        reportInformation.setReporterid(5);
        System.out.print(reportService.saveReportInformation(reportInformation));
        //reportService.statistics();
    }
}