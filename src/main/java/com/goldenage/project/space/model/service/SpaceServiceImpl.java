package com.goldenage.project.space.model.service;

import com.goldenage.project.exception.notice.NoticeDeleteException;
import com.goldenage.project.exception.space.SpaceDeleteException;
import com.goldenage.project.space.model.dao.SpaceMapper;
import com.goldenage.project.space.model.dto.SpaceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("spaceService")
public class SpaceServiceImpl implements SpaceService{

    private SpaceMapper spaceMapper;

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
}

