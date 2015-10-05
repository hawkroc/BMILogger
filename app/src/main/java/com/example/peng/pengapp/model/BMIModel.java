package com.example.peng.pengapp.model;

/**
 * Created by peng on 15/10/3.
 */
public class BMIModel extends BaseModel {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private int id;
    private String email;
    private String bmi;
    private String time;

    /**
     *
     * @param id
     * @param bmi
     * @param time
     */
    public BMIModel(int id,String bmi,String time){
        this.id=id;
        this.bmi=bmi;
        this.time=time;
    }

    /**
     *
     */
    public BMIModel(){

    }

}
