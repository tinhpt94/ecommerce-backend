package com.tinhpt.ecommerce.serviceimplements;

import com.tinhpt.ecommerce.daos.ReportDAO;
import com.tinhpt.ecommerce.models.Report;
import com.tinhpt.ecommerce.services.ReportService;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("reportService")
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportDAO reportDAO;

    @Override
    public List<Report> getReport(Date startDate, Date endDate) {
        List<Report> reports = new ArrayList<>();
        DateTime jodaStartDate = new DateTime(startDate);
        DateTime jodaEndDate = new DateTime(endDate);
        Duration duration = new Duration(jodaStartDate, jodaEndDate);
        long durationDate = duration.getStandardDays() + 1;

        for (int i = 0; i < durationDate; i++) {
            Date reportDate = jodaStartDate.plusDays(i).toDate();
            Object[] reportData = (Object[]) reportDAO.getReport(reportDate);
            Report report;
            int orderAmount;
            try {
                orderAmount = ((BigInteger) reportData[0]).intValue();
            } catch (Exception e) {
                orderAmount = 0;
            }
            double totalCost;
            try {
                totalCost = ((Double) reportData[1]).intValue();
            } catch (Exception e) {
                totalCost = 0;
            }
            report = new Report(reportDate, orderAmount, totalCost);
            reports.add(report);
        }
        return reports;
    }
}
