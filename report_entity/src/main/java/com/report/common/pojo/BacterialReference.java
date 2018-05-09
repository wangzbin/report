
package com.report.common.pojo;

public class BacterialReference {

    /** 菌种ID,主键 */
    private Integer bacterialId;

    /** 菌种名 */
    private String bacterialName;

    /** 最小值 */
    private Double min;

    /** 25% */
    private Double quartileOne;

    /** 中位数 */
    private Double median;

    /** 75% */
    private Double quartileThree;

    /** 最大值 */
    private Double max;

    /**
     * 获取菌种ID,主键
     * 
     * @return 菌种ID
     */
    public Integer getBacterialId() {
        return this.bacterialId;
    }

    /**
     * 设置菌种ID,主键
     * 
     * @param bacterialId
     *          菌种ID
     */
    public void setBacterialId(Integer bacterialId) {
        this.bacterialId = bacterialId;
    }

    /**
     * 获取菌种名
     * 
     * @return 菌种名
     */
    public String getBacterialName() {
        return this.bacterialName;
    }

    /**
     * 设置菌种名
     * 
     * @param bacterialName
     *          菌种名
     */
    public void setBacterialName(String bacterialName) {
        this.bacterialName = bacterialName;
    }

    /**
     * 获取最小值
     * 
     * @return 最小值
     */
    public Double getMin() {
        return this.min;
    }

    /**
     * 设置最小值
     * 
     * @param min
     *          最小值
     */
    public void setMin(Double min) {
        this.min = min;
    }

    /**
     * 获取25%
     * 
     * @return 25%
     */
    public Double getQuartileOne() {
        return this.quartileOne;
    }

    /**
     * 设置25%
     * 
     * @param quartileOne
     *          25%
     */
    public void setQuartileOne(Double quartileOne) {
        this.quartileOne = quartileOne;
    }

    /**
     * 获取中位数
     * 
     * @return 中位数
     */
    public Double getMedian() {
        return this.median;
    }

    /**
     * 设置中位数
     * 
     * @param median
     *          中位数
     */
    public void setMedian(Double median) {
        this.median = median;
    }

    /**
     * 获取75%
     * 
     * @return 75%
     */
    public Double getQuartileThree() {
        return this.quartileThree;
    }

    /**
     * 设置75%
     * 
     * @param quartileThree
     *          75%
     */
    public void setQuartileThree(Double quartileThree) {
        this.quartileThree = quartileThree;
    }

    /**
     * 获取最大值
     * 
     * @return 最大值
     */
    public Double getMax() {
        return this.max;
    }

    /**
     * 设置最大值
     * 
     * @param max
     *          最大值
     */
    public void setMax(Double max) {
        this.max = max;
    }
}