package Controller;

import Dao.model.ReportInformation;
import Service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by li on 2014/9/10.
 */

@Controller
@RequestMapping("/report")
public class ReportController {
    @Autowired
    ReportService reportService;

    private static Logger logger = LoggerFactory.getLogger(CommentController.class);

    @ResponseBody
    @RequestMapping(value = "/{reportText}/{goodsId}/{userId}",method = RequestMethod.POST)
    public String addReport(@PathVariable String reportText,
                            @PathVariable int goodsId,
                            @PathVariable int userId){
        //System.out.println(reportText + goodsId + userId);
        ReportInformation reportInformation = new ReportInformation();
        reportInformation.setDescription(reportText);
        reportInformation.setSalegoodsid(goodsId);
        reportInformation.setReporterid(userId);
        return reportService.saveReportInformation(reportInformation);
    }
}
