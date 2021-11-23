package com.stalin.java.basics;

import jdk.nashorn.internal.objects.annotations.Getter;

public enum UserRoleEnum {
    ROLE_ADMIN(1, "Administrator"),
    ROLE_MASTER_ADMIN(2, "Master Administrator"),
    ROLE_INTERNAL_USER(3, "Internal User"),
    ROLE_CUSTOMER(4, "Customer") {
        // @Override
        public String getFundTransferPath() {
            return "";
        }
    };

    private Integer code;
    private String description;

    private String Level;

    public String toString() {
        return "UserRole(code=" + this.getCode() + ", description=" + this.getDescription() + ")";
    }

    public static boolean isCustomer(UserRoleEnum userRole){
        return userRole == UserRoleEnum.ROLE_CUSTOMER;
    }

    private UserRoleEnum(final Integer code, final String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }
}