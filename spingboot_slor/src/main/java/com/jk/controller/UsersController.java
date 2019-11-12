package com.jk.controller;

import com.jk.model.Users;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("solr")
public class UsersController {

    @Autowired
    private SolrClient client;

    @RequestMapping("toShow")
    public String toShow(){
        return "show";
    }



    @RequestMapping("findUserList")
    @ResponseBody
    public Map<String,Object> findUserList(Users u,Integer page,Integer rows){

        //返回到前台
        Map<String, Object> map1=new HashMap<>();

        try {
            //存放所有的查询条件
            SolrQuery params = new SolrQuery();

            //查询条件, 这里的 q 对应 下面图片标红的地方
            if(u.getUsername()!=null && !"".equals(u.getUsername())){
                params.set("q", u.getUsername());
            }else {
                params.set("q", "*:*");
            }


            //过滤条件
            // params.set("fq", "carPrice:["+car.get+" TO "++"]");

            //排序
           // params.addSort("carPrice", SolrQuery.ORDER.desc);

            //分页
            if(page==null){
                params.setStart(0);
            }else {
                params.setStart((page-1)*rows);
            }
            if(rows==null){
                params.setRows(5);
            }else {
                params.setRows(rows);
            }


            //默认域
            params.set("df", "userName");

            //只查询指定域
            //params.set("fl", "id,product_title,product_price");

            //高亮
            //打开开关
            params.setHighlight(true);
            //指定高亮域
            params.addHighlightField("userName");
            //设置前缀
            params.setHighlightSimplePre("<span style='color:red'>");
            //设置后缀
            params.setHighlightSimplePost("</span>");

            //查询后返回的对象
            QueryResponse queryResponse = client.query("core1",params);
            //查询后返回的对象 获得真正的查询结果
            SolrDocumentList results = queryResponse.getResults();
            //查询的总条数
            long numFound = results.getNumFound();

            //获取高亮显示的结果, 高亮显示的结果和查询结果是分开放的
            Map<String, Map<String, List<String>>> highlight = queryResponse.getHighlighting();

            //创建list集合接收我们循环的参数
            List<Users> list1 =new ArrayList<>();
            for (SolrDocument result : results) {

                Users car1=new Users();
                String highFile="";

                Map<String, List<String>> map = highlight.get(result.get("id"));
                List<String> list = map.get("userName");
                if(list==null){
                    highFile= result.get("userName").toString();
                }else {
                    highFile=list.get(0);
                }

                car1.setUserid(Integer.parseInt(result.get("id").toString()));
                car1.setUsername(highFile);
                car1.setUsershow(highFile);
                car1.setUsersex(Integer.parseInt(result.get("userSex").toString()));
                car1.setUsershow(result.get("userShow").toString());
                list1.add(car1);
            }
            map1.put("total",numFound);
            map1.put("rows",list1);
            return map1;

        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }



    @RequestMapping("toAdd")
    public String toAdd(){
        return "add";
    }
}
