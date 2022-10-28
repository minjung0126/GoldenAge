package com.goldenage.project.marketing.model.service;

import com.goldenage.project.marketing.model.dto.MarketingDTO;
import com.goldenage.project.marketing.model.dto.MkItemDTO;
import com.goldenage.project.marketing.model.dto.MkMdDTO;
import com.goldenage.project.marketing.model.dto.MkPosterDTO;

import java.util.List;

public interface MarketingService {


    List<MarketingDTO> selectAllMarketing();

    MarketingDTO selectOneMarketing(String mkNum);

    List<MkPosterDTO> selectAllPoster(String mkNum);

    List<MkMdDTO> selectAllMd(String mkNum);

    List<MkItemDTO> selectAllItem(String mkNum);
}
