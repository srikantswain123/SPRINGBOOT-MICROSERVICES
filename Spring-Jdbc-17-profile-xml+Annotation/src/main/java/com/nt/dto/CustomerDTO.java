package com.nt.dto;

public class CustomerDTO {
private String cname,cadd;
private float pamt;
private float rtintrest;
private int time;
public int getTime() {
	return time;
}
public void setTime(int time) {
	this.time = time;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getCadd() {
	return cadd;
}
public void setCadd(String cadd) {
	this.cadd = cadd;
}
public float getPamt() {
	return pamt;
}
public void setPamt(float pamt) {
	this.pamt = pamt;
}
public float getRtintrest() {
	return rtintrest;
}
public void setRtintrest(float rtintrest) {
	this.rtintrest = rtintrest;
}

}
