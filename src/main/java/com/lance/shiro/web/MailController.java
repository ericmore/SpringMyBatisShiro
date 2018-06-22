package com.lance.shiro.web;

import com.lance.shiro.service.UMailService;
import com.lance.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by bingyun on 2018-06-10.
 */
@RestController
@RequestMapping("/rest/mail")
public class MailController extends BaseController {

    @Autowired
    private UMailService uMailService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity mail() {
        Map<String,String> otherParams=new HashMap<String,String>();
//        uMailService.addMailBox("test123","test123","iPanPassw0rd",otherParams);
        uMailService.delMailbox("test123");
//        uMailService.sendManagerMail("578210452@qq.com","test1","test123");
        return success("ok");
    }

//    /**
//     * chuangjian系统邮件
//     * @param u
//     * @return
//     */
//    public static boolean createSystemMail(User u)
//    {
//
//        String name=u.getName();
//
//        String code=u.getCode();
//
//        Map<String,String> otherParams=new HashMap<String,String>();
//
//        Map<String,String> ret=UMailServerAPI.addMailBox(code, name, "", otherParams);
//        if(ret==null)
//        {
//            System.out.println("createSystemMail error,return null");
//        }
//        if(ret.containsKey("status"))
//        {
//            String status=ret.get("status");
//            String data=ret.get("data");
//            if(status.equalsIgnoreCase("0"))
//            {
//                System.out.println("have createSystemMail success:"+data);
//                String mail=ret.get("mail");
//                u.setSystemMail(mail);
//                u.setUpdateDate(new Date());
//                userService.updateSystemMail(u);
//
//            }
//        }
//        return true;
//
//    }

//
//    public static void notifyEmail(UserAgent ra) {
//        String defaultPassword = GlobalPropertyUtil.getConfig("mail.defaultPassword");
//        String subject = "Dear " + ra.getFirstname() + " " + ra.getSurname() + ", Welcome To the iPAN!";
//        String body = "<div>Welcome to the international Property Agent network(iPAN)</div>";
//        // body+="<div>Your member ID:"+u.getCode()+",system mail is
//        // "+u.getSystemMail()+"(default password is :"+defaultPassword+")</div>";
//        body += "<div>Your member ID:" + ra.getCode() + "</div>";
//        body += "<div>Please confirm your detail below</div>";
//        body += "<div>Mobile Number:" + (ra.getMobile()==null?"none":ra.getMobile()) + "</div>";
//        body += "<div>Country/Region:" + ra.getCountry() + "</div>";
//        body += "<div>State/Province:" + (ra.getState()==null?"none":ra.getState()) + "</div>";
//        body += "<div>City:" + (ra.getCity()==null?"none":ra.getCity()) + "</div>";
//        body += "<div>Street:" + (ra.getStreet()==null?"none":ra.getStreet()) + "</div>";
//        body += "<div>Occupation:" + (ra.getOccupation()==null?"none":ra.getOccupation() ) + "</div>";
//        body += "<div>Please contact info@ipan.net.au if detail need to be corrected.</div>";
//        body += "<div>Now you may use your Member ID to RSVP the coming up Event.</div>";
//        body += "<div><br><br>    iPAN Admin Team </div>";
//        String to = ra.getEmail();
//
//        Map<String, String> ret = UMailServerAPI.sendManagerMail(to, subject, body);
//        if (ret.containsKey("status")) {
//            String status = ret.get("status");
//            String data = ret.get("data");
//            if (status.equalsIgnoreCase("0")) {
//                System.out.println("have notify user success:" + data);
//                ra.setStatus(9);
//                regAgentService.updateStatus(ra);
//            }
//
//        }
//    }

}
