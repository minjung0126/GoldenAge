package com.goldenage.project.marketing.model.service;

import com.goldenage.project.marketing.exception.MkException;
import com.goldenage.project.marketing.model.dao.MarketingMapper;
import com.goldenage.project.marketing.model.dto.MarketingDTO;
import com.goldenage.project.marketing.model.dto.MkItemDTO;
import com.goldenage.project.marketing.model.dto.MkMdDTO;
import com.goldenage.project.marketing.model.dto.MkPosterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public int insertMkInfo(MarketingDTO marketing) throws MkException {

        int result = marketingMapper.insertMkInfo(marketing);

        if(!(result > 0)){
            throw new MkException("등록 실패");
        }

        return result;
    }

    @Override
    @Transactional
    public int updateMkInfo(MarketingDTO marketing) throws MkException{

        int result = marketingMapper.updateMkInfo(marketing);

        if(!(result > 0)) {

            throw new MkException("수정 실패");
        }

        return result;
    }

    @Override
    @Transactional
    public int updateMkInfoNoFile(MarketingDTO marketing) throws MkException{

        int result = marketingMapper.updateMkInfoNoFile(marketing);

        if(!(result > 0)) {

            throw new MkException("수정 실패");
        }

        return result;
    }

    @Override
    @Transactional
    public int deleteMkInfo(String mkNum) throws MkException{

        int result = marketingMapper.deleteMkInfo(mkNum);

        if(!(result > 0)){
            throw new MkException("삭제 실패");
        }

        return result;
    }

    @Override
    public MkPosterDTO selectPoster(String pFileNum) {

        MkPosterDTO mkPoster = marketingMapper.selectPoster(pFileNum);
        return mkPoster;
    }

    @Override
    public MkMdDTO selectMd(String mdFileNum) {

        MkMdDTO mkMd = marketingMapper.selectMd(mdFileNum);
        return mkMd;
    }

    @Override
    public MkItemDTO selectItem(String itemFileNum) {

        MkItemDTO mkItem = marketingMapper.selectItem(itemFileNum);
        return mkItem;
    }

    @Override
    @Transactional
    public int updateMkPoster(MkPosterDTO mkPoster) throws MkException{

        int result = marketingMapper.updateMkPoster(mkPoster);

        if(!(result > 0)) {

            throw new MkException("수정 실패");
        }

        return result;
    }

    @Override
    @Transactional
    public int updateMkPosterNoFile(MkPosterDTO mkPoster) throws MkException{

        int result = marketingMapper.updateMkPosterNoFile(mkPoster);

        if(!(result > 0)) {

            throw new MkException("수정 실패");
        }

        return result;
    }

    @Override
    @Transactional
    public int updateMkMd(MkMdDTO mkMd) throws MkException{

        int result = marketingMapper.updateMkMd(mkMd);

        if(!(result > 0)) {

            throw new MkException("수정 실패");
        }

        return result;
    }

    @Override
    @Transactional
    public int updateMkMdNoFile(MkMdDTO mkMd) throws MkException{

        int result = marketingMapper.updateMkMdNoFile(mkMd);

        if(!(result > 0)) {

            throw new MkException("수정 실패");
        }

        return result;
    }

    @Override
    @Transactional
    public int updateMkItem(MkItemDTO mkItem) throws MkException{

        int result = marketingMapper.updateMkItem(mkItem);

        if(!(result > 0)) {

            throw new MkException("수정 실패");
        }

        return result;
    }

    @Override
    @Transactional
    public int updateMkItemNoFile(MkItemDTO mkItem) throws MkException{

        int result = marketingMapper.updateMkItemNoFile(mkItem);

        if(!(result > 0)) {

            throw new MkException("수정 실패");
        }

        return result;
    }

    @Override
    @Transactional
    public int insertMkPoster(MkPosterDTO mkPoster) throws MkException{

        int result = marketingMapper.insertMkPoster(mkPoster);

        if(!(result > 0)){
            throw new MkException("등록 실패");
        }

        return result;
    }

    @Override
    @Transactional
    public int insertMkMd(MkMdDTO mkMd) throws MkException{

        int result = marketingMapper.insertMkMd(mkMd);

        if(!(result > 0)){
            throw new MkException("등록 실패");
        }

        return result;
    }

    @Override
    @Transactional
    public int insertMkItem(MkItemDTO mkItem) throws MkException{

        int result = marketingMapper.insertMkItem(mkItem);

        if(!(result > 0)){
            throw new MkException("등록 실패");
        }

        return result;
    }

    @Override
    @Transactional
    public int deleteMkPoster(int pFileNum) throws MkException{

        int result = marketingMapper.deleteMkPoster(pFileNum);

        if(!(result > 0)){
            throw new MkException("삭제 실패");
        }

        return result;
    }

    @Override
    @Transactional
    public int deleteMkMd(int mdFileNum) throws MkException{

        int result = marketingMapper.deleteMkMd(mdFileNum);

        if(!(result > 0)){
            throw new MkException("삭제 실패");
        }

        return result;
    }

    @Override
    @Transactional
    public int deleteMkItem(int itemFileNum) throws MkException{

        int result = marketingMapper.deleteMkItem(itemFileNum);

        if(!(result > 0)){
            throw new MkException("삭제 실패");
        }

        return result;
    }
}
