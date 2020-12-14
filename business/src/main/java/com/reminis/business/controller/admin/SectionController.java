package com.reminis.business.controller.admin;

import com.reminis.server.domain.Section;
import com.reminis.server.dto.SectionDto;
import com.reminis.server.dto.PageDto;
import com.reminis.server.dto.ResponseDto;
import com.reminis.server.service.SectionService;
import com.reminis.server.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/section")
public class SectionController {
    private static final Logger LOG = LoggerFactory.getLogger(SectionController.class);
    private static final String BUSINESS_NAME = "小节";

    @Resource
    private SectionService sectionService;

    /**
     * 大章列表查询
     * @param pageDto
     * @return
     */
    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
        ResponseDto responseDto = new ResponseDto();
        sectionService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }

    /**
     * 保存大章信息
     * @param sectionDto
     * @return
     */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody SectionDto sectionDto) {
        //保存校验

        ResponseDto responseDto = new ResponseDto();
        sectionService.save(sectionDto);
        responseDto.setContent(sectionDto);
        return responseDto;
    }

    /**
     * 删除大章信息
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id) {
        ResponseDto responseDto = new ResponseDto();
        sectionService.delete(id);
        responseDto.setContent(id);
        return responseDto;
    }

}
