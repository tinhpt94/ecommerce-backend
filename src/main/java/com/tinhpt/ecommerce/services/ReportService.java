package com.tinhpt.ecommerce.services;

import com.tinhpt.ecommerce.models.Report;

import java.util.Date;
import java.util.List;

public interface ReportService {
    List<Report> getReport(Date startDate, Date endDate);
}
