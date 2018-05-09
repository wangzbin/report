package com.report.common.pojo;


/**
 * t_xcs_user_report
 * 
 * @author bianj
 * @version 1.0.0 2018-04-25
 */

public class UserReport  {


    /** 主键 */
    private Integer reportId;

    /** 采样管编号 */
    private String reportTubeId;

    /** 被检测人(从问券数据库获取) */
    private String name;

    /** 年龄(从问券数据库获取) */
    private Integer age;

    /** 性别(从问券数据库获取) */
    private Integer sex;

    /** 被检测人手机号(从问券数据库获取) */
    private String phone;

    /** 状态（0未出报告，待填问券，未绑定用户，待审核 */
    private Integer reportStatus;

    /** 报告生成时间 */
    private Integer reportCreateTime;

    private Integer reportBacterialId;

    private BacterialReport bacterialReport;

    public Integer getReportBacterialId() {
        return reportBacterialId;
    }

    public BacterialReport getBacterialReport() {
        return bacterialReport;
    }

    public void setBacterialReport(BacterialReport bacterialReport) {
        this.bacterialReport = bacterialReport;
    }

    public void setReportBacterialId(Integer reportBacterialId) {
        this.reportBacterialId = reportBacterialId;
    }

    /**
     * 获取主键
     * 
     * @return 主键
     */
    public Integer getReportId() {
        return this.reportId;
    }

    /**
     * 设置主键
     * 
     * @param reportId
     *          主键
     */
    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    /**
     * 获取采样管编号
     * 
     * @return 采样管编号
     */
    public String getReportTubeId() {
        return this.reportTubeId;
    }

    /**
     * 设置采样管编号
     * 
     * @param reportTubeId
     *          采样管编号
     */
    public void setReportTubeId(String reportTubeId) {
        this.reportTubeId = reportTubeId;
    }

    /**
     * 获取被检测人(从问券数据库获取)
     * 
     * @return 被检测人(从问券数据库获取)
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置被检测人(从问券数据库获取)
     * 
     * @param name
     *          被检测人(从问券数据库获取)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取年龄(从问券数据库获取)
     * 
     * @return 年龄(从问券数据库获取)
     */
    public Integer getAge() {
        return this.age;
    }

    /**
     * 设置年龄(从问券数据库获取)
     * 
     * @param age
     *          年龄(从问券数据库获取)
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取性别(从问券数据库获取)
     * 
     * @return 性别(从问券数据库获取)
     */
    public Integer getSex() {
        return this.sex;
    }

    /**
     * 设置性别(从问券数据库获取)
     * 
     * @param sex
     *          性别(从问券数据库获取)
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取被检测人手机号(从问券数据库获取)
     * 
     * @return 被检测人手机号(从问券数据库获取)
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * 设置被检测人手机号(从问券数据库获取)
     * 
     * @param phone
     *          被检测人手机号(从问券数据库获取)
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取状态（0未出报告，待填问券，未绑定用户，待审核
     * 
     * @return 状态（0未出报告
     */
    public Integer getReportStatus() {
        return this.reportStatus;
    }

    /**
     * 设置状态（0未出报告，待填问券，未绑定用户，待审核
     * 
     * @param reportStatus
     *          状态（0未出报告
     */
    public void setReportStatus(Integer reportStatus) {
        this.reportStatus = reportStatus;
    }

    /**
     * 获取报告生成时间
     * 
     * @return 报告生成时间
     */
    public Integer getReportCreateTime() {
        return this.reportCreateTime;
    }

    /**
     * 设置报告生成时间
     * 
     * @param reportCreateTime
     *          报告生成时间
     */
    public void setReportCreateTime(Integer reportCreateTime) {
        this.reportCreateTime = reportCreateTime;
    }

    @Override
    public String toString() {
        return "UserReport{" +
                "reportId=" + reportId +
                ", reportTubeId='" + reportTubeId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", reportStatus=" + reportStatus +
                ", reportCreateTime=" + reportCreateTime +
                '}';
    }
}