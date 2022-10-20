package com.arturmolla.jsondata.data;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.LinkedHashMap;
import java.util.Map;

@Entity
@Table(name = "multi_purpose_json")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class MultiPurposeJson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data",columnDefinition = "jsonb")
    @Type(type = "jsonb")
    private Map<String, Object> data = new LinkedHashMap<>();

    @JsonAnySetter
    public void setEntryInData(String key, Object value){
        this.data.put(key, value);
    }
}
