package com.goldenage.project.notice.model.service;

import com.goldenage.project.notice.model.dao.NoticeMapper;
import com.goldenage.project.notice.model.dto.NoticeDTO;
import com.goldenage.project.paging.SelectCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{

    private NoticeMapper noticeMapper;

    @Autowired
    public NoticeServiceImpl(NoticeMapper noticeMapper){
        this.noticeMapper = noticeMapper;
    }
    //공지사항 리스트 보기
    @Override
    public List<NoticeDTO> selectNoticeList(SelectCriteria selectCriteria) {

        List<NoticeDTO> noticeList = noticeMapper.selectNoticeList(selectCriteria);

        return noticeList;
    }

    // 공지사항 상세보기
    @Override
    public NoticeDTO selectNoticeDetail(int noticeNo) {

        NoticeDTO noticeDetail = noticeMapper.selectNoticeDetail(noticeNo);

        return noticeDetail;

    }

    // 공지사항 전체 글 조회
    @Override
    public int selectTotalCount(Map<String, String> searchMap) {

        int result = noticeMapper.selectTotalCount(searchMap);

        return result;
    }
}
