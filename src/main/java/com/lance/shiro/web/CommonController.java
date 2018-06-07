package com.lance.shiro.web;


import com.lance.shiro.entity.IAttachment;
import com.lance.shiro.service.CommonService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/common/")
public class CommonController extends BaseController {
    @Autowired
    private CommonService commonService;

    @Autowired
    private final ResourceLoader resourceLoader;


    public CommonController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    /**
     * find country
     *
     * @return
     */
    @RequestMapping(value = "country", method = RequestMethod.GET)
    public ResponseEntity country() {
        return ResponseEntity.ok(commonService.findCountry());
    }

    /**
     * find state
     *
     * @return
     */
    @RequestMapping(value = "state", method = RequestMethod.GET)
    public ResponseEntity state(@RequestParam("country") String country) {
        return ResponseEntity.ok(commonService.findState(country));
    }


    /**
     * find city
     *
     * @return
     */
    @RequestMapping(value = "city", method = RequestMethod.GET)
    public ResponseEntity city(@RequestParam("country") String country, @RequestParam("state") String state) {
        return ResponseEntity.ok(commonService.findCity(country, state));
    }


    /**
     * post attachment
     *
     * @return
     */
    @RequestMapping(value = "attachment", method = RequestMethod.POST)
    public ResponseEntity postAttachment(HttpServletRequest request) {
        try {
            // 判断是否有附件
            if (request instanceof MultipartHttpServletRequest) {
                List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
                IAttachment attachment = new IAttachment();
                String belongToID = request.getParameter("belongToID");
                attachment.setBelongToID(belongToID);
                String belongToCategory = request.getParameter("belongToCategory");
                attachment.setBelongToCategory(belongToCategory);
                String description = request.getParameter("description") == null ? "" : request.getParameter("description");
                attachment.setDescription(description);
                String createUser = request.getParameter("createUser") == null ? "" : request.getParameter("createUser");
                attachment.setCreateUser(createUser);
                String module = request.getParameter("module") == null ? "" : request.getParameter("module");
                attachment.setModule(module);
                List<IAttachment> attachments = commonService.uploadFiles(files, attachment);
                if (null == attachments) {
                    return error("Upload Attachment Exception,Pls Contact Administrators !");
                } else {
                    return success("Operation success!", attachments);
                }
            } else {
                return error("No Attachment!");
            }
        } catch (Exception e) {
            return error("Upload Attachment Exception,Pls Contact Administrators!");
        }
    }

    /**
     * show Attachment
     *
     * @param filename
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/attachment/{filename:.+}")
    @ResponseBody
    public ResponseEntity showAttachment(@PathVariable String filename) {
        try {
            String rootFilePath = commonService.findRootFilePath();
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(rootFilePath + "attachment/", filename).toString()));
        } catch (Exception e) {
            return error("Not Found The File,Pls Contact Administrators!");
        }
    }

    /**
     * find list attachment
     *
     * @return
     */
    @RequestMapping(value = "attachment", method = RequestMethod.GET)
    public ResponseEntity listAttachment(@RequestParam(name = "id", required = false) ArrayList<String> id, @RequestParam(name = "module", required = false) String module) {
        try {
            return success("Operation success!", commonService.findListAttachment(id, module));
        } catch (Exception e) {
            return error("Find List Attachment Exception,Pls Contact Administrators!");
        }
    }

    /**
     * delete attachment
     *
     * @return
     */
    @RequestMapping(value = "attachment", method = RequestMethod.DELETE)
    public ResponseEntity delete(@RequestParam(name = "id", required = false) ArrayList<String> id, @RequestParam(name = "module", required = false) String module) {
        try {
            commonService.deleteListAttachment(id, module);
            return success("Operation success!");
        } catch (Exception e) {
            return error("Delete  Attachment Exception,Pls Contact Administrators!");
        }
    }

    /**
     * update attachment
     *
     * @return
     */
    @RequestMapping(value = "attachment", method = RequestMethod.PUT)
    public ResponseEntity updateAttachment(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) {
        try {
            IAttachment attachment = new IAttachment();
            String id = request.getParameter("id");
            if (StringUtils.isBlank(id)) {
                return error("Recode ID Is Null ,Pls Contact Administrators !");
            }
            attachment.setId(Integer.valueOf(id));
            String description = request.getParameter("description");
            attachment.setDescription(description);
            String createUser = request.getParameter("createUser");
            attachment.setCreateUser(createUser);
            IAttachment temp = commonService.updateFiles(file, attachment);
            if (null == temp) {
                return error("Update File Exception,Pls Contact Administrators !");
            } else {
                return success("Operation success!", temp);
            }
        } catch (Exception e) {
            return error("Update Attachment Exception,Pls Contact Administrators!");
        }
    }

}



