package com.enumpackage;

import lombok.Data;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum  StatusEnum {
    PENDING("00","PENDING"),
    SUCCESS("01", "SUCCEESS");


    StatusEnum(String code, String value){
        this.code = code;
        this.value = value;
    }
    private String code;
    private String value;

    public static String parseCode(String code){
        /*for(StatusEnum statusEnum : StatusEnum.values()){
            if (statusEnum.getCode().equals(code)){
                return statusEnum.getValue();
            }
        }*/
        Arrays.stream(StatusEnum.values()).map(m -> {
            if(m.getCode().equals(code)) {
                return m.getValue();
            }
            return  null;
        }).toString();
        return null;
    }
    public static String parseValue(String value){
        for(StatusEnum statusEnum : StatusEnum.values()){
            if (statusEnum.getValue().equals(value)){
                return statusEnum.getCode();
            }
        }
        return null;
    }
    // 按照状态码返回枚举对象
    public static StatusEnum getEmpStatusByCode(String code) {
        switch (code) {
            case "00":
                return PENDING;
            case "01":
                return SUCCESS;

            default:
                return SUCCESS;
        }
    }

}
