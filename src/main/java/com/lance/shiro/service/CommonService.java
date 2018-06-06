package com.lance.shiro.service;

import com.lance.shiro.entity.IAttachment;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
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
     *
     * @param country
     * @param state
     * @return
     */
    List<Map<String, String>> findCity(String country, String state);

    /**
     * upload files
     *
     * @param files
     * @param attachment
     * @return
     */
    List<IAttachment> uploadFiles(List<MultipartFile> files, IAttachment attachment);

    /**
     * @return
     */
    String findRootFilePath();

    /**
     * @param id
     * @param module
     * @return
     */
    List<IAttachment> findListAttachment(ArrayList<String> id, String module);

    /**
     * @param id
     * @param module
     */
    int deleteListAttachment(ArrayList<String> id, String module);

    /**
     * update files
     *
     * @param file
     * @param attachment
     * @return
     */
    IAttachment updateFiles(MultipartFile file, IAttachment attachment);

    /**
     *
     * @param belongToID
     * @param belongToCategory
     * @return
     */
    List<IAttachment> findListAttachmentByBelong(String belongToID, String belongToCategory);
    /**
     *
     * @param belongToID
     * @param belongToCategory
     * @return
     */
   int deleteListAttachmentByBelong(String belongToID, String belongToCategory);
}
