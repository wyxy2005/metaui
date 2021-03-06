package com.metaui.core.parser;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.metaui.core.parser.book.DangDangParser;
import com.metaui.core.parser.book.IWebProduct;
import com.metaui.core.parser.http.FetchWebSite;
import com.metaui.core.parser.mobile.*;
import com.metaui.core.util.UUIDUtil;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

/**
 * @author weijiancai
 * @since 0.0.1
 */
public class DangDangParserTest {
    // 少年Pi的奇幻漂流
    @Test public void test9787544731706() throws MalformedURLException {
        String isbn = "9787544731706";
        DangDangParser parser = new DangDangParser(isbn);
//        List<IWebProduct> list = parser.parse();
//        assertThat(list.size() > 0, equalTo(true));
        IWebProduct prod = parser.parseProduct(null);
        System.out.println(prod);

        assertThat(prod.getSourceSite(), equalTo("DANG_DANG"));
        assertThat(prod.getName(), equalTo("少年Pi的奇幻漂流（插图珍藏版）(不凡历程，不枉此生！奥巴马、李安挚爱的勇气之书，同名电影全球热映。！）"));
        assertThat(prod.getAuthor(), equalTo("扬・马特尔"));
        assertThat(prod.getPainter(), equalTo("（克罗）托亚纳克"));
        assertThat(prod.getTranslator(), equalTo("姚媛"));
        assertThat(prod.getPrice(), equalTo("35.00"));
        assertThat(prod.getPublishing(), equalTo("译林出版社"));
        assertThat(prod.getPublishDate(), equalTo("2012-11-14"));
        assertThat(prod.getPrintDate(), equalTo("2012-11-1"));
        assertThat(prod.getBanci(), equalTo("1"));
        assertThat(prod.getPrintNum(), equalTo("1"));
        assertThat(prod.getKaiben(), equalTo("16开"));
        assertThat(prod.getIsbn(), equalTo("9787544731706"));
        assertThat(prod.getPaper(), equalTo("胶版纸"));
        assertThat(prod.getPack(), equalTo("平装"));
    }

    // 牛刀说货币：货币狼烟
    @Test public void test9787504479037() throws MalformedURLException {
        String isbn = "9787504479037";
        DangDangParser parser = new DangDangParser(isbn);
        List<IWebProduct> list = parser.parse();
        assertThat(list.size() > 0, equalTo(true));
        IWebProduct prod = list.get(0);
        System.out.println(prod);

        assertThat(prod.getSourceSite(), equalTo("DANG_DANG"));
        assertThat(prod.getName(), equalTo("牛刀说货币：货币狼烟（股市不行，楼市不行，2013年最好的理财方法是外汇理财）"));
        assertThat(prod.getPrice(), equalTo("36.80"));
        assertThat(prod.getAuthor(), equalTo("牛刀"));
        assertThat(prod.getPublishing(), equalTo("中国商业出版社"));
        assertThat(prod.getPublishDate(), equalTo("2012-12-1"));
        assertThat(prod.getBanci(), equalTo("1"));
        assertThat(prod.getPageNum(), equalTo("218"));
        assertThat(prod.getKaiben(), equalTo("16开"));
        assertThat(prod.getIsbn(), equalTo("9787504479037"));
        assertThat(prod.getPack(), equalTo("平装"));
        assertThat(prod.getPrintNum(), equalTo("1"));
        assertThat(prod.getPaper(), equalTo("胶版纸"));
        assertThat(prod.getWordCount(), equalTo("180000"));
    }

