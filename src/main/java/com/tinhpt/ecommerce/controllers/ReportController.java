package com.tinhpt.ecommerce.controllers;

import com.tinhpt.ecommerce.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin(value = "*", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/api/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getReport(@RequestParam("from") @DateTimeFormat(pattern = "dd-MM-yyyy") Date startDate,
                                    @RequestParam("to") @DateTimeFormat(pattern = "dd-MM-yyyy") Date endDate) {
        try {
            return ResponseEntity.ok(reportService.getReport(startDate, endDate));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
