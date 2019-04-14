package com.thread.responsetype.service.usermodel;

import javax.validation.constraints.*;

public class Usermodel {

    private Integer id;

    @NotBlank(message = "用户名不能为空")
    private String name;

    @NotNull(message = "性别不能不填")
    private Integer gerder;

    @NotNull(message = "手机号不能为空")
    @Min(value = 99999,message = "手机号位数过小")
    @Max(value = 999999,message = "手机号过大")
    private Integer telephone;

    private String registerMode;

    private String thirdPartyId;

    @NotBlank(message = "密码不能为空")
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
