package net.util;

public class LogBean {
	private int log_id;
	private int log_time;
	private int user_id;
	private String log_info;
	private String ip_address;
	
	public LogBean(){
		
	}

	public int getLog_id() {
		return log_id;
	}

	@Override
	public String toString() {
		return "LogBean [log_id=" + log_id + ", log_time=" + log_time + ", user_id=" + user_id + ", log_info="
				+ log_info + ", ip_address=" + ip_address + "]";
	}

	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}

	public int getLog_time() {
		return log_time;
	}

	public void setLog_time(int log_time) {
		this.log_time = log_time;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getLog_info() {
		return log_info;
	}

	public void setLog_info(String log_info) {
		this.log_info = log_info;
	}

	public String getIp_address() {
		return ip_address;
	}

	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	
	
}
