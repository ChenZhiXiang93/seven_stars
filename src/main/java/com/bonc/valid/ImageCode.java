package com.bonc.valid;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author:ChenZhiXiang
 * @Description: 图片验证码实体
 * @Date:Created in 21:25 2018/8/6
 * @Modified By:
 * image 图片
 * code  验证码
 * expireTime  过期时间
 */
public class ImageCode implements Serializable {
    private BufferedImage image;
    private String code;
    private LocalDateTime expireTime;

    public ImageCode(BufferedImage image, String code, int expireIn) {
        this.image = image;
        this.code = code;
        //通过当前时间加上过期的间隔得到过期时间
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        this.image = image;
        this.code = code;
        this.expireTime = expireTime;
    }

    /**
     Boolean类型   是否在过期时间之后
     */
    public boolean isExpried(){
        return LocalDateTime.now().isAfter(expireTime);
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }
}
