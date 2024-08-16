package com.qst.s5.controller;

import com.qst.s5.service.Impl.MkxFileServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Api(tags = "1牛牛file仅供debug 正常不要用")
@RestController
@RequestMapping("/upload_file")
public class TestMkxFileController {
    private MkxFileServiceImpl mkxFileService;

    @Autowired
    public void setMkxFileService(MkxFileServiceImpl mkxFileService) {
        this.mkxFileService = mkxFileService;
    }

    /**
     * 上传一个文件
     * @return 上传文件
     */
    @ApiOperation(value = "上传一个文件")
    @PostMapping(value = "/one_file", produces = "application/json;charset=UTF-8")
    public String upload_one_file(@RequestPart("file") MultipartFile file) throws IOException {
        return mkxFileService.upload_one_file(file);
    }

    /**
     * 上传多个文件
     * @return 上传文件
     */
    @ApiOperation(value = "上传多个文件")
    @PostMapping(value = "/file_list", produces = "application/json;charset=UTF-8")
    public String upload_file_list(@RequestPart("file") List<MultipartFile> files) throws IOException {
        return mkxFileService.upload_file_list(files);
    }
}
