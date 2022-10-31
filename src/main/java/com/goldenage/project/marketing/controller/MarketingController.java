package com.goldenage.project.marketing.controller;

import com.goldenage.project.marketing.model.dto.MarketingDTO;
import com.goldenage.project.marketing.model.dto.MkItemDTO;
import com.goldenage.project.marketing.model.dto.MkMdDTO;
import com.goldenage.project.marketing.model.dto.MkPosterDTO;
import com.goldenage.project.marketing.model.service.MarketingServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/marketing")
public class MarketingController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final MarketingServiceImpl marketingService;


    @Autowired
    public MarketingController(MarketingServiceImpl marketingService){

        this.marketingService = marketingService;
    }


    @GetMapping("/list")
    public ModelAndView marketingList(HttpServletRequest request, ModelAndView mv){

        List<MarketingDTO> marketingList = marketingService.selectAllMarketing();

        mv.addObject("marketingList", marketingList);
        mv.setViewName("/marketing/marketing");

        return mv;
    }

    @GetMapping("/detail")
    public ModelAndView marketingDetail(ModelAndView mv, HttpServletRequest request, @RequestParam(value = "mkNum", required = false) String mkNum){

        String num = request.getParameter("mkNum");
        log.info("mkNum : " + mkNum);

        MarketingDTO marketingDetail = marketingService.selectOneMarketing(mkNum);
        List<MkPosterDTO> mkPosterList = marketingService.selectAllPoster(mkNum);
        List<MkMdDTO> mkMdList = marketingService.selectAllMd(mkNum);
        List<MkItemDTO> mkItemList = marketingService.selectAllItem(mkNum);

        mv.addObject("marketingDetail", marketingDetail);
        mv.addObject("mkPosterList", mkPosterList);
        mv.addObject("mkMdList", mkMdList);
        mv.addObject("mkItemList", mkItemList);

        mv.setViewName("/marketing/marketing_detail");
        return mv;
    }
}
