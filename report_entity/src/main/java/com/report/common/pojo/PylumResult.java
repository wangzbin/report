package com.report.common.pojo;

import java.io.Serializable;

public class PylumResult implements Serializable {
    private Integer id;

    private String tubeNumber;

    private Double spirochaetes;

    private Double verrucomicrobia;

    private Double lentisphaerae;

    private Double chlamydiae;

    private Double deinococcusThermus;

    private Double proteobacteria;

    private Double firmicutes;

    private Double nitrospirae;

    private Double bacteroidetes;

    private Double chloroflexi;

    private Double actinobacteria;

    private Double tenericutes;

    private Double synergistetes;

    private Double fusobacteria;

    private Double cyanobacteria;

    private Double fibrobacteres;

    private Double euryarchaeota;

    private Double unknown;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTubeNumber() {
        return tubeNumber;
    }

    public void setTubeNumber(String tubeNumber) {
        this.tubeNumber = tubeNumber == null ? null : tubeNumber.trim();
    }

    public Double getSpirochaetes() {
        return spirochaetes;
    }

    public void setSpirochaetes(Double spirochaetes) {
        this.spirochaetes = spirochaetes;
    }

    public Double getVerrucomicrobia() {
        return verrucomicrobia;
    }

    public void setVerrucomicrobia(Double verrucomicrobia) {
        this.verrucomicrobia = verrucomicrobia;
    }

    public Double getLentisphaerae() {
        return lentisphaerae;
    }

    public void setLentisphaerae(Double lentisphaerae) {
        this.lentisphaerae = lentisphaerae;
    }

    public Double getChlamydiae() {
        return chlamydiae;
    }

    public void setChlamydiae(Double chlamydiae) {
        this.chlamydiae = chlamydiae;
    }

    public Double getDeinococcusThermus() {
        return deinococcusThermus;
    }

    public void setDeinococcusThermus(Double deinococcusThermus) {
        this.deinococcusThermus = deinococcusThermus;
    }

    public Double getProteobacteria() {
        return proteobacteria;
    }

    public void setProteobacteria(Double proteobacteria) {
        this.proteobacteria = proteobacteria;
    }

    public Double getFirmicutes() {
        return firmicutes;
    }

    public void setFirmicutes(Double firmicutes) {
        this.firmicutes = firmicutes;
    }

    public Double getNitrospirae() {
        return nitrospirae;
    }

    public void setNitrospirae(Double nitrospirae) {
        this.nitrospirae = nitrospirae;
    }

    public Double getBacteroidetes() {
        return bacteroidetes;
    }

    public void setBacteroidetes(Double bacteroidetes) {
        this.bacteroidetes = bacteroidetes;
    }

    public Double getChloroflexi() {
        return chloroflexi;
    }

    public void setChloroflexi(Double chloroflexi) {
        this.chloroflexi = chloroflexi;
    }

    public Double getActinobacteria() {
        return actinobacteria;
    }

    public void setActinobacteria(Double actinobacteria) {
        this.actinobacteria = actinobacteria;
    }

    public Double getTenericutes() {
        return tenericutes;
    }

    public void setTenericutes(Double tenericutes) {
        this.tenericutes = tenericutes;
    }

    public Double getSynergistetes() {
        return synergistetes;
    }

    public void setSynergistetes(Double synergistetes) {
        this.synergistetes = synergistetes;
    }

    public Double getFusobacteria() {
        return fusobacteria;
    }

    public void setFusobacteria(Double fusobacteria) {
        this.fusobacteria = fusobacteria;
    }

    public Double getCyanobacteria() {
        return cyanobacteria;
    }

    public void setCyanobacteria(Double cyanobacteria) {
        this.cyanobacteria = cyanobacteria;
    }

    public Double getFibrobacteres() {
        return fibrobacteres;
    }

    public void setFibrobacteres(Double fibrobacteres) {
        this.fibrobacteres = fibrobacteres;
    }

    public Double getEuryarchaeota() {
        return euryarchaeota;
    }

    public void setEuryarchaeota(Double euryarchaeota) {
        this.euryarchaeota = euryarchaeota;
    }

    public Double getUnknown() {
        return unknown;
    }

    public void setUnknown(Double unknown) {
        this.unknown = unknown;
    }
}