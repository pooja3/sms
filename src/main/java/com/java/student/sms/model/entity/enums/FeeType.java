package com.java.student.sms.model.entity.enums;

public enum FeeType {
    TYPE_1(1.0f),
    TYPE_2(1.1f),
    TYPE_3(1.21f),
    TYPE_4(1.32f),
    TYPE_5(1.43f),
    TYPE_6(1.54f),
    TYPE_7(1.65f),
    TYPE_8(1.76f),
    TYPE_9(1.89f),
    TYPE_10(1.98f),
    TYPE_11(2.09f),
    TYPE_12(2.29f);

    private final Float value;

    FeeType(float value) {
        this.value = value;
    }

    public Float getValue() {
        return this.value;
    }
}
