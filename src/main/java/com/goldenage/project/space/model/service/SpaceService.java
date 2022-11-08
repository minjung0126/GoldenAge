package com.goldenage.project.space.model.service;

import com.goldenage.project.exception.notice.NoticeDeleteException;
import com.goldenage.project.exception.space.SpaceDeleteException;
import com.goldenage.project.exception.space.SpaceInsertException;
import com.goldenage.project.space.model.dto.SpaceDTO;
import com.goldenage.project.space.model.dto.SpacePhoDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface SpaceService {
    // 관리자 연습실 리스트
    List<SpaceDTO> selectSpaceList();

    // 연습실 등록
    @Transactional
    int insertSpace(SpaceDTO space) throws SpaceInsertException;


    // 연습실 사진 등록
    @Transactional
    int insertSpacePho(List<Map<String, String>> files);

    //연습실 삭제
    @Transactional
    int deleteSpace(int spaceNum) throws NoticeDeleteException, SpaceDeleteException;

    String selectNum();
}
