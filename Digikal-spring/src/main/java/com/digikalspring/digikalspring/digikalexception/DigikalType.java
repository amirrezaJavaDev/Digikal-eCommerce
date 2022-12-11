package com.digikalspring.digikalspring.digikalexception;

public enum DigikalType {
    USER_NOT_FOUND(-101,"user not found"),
    REGISTERATION_FAIL(-103,"Register fail! fill with correct value please"),
    LOGIN_OPERATION_FAIL(-102,"username ro password is not valid!"),
    USER_REGISTED(-104,"user Registered before!"),
    PRODUCT_DTO_FAIL(-105,"product Operation failed!!");

    private int code;
    private String messageEng;

    DigikalType(int code, String messageFa) {
        this.code = code;
        this.messageEng = messageFa;
    }

    public String getMessageEng() {
        return messageEng;
    }
}
