package com.goldenage.project.marketing.model.dao;

import com.goldenage.project.marketing.model.dto.MarketingDTO;
import com.goldenage.project.marketing.model.dto.MkItemDTO;
import com.goldenage.project.marketing.model.dto.MkMdDTO;
import com.goldenage.project.marketing.model.dto.MkPosterDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MarketingMapper {
    List<MarketingDTO> selectAllMarketing();

    MarketingDTO selectOneMarketing(String mkNum);

    List<MkPosterDTO> selectAllPoster(String mkNum);

    List<MkMdDTO> selectAllMd(String mkNum);

    List<MkItemDTO> selectAllItem(String mkNum);

    int insertMkInfo(MarketingDTO marketing);

    int updateMkInfo(MarketingDTO marketing);

    int updateMkInfoNoFile(MarketingDTO marketing);

    int deleteMkInfo(String mkNum);

    MkPosterDTO selectPoster(String pFileNum);

    MkMdDTO selectMd(String mdFileNum);

    MkItemDTO selectItem(String itemFileNum);

    int updateMkPoster(MkPosterDTO mkPoster);

    int updateMkPosterNoFile(MkPosterDTO mkPoster);

    int updateMkMd(MkMdDTO mkMd);

    int updateMkMdNoFile(MkMdDTO mkMd);

    int updateMkItem(MkItemDTO mkItem);

    int updateMkItemNoFile(MkItemDTO mkItem);

    int insertMkPoster(MkPosterDTO mkPoster);

    int insertMkMd(MkMdDTO mkMd);

    int insertMkItem(MkItemDTO mkItem);

    int deleteMkPoster(int pFileNum);

    int deleteMkMd(int mdFileNum);

    int deleteMkItem(int itemFileNum);

    List<MkPosterDTO> selectPosterMkNum(String mkNum);

    List<MkMdDTO> selectMdMkNum(String mkNum);

    List<MkItemDTO> selectItemMkNum(String mkNum);
}
