/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.rpa.controller;
import cn.zhuatech.rpa.common.ApiResponse;import cn.zhuatech.rpa.service.AutomationSuitabilityService;import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/rpa/insights/automation-suitability") public class AutomationSuitabilityController {private final AutomationSuitabilityService service;/**
                                                                                                                                                                              * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                              */
public AutomationSuitabilityController(AutomationSuitabilityService service){this.service=service;}/**
                                                                                                                                                                                                                                                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                 */
@PostMapping ApiResponse<AutomationSuitabilityService.Result> assess(@Valid @RequestBody AutomationSuitabilityService.Request request){return ApiResponse.ok(service.assess(request));}}
