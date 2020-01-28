package com.leyou.upload.service;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author hhl
 * @date - 14:02
 */
@Service
public class UploadService {

    private static final List<String> CONTENT_TYPES = Arrays.asList("image/gif","image/jpeg","application/x-img");
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadService.class);

    @Autowired
    private FastFileStorageClient storageClient;


    public String uploadImage(MultipartFile file){
        String originalFilename = file.getOriginalFilename();
        try {
            //校验文件类型
            //StringUtils.substringAfterLast(originalFilename,".");
            String contentType = file.getContentType();
            if (!CONTENT_TYPES.contains(contentType)){
                LOGGER.info("文件类型不合法：{}" , originalFilename);
                return null;
            }
            //校验文件的内容
            BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
            if (bufferedImage == null){
                LOGGER.info("文件内容不合法：{}",originalFilename);
                return null;
            }
            //保存到文件的服务器
            //UUID uuid = UUID.randomUUID();
            //file.transferTo(new File("D:\\IDEA\\workspaces\\乐优商城\\image\\" + uuid));//该处路径最后要加\否则会将文件保存到乐游商城目录下
            //返回url，进行回写
            //return "http://image.leyou.com/" + uuid;
            String ext = StringUtils.substringAfterLast(originalFilename,".");;
            StorePath storePath = this.storageClient.uploadFile(file.getInputStream(), file.getSize(), ext, null);

            return "http://image.leyou.com/" + storePath.getFullPath();
        } catch (IOException e) {
            LOGGER.info("服务器内部错误：" +  originalFilename);
            e.printStackTrace();
        }
        return null;
    }




}
