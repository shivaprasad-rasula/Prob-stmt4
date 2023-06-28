package com.event.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServerResponse {
	private String serverName;
	private int status;
	private String applicationUrl;
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getApplicationUrl() {
		return applicationUrl;
	}
	public void setApplicationUrl(String applicationUrl) {
		this.applicationUrl = applicationUrl;
	}
	@Override
	public String toString() {
		return "ServerResponse [serverName=" + serverName + ", status=" + status + ", applicationUrl=" + applicationUrl
				+ "]";
	}
		
	
}
