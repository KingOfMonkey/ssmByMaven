package org.bb.ssm.model;

public class UserInfo {
    private Integer userId;

    private String userName;

    private Integer userAge;

    private String userAddress;
    
    public UserInfo() {
		// TODO Auto-generated constructor stub
	}
    
    public UserInfo(Integer userId, String userName, Integer userAge, String userAddress) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAge = userAge;
		this.userAddress = userAddress;
	}

    
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName + ", userAge=" + userAge + ", userAddress="
				+ userAddress + "]";
	}

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}