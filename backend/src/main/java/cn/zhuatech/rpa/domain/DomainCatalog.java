/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.rpa.domain;
import org.springframework.stereotype.Component;
import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Component public class DomainCatalog {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String systemName(){return "知华 RPA 企业自动化机器人平台";}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String sceneName(){return "流程、机器人、任务、凭证与异常治理";}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public List<SeedItem> seedItems(){return List.of(
        new SeedItem("RPA-20260801-001","发票识别机器人凭证失效","处理中","平台运维组","紧急"),
        new SeedItem("RPA-20260801-002","月结流程执行窗口复核","待处理","自动化运营组","高"),
        new SeedItem("RPA-20260801-003","采购对账流程版本发布","已完成","流程开发组","中"),
        new SeedItem("RPA-20260801-004","无人值守节点容量调整","处理中","基础设施组","高"));}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public List<String> recommendedActions(){return List.of("暂停高风险机器人并隔离凭证","优先恢复影响财务时点的自动化流程","复核失败重试、审计与人工接管记录");}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record SeedItem(String recordNo,String title,String status,String owner,String priority){}
}
