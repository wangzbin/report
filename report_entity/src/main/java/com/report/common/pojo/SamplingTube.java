package com.report.common.pojo;

import java.io.Serializable;

public class SamplingTube implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_xcs_sampling_tube.id
     *
     * @mbg.generated Wed May 02 17:28:25 CST 2018
     */
    private Integer id;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_xcs_sampling_tube.tube_number
     *
     * @mbg.generated Wed May 02 17:28:25 CST 2018
     */
    private String tubeNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_xcs_sampling_tube.tube_binding
     *
     * @mbg.generated Wed May 02 17:28:25 CST 2018
     */
    private Integer tubeBinding;

    /**
     * 用户对象
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_xcs_sampling_tube.tube_user_id
     *
     * @mbg.generated Wed May 02 17:28:25 CST 2018
     */
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_xcs_sampling_tube.tube_state
     *
     * @mbg.generated Wed May 02 17:28:25 CST 2018
     */
    private Integer tubeState;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_xcs_sampling_tube.creater
     *
     * @mbg.generated Wed May 02 17:28:25 CST 2018
     */
    private String creater;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_xcs_sampling_tube.creater_time
     *
     * @mbg.generated Wed May 02 17:28:25 CST 2018
     */
    private Integer createrTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_xcs_sampling_tube.tube_report_id
     *
     * @mbg.generated Wed May 02 17:28:25 CST 2018
     */
    private Integer tubeReportId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_xcs_sampling_tube
     *
     * @mbg.generated Wed May 02 17:28:25 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_xcs_sampling_tube.id
     *
     * @return the value of t_xcs_sampling_tube.id
     * @mbg.generated Wed May 02 17:28:25 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_xcs_sampling_tube.id
     *
     * @param id the value for t_xcs_sampling_tube.id
     * @mbg.generated Wed May 02 17:28:25 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_xcs_sampling_tube.tube_number
     *
     * @return the value of t_xcs_sampling_tube.tube_number
     * @mbg.generated Wed May 02 17:28:25 CST 2018
     */
    public String getTubeNumber() {
        return tubeNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_xcs_sampling_tube.tube_number
     *
     * @param tubeNumber the value for t_xcs_sampling_tube.tube_number
     * @mbg.generated Wed May 02 17:28:25 CST 2018
     */
    public void setTubeNumber(String tubeNumber) {
        this.tubeNumber = tubeNumber == null ? null : tubeNumber.trim();
    }


    public Integer getTubeBinding() {
        return tubeBinding;
    }

    public void setTubeBinding(Integer tubeBinding) {
        this.tubeBinding = tubeBinding;
    }

    public Integer getTubeState() {
        return tubeState;
    }

    public void setTubeState(Integer tubeState) {
        this.tubeState = tubeState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_xcs_sampling_tube.creater
     *
     * @return the value of t_xcs_sampling_tube.creater
     * @mbg.generated Wed May 02 17:28:25 CST 2018
     */
    public String getCreater() {
        return creater;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_xcs_sampling_tube.creater
     *
     * @param creater the value for t_xcs_sampling_tube.creater
     * @mbg.generated Wed May 02 17:28:25 CST 2018
     */
    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_xcs_sampling_tube.creater_time
     *
     * @return the value of t_xcs_sampling_tube.creater_time
     * @mbg.generated Wed May 02 17:28:25 CST 2018
     */
    public Integer getCreaterTime() {
        return createrTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_xcs_sampling_tube.creater_time
     *
     * @param createrTime the value for t_xcs_sampling_tube.creater_time
     * @mbg.generated Wed May 02 17:28:25 CST 2018
     */
    public void setCreaterTime(Integer createrTime) {
        this.createrTime = createrTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_xcs_sampling_tube.tube_report_id
     *
     * @return the value of t_xcs_sampling_tube.tube_report_id
     * @mbg.generated Wed May 02 17:28:25 CST 2018
     */
    public Integer getTubeReportId() {
        return tubeReportId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_xcs_sampling_tube.tube_report_id
     *
     * @param tubeReportId the value for t_xcs_sampling_tube.tube_report_id
     * @mbg.generated Wed May 02 17:28:25 CST 2018
     */
    public void setTubeReportId(Integer tubeReportId) {
        this.tubeReportId = tubeReportId;
    }
}