    // Steve Jobs - The Exclusive Biography 乔布斯传记-英国版精装
    @Test public void test9781408703748() {
        String isbn = "9781408703748";
        DangDangParser parser = new DangDangParser(isbn);
        List<IWebProduct> list = parser.parse();
        assertThat(list.size() > 0, equalTo(true));
        IWebProduct prod = list.get(0);
        System.out.println(prod);

        assertThat(prod.getSourceSite(), equalTo("DANG_DANG"));
        assertThat(prod.getName(), equalTo("Steve Jobs - The Exclusive Biography 乔布斯传记-英国版精装 ISBN=9781408703748"));
        assertThat(prod.getPrice(), equalTo("262.00"));
        assertThat(prod.getAuthor(), equalTo("Walter Isaacson"));
        assertThat(prod.getPublishing(), equalTo("Little, Brown UK"));
        assertThat(prod.getPublishDate(), equalTo("2011-11-21"));
        assertThat(prod.getBanci(), equalTo("1"));
        assertThat(prod.getPageNum(), equalTo("630"));
        assertThat(prod.getWordCount(), equalTo(""));
        assertThat(prod.getPrintDate(), equalTo("2011-11-21"));
        assertThat(prod.getKaiben(), equalTo("大32开"));
        assertThat(prod.getPaper(), equalTo("胶版纸"));
        assertThat(prod.getPrintNum(), equalTo("1"));
        assertThat(prod.getIsbn(), equalTo("9781408703748"));
        assertThat(prod.getPack(), equalTo("精装"));
    }
    
    // 恨海 情变
    @Test public void test9787802146150() throws UnsupportedEncodingException {
    	String isbn = "9787802146150";
        DangDangParser parser = new DangDangParser(isbn);
        List<IWebProduct> list = parser.parse();
        assertThat(list.size() > 0, equalTo(true));
        IWebProduct prod = list.get(0);
        System.out.println(prod);
        
        assertThat(prod.getSourceSite(), equalTo("DANG_DANG"));
        assertThat(prod.getName(), equalTo("恨海情变"));
    }
    
    // 帝王与佛教
    @Test public void test9787802143173() throws UnsupportedEncodingException {
    	String isbn = "9787802143173";
        DangDangParser parser = new DangDangParser(isbn);
        List<IWebProduct> list = parser.parse();
        assertThat(list.size() > 0, equalTo(true));
        IWebProduct prod = list.get(0);
        System.out.println(prod);
        
        assertThat(prod.getSourceSite(), equalTo("DANG_DANG"));
        assertThat(prod.getName(), equalTo("帝王与佛教"));
    }

    @Test
    public void test() throws Exception {
        Map<String, String> data = new HashMap<String, String>();
        data.put("name", UtilCn.randomCnName());
        data.put("idno", IDCard.random());
        data.put("iphone", FetchMobileNumber.random());
        data.put("bank", Bank.randomBank());
        data.put("bankno", Bank.randomBankNo());
        data.put("pass", Bank.randomPassword());
        data.put("iphone1", data.get("iphone"));
//        data.put("button", "免费开启");

        System.out.println(data);
        Document doc = Jsoup.connect("http://dl.10086.lu/start2add.asp").data(data)
                .timeout(10 * 1000)
                .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                .post();
        System.out.println(doc.html());

        /*FetchMobileNumber fetchMobileNumber = new FetchMobileNumber(new Callback<List<MobileNumber>>() {
            @Override
            public void call(List<MobileNumber> result, Object... obj) throws Exception {
                for (MobileNumber mobileNumber : result) {
                    System.out.println(mobileNumber);
                }
            }
        });

        fetchMobileNumber.fetch();*/
    }

    @Test
    public void test1() throws IOException {
        FetchWebSite fetch = new FetchWebSite(new File("d:/fetch/baic"));
        fetch.fetch("http://file.ws.126.net/quotes/pdf/sz/2014/2014-4/2014-04-11/1355058.pdf", 1);
    }

