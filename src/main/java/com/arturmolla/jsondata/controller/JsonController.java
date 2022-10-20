package com.arturmolla.jsondata.controller;

import com.arturmolla.jsondata.data.MultiPurposeJson;
import com.arturmolla.jsondata.service.JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/data")
public class JsonController {

    @Autowired
    private JsonService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createDataRecord(@RequestBody Map<String, Object> requestData){
        service.createDataRecord(requestData);
    }

    @GetMapping
    public ResponseEntity<List<MultiPurposeJson>> getAllDataRecord(){
        return new ResponseEntity<>(service.getAllDataRecord(), HttpStatus.OK);
    }
}
