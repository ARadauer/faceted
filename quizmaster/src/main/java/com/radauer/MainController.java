package com.radauer;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController
{
/*
    @RequestMapping(value = {"/index", "/"})
    public String index()
    {
        return "index";
    }*/

    @RequestMapping(value = {"/date"})
    @ResponseBody
    public String getCurrentdatetime()
    {
        return String.valueOf(new Date().getTime());
    }

}
