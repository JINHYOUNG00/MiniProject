package co.jin.pj.user.service;

import lombok.Data;

@Data
public class UserVO {
	private  String userId;
	private String userPassword;
	private String userPassword2;
	private String userPhone;
	private String userAddress;
	private String userNickname;
	private String blackList;
	
	
}
