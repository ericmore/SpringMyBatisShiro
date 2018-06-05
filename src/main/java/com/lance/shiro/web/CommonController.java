package com.lance.shiro.web;


import com.lance.shiro.entity.IAttachment;
import com.lance.shiro.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Paths;
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
     * find country
     *
     * @return
     */
    @RequestMapping(value = "attachment", method = RequestMethod.POST)
    public ResponseEntity pAttachment(HttpServletRequest request) {
        try {
            List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
            String belongToID = request.getParameter("belongToID");
            IAttachment attachment = new IAttachment();
            attachment.setBelongToID(belongToID);
            String belongToCategory = request.getParameter("belongToCategory");
            attachment.setBelongToCategory(belongToCategory);
            String description = request.getParameter("description");
            attachment.setDescription(description);
            String createUser = request.getParameter("createUser");
            attachment.setCreateUser(createUser);
            String module = request.getParameter("module");
            attachment.setModule(module);
            List<IAttachment> attachments = commonService.uploadFiles(files, attachment);
            if (null == attachment) {
                return error("Upload File Exception,Pls contact administrators !");
            } else {
                return success("Operation success!", attachments);
            }
        } catch (Exception e) {
            return error("Upload File Exception,Pls contact administrators!");
        }
    }

    /**
     * getAttachment
     *
     * @param filename
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/attachment/{filename:.+}")
    @ResponseBody
    public ResponseEntity getAttachment(@PathVariable String filename) {
        try {
            String rootFilePath = commonService.findRootFilePath();
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(rootFilePath + "attachment/", filename).toString()));
        } catch (Exception e) {
            return error("notFound the File,Pls contact administrators!");
        }
    }


}



