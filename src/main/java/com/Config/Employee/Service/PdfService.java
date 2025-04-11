package com.Config.Employee.Service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class PdfService {

       private Logger logger = LoggerFactory.getLogger(PdfService.class);

       public ByteArrayInputStream createPdf(){
           logger.info("Pdf Started : ");

           String title = "Welcome to create Pdf ";
           String content = " Here you can get all type of data ";

           ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

           Document document = new Document();

           PdfWriter.getInstance(document,outputStream);
           document.open();

           Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,25);
           Paragraph paragraph = new Paragraph(title,titleFont);
            paragraph.setAlignment(Element.ALIGN_CENTER);

            document.add(paragraph);

            Font peraFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);

            Paragraph paragraph1 = new Paragraph();
            paragraph1.add(new Chunk("Choose  the chapter for learning  "));
            document.add(paragraph1);

            document.close();

           return  new ByteArrayInputStream(outputStream.toByteArray());


       }
}
