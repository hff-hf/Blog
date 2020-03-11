//package com.hff.myController;
//
//import com.hff.entity.Admin;
//import com.hff.entity.TBlog;
//import com.hff.entity.TTag;
//import com.hff.services.realize.AdminImpl;
//import com.hff.services.realize.BlogImpl;
//import com.hff.services.realize.TagImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import javax.servlet.http.HttpSession;
//import java.util.List;
//
///**
// * @auther hff
// * @time 2020/3/3 - 9:50
// **/
//@Controller
//@RequestMapping("/admin")
//public class AdminController {
//
//    @Autowired
//    private AdminImpl admin;
//    @Autowired
//    private BlogImpl blog;
//    @Autowired
//    private TagImpl tag;
//
// //   private boolean sing = true;
//
//    @GetMapping
//    public String loginPage() {
////        blog.setDefultePageNum(1);
////        tag.setDefultePageNum(1);
//
//        return "admin/login";
//
//    }
//
//
//    @PostMapping("/login")
//    public String login(String admin, String password, HttpSession session, RedirectAttributes redirect) {
//
//        Admin checkAdmin = this.admin.checkAdmin(new Admin(admin, password));
//        if (checkAdmin != null) {
//
//            checkAdmin.setPassword(null);
//            session.setAttribute("admin", checkAdmin);
//            return "admin/index";
//        } else {
//            redirect.addFlashAttribute("message", "出错！！！");
//            return "redirect:/admin";
//        }
//
//    }
//
//    @GetMapping("/logout")
//    public String logout(HttpSession session) {
//
//        session.removeAttribute("admin");
//        return "redirect:/admin";
//    }
//
//
//    @GetMapping("/blogs")
//    public String blogs(Model model) {
////
////        if(!sing){
////            blog.setDefultePageNum(1);
////        }
//
//        List<TBlog> blogs = blog.selectAll();
//        if (null != blogs) {
//
//            if (blog.getDefultePageNum() == 1) {
//                model.addAttribute("proP", "over");
//            }
//            if (!blog.isNextPage()) {
//                model.addAttribute("nextP", "over");
//            }
//
//            model.addAttribute("blogs", blogs);
//            return "admin/blogs";
//
//        }
//        model.addAttribute("blogs",blogs);
////             sing=true;
//            return "admin/blogs";
//
//    }
//
//
//    @GetMapping("/blog/nextPage")
//    public String nextPage(RedirectAttributes redirect) {
//
//        String s = next();
//        if (!s.equals("over")) {
//            return "redirect:/admin/blogs";
//        } else {
//            redirect.addFlashAttribute("nextP", s);
//            return "redirect:/admin/blogs";
//        }
//
//    }
//
//
//    @GetMapping("/blog/proPage")
//    public String proPage(RedirectAttributes redirect) {
//
//        String s = privious();
//        if (!s.equals("over")) {
//
//            return "redirect:/admin/blgs";
//        } else {
//
//            redirect.addFlashAttribute("proP", s);
//            return "redirect:/admin/blogs";
//
//        }
//
//    }
//
//    @GetMapping("/tags")
//    public String tags(Model model) {
////        if(!sing){
////            tag.setDefultePageNum(1);
////        }
//
//        List<TTag> tags = tag.selectAll();
//        if (null != tags) {
//
//            if (tag.getDefultePageNum() == 1) {
//                model.addAttribute("proP", "over");
//            }
//            if (!tag.isNextPage()) {
//                model.addAttribute("nextP", "over");
//            }
//
//            model.addAttribute("tags", tags);
////            sing=true;
//            return "admin/tags";
//
//        }
//
//        model.addAttribute("tags",tags);
//            return "admin/tags";
//    }
//
//
//
//    @GetMapping("/tags/nextPage")
//    public String tnextPage(RedirectAttributes redirect) {
//
//        String s = next();
//        if (!s.equals("over")) {
//            return "redirect:/admin/tags";
//        } else {
//            redirect.addFlashAttribute("nextP", s);
//            return "redirect:/admin/tags";
//        }
//
//    }
//
//
//    @GetMapping("/tags/proPage")
//    public String tproPage(RedirectAttributes redirect) {
//
//        String s = privious();
//        if (!s.equals("over")) {
//
//            return "redirect:/admin/tags";
//        } else {
//
//            redirect.addFlashAttribute("proP", s);
//            return "redirect:/admin/tags";
//
//        }
//
//    }
//
//
//    @GetMapping("/tags/input")
//    public String addTag(){
//
//    return "redirect:/admin/tags";
//
//    }
//
//
//    @GetMapping("/tags/delete")
//    public String tdeleteBlog(Long id, RedirectAttributes redirect) {
//
//        if (blog.deleteByPrimaryKey(id)) {
//            return "redirect:/admin/tags";
//        }
//
//        redirect.addFlashAttribute("message", "操作失败！！");
//        return "redirect:/admin/tags";
//    }
//
//
//
//    @GetMapping("/blogs/delete")
//    public String deleteBlog(Long id, RedirectAttributes redirect) {
//
//        if (blog.deleteByPrimaryKey(id)) {
//            return "redirect:/admin/blogs";
//        }
//
//        redirect.addFlashAttribute("message", "操作失败！！");
//        return "redirect:/admin/blogs";
//    }
//
////
////    @GetMapping("/regest")
////    public String regest() {
////
////        return "admin/regester";
////    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//    public String next(){
//        if (blog.isNextPage()) {
//            blog.setDefultePageNum(blog.getDefultePageNum() + 1);
//            return "yes";
//        } else {
//            blog.setDefultePageNum(1);
//            return "over";
//        }
//    }
//
//    public String privious(){
//        if (blog.isProPage()) {
//            blog.setDefultePageNum(blog.getDefultePageNum() - 1);
//            return "yes";
//        } else {
//            blog.setDefultePageNum(1);
//            return "over";
//        }
//    }
//
//
//
//
//
//
//
//}
