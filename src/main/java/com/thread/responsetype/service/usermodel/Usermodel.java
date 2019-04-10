package com.thread.responsetype.service.usermodel;

public class Usermodel {
    private Integer id;

    private String name;

    private Integer gerder;

    private Integer telephone;

    private String registerMode;

    private String thirdPartyId;

    private String password;

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Usermodel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gerder=" + gerder +
                ", telephone=" + telephone +
                ", registerMode='" + registerMode + '\'' +
                ", thirdPartyId='" + thirdPartyId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGerder() {
        return gerder;
    }

    public void setGerder(Integer gerder) {
        this.gerder = gerder;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getRegisterMode() {
        return registerMode;
    }

    public void setRegisterMode(String registerMode) {
        this.registerMode = registerMode;
    }

    public String getThirdPartyId() {
        return thirdPartyId;
    }

    public void setThirdPartyId(String thirdPartyId) {
        this.thirdPartyId = thirdPartyId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
