package com.capstone.domain;

import java.util.Date;

public class MessageVO {
	private int message_Num;
	private String send_Id;
	private String recv_Id;
	private Date send_Time;
	private Date read_Time;
	private String content;
	private int read_Chk;
	
	public int getMessage_Num() {
		return message_Num;
	}
	public void setMessage_Num(int message_Num) {
		this.message_Num = message_Num;
	}
	public String getSend_Id() {
		return send_Id;
	}
	public void setSend_Id(String send_Id) {
		this.send_Id = send_Id;
	}
	public String getRecv_Id() {
		return recv_Id;
	}
	public void setRecv_Id(String recv_Id) {
		this.recv_Id = recv_Id;
	}
	public Date getSend_Time() {
		return send_Time;
	}
	public void setSend_Time(Date send_Time) {
		this.send_Time = send_Time;
	}
	public Date getRead_Time() {
		return read_Time;
	}
	public void setRead_Time(Date read_Time) {
		this.read_Time = read_Time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRead_Chk() {
		return read_Chk;
	}
	public void setRead_Chk(int read_Chk) {
		this.read_Chk = read_Chk;
	}
	
	
}
