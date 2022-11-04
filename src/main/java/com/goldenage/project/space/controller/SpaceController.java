package com.goldenage.project.space.controller;

import com.goldenage.project.exception.notice.NoticeDeleteException;
import com.goldenage.project.exception.space.SpaceDeleteException;
import com.goldenage.project.space.model.dto.SpaceDTO;
import com.goldenage.project.space.model.dto.SpacePhoDTO;
import com.goldenage.project.space.model.service.SpaceServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/space/*")
public class SpaceController {

    private final SpaceServiceImpl spaceService;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public SpaceController(SpaceServiceImpl spaceService) {
        this.spaceService = spaceService;
    }

    // 관리자 연습실 리스트 출력
    @GetMapping("/spaceList")
    public ModelAndView spaceList(ModelAndView mv, HttpServletRequest request){

        List<SpaceDTO> spaceList = spaceService.selectSpaceList();

        log.info("뭘까정말" + spaceList);

        mv.addObject("spaceList", spaceList);
        mv.setViewName("space/spaceList");

        return mv;

    }

    // 관리자 연습실 추가 화면보기
    @GetMapping("/spaceInsert")
    public String spaceInsertView(){

        return "space/spaceInsert";
    }

    @PostMapping("/spaceInsert")
    public String insertSpace(@ModelAttribute SpaceDTO space
            , @RequestParam(value="multiFiles", required = false) List<MultipartFile> multiFiles
            , RedirectAttributes rttr) throws Exception {

        SpacePhoDTO spacePho = new SpacePhoDTO();

        int result = spaceService.insertSpace(space);

        String root = ResourceUtils.getURL("src/main/resources").getPath();

        String filePath = root + "static/images/space";

        File mkdir = new File(filePath);
        if(!mkdir.exists()) {
            mkdir.mkdirs();
        }

        if(multiFiles.size() > 0){
            List<Map<String,String>> files = new ArrayList<>();
            for(int i = 0; i < multiFiles.size(); i++) {

                String spaceOriName = "";
                String ext = "";
                String spaceFileName = "";
                String spaceName = spaceService.selectNum();

                spaceOriName = multiFiles.get(i).getOriginalFilename();
                ext = spaceOriName.substring(spaceOriName.lastIndexOf("."));
                spaceFileName = UUID.randomUUID().toString().replace("-", "") + ext;

                Map<String, String> file = new HashMap<>();
                file.put("spaceOriName", spaceOriName);
                file.put("spaceFileName", spaceFileName);
                file.put("spaceName", spaceName);

                files.add(file);
                spaceService.insertSpacePho(files);
            }

                try {

                    for (int j = 0; j < multiFiles.size(); j++) {

                        Map<String, String> pho = files.get(j);
                        multiFiles.get(j).transferTo(new File(filePath + "/" + pho.get("spaceFileName")));
                    }
                } catch (IOException e) {

                    for (int j = 0; j < multiFiles.size(); j++) {

                        Map<String, String> pho = files.get(j);
                        new File(filePath + "/" + pho.get("spaceFileName")).delete();
                    }
                }
        }else if(multiFiles.size() == 0){

            String spaceName = spaceService.selectNum();

            spacePho.setSpaceFileName(null);
            spacePho.setSpaceName(spaceName);
            spacePho.setSpaceOriName(null);

            spaceService.insertSpacePho((List<Map<String, String>>) spacePho);

        }
        rttr.addFlashAttribute("message", "연습실 등록 성공!");

        return "redirect:/space/spaceList";

    }

    //연습실 삭제
    @GetMapping("/delete")
    public String spaceDelete(HttpServletRequest request, RedirectAttributes rttr) throws SpaceDeleteException {

        int spaceNum = Integer.parseInt(request.getParameter("spaceNum"));

        int result = spaceService.deleteSpace(spaceNum);

        rttr.addFlashAttribute("message", "연습실 삭제 성공!");

        return "redirect:/space/spaceList";
    }

    @GetMapping("/theater")
    public String theaher(){

        return "space/theater";
    }
}

