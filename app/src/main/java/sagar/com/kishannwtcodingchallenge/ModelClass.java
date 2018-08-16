package sagar.com.kishannwtcodingchallenge;

public class ModelClass {

    public String name;
    public String mobile;
    public String date;
    public String otp;

    public ModelClass() {
    }

    public ModelClass(String name, String mobile, String date, String otp) {
        this.name = name;
        this.mobile = mobile;
        this.date = date;
        this.otp = otp;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
