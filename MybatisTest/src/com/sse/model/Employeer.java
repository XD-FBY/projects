package com.sse.model;

/**
 * Created by Administrator on 2017/11/28.
 */
public class Employeer {
    private Integer employeer_id;
    private String employeer_name;
    private Integer employeer_age;
    private String employeer_department;
    private String employeer_worktype;
    public Employeer(){
        super();
    }

    public Integer getEmloyeer_id() {
        return employeer_id;
    }

    public String getEmployeer_name() {
        return employeer_name;
    }

    public Integer getEmployeer_age() {
        return employeer_age;
    }

    public String getEmployeer_department() {
        return employeer_department;
    }

    public String getEmployeer_worktype() {
        return employeer_worktype;
    }

    public void setEmloyeer_id(Integer emloyeer_id) {
        this.employeer_id = emloyeer_id;
    }

    public void setEmployeer_name(String employeer_name) {
        this.employeer_name = employeer_name;
    }

    public void setEmployeer_age(Integer employeer_age) {
        this.employeer_age = employeer_age;
    }

    public void setEmployeer_department(String employeer_department) {
        this.employeer_department = employeer_department;
    }

    public void setEmployeer_worktype(String employeer_worktype) {
        this.employeer_worktype = employeer_worktype;
    }
    @Override
    public String toString(){
        return "Employeer[employeer_id=" + employeer_id + ", employeer_name="
                + employeer_name + ", employeer_age=" + employeer_age
                + ", employeer_department=" + employeer_department
                + ", employeer_worktype=" + employeer_worktype + "]";
    }
}
