package com.mydemo.model.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class StudentSearchDto implements Serializable {

    private String name;

}
