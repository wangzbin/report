package com.report.common.pojo;

import java.io.Serializable;

public class BacterialResult implements Serializable {
    private Integer id;

    private String tubeNumber;

    private Byte bacteroidesUniformis;

    private Byte lactobacillusSalivarius;

    private Byte lactobacillusAcidophilus;

    private Byte lactobacillusFermentum;

    private Byte streptococcusThermophilus;

    private Byte lactobacillusHelveticus;

    private Byte faecalibacteriumPrausnitzii;

    private Byte lactobacillusJohnsonii;

    private Byte lactobacillusCasei;

    private Byte roseburiaInulinivorans;

    private Byte lactococcusLactis;

    private Byte lactobacillusReuteri;

    private Byte clostridiumButyricum;

    private Byte bifidobacteriumAdolescentis;

    private Byte bifidobacteriumBifidum;

    private Byte bifidobacteriumAngulatum;

    private Byte salmonellaEnterica;

    private Byte campylobacterJejuni;

    private Byte clostridiumPerfringens;

    private Byte klebsiellaPneumoniae;

    private Byte bacteroidesFragilis;

    private Byte enterobacterAerogenes;

    private Byte bacteroidesStercoris;

    private Byte escherichiaColi;

    private Byte staphylococcusAureus;

    private Byte enterococcusFaecium;

    private Byte enterococcusFaecalis;

    private Byte veillonellaParvula;

    private Byte streptococcusSuis;

    private Byte streptococcusAnginosus;

    private Byte fusobacteriumNucleatum;

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

    public Byte getBacteroidesUniformis() {
        return bacteroidesUniformis;
    }

    public void setBacteroidesUniformis(Byte bacteroidesUniformis) {
        this.bacteroidesUniformis = bacteroidesUniformis;
    }

    public Byte getLactobacillusSalivarius() {
        return lactobacillusSalivarius;
    }

    public void setLactobacillusSalivarius(Byte lactobacillusSalivarius) {
        this.lactobacillusSalivarius = lactobacillusSalivarius;
    }

    public Byte getLactobacillusAcidophilus() {
        return lactobacillusAcidophilus;
    }

    public void setLactobacillusAcidophilus(Byte lactobacillusAcidophilus) {
        this.lactobacillusAcidophilus = lactobacillusAcidophilus;
    }

    public Byte getLactobacillusFermentum() {
        return lactobacillusFermentum;
    }

    public void setLactobacillusFermentum(Byte lactobacillusFermentum) {
        this.lactobacillusFermentum = lactobacillusFermentum;
    }

    public Byte getStreptococcusThermophilus() {
        return streptococcusThermophilus;
    }

    public void setStreptococcusThermophilus(Byte streptococcusThermophilus) {
        this.streptococcusThermophilus = streptococcusThermophilus;
    }

    public Byte getLactobacillusHelveticus() {
        return lactobacillusHelveticus;
    }

    public void setLactobacillusHelveticus(Byte lactobacillusHelveticus) {
        this.lactobacillusHelveticus = lactobacillusHelveticus;
    }

    public Byte getFaecalibacteriumPrausnitzii() {
        return faecalibacteriumPrausnitzii;
    }

    public void setFaecalibacteriumPrausnitzii(Byte faecalibacteriumPrausnitzii) {
        this.faecalibacteriumPrausnitzii = faecalibacteriumPrausnitzii;
    }

    public Byte getLactobacillusJohnsonii() {
        return lactobacillusJohnsonii;
    }

    public void setLactobacillusJohnsonii(Byte lactobacillusJohnsonii) {
        this.lactobacillusJohnsonii = lactobacillusJohnsonii;
    }

    public Byte getLactobacillusCasei() {
        return lactobacillusCasei;
    }

    public void setLactobacillusCasei(Byte lactobacillusCasei) {
        this.lactobacillusCasei = lactobacillusCasei;
    }

    public Byte getRoseburiaInulinivorans() {
        return roseburiaInulinivorans;
    }

    public void setRoseburiaInulinivorans(Byte roseburiaInulinivorans) {
        this.roseburiaInulinivorans = roseburiaInulinivorans;
    }

    public Byte getLactococcusLactis() {
        return lactococcusLactis;
    }

    public void setLactococcusLactis(Byte lactococcusLactis) {
        this.lactococcusLactis = lactococcusLactis;
    }

    public Byte getLactobacillusReuteri() {
        return lactobacillusReuteri;
    }

    public void setLactobacillusReuteri(Byte lactobacillusReuteri) {
        this.lactobacillusReuteri = lactobacillusReuteri;
    }

