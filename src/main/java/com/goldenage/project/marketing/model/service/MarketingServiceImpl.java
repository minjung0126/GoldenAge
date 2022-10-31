package com.goldenage.project.marketing.model.service;

import com.goldenage.project.marketing.model.dao.MarketingMapper;
import com.goldenage.project.marketing.model.dto.MarketingDTO;
import com.goldenage.project.marketing.model.dto.MkItemDTO;
import com.goldenage.project.marketing.model.dto.MkMdDTO;
import com.goldenage.project.marketing.model.dto.MkPosterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketingServiceImpl implements MarketingService {

    private final MarketingMapper marketingMapper;

    @Autowired
    public MarketingServiceImpl(MarketingMapper marketingMapper){

        this.marketingMapper = marketingMapper;
    }

    @Override
    public List<MarketingDTO> selectAllMarketing() {

        List<MarketingDTO> marketingList = marketingMapper.selectAllMarketing();
        return marketingList;
    }

    @Override
    public MarketingDTO selectOneMarketing(String mkNum) {

        MarketingDTO marketing = marketingMapper.selectOneMarketing(mkNum);
        return marketing;
    }

    @Override
    public List<MkPosterDTO> selectAllPoster(String mkNum) {

        List<MkPosterDTO> mkPosterList = marketingMapper.selectAllPoster(mkNum);
        return mkPosterList;
    }

    @Override
    public List<MkMdDTO> selectAllMd(String mkNum) {

        List<MkMdDTO> mkMdList = marketingMapper.selectAllMd(mkNum);
        return mkMdList;
    }

    @Override
    public List<MkItemDTO> selectAllItem(String mkNum) {

        List<MkItemDTO> mkItemList = marketingMapper.selectAllItem(mkNum);
        return mkItemList;
    }
}
