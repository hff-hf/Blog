package com.hff.myController;

import com.hff.entity.*;
import com.hff.services.realize.*;
import com.hff.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @auther hff
 * @time 2020/3/6 - 11:41
 **/

@Controller
@RequestMapping("/plush")
public class pushBlogController {

    @Autowired
    private UserImpl user;
    @Autowired
    private TagImpl tag;
    @Autowired
    private TypeImpl type;
    @Autowired
    private BlogImpl blog;
    @Autowired
    private Blog_tagsImpl blogTags;

    @PostMapping
    public String plushBlog(String username, String password , Model model , HttpSession session){
        TUser checkUser = new TUser(username, MD5Utils.code(password));

        TUser tUser = user.checkUser(checkUser);
        if(tUser!=null){
            session.setAttribute("user",tUser);

            return "redirect:/view";
        }else {
            model.addAttribute("message","用户名or密码错误！！！");
            return "views/enroll";
        }

    }

    @GetMapping("/input")
    public String plushsBlog(Model model){

            List<TTag> tags = tag.selectAll();
            List<TType> tTypes = type.allTypes();
            model.addAttribute("tags",tags);
            model.addAttribute("types",tTypes);

            return "plushBlog/input";

    }


    @PostMapping("/inputt")
    public String input(String sign, String title, String content , Long type_id,
                        @RequestParam(value = "tag_id") List<Long> tag_id, @RequestParam("picture") MultipartFile picture, RedirectAttributes redirect, HttpSession session){

        new ViewsController().setP(true);

        String filename = picture.getOriginalFilename();
        String path = "E:\\IDEA\\MyBlog\\src\\main\\resources\\static\\allsource\\pictures\\";
        TUser user = (TUser) session.getAttribute("user");
        try {
            picture.transferTo(new File(path+filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        TBlog tBlog = new TBlog(content, new Date(), filename, sign, title, type_id, user.getUsId());
        int blog_id= blog.insertBlog(tBlog);
        Long newId = tBlog.getbId();
        System.out.println(newId);

        List<TBlogTags> blogTags = new ArrayList<>();
        for (Long id : tag_id) {
            blogTags.add(new TBlogTags(newId,id));
        }
        int i = this.blogTags.insertBlogTags(blogTags);

        if(blog_id==1L&&i>0){
            return "redirect:/view";
        }else {
            redirect.addFlashAttribute("message","发表失败！！！");
            return "redirect:/plush";
        }


    }



    @PostMapping("/register")
    public String register(String username, String password, String nickname,@RequestParam("head")MultipartFile head,String email, Model model){

        if(user.checkNickName(nickname)==null) {


            String filename = head.getOriginalFilename();
            if (filename != null) {
                String path = "E:\\IDEA\\MyBlog\\src\\main\\resources\\static\\allsource\\headPictures\\";
                try {
                    head.transferTo(new File(path + filename));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
//            String name = null;
//            String em = null;
//            if (nickname == "") {
//                name = "萝卜";
//            } else {
//                name = nickname;
////            }
//            if (email == "") {
//                em = "1111111@qq.com";
//            } else {
//                em = email;
//            }
            TUser newUser = new TUser(email, nickname, MD5Utils.code(password), username, filename);
            int insertUser = user.insertUser(newUser);

            if (insertUser == 1) {
                return "views/enroll";
            } else {
                model.addAttribute("message", "注册失败！！！！！");
                return "views/register";
            }

        }else {
            model.addAttribute("message", "昵称重复！！！！！");
            return "views/register";
        }
    }
}
