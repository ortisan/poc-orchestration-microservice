package com.ortiz.dto;

import lombok.Data;

@Data
public class PhoneDTO {
    private String id;
    private Integer ddi;
    private Integer ddd;
    private Integer number;
    private Integer extensionLine;
}
