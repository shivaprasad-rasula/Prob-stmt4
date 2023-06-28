package com.event.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServerResponse {
	private String serverName;
	private int serverstatus;
	private String appUrl;
	
	
	
	@Override
	public String toString() {
		return "ServerResponse [serverName=" + serverName + ", serverstatus=" + serverstatus + ", appUrl=" + appUrl
				+ "]";
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	
	
	public int getServerstatus() {
		return serverstatus;
	}
	public void setServerstatus(int serverstatus) {
		this.serverstatus = serverstatus;
	}
	public String getAppUrl() {
		return appUrl;
	}
	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}
	
	
}
