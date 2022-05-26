package com.example.integratedsystem.Service;

import com.example.integratedsystem.dao.DonorRepo;
import com.example.integratedsystem.Entities.bloodDonor;
import net.sf.jasperreports.engine.*;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Optional;

@Service
@Configuration
public class JasperService {

    @Autowired
    private DonorRepo repo;

    public ResponseEntity<byte[]> generateCertificate(Integer no) throws FileNotFoundException, JRException {
        Optional<bloodDonor> donor = repo.findById(no);
        File file = ResourceUtils.getFile("src/main/resources/templates/Certificate.jrxml");
        JasperReport report = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRDataSource source = new JREmptyDataSource();
        HashMap<String, Object> map = new HashMap<>();
        map.put("donorName" , donor.get().getDonorName());
        map.put("date" , donor.get().getDate());
        JasperPrint printreport = JasperFillManager.fillReport(report, map, source);
        JasperExportManager.exportReportToPdfFile(printreport,"certificate.pdf");
        byte[] data = JasperExportManager.exportReportToPdf(printreport);
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=certificate.pdf");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
    }

}
