package com.goldenage.project.notice.controller;

import com.goldenage.project.notice.model.dto.NoticeDTO;
import com.goldenage.project.notice.model.service.NoticeServiceImpl;
import com.goldenage.project.paging.Pagenation;
import com.goldenage.project.paging.SelectCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeServiceImpl noticeService;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public NoticeController(NoticeServiceImpl noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping("/notice")
    public ModelAndView noticeList(ModelAndView mv,  HttpServletRequest request){

        String currentPage = request.getParameter("currentPage");
        int pageNo = 1;

        if(currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
        }

        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);

        log.info("[NoticeController] searchMap = " + searchMap);

        int totalCount = noticeService.selectTotalCount(searchMap);

        log.info("[NoticeController] totalCount = " + totalCount);

        int limit = 6;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if(searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        }

        List<NoticeDTO> noticeList = noticeService.selectNoticeList(selectCriteria);

        mv.addObject("noticeList", noticeList);
        mv.addObject("selectCriteria", selectCriteria);
        mv.setViewName("/notice/notice");

        return mv;
    }

    @GetMapping("/notice_view")
    public ModelAndView noticeDetail(ModelAndView mv, HttpServletRequest request){

        int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));

        log.info("noticeNo 무엇 : " + noticeNo);
        NoticeDTO noticeDetail = noticeService.selectNoticeDetail(noticeNo);

        mv.addObject("noticeDetail", noticeDetail);
        mv.setViewName("/notice/notice_view");

        return mv;
    }
}
