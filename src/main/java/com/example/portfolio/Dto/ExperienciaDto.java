package com.example.portfolio.Dto;

public class ExperienciaDto {
    private String position;
    private String company;
    private String img;
    private String url;

    public ExperienciaDto() {
    }

    public ExperienciaDto(String position, String company, String img, String url) {
        this.position = position;
        this.company = company;
        this.img = img;
        this.url = url;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
}
