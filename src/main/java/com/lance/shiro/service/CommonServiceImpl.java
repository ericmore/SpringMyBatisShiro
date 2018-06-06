package com.lance.shiro.service;

import com.lance.shiro.entity.IAttachment;
import com.lance.shiro.entity.ICommonConfig;
import com.lance.shiro.entity.IRegion;
import com.lance.shiro.mapper.CommonConfigMapper;
import com.lance.shiro.mapper.CommonMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class CommonServiceImpl implements CommonService {
    public Logger log = LogManager.getLogger(getClass());

    @Autowired
    private CommonMapper commonMapper;

    @Autowired
    private CommonConfigMapper commonConfigMapper;

    @Override
    public List<Map<String, String>> findCountry() {
        List<Map<String, String>> mapList = new ArrayList<>();
        try {
            List<IRegion> iRegionList = commonMapper.findCountry();
            for (IRegion iRegion : iRegionList) {
                Map<String, String> map = new HashMap<>();
                map.put("code", iRegion.getCountry_iso_code());
                map.put("name", iRegion.getCountry_name());
                mapList.add(map);
            }
        } catch (Exception e) {
            log.error(e);
        }

        return mapList;
    }

    @Override
    public List<Map<String, String>> findState(String country) {
        List<Map<String, String>> mapList = new ArrayList<>();
        try {
            List<IRegion> iRegionList = commonMapper.findState(country);
            for (IRegion iRegion : iRegionList) {
                Map<String, String> map = new HashMap<>();
                map.put("code", iRegion.getSubdivision_1_iso_code());
                map.put("name", iRegion.getSubdivision_1_name());
                mapList.add(map);
            }
        } catch (Exception e) {
            log.error(e);
        }
        return mapList;
    }

    @Override
    public List<Map<String, String>> findCity(String country, String state) {

        List<Map<String, String>> mapList = new ArrayList<>();
        try {
            List<IRegion> iRegionList = commonMapper.findCity(country, state);
            for (IRegion iRegion : iRegionList) {
                Map<String, String> map = new HashMap<>();
                map.put("code", iRegion.getCity_name());
                map.put("name", iRegion.getCity_name());
                mapList.add(map);
            }
        } catch (Exception e) {
            log.error(e);
        }
        return mapList;

    }

    @Override
    public List<IAttachment> uploadFiles(List<MultipartFile> files, IAttachment attachment) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            List<IAttachment> iAttachments = new ArrayList<>();
            List<ICommonConfig> rootFilePaths = commonConfigMapper.findCommonConfigs("rootFilePath");
            List<ICommonConfig> rootHttpPaths = commonConfigMapper.findCommonConfigs("rootHttpPath");
            String uploadPath = rootFilePaths.get(0).getcValue() + "attachment/";
            String rootHttpPath = rootHttpPaths.get(0).getcValue() + "rest/common/attachment/";
            File dir = new File(uploadPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            for (MultipartFile file : files) {
                IAttachment temp = new IAttachment();
                if (!file.isEmpty()) {
                    String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                    String fileName = UUID.randomUUID().toString();
                    String fileFullName = String.format("%s%s", fileName, suffix);
                    String fileSize = String.valueOf(file.getSize());
                    String contentType = file.getContentType();
                    temp.setFilePath(rootHttpPath + fileFullName);
                    temp.setFileName(fileName);
                    temp.setExtension(suffix);
                    temp.setFileSize(fileSize);
                    temp.setBelongToID(attachment.getBelongToID());
                    temp.setBelongToCategory(attachment.getBelongToCategory());
                    temp.setDescription(attachment.getDescription());
                    temp.setContentType(contentType);
                    temp.setCreateUser(attachment.getCreateUser());
                    temp.setRealPath(uploadPath + fileFullName);
                    temp.setStatus("0");
                    temp.setCreateTime(formatter.format(new Date()));
                    commonMapper.addAttachment(temp);
                    File fileInfo = new File(String.format("%s%s", uploadPath, fileFullName));
                    org.apache.commons.io.FileUtils.writeByteArrayToFile(fileInfo, file.getBytes());
                    iAttachments.add(temp);
                }
            }
            return iAttachments;
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public String findRootFilePath() {
        List<ICommonConfig> rootFilePaths = commonConfigMapper.findCommonConfigs("rootFilePath");
        return rootFilePaths.get(0).getcValue();
    }

    @Override
    public List<IAttachment> findAllAttachment() {
        return commonMapper.findAllAttachment();
    }
}