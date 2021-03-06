package com.bonc.controller;

import com.bonc.valid.ImageCode;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @Author:ChenZhiXiang
 * @Description:
 * @Date:Created in 21:29 2018/8/6
 * @Modified By:
 */
@RestController
public class ValidCodeController {
    /**
     * 存放session的key
     */
    public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";
    /**
     * spring的session工具类
     */
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @GetMapping("/code/image")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //根据随机数生成图片
        ImageCode imageCode = createImageCode(request);
        //将随机数存到session
        sessionStrategy.setAttribute(new ServletWebRequest(request),SESSION_KEY,imageCode);
        //将生成的图片写到响应  格式   响应是否
        ImageIO.write(imageCode.getImage(),"JPEG",response.getOutputStream());
        System.out.println("czx");
    }

    private ImageCode createImageCode(HttpServletRequest request) {
        int width = 67;
        int height = 23;
        // 验证码范围,去掉0(数字)和O(拼音)容易混淆的(小写的1和L也可以去掉,大写不用了)
        char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        //生成图片对象
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Random random = new Random();
        g.setColor(getRandColor(200,250));
        g.fillRect(0,0,width,height);
        g.setFont(new Font("Times New Roman",Font.ITALIC,20));
        g.setColor(getRandColor(160,200));
        for (int i = 0;i < 155;i++){
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int y1 = random.nextInt(12);
            g.drawLine(x,y,x+xl,y+y1);
        }

        String sRand = "";
        for (int i = 0;i < 4;i++){
            String rand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
            /*String rand = String.valueOf(random.nextInt(10));*/
            sRand += rand;
            g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
            g.drawString(rand,13*i+6,16);
        }
        g.dispose();
        return new ImageCode(image,sRand,60);
    }

    //生成随机背景条纹
    private Color getRandColor(int fc,int bc){
        Random random = new Random();
        if (fc > 255){
            fc =255;
        }
        if (bc > 255){
            bc =255;
        }
        int r = fc + random.nextInt(bc-fc);
        int g = fc + random.nextInt(bc-fc);
        int b = fc + random.nextInt(bc-fc);
        return new Color(r,g,b);
    }
}
