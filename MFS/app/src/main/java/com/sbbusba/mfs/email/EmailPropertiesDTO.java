package com.sbbusba.mfs.email;

public class EmailPropertiesDTO {

    private String fromAddress;
    private String fromName;
    private String password;
    private String adminAddress;
    private String adminName;
    public EmailPropertiesDTO() {}

    public EmailPropertiesDTO(String fromAddress, String fromName, String password) {

        this.fromAddress = fromAddress;
        this.fromName = fromName;
        this.password = password;
    }

    public EmailPropertiesDTO(String fromAddress, String fromName, String password, String adminAddress, String adminName) {
        this.fromAddress = fromAddress;
        this.fromName = fromName;
        this.password = password;
        this.adminAddress = adminAddress;
        this.adminName = adminName;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminAddress() {
        return adminAddress;
    }

    public void setAdminAddress(String adminAddress) {
        this.adminAddress = adminAddress;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
}
