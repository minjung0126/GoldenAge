package com.goldenage.project.space.model.service;

import com.goldenage.project.exception.space.SpaceDeleteException;
import com.goldenage.project.exception.space.SpaceInsertException;
import com.goldenage.project.space.model.dao.SpaceMapper;
import com.goldenage.project.space.model.dto.SpaceDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("spaceService")
public class SpaceServiceImpl implements SpaceService{

    private SpaceMapper spaceMapper;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public SpaceServiceImpl(SpaceMapper spaceMapper) {
        this.spaceMapper = spaceMapper;

    }

    // 관리자 연습실 리스트
    @Override
    public List<SpaceDTO> selectSpaceList() {

        List<SpaceDTO> spaceList = spaceMapper.selectSpaceList();

        return spaceList;
    }
    // 연습실 등록
    @Override
    @Transactional
    public int insertSpace(SpaceDTO space) throws SpaceInsertException {

        int result = spaceMapper.insertSpace(space);


        if(!(result > 0)){

            throw new SpaceInsertException("연습실 등록 실패!");

        }

        return result;
    }

    // 연습실 사진 등록
    @Override
    @Transactional
    public int insertSpacePho(List<Map<String, String>> files) {

        int result = spaceMapper.insertSpacePhoto((Map<String, String>) files);

//        log.info("뭘가요 왤까요"+ files.size());
//        for(int i =0; i < files.size(); i++){
//
//            Map<String, String> pho = files.get(i);
//            log.info("어디서잘못돌고있니" + pho);
//            result += spaceMapper.insertSpacePhoto(pho);
//
//        }
        log.info("잔디처럼 "+result);

        return result;
    }


    //연습실 삭제
    @Override
    @Transactional
    public int deleteSpace(int spaceNum) throws SpaceDeleteException {

        int result = spaceMapper.deleteSpaceFile(spaceNum);
        int result2 = spaceMapper.deleteSpace(spaceNum);

        if(!(result2 > 0)){

            throw new SpaceDeleteException("연습실 삭제 실패!");
        }

        return result;
    }

    @Override
    public int selectNum() {

        int selectNum = spaceMapper.selectNum();

        return selectNum;
    }
}

