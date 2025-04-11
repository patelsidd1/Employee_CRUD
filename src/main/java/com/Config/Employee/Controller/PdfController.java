package com.Config.Employee.Controller;

import com.Config.Employee.Service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.ByteArrayInputStream;

@Controller
@RequestMapping("/pdf")
public class PdfController {

    @Autowired
    private PdfService pdfService;

    @GetMapping("/create-pdf")
    public ResponseEntity<InputStreamResource> createPdf(){

        ByteArrayInputStream pdf = pdfService.createPdf();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content_Disposition", "inliint-file=abc.pdf");
        return  ResponseEntity.ok().header(String.valueOf(httpHeaders)).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(pdf));



    }
}
