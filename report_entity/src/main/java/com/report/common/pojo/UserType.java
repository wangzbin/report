/*
 * Welcome to use the TableGo Tools.
 * 
 * http://vipbooks.iteye.com
 * http://blog.csdn.net/vipbooks
 * http://www.cnblogs.com/vipbooks
 * 
 * Author:bianj
 * Email:edinsker@163.com
 * Version:5.8.0
 */

package com.report.common.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * t_xcs_user_type
 * 
 * @author bianj
 * @version 1.0.0 2018-04-28
 */
@Entity
@Table(name = "t_xcs_user_type")
public class UserType implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -5274673636971762382L;

    /** 用户分类ID,主键 */
    @Id
    @Column(name = "user_type_id", unique = true, nullable = false, length = 10)
    private Integer userTypeId;

    /** 分类名称 */
    @Column(name = "user_type_name", nullable = true, length = 50)
    private String userTypeName;

    /** 状态0:正常;1:删除 */
    @Column(name = "user_type_state", nullable = true, length = 3)
    private Integer userTypeState;

    /** 创建人 */
    @Column(name = "user_type_creater", nullable = true, length = 50)
    private String userTypeCreater;

    /** 创建时间 */
    @Column(name = "create_date", nullable = true, length = 10)
    private Integer createDate;

    /** 修改人 */
    @Column(name = "user_type_modifier", nullable = true, length = 50)
    private String userTypeModifier;

    /** 修改时间 */
    @Column(name = "modify_date", nullable = true, length = 10)
    private Integer modifyDate;

    /**
     * 获取用户分类ID,主键
     * 
     * @return 用户分类ID
     */
    public Integer getUserTypeId() {
        return this.userTypeId;
    }

    /**
     * 设置用户分类ID,主键
     * 
     * @param userTypeId
     *          用户分类ID
     */
    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }

    /**
     * 获取分类名称
     * 
     * @return 分类名称
     */
    public String getUserTypeName() {
        return this.userTypeName;
    }

    /**
     * 设置分类名称
     * 
     * @param userTypeName
     *          分类名称
     */
    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    /**
     * 获取状态0:正常;1:删除
     * 
     * @return 状态0
     */
    public Integer getUserTypeState() {
        return this.userTypeState;
    }

    /**
     * 设置状态0:正常;1:删除
     * 
     * @param userTypeState
     *          状态0
     */
    public void setUserTypeState(Integer userTypeState) {
        this.userTypeState = userTypeState;
    }

    /**
     * 获取创建人
     * 
     * @return 创建人
     */
    public String getUserTypeCreater() {
        return this.userTypeCreater;
    }

    /**
     * 设置创建人
     * 
     * @param userTypeCreater
     *          创建人
     */
    public void setUserTypeCreater(String userTypeCreater) {
        this.userTypeCreater = userTypeCreater;
    }

    /**
     * 获取创建时间
     * 
     * @return 创建时间
     */
    public Integer getCreateDate() {
        return this.createDate;
    }

    /**
     * 设置创建时间
     * 
     * @param createDate
     *          创建时间
     */
    public void setCreateDate(Integer createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取修改人
     * 
     * @return 修改人
     */
    public String getUserTypeModifier() {
        return this.userTypeModifier;
    }

    /**
     * 设置修改人
     * 
     * @param userTypeModifier
     *          修改人
     */
    public void setUserTypeModifier(String userTypeModifier) {
        this.userTypeModifier = userTypeModifier;
    }

    /**
     * 获取修改时间
     * 
     * @return 修改时间
     */
    public Integer getModifyDate() {
        return this.modifyDate;
    }

    /**
     * 设置修改时间
     * 
     * @param modifyDate
     *          修改时间
     */
    public void setModifyDate(Integer modifyDate) {
        this.modifyDate = modifyDate;
    }
}