package com.hff.myController;

import com.hff.entity.*;
import com.hff.services.realize.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @auther hff
 * @time 2020/3/4 - 17:12
 **/
@Controller
@RequestMapping("/view")
public class ViewsController {

//    private AdminController admin = new AdminController();

    @Autowired
    private BlogImpl blog;
    @Autowired
    private TypeImpl type;
    @Autowired
    private TagImpl tag;
    @Autowired
    private UserImpl user;
    @Autowired
    private CommentImpl comment;
    private boolean p=true;
    private Long pid=null;

    private List<TUser> tu_defult =null;

    @RequestMapping
    public String webIndex(Model model){

//        if(p){
//            user.setDefultePageNum(1);
//            tag.setDefultePageNum(1);
//            p =false;
//        }

        List<TType> types = type.typeAndBlogs();
        List<TUser> users = user.userAndBlogs();
        int count=0;
        for(TType type : types){
            count = count+type.getBlogs().size();
        }
        List<TBlog> blogs = blog.selcetAllByTime();
        List<TTag> tags = tag.TagsAndblogs();

        if (null!=users) {

            if (user.getDefultePageNum() == 1) {
                model.addAttribute("proP", "over");
            }
            if (!user.isNextPage()) {
                model.addAttribute("nextP", "over");
            }
        }

        model.addAttribute("users", users);
        model.addAttribute("count",count);
        model.addAttribute("types",types);
        model.addAttribute("tags",tags);
        model.addAttribute("blogs",blogs);
        return "views/index";
    }




    @GetMapping("/blog/nextPage")
    public String nextPage() {
        if(user.isNextPage()){
            user.setDefultePageNum(user.getDefultePageNum()+1);
        }
        return "redirect:/view";
    }


    @GetMapping("/blog/proPage")
    public String proPage() {
        if(user.isProPage()){
            user.setDefultePageNum(user.getDefultePageNum()-1);
        }
        return "redirect:/view";
    }





    @GetMapping("/blog")
    public String blog(Long id , Model model, HttpServletRequest request){
        if(pid==null){
            pid = id;
        }
        blog.addBrownTime(pid);
        TUser user = this.user.userAndBlogByBlogId(pid);

        List<TComment> tComments = comment.selectAllByBlogId(pid);

        model.addAttribute("comments",tComments);
        model.addAttribute("blog_user",user);
            pid=null;
        return "views/blog";
    }



    @PostMapping("/comment")
    public String comment(Long blog_id, String user_nick ,String user_head,String content,RedirectAttributes re){


        int i = comment.insertComment(new TComment(content,new Date(),user_nick,blog_id,user_head));
        if(i!=1){
            re.addFlashAttribute("message","发表失败！！！！！！");
        }
        pid=blog_id;
        return "redirect:/view/blog";
    }


    @GetMapping("/register")
    public String register(){

        return "views/register";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        user.setDefultePageNum(1);
        session.removeAttribute("user");
        return "redirect:/view";
    }


    @GetMapping("/type")
    public String type(Model model){

        List<TType> tTypes = type.typeAndBlogs();
        if(tu_defult==null&&tTypes!=null){

            tu_defult =  user.userAndBlogsByTypeId(tTypes.get(0).getTpId());
            model.addAttribute("redList",tu_defult);
            tu_defult=null;
        }

        model.addAttribute("types",tTypes);
        tu_defult=null;
        return "views/types";
    }

//    @GetMapping("/type/blog")
//    public String type_blogs(Long id , RedirectAttributes attributes){
//        tu_defult = user.userAndBlogsByTypeId(id);
//        attributes.addFlashAttribute("redList",tu_defult);
//
//        return "redirect:/view/type";
//
//    }


    @GetMapping("/blog/type")
    public String blogtype(Long id , RedirectAttributes attributes){

        tu_defult = user.userAndBlogsByTypeId(id);
        attributes.addFlashAttribute("redList",tu_defult);
        return "redirect:/view/type";
    }


    @GetMapping("/tag")
    public String tag(Model model){
        List<TTag> tags = tag.TagsAndblogTag();
        if(tu_defult==null&&tags!=null){

            tu_defult =  user.userAndBlogsByTagId(tags.get(0).gettId());
            model.addAttribute("redList",tu_defult);
            tu_defult=null;
        }
        model.addAttribute("tags",tags);
        tu_defult=null;
        return "views/tags";

    }

    @GetMapping("/blog/tag")
    public String blogtag(Long id , RedirectAttributes attributes){
        System.out.println("====================="+id);
        tu_defult = user.userAndBlogsByTagId(id);
        attributes.addFlashAttribute("redList",tu_defult);
        return "redirect:/view/tag";

    }


    @GetMapping("/aboutMe")
    public String aboutMe(){

        return "views/about";
    }


    @GetMapping("/enroll")
    public String enroll(){

        return "views/enroll";
    }





    @GetMapping("/archives")
    public String archives(Model model){

        List<TBlog> blogs = blog.selectAll();
        Map<String, List<TBlog>> stringListMap = splitDate(blogs);

        model.addAttribute("size",blogs.size());
        model.addAttribute("blogMap",stringListMap);
        return "views/archives";
    }





     private Map<String,List<TBlog>> splitDate(List<TBlog> blogs){

         List<TBlog> blogs1 = blog.selcrtTimeGroup();
         Map<String,List<TBlog>> mapBlog = new HashMap<>();
         SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");

         for(int i=0 ; i<blogs1.size() ; i++){
             String[] split = simpleDate.format(blogs1.get(i).getCreateTime()).split("-");
                mapBlog.put(split[0],new ArrayList<>());
         }

           for(int i=0 ; i<blogs.size() ; i++){
               String[] split = simpleDate.format(blogs.get(i).getCreateTime()).split("-");

                   for(String k : mapBlog.keySet()){
                        if(k.equals(split[0])){
                            mapBlog.get(k).add(blogs.get(i));
                        }
                   }
           }

        return mapBlog;
     }


     @PostMapping("/search")
    public String search(String searchInfo , Model model){

        String s = "%"+searchInfo+"%";
         List<TUser> tUsers = user.userAndBlogsBycontentAndTitle(new TBlog(s, s));
         List<TType> types = type.typeAndBlogs();


         int count=0;
         for(TType type : types){
             count = count+type.getBlogs().size();
         }

         List<TTag> tags = tag.TagsAndblogs();
         List<TBlog> blogs = blog.selectAll();
         model.addAttribute("blogs",blogs);
         model.addAttribute("users",tUsers);
         model.addAttribute("count",count);
         model.addAttribute("types",types);
         model.addAttribute("tags",tags);
        return "views/index";
    }



































    public void setP(boolean p) {
        this.p = p;
    }

}
