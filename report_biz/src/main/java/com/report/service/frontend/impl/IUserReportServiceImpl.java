package com.report.service.frontend.impl;

import com.report.common.constant.Constant;

import com.report.common.pojo.*;
import com.report.common.util.Arith;
import com.report.common.util.CommonResult;
import com.report.common.util.DateFormatUtil;
import com.report.common.util.LOG;
import com.report.mapper.manage.BacterialReferenceMapper;
import com.report.mapper.manage.BacterialResultMapper;
import com.report.mapper.manage.UserReportMapper;
import com.report.service.frontend.IUserReportService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class IUserReportServiceImpl implements IUserReportService {
    @Autowired
    private BacterialResultMapper bacterialResultMapper;
    @Autowired
    private UserReportMapper userReportMapper;
    @Autowired
    private BacterialReferenceMapper bacterialReferenceMapper;
    /**
     * 生成检测报告
     * @param reportTubeId
     * @return
     */
    @Override
    public CommonResult addCreateReport(String reportTubeId) {


        LOG.info("开始执行代码"+ DateFormatUtil.transForDate3((int)System.currentTimeMillis()));

        UserReport userReport = userReportMapper.selectUserReport(reportTubeId);
        Integer reportBacterialId = userReport.getReportBacterialId();
        UserReport userReportData = userReportMapper.selectUserReportData(reportBacterialId);
        BacterialReport bacterialReport = userReportData.getBacterialReport();
        List<BacterialReference> list = bacterialReferenceMapper.selectBacterialReference();
        BacterialResult bacterialResult = new BacterialResult();
        for ( BacterialReference bacterialReference: list){
            if (Constant.BACTEROIDES_FRAGILIS.equals(bacterialReference.getBacterialName())) {
                //脆弱拟杆菌 致病菌
                Double bacteroidesFragilis = bacterialReport.getBacteroidesFragilis();
                if (bacteroidesFragilis>0) {
                    if (Arith.compareTo(bacteroidesFragilis.toString(), bacterialReference.getQuartileThree().toString()) > 0){
                        bacterialResult.setBacteroidesFragilis((byte) 2);
                    }else{
                        bacterialResult.setBacteroidesFragilis((byte) 1);
                    }
                } else {
                    bacterialResult.setBacteroidesFragilis((byte) 0);
                }
            }
            if (Constant.BACTEROIDES_STERCORIS.equals(bacterialReference.getBacterialName())) {
                //粪拟杆菌 中性菌
                Double bacteroidesStercoris = bacterialReport.getBacteroidesStercoris();
                //25%
                if (Arith.compareTo(bacteroidesStercoris.toString(), bacterialReference.getQuartileOne().toString()) >= 0 ) {
                    if (Arith.compareTo(bacteroidesStercoris.toString(), bacterialReference.getQuartileThree().toString()) <= 0 ) {
                        bacterialResult.setBacteroidesStercoris((byte) 0);
                    }else{
                        bacterialResult.setBacteroidesStercoris((byte) 2);
                    }
                } else {
                    bacterialResult.setBacteroidesStercoris((byte) 1);
                }

            }
            if (Constant.BIFIDOBACTERIUM_ADOLESCENTIS.equals(bacterialReference.getBacterialName())) {
                //青春双歧杆菌 有益菌
                Double bifidobacteriumAdolescentis = bacterialReport.getBifidobacteriumAdolescentis();
                if (Arith.compareTo(bifidobacteriumAdolescentis.toString(), bacterialReference.getQuartileOne().toString()) >= 0 ) {
                    if (Arith.compareTo(bifidobacteriumAdolescentis.toString(), bacterialReference.getQuartileThree().toString()) <= 0 ) {
                        bacterialResult.setBifidobacteriumAdolescentis((byte) 0);
                    }else{
                        bacterialResult.setBifidobacteriumAdolescentis((byte) 2);
                    }
                }else{
                    bacterialResult.setBifidobacteriumAdolescentis((byte) 1);
                }
            }

            if (Constant.BIFIDOBACTERIUM_ANGULATUM .equals(bacterialReference.getBacterialName())) {
                //角双歧杆菌 有益菌
                Double bifidobacteriumAngulatum = bacterialReport.getBifidobacteriumAngulatum();
                if (Arith.compareTo(bifidobacteriumAngulatum.toString(), bacterialReference.getQuartileOne().toString()) >= 0 ) {
                    if (Arith.compareTo(bifidobacteriumAngulatum.toString(), bacterialReference.getQuartileThree().toString()) <= 0 ) {
                        bacterialResult.setBifidobacteriumAngulatum((byte) 0);
                    }else{
                        bacterialResult.setBifidobacteriumAngulatum((byte) 2);
                    }
                }else{
                    bacterialResult.setBifidobacteriumAngulatum((byte) 1);
                }
            }
            if (Constant.BIFIDOBACTERIUM_BIFIDUM .equals(bacterialReference.getBacterialName())) {
                //有益菌  两岐双歧杆菌
                Double bifidobacteriumBifidum = bacterialReport.getBifidobacteriumBifidum();
                if (Arith.compareTo(bifidobacteriumBifidum.toString(), bacterialReference.getQuartileOne().toString()) >= 0 ) {
                    if (Arith.compareTo(bifidobacteriumBifidum.toString(), bacterialReference.getQuartileThree().toString()) <= 0 ) {
                        bacterialResult.setBifidobacteriumBifidum((byte) 0);
                    }else{
                        bacterialResult.setBifidobacteriumBifidum((byte) 2);
                    }
                }else{
                    bacterialResult.setBifidobacteriumBifidum((byte) 1);
                }
            }

            if (Constant.CAMPYLOBACTER_JEJUNI.equals(bacterialReference.getBacterialName())) {
                //脆弱拟杆菌 致病菌
                Double campylobacterJejuni = bacterialReport.getCampylobacterJejuni();
                if (campylobacterJejuni>0) {
                    if (Arith.compareTo(campylobacterJejuni.toString(), bacterialReference.getQuartileThree().toString()) > 0){
                        bacterialResult.setCampylobacterJejuni((byte) 2);
                    }else{
                        bacterialResult.setCampylobacterJejuni((byte) 1);
                    }
                } else {
                    bacterialResult.setCampylobacterJejuni((byte) 0);
                }
            }

            if (Constant.CLOSTRIDIUM_BUTYRICUM .equals(bacterialReference.getBacterialName())) {
                //有益菌  两岐双歧杆菌
                Double clostridiumButyricum = bacterialReport.getClostridiumButyricum();
                if (Arith.compareTo(clostridiumButyricum.toString(), bacterialReference.getQuartileOne().toString()) >= 0 ) {
                    if (Arith.compareTo(clostridiumButyricum.toString(), bacterialReference.getQuartileThree().toString()) <= 0 ) {
                        bacterialResult.setClostridiumButyricum((byte) 0);
                    }else{
                        bacterialResult.setClostridiumButyricum((byte) 2);
                    }
                }else{
                    bacterialResult.setClostridiumButyricum((byte) 1);
                }
            }
            if (Constant.CLOSTRIDIUM_PERFRINGENS.equals(bacterialReference.getBacterialName())) {
                //产气荚膜梭菌 致病菌
                Double clostridiumPerfringens = bacterialReport.getClostridiumPerfringens();
                if (clostridiumPerfringens>0) {
                    if (Arith.compareTo(clostridiumPerfringens.toString(), bacterialReference.getQuartileThree().toString()) > 0){
                        bacterialResult.setClostridiumPerfringens((byte) 2);
                    }else{
                        bacterialResult.setClostridiumPerfringens((byte) 1);
                    }
                } else {
                    bacterialResult.setClostridiumPerfringens((byte) 0);
                }
            }
            if (Constant.ENTEROBACTER_AEROGENES.equals(bacterialReference.getBacterialName())) {
                //产气肠杆菌 致病菌
                Double enterobacterAerogenes = bacterialReport.getEnterobacterAerogenes();
                if (enterobacterAerogenes>0) {
                    if (Arith.compareTo(enterobacterAerogenes.toString(), bacterialReference.getQuartileThree().toString()) > 0){
                        bacterialResult.setEnterobacterAerogenes((byte) 2);
                    }else{
                        bacterialResult.setEnterobacterAerogenes((byte) 1);
                    }
                } else {
                    bacterialResult.setEnterobacterAerogenes((byte) 0);
                }
            }
            if (Constant.ENTEROCOCCUS_FAECALIS.equals(bacterialReference.getBacterialName())) {
                //粪肠球菌 中性菌
                Double enterococcusFaecalis = bacterialReport.getEnterococcusFaecalis();
                //25%
                if (Arith.compareTo(enterococcusFaecalis.toString(), bacterialReference.getQuartileOne().toString()) >= 0 ) {
                    if (Arith.compareTo(enterococcusFaecalis.toString(), bacterialReference.getQuartileThree().toString()) <= 0 ) {
                        bacterialResult.setEnterococcusFaecalis((byte) 0);
                    }else{
                        bacterialResult.setEnterococcusFaecalis((byte) 2);
                    }
                } else {
                    bacterialResult.setEnterococcusFaecalis((byte) 1);
                }

            }

            if (Constant.ENTEROCOCCUS_FAECIUM.equals(bacterialReference.getBacterialName())) {
                //屎肠球菌 中性菌
                Double enterococcusFaecium = bacterialReport.getEnterococcusFaecium();
                //25%
                if (Arith.compareTo(enterococcusFaecium.toString(), bacterialReference.getQuartileOne().toString()) >= 0 ) {
                    if (Arith.compareTo(enterococcusFaecium.toString(), bacterialReference.getQuartileThree().toString()) <= 0 ) {
                        bacterialResult.setEnterococcusFaecium((byte) 0);
                    }else{
                        bacterialResult.setEnterococcusFaecium((byte) 2);
                    }
                } else {
                    bacterialResult.setEnterococcusFaecium((byte) 1);
                }

            }
            if (Constant.ESCHERICHIA_COLI.equals(bacterialReference.getBacterialName())) {
                //大肠杆菌 中性菌
                Double escherichiaColi = bacterialReport.getEscherichiaColi();
                //25%
                if (Arith.compareTo(escherichiaColi.toString(), bacterialReference.getQuartileOne().toString()) >= 0 ) {
                    if (Arith.compareTo(escherichiaColi.toString(), bacterialReference.getQuartileThree().toString()) <= 0 ) {
                        bacterialResult.setEscherichiaColi((byte) 0);
                    }else{
                        bacterialResult.setEscherichiaColi((byte) 2);
                    }
                } else {
                    bacterialResult.setEscherichiaColi((byte) 1);
                }

            }

            if (Constant.FAECALIBACTERIUM_PRAUSNITZII .equals(bacterialReference.getBacterialName())) {
                //普拉梭菌 有益菌
                Double faecalibacteriumPrausnitzii = bacterialReport.getFaecalibacteriumPrausnitzii();
                if (Arith.compareTo(faecalibacteriumPrausnitzii.toString(), bacterialReference.getQuartileOne().toString()) >= 0 ) {
                    if (Arith.compareTo(faecalibacteriumPrausnitzii.toString(), bacterialReference.getQuartileThree().toString()) <= 0 ) {
                        bacterialResult.setFaecalibacteriumPrausnitzii((byte) 0);
                    }else{
                        bacterialResult.setFaecalibacteriumPrausnitzii((byte) 2);
                    }
                }else{
                    bacterialResult.setFaecalibacteriumPrausnitzii((byte) 1);
                }
            }

            if (Constant.FUSOBACTERIUM_NUCLEATUM.equals(bacterialReference.getBacterialName())) {
                //具核梭杆菌 中性菌
                Double fusobacteriumNucleatum = bacterialReport.getFusobacteriumNucleatum();
                //25%
                if (Arith.compareTo(fusobacteriumNucleatum.toString(), bacterialReference.getQuartileOne().toString()) >= 0 ) {
                    if (Arith.compareTo(fusobacteriumNucleatum.toString(), bacterialReference.getQuartileThree().toString()) <= 0 ) {
                        bacterialResult.setFusobacteriumNucleatum((byte) 0);
                    }else{
                        bacterialResult.setFusobacteriumNucleatum((byte) 2);
                    }
                } else {
                    bacterialResult.setFusobacteriumNucleatum((byte) 1);
                }

            }
            if (Constant.KLEBSIELLA_PNEUMONIAE.equals(bacterialReference.getBacterialName())) {
                //肺炎克雷伯菌 致病菌
                Double klebsiellaPneumoniae = bacterialReport.getKlebsiellaPneumoniae();
                if (klebsiellaPneumoniae>0) {
                    if (Arith.compareTo(klebsiellaPneumoniae.toString(), bacterialReference.getQuartileThree().toString()) > 0){
                        bacterialResult.setKlebsiellaPneumoniae((byte) 2);
                    }else{
                        bacterialResult.setKlebsiellaPneumoniae((byte) 1);
                    }
                } else {
                    bacterialResult.setKlebsiellaPneumoniae((byte) 0);
                }
            }

            if (Constant.LACTOBACILLUS_ACIDOPHILUS .equals(bacterialReference.getBacterialName())) {
                //嗜酸乳杆菌 有益菌
                Double lactobacillusAcidophilus = bacterialReport.getLactobacillusAcidophilus();
                if (Arith.compareTo(lactobacillusAcidophilus.toString(), bacterialReference.getQuartileOne().toString()) >= 0 ) {
                    if (Arith.compareTo(lactobacillusAcidophilus.toString(), bacterialReference.getQuartileThree().toString()) <= 0 ) {
                        bacterialResult.setLactobacillusAcidophilus((byte) 0);
                    }else{
                        bacterialResult.setLactobacillusAcidophilus((byte) 2);
                    }
                }else{
                    bacterialResult.setLactobacillusAcidophilus((byte) 1);
                }
            }

            if (Constant.LACTOBACILLUS_CASEI .equals(bacterialReference.getBacterialName())) {
                //干酪乳杆菌 有益菌
                Double lactobacillusCasei = bacterialReport.getLactobacillusCasei();
                if (Arith.compareTo(lactobacillusCasei.toString(), bacterialReference.getQuartileOne().toString()) >= 0 ) {
                    if (Arith.compareTo(lactobacillusCasei.toString(), bacterialReference.getQuartileThree().toString()) <= 0 ) {
                        bacterialResult.setLactobacillusCasei((byte) 0);
                    }else{
                        bacterialResult.setLactobacillusCasei((byte) 2);
                    }
                }else{
                    bacterialResult.setLactobacillusCasei((byte) 1);
                }
            }
            if (Constant.LACTOBACILLUS_FERMENTUM .equals(bacterialReference.getBacterialName())) {
                //干酪乳杆菌 有益菌
                Double lactobacillusFermentum = bacterialReport.getLactobacillusFermentum();
                if (Arith.compareTo(lactobacillusFermentum.toString(), bacterialReference.getQuartileOne().toString()) >= 0 ) {
                    if (Arith.compareTo(lactobacillusFermentum.toString(), bacterialReference.getQuartileThree().toString()) <= 0 ) {
                        bacterialResult.setLactobacillusFermentum((byte) 0);
                    }else{
                        bacterialResult.setLactobacillusFermentum((byte) 2);
                    }
                }else{
                    bacterialResult.setLactobacillusFermentum((byte) 1);
                }
            }

            if (Constant.LACTOBACILLUS_HELVETICUS .equals(bacterialReference.getBacterialName())) {
                //瑞士乳杆菌 有益菌
                Double lactobacillusHelveticus = bacterialReport.getLactobacillusHelveticus();
                if (Arith.compareTo(lactobacillusHelveticus.toString(), bacterialReference.getQuartileOne().toString()) >= 0 ) {
                    if (Arith.compareTo(lactobacillusHelveticus.toString(), bacterialReference.getQuartileThree().toString()) <= 0 ) {
                        bacterialResult.setLactobacillusHelveticus((byte) 0);
                    }else{
                        bacterialResult.setLactobacillusHelveticus((byte) 2);
                    }
                }else{
                    bacterialResult.setLactobacillusHelveticus((byte) 1);
                }
            }

            if (Constant.LACTOBACILLUS_JOHNSONII .equals(bacterialReference.getBacterialName())) {
                //约氏乳杆菌 有益菌
                Double lactobacillusJohnsonii = bacterialReport.getLactobacillusJohnsonii();
                if (Arith.compareTo(lactobacillusJohnsonii.toString(), bacterialReference.getQuartileOne().toString()) >= 0 ) {
                    if (Arith.compareTo(lactobacillusJohnsonii.toString(), bacterialReference.getQuartileThree().toString()) <= 0 ) {
                        bacterialResult.setLactobacillusJohnsonii((byte) 0);
                    }else{
                        bacterialResult.setLactobacillusJohnsonii((byte) 2);
                    }
                }else{
                    bacterialResult.setLactobacillusJohnsonii((byte) 1);
                }
            }
            if (Constant.LACTOBACILLUS_REUTERI .equals(bacterialReference.getBacterialName())) {
                //罗伊氏乳杆菌 有益菌
                Double lactobacillusReuteri = bacterialReport.getLactobacillusReuteri();
                if (Arith.compareTo(lactobacillusReuteri.toString(), bacterialReference.getQuartileOne().toString()) >= 0 ) {
                    if (Arith.compareTo(lactobacillusReuteri.toString(), bacterialReference.getQuartileThree().toString()) <= 0 ) {
                        bacterialResult.setLactobacillusReuteri((byte) 0);
                    }else{
                        bacterialResult.setLactobacillusReuteri((byte) 2);
                    }
                }else{
                    bacterialResult.setLactobacillusReuteri((byte) 1);
                }
            }

            if (Constant.LACTOBACILLUS_SALIVARIUS .equals(bacterialReference.getBacterialName())) {
                //唾液乳杆菌 有益菌
                Double lactobacillusSalivarius = bacterialReport.getLactobacillusSalivarius();
                if (Arith.compareTo(lactobacillusSalivarius.toString(), bacterialReference.getQuartileOne().toString()) >= 0 ) {
                    if (Arith.compareTo(lactobacillusSalivarius.toString(), bacterialReference.getQuartileThree().toString()) <= 0 ) {
                        bacterialResult.setLactobacillusSalivarius((byte) 0);
                    }else{
                        bacterialResult.setLactobacillusSalivarius((byte) 2);
                    }
                }else{
                    bacterialResult.setLactobacillusSalivarius((byte) 1);
                }
            }

            if (Constant.LACTOCOCCUS_LACTIS .equals(bacterialReference.getBacterialName())) {
                //乳酸乳球菌 有益菌
                Double lactococcusLactis = bacterialReport.getLactococcusLactis();
                if (Arith.compareTo(lactococcusLactis.toString(), bacterialReference.getQuartileOne().toString()) >= 0 ) {
                    if (Arith.compareTo(lactococcusLactis.toString(), bacterialReference.getQuartileThree().toString()) <= 0 ) {
                        bacterialResult.setLactococcusLactis((byte) 0);
                    }else{
                        bacterialResult.setLactococcusLactis((byte) 2);
                    }
                }else{
                    bacterialResult.setLactococcusLactis((byte) 1);
                }
            }

            if (Constant.ROSEBURIA_INULINIVORANS .equals(bacterialReference.getBacterialName())) {
                //短乳杆菌 有益菌
                Double roseburiaInulinivorans = bacterialReport.getRoseburiaInulinivorans();
                if (Arith.compareTo(roseburiaInulinivorans.toString(), bacterialReference.getQuartileOne().toString()) >= 0 ) {
                    if (Arith.compareTo(roseburiaInulinivorans.toString(), bacterialReference.getQuartileThree().toString()) <= 0 ) {
                        bacterialResult.setRoseburiaInulinivorans((byte) 0);
                    }else{
                        bacterialResult.setRoseburiaInulinivorans((byte) 2);
                    }
                }else{
                    bacterialResult.setRoseburiaInulinivorans((byte) 1);
                }
            }

            if (Constant.SALMONELLA_ENTERICA.equals(bacterialReference.getBacterialName())) {
                //沙门氏菌 致病菌
                Double salmonellaEnterica = bacterialReport.getSalmonellaEnterica();
                if (salmonellaEnterica>0) {
                    if (Arith.compareTo(salmonellaEnterica.toString(), bacterialReference.getQuartileThree().toString()) > 0){
                        bacterialResult.setSalmonellaEnterica((byte) 2);
                    }else{
                        bacterialResult.setSalmonellaEnterica((byte) 1);
                    }
                } else {
                    bacterialResult.setSalmonellaEnterica((byte) 0);
                }
            }

            if (Constant.STAPHYLOCOCCUS_AUREUS.equals(bacterialReference.getBacterialName())) {
                //金黄色葡萄球菌 中性菌
                Double staphylococcusAureus = bacterialReport.getStaphylococcusAureus();
                //25%
                if (Arith.compareTo(staphylococcusAureus.toString(), bacterialReference.getQuartileOne().toString()) >= 0 ) {
                    if (Arith.compareTo(staphylococcusAureus.toString(), bacterialReference.getQuartileThree().toString()) <= 0 ) {
                        bacterialResult.setStaphylococcusAureus((byte) 0);
                    }else{
                        bacterialResult.setStaphylococcusAureus((byte) 2);
                    }
                } else {
                    bacterialResult.setStaphylococcusAureus((byte) 1);
                }

            }

            if (Constant.STREPTOCOCCUS_ANGINOSUS.equals(bacterialReference.getBacterialName())) {
                //咽峡炎链球菌 中性菌
                Double streptococcusAnginosus = bacterialReport.getStreptococcusAnginosus();
                //25%
                if (Arith.compareTo(streptococcusAnginosus.toString(), bacterialReference.getQuartileOne().toString()) >= 0 ) {
                    if (Arith.compareTo(streptococcusAnginosus.toString(), bacterialReference.getQuartileThree().toString()) <= 0 ) {
                        bacterialResult.setStreptococcusAnginosus((byte) 0);
                    }else{
                        bacterialResult.setStreptococcusAnginosus((byte) 2);
                    }
                } else {
                    bacterialResult.setStreptococcusAnginosus((byte) 1);
                }

            }

            if (Constant.STREPTOCOCCUS_SUIS.equals(bacterialReference.getBacterialName())) {
                //猪链球菌 中性菌
                Double streptococcusSuis = bacterialReport.getStreptococcusSuis();
                //25%
                if (Arith.compareTo(streptococcusSuis.toString(), bacterialReference.getQuartileOne().toString()) >= 0 ) {
                    if (Arith.compareTo(streptococcusSuis.toString(), bacterialReference.getQuartileThree().toString()) <= 0 ) {
                        bacterialResult.setStreptococcusSuis((byte) 0);
                    }else{
                        bacterialResult.setStreptococcusSuis((byte) 2);
                    }
                } else {
                    bacterialResult.setStreptococcusSuis((byte) 1);
                }

            }

            if (Constant.STREPTOCOCCUS_THERMOPHILUS .equals(bacterialReference.getBacterialName())) {
                //嗜热链球菌 有益菌
                Double streptococcusThermophilus = bacterialReport.getStreptococcusThermophilus();
                if (Arith.compareTo(streptococcusThermophilus.toString(), bacterialReference.getQuartileOne().toString()) >= 0 ) {
                    if (Arith.compareTo(streptococcusThermophilus.toString(), bacterialReference.getQuartileThree().toString()) <= 0 ) {
                        bacterialResult.setStreptococcusThermophilus((byte) 0);
                    }else{
                        bacterialResult.setStreptococcusThermophilus((byte) 2);
                    }
                }else{
                    bacterialResult.setStreptococcusThermophilus((byte) 1);
                }
            }
            if (Constant.VEILLONELLA_PARVULA.equals(bacterialReference.getBacterialName())) {
                //小韦容球菌 中性菌
                Double veillonellaParvula = bacterialReport.getVeillonellaParvula();
                //25%
                if (Arith.compareTo(veillonellaParvula.toString(), bacterialReference.getQuartileOne().toString()) >= 0 ) {
                    if (Arith.compareTo(veillonellaParvula.toString(), bacterialReference.getQuartileThree().toString()) <= 0 ) {
                        bacterialResult.setVeillonellaParvula((byte) 0);
                    }else{
                        bacterialResult.setVeillonellaParvula((byte) 2);
                    }
                } else {
                    bacterialResult.setVeillonellaParvula((byte) 1);
                }

            }
            if (Constant.BACTEROIDES_UNIFORMIS .equals(bacterialReference.getBacterialName())) {
                //单形拟杆菌 有益菌
                Double bacteroidesUniformis = bacterialReport.getBacteroidesUniformis();
                if (Arith.compareTo(bacteroidesUniformis.toString(), bacterialReference.getQuartileOne().toString()) >= 0 ) {
                    if (Arith.compareTo(bacteroidesUniformis.toString(), bacterialReference.getQuartileThree().toString()) <= 0 ) {
                        bacterialResult.setBacteroidesUniformis((byte) 0);
                    }else{
                        bacterialResult.setBacteroidesUniformis((byte) 2);
                    }
                }else{
                    bacterialResult.setBacteroidesUniformis((byte) 1);
                }
            }

        }
        try{
            bacterialResult.setTubeNumber(reportTubeId);
            bacterialResultMapper.insertSelective(bacterialResult);
            int a = 1/0;

        }catch (Exception e){
            LOG.error("保存报告数据失败"+ e);
            e.printStackTrace();
            //return CommonResult.fail("保存报告数据失败");
        }
        LOG.info("结束执行代码"+ DateFormatUtil.transForDate3((int)System.currentTimeMillis()));
        return CommonResult.ok("生成报告成功");
    }

    /**
     * 查询用户采样管检测数据
     * @return
     */
    public UserReport selectUserReportData(int reportTubeId) {
        UserReport userReport = userReportMapper.selectUserReportData(reportTubeId);
        return userReport;
    }
    /**
     * 查询基线人群
     * @return
     */
    public List<BacterialReference> selectBacterialReference() {
        List<BacterialReference> list = bacterialReferenceMapper.selectBacterialReference();
        return list;
    }
    /**
     * 根据采样管查询
     * @param reportTubeId
     * @return
     */
    public UserReport selectUserReport(String reportTubeId) {
        UserReport userReport = userReportMapper.selectUserReport(reportTubeId);
        return userReport;
    }


}
