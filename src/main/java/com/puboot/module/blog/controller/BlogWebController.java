package com.puboot.module.blog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.puboot.common.util.CoreConst;
import com.puboot.common.util.Pagination;
import com.puboot.common.util.ResultUtil;
import com.puboot.exception.ArticleNotFoundException;
import com.puboot.module.admin.model.BizArticle;
import com.puboot.module.admin.service.BizArticleService;
import com.puboot.module.admin.service.BizArticleTagsService;
import com.puboot.module.admin.service.BizThemeService;
import com.puboot.module.admin.vo.ArticleConditionVo;
import com.puboot.module.admin.vo.base.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * CMS页面相关接口
 *
 * @author Linzhaoguan
 * @version V1.0
 * @date 2019年9月11日
 */
@Controller
@AllArgsConstructor
@Api(tags = "登录接口")
public class BlogWebController {

    private static final String THEME_PREFIX = "theme/";

    private final BizArticleTagsService articleTagsService;

    private final BizArticleService bizArticleService;
    private final BizThemeService bizThemeService;

    /**
     * 首页
     *
     * @param model
     * @param vo
     * @return
     */
    @GetMapping("/")
    public String index(Model model, ArticleConditionVo vo) {
        model.addAttribute("pageUrl", "blog/index");
        model.addAttribute("categoryId", "index");
        model.addAttribute("sliderList", bizArticleService.sliderList());//轮播文章
        loadMainPage(model, vo);
        return THEME_PREFIX + bizThemeService.selectCurrent().getName() + "/index";
    }

    @PostMapping("/blog/news")
    @ResponseBody
    public ResponseVo loadArticle() {
        Integer pageNumber =1;
        Integer pageSize =10;
        ArticleConditionVo vo = new ArticleConditionVo();
        vo.setSliderFlag(true);
        IPage<BizArticle> page = new Pagination<>(pageNumber, pageSize);
        List<BizArticle> articleList = bizArticleService.findByCondition(page, vo);
        String json = JSON.toJSONString(articleList);
        Object data =  JSONObject.parse(json);
        return  ResultUtil.success("成功",data);
    }

    @PostMapping("/blog/add")
    @ResponseBody
    @ApiOperation(value = "接口的功能介绍",notes = "提示接口使用者注意事项",httpMethod = "POST")
    @ApiImplicitParam(dataType = "string",name = "data",value = "数据",required = true)
    public ResponseVo addArticle(String data) {
        JSONObject jsonObject = JSONObject.parseObject(data);
        BizArticle bizArticle = new BizArticle();
        String tagS = jsonObject.getString("tags");
        String[] array = tagS.split(",");
        Integer tag[]= new Integer[array.length];
        for(int i=0;i<array.length;i++){
            tag[i]=Integer.parseInt(array[i]);
        }
       ;
        try {
//            User user = (User) SecurityUtils.getSubject().getPrincipal();
            bizArticle.setCreateTime(new Date());
            bizArticle.setUpdateTime(new Date());
            bizArticle.setUserId(jsonObject.getString("userId"));
            bizArticle.setAuthor(jsonObject.getString("author"));
            bizArticle.setContent(jsonObject.getString("content"));
            bizArticle.setContentMd(jsonObject.getString("contentMd"));
            bizArticle.setDescription(jsonObject.getString("description"));
            bizArticle.setTitle(jsonObject.getString("title"));
            bizArticle.setStatus(jsonObject.getInteger("status"));
            bizArticle.setCategoryId(jsonObject.getInteger("categoryId"));
            bizArticle.setKeywords(jsonObject.getString("keywords"));
            bizArticle.setComment(1);
            bizArticle.setCoverImage(jsonObject.getString("coverImage"));
            bizArticle.setJd(jsonObject.getBigDecimal("jd"));
            bizArticle.setWd(jsonObject.getBigDecimal("wd"));
            BizArticle article = bizArticleService.insertArticle(bizArticle);
            articleTagsService.insertList(tag, article.getId());
            return ResultUtil.success("保存文章成功");
        } catch (Exception e) {
            return ResultUtil.error("保存文章失败");
        }
    }
    /**
     * 文章列表分页
     *
     * @param pageNumber
     * @param vo
     * @param model
     * @return
     */
    @RequestMapping("/blog/index/{pageNumber}")
    public String index(@PathVariable("pageNumber") Integer pageNumber, ArticleConditionVo vo, Model model) {
        vo.setPageNumber(pageNumber);
        model.addAttribute("pageUrl", "blog/index");
        model.addAttribute("categoryId", "index");
        loadMainPage(model, vo);
        return THEME_PREFIX + bizThemeService.selectCurrent().getName() + "/index";
    }

