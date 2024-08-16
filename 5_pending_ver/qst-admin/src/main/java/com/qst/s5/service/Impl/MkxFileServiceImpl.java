package com.qst.s5.service.Impl;

import com.qst.s5.service.MkxFileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class MkxFileServiceImpl implements MkxFileService {

    /**
     * 拼接路径
     * @param path1 路径1
     * @param path2 路径2
     * @return 拼接后的路径
     */
    public String join_path(String path1, String path2) {
        // 首先判断是否为空串""，robustness
        if (path1.isEmpty()) {
            return path2;
        }
        Path path = Paths.get(path1, path2);
        return path.toString();
    }

    /**
     * 保存单个文件到指定路径
     * 不要用Controller直接调用这个方法。
     * @param file 文件
     * @param save_to_file_path 保存路径
     * @return 保存结果
     * @throws IOException IO异常
     */
    public String save_one_file_to_path(MultipartFile file, String save_to_file_path) throws IOException {
        if (file.isEmpty()) {
            return "上传失败";
        }
        File new_file = new File(save_to_file_path);
        file.transferTo(new_file);
        return "上传成功";
    }

    /**
     * 上传单个文件
     *
     * @param file 文件
     * @return 上传结果
     * @throws IOException IO异常
     */
    public String upload_one_file(MultipartFile file) throws IOException {
        String file_path = this.join_path(save_to_folder_path, file.getOriginalFilename());
        return this.save_one_file_to_path(file, file_path);
    }

    /**
     * 上传多个文件
     *
     * @param files 文件列表
     * @return 上传结果
     * @throws IOException IO异常
     */
    public String upload_file_list(List<MultipartFile> files) throws IOException {
        String upload_status = "";
        for (MultipartFile file : files) {
            String file_path = this.join_path(save_to_folder_path, file.getOriginalFilename());
            upload_status = this.save_one_file_to_path(file, file_path);
            if (!upload_status.equals("上传成功")) {
                break;
            }
        }
        return upload_status;
    }
}
