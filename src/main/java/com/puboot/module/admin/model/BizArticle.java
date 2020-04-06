package com.puboot.module.admin.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.puboot.module.admin.vo.base.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Linzhaoguan
 * @version V1.0
 * @date 2019年9月11日
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BizArticle extends BaseVo {
    private static final long serialVersionUID = 7238198006412851176L;

    private String title;
    private String userId;
    private String author;
    private String coverImage;
    private String qrcodePath;
    private Boolean isMarkdown;
    private String content;
    private String contentMd;
    private Integer top;
    private Integer categoryId;
    private Integer status;
    private Integer recommended;
    private Integer slider;
    private String sliderImg;
    private Integer original;
    private String description;
    private String keywords;
    private Integer comment;
    private BigDecimal jd;
    private  BigDecimal wd;
    @TableField(exist = false)
    private Integer lookCount = 0;
    @TableField(exist = false)
    private Integer commentCount = 0;
    @TableField(exist = false)
    private Integer loveCount = 0;
    @TableField(exist = false)
    private Integer newFlag = 0;
    @TableField(exist = false)
    List<BizTags> tags;
    @TableField(exist = false)
    BizCategory bizCategory;

}
