package com.Config.Employee.Controller;

import com.Config.Employee.Entity.Upload;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

// Take multiple file input in a single api

@RestController
@RequestMapping("/upload")
public class UploadingController {

    private Logger logger = LoggerFactory.getLogger(UploadingController.class);

    @Autowired
    ObjectMapper objectMapper;

    @PostMapping("/multiple")
    public ResponseEntity<?> addUserInformation(@RequestParam("upload") String upload,
                                                @RequestParam("file") MultipartFile file) {


        this.logger.info("Add User Info ");

        logger.info("File is uploaded {} ", file.getOriginalFilename());

        logger.info("upload {}", upload);
        try {
            Upload upload1 = objectMapper.readValue(upload, Upload.class);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Request  ");


        }
        return ResponseEntity.ok("Done");
    }

    @PostMapping("/images")
    public ResponseEntity<?> uploadMultipleImages(@RequestParam("images")MultipartFile[] file){

        this.logger.info("{} Number of files uploaded ",file.length);

        Arrays.stream(file).forEach(multipartFile -> {
            logger.info("file name : {} " ,multipartFile.getOriginalFilename());
            logger.info("file type : {} ", multipartFile.getContentType());
        });

        return ResponseEntity.ok("Images Uploaded Sucessfully");
    }

}
