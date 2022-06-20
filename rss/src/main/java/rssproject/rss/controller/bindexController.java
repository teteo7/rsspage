package rssproject.rss.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Component; //는 Bean Configuration 파일에 Bean을 따로 등록하지 않아도 사용할 수 있다.
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@Component
public class bindexController {
    private ChromeDriver driver;
    private static final String url="https://news.naver.com/main/list.naver?mode=LS2D&mid=shm&sid1=105&sid2=732";

    @GetMapping("bindex")
    public String bindex(Model model){
        System.setProperty("webdriver.chorme.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();

        try{

            System.out.println("BBBBBBBBBBBBBBBBBBBbbindexPage");
            System.out.println(getDataList().getClass().getName());
            System.out.println(getDataList());
//            Object a= getDataList();
//            model.addAttribute("data", a);

//            String b = getDataList().toString();

//            Object b = getDataList();
//            String c= String.valueOf(b);

//            String arr[]= getDataList().toArray(new String[0]);
            model.addAttribute("data", getDataList());


        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return "bindex";
    }

    private List<String> getDataList() throws InterruptedException {
        List<String> list= new ArrayList<>();
        driver.get(url);

        Thread.sleep(1000);


//        System.out.println(elements.getClass().getName());
        List<WebElement> elements= driver.findElements(By.xpath("//*[@id=\"main_content\"]/div[2]/ul[1]/li[1]/dl/dt[2]/a"));

        for (WebElement element : elements){
            String a= element.getText();
            System.out.println(a.getClass().getName());
            System.out.println("=================");
            System.out.println(a);
        }

        return list;
    }

}


