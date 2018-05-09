package com.report.common.pojo;



import java.math.BigDecimal;
import java.util.Date;



/**
 * t_xcs_user
 * 
 * @author bianj
 * @version 1.0.0 2018-04-13
 */
public class User {

    /** 主键 */
    private Integer userId;

    /** 手机号(作为唯一识别编号) */
    private String userPhone;

    /*用户类型*/
    private UserType userType;

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
	public String toString() {
		return "User [userId=" + userId + ", userPhone=" + userPhone + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", userRealName=" + userRealName + ", userSex=" + userSex + ", userSampleDate=" + userSampleDate
				+ ", openId=" + openId + ", publicId=" + publicId + ", nickName=" + nickName + ", subscribe="
				+ subscribe + ", country=" + country + ", province=" + province + ", city=" + city + ", createDate="
				+ createDate + ", headimgUrl=" + headimgUrl + ", unionId=" + unionId + ", unSubscribeTime="
				+ unSubscribeTime + ", userNational=" + userNational + ", userHeight=" + userHeight + ", userWeight="
				+ userWeight + ", userBmi=" + userBmi + ", userIdentityCard=" + userIdentityCard + ", userWechatNumber="
				+ userWechatNumber + ", userAge=" + userAge + ", userTypeId=" + userTypeId + "]";
	}

	/** 密码 */
    private String userPwd;

    /** 用户名 */
    private String userName;

    /** 真实姓名 */
    private String userRealName;

    /** 性别 */
    private Integer userSex;

    /** 最近取样时间 */
    private Date userSampleDate;

    /** 全局凭证唯一Id */
    private String openId;

    /** 公众号Id */
    private String publicId;

    /** 昵称 */
    private String nickName;

    /** 是否关注 1是关注  */
    private Integer subscribe;

    /** 国家 */
    private String country;

    /** 地区 */
    private String province;

    /** 城市 */
    private String city;

    /** 关注时间 */
    private Date createDate;

    /** 用户头像 */
    private String headimgUrl;

    /** 第三方平台Id，可为空 */
    private String unionId;

    /** 用户取消关注时间 */
    private Date unSubscribeTime;

    /** 民族(预留) */
    private String userNational;

    /** 身高cm(预留) */
    private Integer userHeight;

    /** 体重kg(预留) */
    private Integer userWeight;

    /** BMI(身体质量指数)(预留) */
    private BigDecimal userBmi;

    /** 身份证号(预留) */
    private String userIdentityCard;

    /** 微信号（预留） */
    private String userWechatNumber;

    /** 年龄(预留)
    所属分类（外键） */
    private Integer userAge;

    /** 所属分类（外键） */
    private Integer userTypeId;

    /**
     * 获取主键
     * 
     * @return 主键
     */
    public Integer getUserId() {
        return this.userId;
    }

    /**
     * 设置主键
     * 
     * @param userId
     *          主键
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取手机号(作为唯一识别编号)
     * 
     * @return 手机号(作为唯一识别编号)
     */
    public String getUserPhone() {
        return this.userPhone;
    }

    /**
     * 设置手机号(作为唯一识别编号)
     * 
     * @param userPhone
     *          手机号(作为唯一识别编号)
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * 获取密码
     * 
     * @return 密码
     */
    public String getUserPwd() {
        return this.userPwd;
    }

    /**
     * 设置密码
     * 
     * @param userPwd
     *          密码
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    /**
     * 获取用户名
     * 
     * @return 用户名
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * 设置用户名
     * 
     * @param userName
     *          用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取真实姓名
     * 
     * @return 真实姓名
     */
    public String getUserRealName() {
        return this.userRealName;
    }

    /**
     * 设置真实姓名
     * 
     * @param userRealName
     *          真实姓名
     */
    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    /**
     * 获取性别
     * 
     * @return 性别
     */
    public Integer getUserSex() {
        return this.userSex;
    }

    /**
     * 设置性别
     * 
     * @param userSex
     *          性别
     */
    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    /**
     * 获取最近取样时间
     * 
     * @return 最近取样时间
     */
    public Date getUserSampleDate() {
        return this.userSampleDate;
    }

    /**
     * 设置最近取样时间
     * 
     * @param userSampleDate
     *          最近取样时间
     */
    public void setUserSampleDate(Date userSampleDate) {
        this.userSampleDate = userSampleDate;
    }

    /**
     * 获取全局凭证唯一Id
     * 
     * @return 全局凭证唯一Id
     */
    public String getOpenId() {
        return this.openId;
    }

    /**
     * 设置全局凭证唯一Id
     * 
     * @param openId
     *          全局凭证唯一Id
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * 获取公众号Id
     * 
     * @return 公众号Id
     */
    public String getPublicId() {
        return this.publicId;
    }

    /**
     * 设置公众号Id
     * 
     * @param publicId
     *          公众号Id
     */
    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    /**
     * 获取昵称
     * 
     * @return 昵称
     */
    public String getNickName() {
        return this.nickName;
    }