    /**
     * 分类列表
     *
     * @param categoryId
     * @param model
     * @return
     */
    @GetMapping("/blog/category/{categoryId}")
    public String category(@PathVariable("categoryId") Integer categoryId, Model model) {
        ArticleConditionVo vo = new ArticleConditionVo();
        vo.setCategoryId(categoryId);
        model.addAttribute("pageUrl", "blog/category/" + categoryId);
        model.addAttribute("categoryId", categoryId);
        loadMainPage(model, vo);
        return THEME_PREFIX + bizThemeService.selectCurrent().getName() + "/index";
    }

    @GetMapping("/blog/category/{categoryId}/{pageNumber}")
    public String category(@PathVariable("categoryId") Integer categoryId, @PathVariable("pageNumber") Integer pageNumber, Model model) {
        ArticleConditionVo vo = new ArticleConditionVo();
        vo.setCategoryId(categoryId);
        vo.setPageNumber(pageNumber);
        model.addAttribute("pageUrl", "blog/category/" + categoryId);
        model.addAttribute("categoryId", categoryId);
        loadMainPage(model, vo);
        return THEME_PREFIX + bizThemeService.selectCurrent().getName() + "/index";
    }


    /**
     * 标签列表
     *
     * @param tagId
     * @param model
     * @return
     */
    @GetMapping("/blog/tag/{tagId}")
    public String tag(@PathVariable("tagId") Integer tagId, Model model) {
        ArticleConditionVo vo = new ArticleConditionVo();
        vo.setTagId(tagId);
        model.addAttribute("pageUrl", "blog/tag/" + tagId);
        loadMainPage(model, vo);
        return THEME_PREFIX + bizThemeService.selectCurrent().getName() + "/index";
    }

    /**
     * 标签列表（分页）
     *
     * @param tagId
     * @param pageNumber
     * @param model
     * @return
     */
    @GetMapping("/blog/tag/{tagId}/{pageNumber}")
    public String tag(@PathVariable("tagId") Integer tagId, @PathVariable("pageNumber") Integer pageNumber, Model model) {
        ArticleConditionVo vo = new ArticleConditionVo();
        vo.setTagId(tagId);
        vo.setPageNumber(pageNumber);
        model.addAttribute("pageUrl", "blog/tag/" + tagId);
        loadMainPage(model, vo);
        return THEME_PREFIX + bizThemeService.selectCurrent().getName() + "/index";
    }

    /**
     * 文章详情
     *
     * @param model
     * @param articleId
     * @return
     */
    @GetMapping("/blog/article/{articleId}")
    public String article(HttpServletRequest request, Model model, @PathVariable("articleId") Integer articleId) {
        BizArticle article = bizArticleService.selectById(articleId);
        if (article == null || CoreConst.STATUS_INVALID.equals(article.getStatus())) {
            throw new ArticleNotFoundException();
        }
        model.addAttribute("article", article);
        model.addAttribute("categoryId", article.getCategoryId());
        return THEME_PREFIX + bizThemeService.selectCurrent().getName() + "/article";
    }

    /**
     * 评论
     *
     * @param model
     * @return
     */
    @GetMapping("/blog/comment")
    public String comment(Model model) {
        model.addAttribute("categoryId", "comment");
        return THEME_PREFIX + bizThemeService.selectCurrent().getName() + "/comment";
    }

    private void loadMainPage(Model model, ArticleConditionVo vo) {
        vo.setStatus(CoreConst.STATUS_VALID);
        IPage<BizArticle> page = new Pagination<>(vo.getPageNumber(), vo.getPageSize());
        List<BizArticle> articleList = bizArticleService.findByCondition(page, vo);
        model.addAttribute("page", page);
        model.addAttribute("articleList", articleList);//文章列表
    }

}
