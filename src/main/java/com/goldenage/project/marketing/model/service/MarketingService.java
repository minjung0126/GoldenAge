package com.goldenage.project.marketing.model.service;

import com.goldenage.project.marketing.exception.MkException;
import com.goldenage.project.marketing.model.dto.MarketingDTO;
import com.goldenage.project.marketing.model.dto.MkItemDTO;
import com.goldenage.project.marketing.model.dto.MkMdDTO;
import com.goldenage.project.marketing.model.dto.MkPosterDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MarketingService {


    List<MarketingDTO> selectAllMarketing();

    MarketingDTO selectOneMarketing(String mkNum);

    List<MkPosterDTO> selectAllPoster(String mkNum);

    List<MkMdDTO> selectAllMd(String mkNum);

    List<MkItemDTO> selectAllItem(String mkNum);

    @Transactional
    int insertMkInfo(MarketingDTO marketing) throws MkException;

    @Transactional
    int updateMkInfo(MarketingDTO marketing) throws MkException;

    @Transactional
    int updateMkInfoNoFile(MarketingDTO marketing) throws MkException;

    @Transactional
    int deleteMkInfo(String mkNum) throws MkException;

    MkPosterDTO selectPoster(String pFileNum);

    MkMdDTO selectMd(String mdFileNum);

    MkItemDTO selectItem(String itemFileNum);

    @Transactional
    int updateMkPoster(MkPosterDTO mkPoster) throws MkException;

    @Transactional
    int updateMkPosterNoFile(MkPosterDTO mkPoster) throws MkException;

    @Transactional
    int updateMkMd(MkMdDTO mkMd) throws MkException;

    @Transactional
    int updateMkMdNoFile(MkMdDTO mkMd) throws MkException;

    @Transactional
    int updateMkItem(MkItemDTO mkItem) throws MkException;

    @Transactional
    int updateMkItemNoFile(MkItemDTO mkItem) throws MkException;

    @Transactional
    int insertMkPoster(MkPosterDTO mkPoster) throws MkException;

    @Transactional
    int insertMkMd(MkMdDTO mkMd) throws MkException;

    @Transactional
    int insertMkItem(MkItemDTO mkItem) throws MkException;

    @Transactional
    int deleteMkPoster(int pFileNum) throws MkException;

    @Transactional
    int deleteMkMd(int mdFileNum) throws MkException;

    @Transactional
    int deleteMkItem(int itemFileNum) throws MkException;
}
