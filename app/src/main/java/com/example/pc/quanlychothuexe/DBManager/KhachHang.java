package com.example.pc.quanlychothuexe.DBManager;

public class KhachHang {
    private int id;
    private String code;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String xe;
    private String biensoxe;
    private String mauxe;

    public KhachHang(){

    }

    public KhachHang(String code, String name, String email, String phone, String address, String xe,String biensoxe,String mauxe){
        this.code = code;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.xe = xe;
        this.biensoxe = biensoxe;
        this.mauxe = mauxe;
    }

    public KhachHang(int id, String code, String name, String email, String phone, String address, String xe, String biensoxe, String mauxe) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.xe = xe;
        this.biensoxe = biensoxe;
        this.mauxe = mauxe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getXe() {
        return xe;
    }

    public void setXe(String xe) {
        this.xe = xe;
    }

    public String getBiensoxe() {
        return biensoxe;
    }

    public void setBiensoxe(String biensoxe) {
        this.biensoxe = biensoxe;
    }

    public String getMauxe() {
        return mauxe;
    }

    public void setMauxe(String mauxe) {
        this.mauxe = mauxe;
    }

    @Override
    public String toString() {
        return "Code: "+getCode()+"Name: "+getName()+"Email: "+getEmail()+"Phone: "+ getPhone()
                +"Address:"+getAddress()+"Xe: "+getXe()+"Bien So Xe: "+getBiensoxe()+"Mau Xe: "+getMauxe();
    }
}
