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
}
