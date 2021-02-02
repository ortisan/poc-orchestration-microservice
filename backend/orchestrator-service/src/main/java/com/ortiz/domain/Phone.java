package com.ortiz.domain;

import lombok.Data;


@Data
public class Phone {
    private boolean insert;
    private String id;
    private Integer ddi;
    private Integer ddd;
    private Integer number;
    private Integer extensionLine;
}