    public Byte getClostridiumButyricum() {
        return clostridiumButyricum;
    }

    public void setClostridiumButyricum(Byte clostridiumButyricum) {
        this.clostridiumButyricum = clostridiumButyricum;
    }

    public Byte getBifidobacteriumAdolescentis() {
        return bifidobacteriumAdolescentis;
    }

    public void setBifidobacteriumAdolescentis(Byte bifidobacteriumAdolescentis) {
        this.bifidobacteriumAdolescentis = bifidobacteriumAdolescentis;
    }

    public Byte getBifidobacteriumBifidum() {
        return bifidobacteriumBifidum;
    }

    public void setBifidobacteriumBifidum(Byte bifidobacteriumBifidum) {
        this.bifidobacteriumBifidum = bifidobacteriumBifidum;
    }

    public Byte getBifidobacteriumAngulatum() {
        return bifidobacteriumAngulatum;
    }

    public void setBifidobacteriumAngulatum(Byte bifidobacteriumAngulatum) {
        this.bifidobacteriumAngulatum = bifidobacteriumAngulatum;
    }

    public Byte getSalmonellaEnterica() {
        return salmonellaEnterica;
    }

    public void setSalmonellaEnterica(Byte salmonellaEnterica) {
        this.salmonellaEnterica = salmonellaEnterica;
    }

    public Byte getCampylobacterJejuni() {
        return campylobacterJejuni;
    }

    public void setCampylobacterJejuni(Byte campylobacterJejuni) {
        this.campylobacterJejuni = campylobacterJejuni;
    }

    public Byte getClostridiumPerfringens() {
        return clostridiumPerfringens;
    }

    public void setClostridiumPerfringens(Byte clostridiumPerfringens) {
        this.clostridiumPerfringens = clostridiumPerfringens;
    }

    public Byte getKlebsiellaPneumoniae() {
        return klebsiellaPneumoniae;
    }

    public void setKlebsiellaPneumoniae(Byte klebsiellaPneumoniae) {
        this.klebsiellaPneumoniae = klebsiellaPneumoniae;
    }

    public Byte getBacteroidesFragilis() {
        return bacteroidesFragilis;
    }

    public void setBacteroidesFragilis(Byte bacteroidesFragilis) {
        this.bacteroidesFragilis = bacteroidesFragilis;
    }

    public Byte getEnterobacterAerogenes() {
        return enterobacterAerogenes;
    }

    public void setEnterobacterAerogenes(Byte enterobacterAerogenes) {
        this.enterobacterAerogenes = enterobacterAerogenes;
    }

    public Byte getBacteroidesStercoris() {
        return bacteroidesStercoris;
    }

    public void setBacteroidesStercoris(Byte bacteroidesStercoris) {
        this.bacteroidesStercoris = bacteroidesStercoris;
    }

    public Byte getEscherichiaColi() {
        return escherichiaColi;
    }

    public void setEscherichiaColi(Byte escherichiaColi) {
        this.escherichiaColi = escherichiaColi;
    }

    public Byte getStaphylococcusAureus() {
        return staphylococcusAureus;
    }

    public void setStaphylococcusAureus(Byte staphylococcusAureus) {
        this.staphylococcusAureus = staphylococcusAureus;
    }

    public Byte getEnterococcusFaecium() {
        return enterococcusFaecium;
    }

    public void setEnterococcusFaecium(Byte enterococcusFaecium) {
        this.enterococcusFaecium = enterococcusFaecium;
    }

    public Byte getEnterococcusFaecalis() {
        return enterococcusFaecalis;
    }

    public void setEnterococcusFaecalis(Byte enterococcusFaecalis) {
        this.enterococcusFaecalis = enterococcusFaecalis;
    }

    public Byte getVeillonellaParvula() {
        return veillonellaParvula;
    }

    public void setVeillonellaParvula(Byte veillonellaParvula) {
        this.veillonellaParvula = veillonellaParvula;
    }

    public Byte getStreptococcusSuis() {
        return streptococcusSuis;
    }

    public void setStreptococcusSuis(Byte streptococcusSuis) {
        this.streptococcusSuis = streptococcusSuis;
    }

    public Byte getStreptococcusAnginosus() {
        return streptococcusAnginosus;
    }

    public void setStreptococcusAnginosus(Byte streptococcusAnginosus) {
        this.streptococcusAnginosus = streptococcusAnginosus;
    }

    public Byte getFusobacteriumNucleatum() {
        return fusobacteriumNucleatum;
    }

    public void setFusobacteriumNucleatum(Byte fusobacteriumNucleatum) {
        this.fusobacteriumNucleatum = fusobacteriumNucleatum;
    }
}