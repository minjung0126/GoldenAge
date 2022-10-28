package com.goldenage.project.notice.model.service;

import com.goldenage.project.exception.notice.NoticeInsertException;
import com.goldenage.project.notice.model.dao.NoticeMapper;
import com.goldenage.project.notice.model.dto.NoticeDTO;
import com.goldenage.project.notice.model.dto.NoticeFileDTO;
import com.goldenage.project.paging.SelectCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{

    private NoticeMapper noticeMapper;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

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

        NoticeDTO noticeDetail = null;

        int result = noticeMapper.incrementNoticeCount(noticeNo);

        log.info("값이 오나요 " + result);
        if(result > 0) {

            noticeDetail = noticeMapper.selectNoticeDetail(noticeNo);
        }
        log.info("값이 오나요 " + noticeDetail);
        return noticeDetail;

    }

    // 공지사항 전체 글 조회
    @Override
    public int selectTotalCount(Map<String, String> searchMap) {

        int result = noticeMapper.selectTotalCount(searchMap);

        return result;
    }

    /* 공지사항 등록 */
    @Override
    @Transactional
    public int noticeInsert(NoticeDTO notice) throws NoticeInsertException {

        int result = noticeMapper.noticeInsert(notice);

        if(!(result > 0)) {

            throw new NoticeInsertException("공지사항 등록 실패!");
        }

        return result;
    }

    /* 공지사항 파일 등록*/
    @Override
    @Transactional
    public int noticeFileInsert(NoticeFileDTO noticeFile) {

        return noticeMapper.noticeFileInsert(noticeFile);
    }


}