    /**
     * 设置昵称
     * 
     * @param nickName
     *          昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取是否关注 1是关注 
     * 
     * @return 是否关注 1是关注 
     */
    public Integer getSubscribe() {
        return this.subscribe;
    }

    /**
     * 设置是否关注 1是关注 
     * 
     * @param subscribe
     *          是否关注 1是关注 
     */
    public void setSubscribe(Integer subscribe) {
        this.subscribe = subscribe;
    }

    /**
     * 获取国家
     * 
     * @return 国家
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * 设置国家
     * 
     * @param country
     *          国家
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 获取地区
     * 
     * @return 地区
     */
    public String getProvince() {
        return this.province;
    }

    /**
     * 设置地区
     * 
     * @param province
     *          地区
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取城市
     * 
     * @return 城市
     */
    public String getCity() {
        return this.city;
    }

    /**
     * 设置城市
     * 
     * @param city
     *          城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取关注时间
     * 
     * @return 关注时间
     */
    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * 设置关注时间
     * 
     * @param createDate
     *          关注时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取用户头像
     * 
     * @return 用户头像
     */
    public String getHeadimgUrl() {
        return this.headimgUrl;
    }

    /**
     * 设置用户头像
     * 
     * @param headimgUrl
     *          用户头像
     */
    public void setHeadimgUrl(String headimgUrl) {
        this.headimgUrl = headimgUrl;
    }

    /**
     * 获取第三方平台Id，可为空
     * 
     * @return 第三方平台Id
     */
    public String getUnionId() {
        return this.unionId;
    }

    /**
     * 设置第三方平台Id，可为空
     * 
     * @param unionId
     *          第三方平台Id
     */
    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    /**
     * 获取用户取消关注时间
     * 
     * @return 用户取消关注时间
     */
    public Date getUnSubscribeTime() {
        return this.unSubscribeTime;
    }

    /**
     * 设置用户取消关注时间
     * 
     * @param unSubscribeTime
     *          用户取消关注时间
     */
    public void setUnSubscribeTime(Date unSubscribeTime) {
        this.unSubscribeTime = unSubscribeTime;
    }

    /**
     * 获取民族(预留)
     * 
     * @return 民族(预留)
     */
    public String getUserNational() {
        return this.userNational;
    }

    /**
     * 设置民族(预留)
     * 
     * @param userNational
     *          民族(预留)
     */
    public void setUserNational(String userNational) {
        this.userNational = userNational;
    }

    /**
     * 获取身高cm(预留)
     * 
     * @return 身高cm(预留)
     */
    public Integer getUserHeight() {
        return this.userHeight;
    }

    /**
     * 设置身高cm(预留)
     * 
     * @param userHeight
     *          身高cm(预留)
     */
    public void setUserHeight(Integer userHeight) {
        this.userHeight = userHeight;
    }

    /**
     * 获取体重kg(预留)
     * 
     * @return 体重kg(预留)
     */
    public Integer getUserWeight() {
        return this.userWeight;
    }

    /**
     * 设置体重kg(预留)
     * 
     * @param userWeight
     *          体重kg(预留)
     */
    public void setUserWeight(Integer userWeight) {
        this.userWeight = userWeight;
    }

    /**
     * 获取BMI(身体质量指数)(预留)
     * 
     * @return BMI(身体质量指数)(预留)
     */
    public BigDecimal getUserBmi() {
        return this.userBmi;
    }

    /**
     * 设置BMI(身体质量指数)(预留)
     * 
     * @param userBmi
     *          BMI(身体质量指数)(预留)
     */
    public void setUserBmi(BigDecimal userBmi) {
        this.userBmi = userBmi;
    }

    /**
     * 获取身份证号(预留)
     * 
     * @return 身份证号(预留)
     */
    public String getUserIdentityCard() {
        return this.userIdentityCard;
    }

    /**
     * 设置身份证号(预留)
     * 
     * @param userIdentityCard
     *          身份证号(预留)
     */
    public void setUserIdentityCard(String userIdentityCard) {
        this.userIdentityCard = userIdentityCard;
    }

    /**
     * 获取微信号（预留）
     * 
     * @return 微信号（预留）
     */
    public String getUserWechatNumber() {
        return this.userWechatNumber;
    }

    /**
     * 设置微信号（预留）
     * 
     * @param userWechatNumber
     *          微信号（预留）
     */
    public void setUserWechatNumber(String userWechatNumber) {
        this.userWechatNumber = userWechatNumber;
    }

    /**
     * 获取年龄(预留)
所属分类（外键）
     * 
     * @return 年龄(预留)
所属分类（外键）
     */
    public Integer getUserAge() {
        return this.userAge;
    }

    /**
     * 设置年龄(预留)
所属分类（外键）
     * 
     * @param userAge
     *          年龄(预留)
所属分类（外键）
     */
    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    /**
     * 获取所属分类（外键）
     * 
     * @return 所属分类（外键）
     */
    public Integer getUserTypeId() {
        return this.userTypeId;
    }

    /**
     * 设置所属分类（外键）
     * 
     * @param userTypeId
     *          所属分类（外键）
     */
    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }
}