/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.rpa.service;
import jakarta.validation.constraints.*;import org.springframework.stereotype.Service;import java.util.*;
@Service public class AutomationSuitabilityService {
 public Result assess(Request r){double score=r.ruleBasedRate()*.45+(100-r.exceptionRate())*.25+(r.stableInputs()?20:0)+(r.systemsCount()<=3?10:5)-(r.sensitiveData()?10:0)-(r.humanJudgmentRequired()?40:0);int rounded=(int)Math.round(Math.max(0,Math.min(100,score)));double hours=Math.round(r.monthlyVolume()*r.averageMinutes()*(1-r.exceptionRate()/100.0)*12/60.0*10)/10.0;String status=r.humanJudgmentRequired()?"MANUAL":rounded>=75?"AUTOMATE":rounded>=55?"PILOT":"MANUAL";List<String> actions=new ArrayList<>();if(r.exceptionRate()>15)actions.add("先标准化高频异常处理路径");if(r.sensitiveData())actions.add("配置凭据隔离、脱敏和操作审计");if(status.equals("AUTOMATE"))actions.add("进入自动化方案设计和收益验证");if(actions.isEmpty())actions.add("保留人工流程并优化业务规则");return new Result(rounded,hours,status,actions);}
 public record Request(@Min(1) int monthlyVolume,@DecimalMin("0.1") double averageMinutes,@DecimalMin("0") @DecimalMax("100") double ruleBasedRate,@DecimalMin("0") @DecimalMax("100") double exceptionRate,@Min(1) int systemsCount,@NotNull Boolean stableInputs,@NotNull Boolean sensitiveData,@NotNull Boolean humanJudgmentRequired){}
 public record Result(int suitabilityScore,double annualHoursSaved,String status,List<String> actions){}
}
