package com.goldenage.project.notice.model.service;

import com.goldenage.project.notice.model.dao.NoticeMapper;
import com.goldenage.project.notice.model.dto.NoticeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{

    private NoticeMapper noticeMapper;

    @Autowired
    public NoticeServiceImpl(NoticeMapper noticeMapper){
        this.noticeMapper = noticeMapper;
    }
    @Override
    public List<NoticeDTO> selectNoticeList() {

        List<NoticeDTO> noticeList = noticeMapper.selectNoticeList();

        return noticeList;
    }
}
