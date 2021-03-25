package com.maktab.enums;

public enum TransportType {
    DOCUMENT("Document"), NON_DOCUMENT("Non_Document");

    private String type;

    TransportType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
