package com.goldenage.project.notice.model.service;

import com.goldenage.project.exception.notice.NoticeDeleteException;
import com.goldenage.project.exception.notice.NoticeInsertException;
import com.goldenage.project.notice.model.dto.NoticeDTO;
import com.goldenage.project.notice.model.dto.NoticeFileDTO;
import com.goldenage.project.paging.SelectCriteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface NoticeService {
    List<NoticeDTO> selectNoticeList(SelectCriteria selectCriteria);

    NoticeDTO selectNoticeDetail(int noticeNo);

    int selectTotalCount(Map<String, String> searchMap);

    /* 공지사항 등록 */
    @Transactional
    int noticeInsert(NoticeDTO notice) throws NoticeInsertException;

    /* 공지사항 파일 등록*/
    @Transactional
    int noticeFileInsert(NoticeFileDTO noticeFile);

    @Transactional
    int updateNotice(NoticeDTO notice);

    @Transactional
    int delelteNoticeFile(int noticeNo);

    /* 공지사항 파일 수정 */
    @Transactional
    int updateNoticeFile(NoticeFileDTO noticeFile);

    //공지사항 삭제
    @Transactional
    int deleteNotice(int noticeNo) throws NoticeDeleteException;
}
