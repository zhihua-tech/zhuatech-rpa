/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.rpa;
import cn.zhuatech.rpa.service.AutomationSuitabilityService;import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;
class AutomationSuitabilityServiceTests {private final AutomationSuitabilityService service=new AutomationSuitabilityService();
 @Test void recommendsStableRuleBasedProcess(){var r=service.assess(new AutomationSuitabilityService.Request(1000,5,95,5,2,true,false,false));assertEquals("AUTOMATE",r.status());assertTrue(r.annualHoursSaved()>900);}
 @Test void retainsJudgmentIntensiveProcess(){var r=service.assess(new AutomationSuitabilityService.Request(100,10,80,10,2,true,false,true));assertEquals("MANUAL",r.status());}}