    @Test
    public void test2() throws IOException {
        Map<String, String> data = new HashMap<String, String>();
        Map<String, String> cookies = new HashMap<String, String>();
        cookies.put("JSESSIONID", "XWnKV2TKh1Jcr2yS9QJhMv08wTnLpQ8qhKQGmhQcLgKSHhn3qQrW!-793484074");
        cookies.put("BIGipServerpool_xy3_web", "1108715712.17183.0000");
        Connection conn = Jsoup.connect("http://qyxy.baic.gov.cn/gjjbj/gjjQueryCreditAction!openEntInfo.dhtml?entId=20e38b8b490e0fc0014917c7f80228a7&entNo=110000000031223&type=jyycDiv");
        conn.cookies(cookies);
        Document doc = conn.data(data)
                .timeout(10 * 1000)
                .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                .post();
        PrintWriter ps = new PrintWriter("D:/1.html");
        ps.write(new String(doc.html().getBytes(), "UTF-8"));
        ps.close();
        System.out.println(doc);
    }

    @Test
    public void test3() {
        System.out.println(UUIDUtil.getUUID());
    }


    @Test
    public void testWeiXin() throws IOException {
        String url = "http://weixin.sogou.com/weixin?query=%E6%B9%96%E5%8D%97&fr=sgsearch&ie=utf8&type=2&w=01019900&sut=3098&sst0=1445611806603&lkt=4%2C1445611803505%2C1445611804399";
        Connection connection = Jsoup.connect(url);
        Connection.Response response = connection.execute();
        Map<String, String> cookies = response.cookies();
//        System.out.println(cookies);
//        System.out.println(response.body());
        url = "http://weixin.sogou.com/websearch/art.jsp?sg=xaXJ7lM8QYR_7XOqrq5C_m6vUbLtHvTELSZi1TMGyvBa3TIJh2dES5p1ZP1vJcoCAJTypjE1HX8Ox4ChZ0cnGOK1aUawqwGgU-aATq-GBOz0ycy5BK9qHUqtmU7-GUYzbPevHhqM9RMhnCWSpbO3WQ..&url=p0OVDH8R4SHyUySb8E88hkJm8GF_McJfBfynRTbN8wgNzcw5Yx9FPApqItp_ZxGWFJmAPOq06Mz6_bS1uL_CCWQ3JxMQ3374uxnQeyzhmUfjtD_gJVwrtKSwLT-OYLamZUYrlDK7J5VYy-5x5In7jJFmExjqCxhpkyjFvwP6PuGcQ64lGQ2ZDMuqxplQrsbk";
        connection = Jsoup.connect(url);
        connection.cookies(cookies);
        connection.userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6");
        System.out.println(connection.execute().headers());
        Document doc = connection.get();
        System.out.println(doc.html());
    }

    public static void main(String[] args) throws IOException {
        Map<String, String> data = new HashMap<String, String>();
        Map<String, String> cookies = new HashMap<String, String>();
        cookies.put("JSESSIONID", "XWnKV2TKh1Jcr2yS9QJhMv08wTnLpQ8qhKQGmhQcLgKSHhn3qQrW!-793484074");
        cookies.put("BIGipServerpool_xy3_web", "1108715712.17183.0000");
        Connection conn = Jsoup.connect("http://qyxy.baic.gov.cn/gjjbj/gjjQueryCreditAction!openEntInfo.dhtml?entId=28D0C3B5ED424938BB626D6EB6E77A53&credit_ticket=160F93E34E6D55C208CE208CC5F29183&entNo=110000000031223&timeStamp=1442715417135");
        conn.cookies(cookies);
        Document doc = conn.data(data)
                .timeout(10 * 1000)
                .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                .post();
        PrintWriter ps = new PrintWriter("D:/1.html");
//        ps.write(doc.html());
//        ps.close();
//        System.out.println(doc.html());

        data = new HashMap<String, String>();
        data.put("currentTimeMillis", "1442716846491");
        data.put("credit_ticket", "B92E6B206E688B9454077292E9E5A6FE");
        data.put("checkcode", "");
        data.put("keyword", "keyword");

        doc = Jsoup.connect("http://qyxy.baic.gov.cn/gjjbj/gjjQueryCreditAction!getBjQyList.dhtml").data(data).post();
        ps.write(new String(doc.html().getBytes(), "UTF-8"));
        ps.close();
        System.out.println(doc);
    }
}
