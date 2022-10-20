package com.arturmolla.jsondata.service;

import com.arturmolla.jsondata.data.MultiPurposeJson;
import com.arturmolla.jsondata.repo.JsonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class JsonService {

    @Autowired
    private JsonRepository repository;

    @Autowired
    private ObjectMapper mapper;

    public void createDataRecord(Map<String, Object> requestData) {
        var entity = new MultiPurposeJson();
        entity.setData(requestData);
        repository.save(entity);
    }

    public List<MultiPurposeJson> getAllDataRecord() {
        return repository.findAll();
    }
}
