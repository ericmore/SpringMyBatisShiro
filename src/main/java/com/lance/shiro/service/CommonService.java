package com.lance.shiro.service;

import com.lance.shiro.entity.IAttachment;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface CommonService {

    /**
     * find country
     *
     * @return
     */
    List<Map<String, String>> findCountry();

    /**
     * find state
     *
     * @param country
     * @return
     */
    List<Map<String, String>> findState(String country);

    /**
     * find city
     * @param country
     * @param state
     * @return
     */
    List<Map<String, String>> findCity(String country, String state);

    /**
     * upload files
     * @param files
     * @param attachment
     * @return
     */
    List<IAttachment> uploadFiles(List<MultipartFile> files, IAttachment attachment);

    /**
     *
     * @return
     */
    String findRootFilePath();
}
