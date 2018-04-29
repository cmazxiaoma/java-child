package cn.photoflash.user.security;

import java.util.Date;

/**
 * 此类用于校验用户的验证码是否过时
 * 
 * @author yishuihan
 * 
 */
public class SecurityCode {

	private String code;
	private Date time;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "SecurityCode [code=" + code + ", time=" + time + "]";
	}

	/**
	 * 超时则返回true 没有超时则返回false
	 * 
	 * @return
	 */
	public boolean isValid() {
		return System.currentTimeMillis() - this.getTime().getTime() > 1 * 60 * 1000 ? true : false;
	}

}