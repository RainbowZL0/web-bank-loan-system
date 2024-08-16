package com.qst.s5.service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface MkxFileService {
    String save_to_folder_path = "D:/qst/uploadPath/";

    String upload_one_file(MultipartFile file) throws IOException;
    String upload_file_list(List<MultipartFile> files) throws IOException;
    String save_one_file_to_path(MultipartFile file, String save_to_file_path) throws IOException;
    String join_path(String path1, String path2);
}
