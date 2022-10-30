package com.example.portfolio.Dto;

public class EducacionDto {
    private String school;
    private String career;
    private String img;
    private String url;

    public EducacionDto() {
    }

    public EducacionDto(String school, String career, String img, String url) {
        this.school = school;
        this.career = career;
        this.img = img;
        this.url = url;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
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
