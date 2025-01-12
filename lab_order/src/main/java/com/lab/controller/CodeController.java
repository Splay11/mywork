package com.lab.controller;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lab.util.*;
import com.lab.util.ImgRandomCodeUtils;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.UUID;
import org.apache.commons.codec.binary.Base64;
import java.io.ByteArrayOutputStream;
/**
 * 
图片验证码生成接口，该接口用来生成一张带有4位随机码的图片
 *
 */
@Controller
@RequestMapping("/validCode")
public class CodeController {
	@RequestMapping("code") 
	@ResponseBody
    public Object getCode(HttpServletRequest req, HttpServletResponse resp) throws IOException { 
		ImgRandomCodeUtils rdnu = ImgRandomCodeUtils.Instance();//图片验证码生成器
		// 禁止图像缓存。  
        resp.setHeader("Pragma", "no-cache"); 
        resp.setHeader("Cache-Control", "no-cache"); 
        resp.setDateHeader("Expires", 0); 
        resp.setContentType("image/jpeg"); 
        // 将图像输出到Servlet输出流中。  
     ByteArrayOutputStream  sos = new ByteArrayOutputStream ();
        ImageIO.write(rdnu.getBuffImg(), "jpeg", sos);//返回给前台
          byte[] bytes = Base64.encodeBase64(sos.toByteArray());
        String base64 = new String(bytes);
         String imgUrl = "data:image/jpeg;base64,"+base64;
        sos.close(); 
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();;
        CacheManage.putCache(uuid, new Cache(uuid,rdnu.getString(),1000*120,false));
        Map<String,Object> rs = new HashMap<String,Object>();
        rs.put("codeToken",uuid);
        rs.put("imgUrl",imgUrl);
        return rs;
    }
}
