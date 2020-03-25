package com.bearhunting.cameraholder.controller;

import com.bearhunting.cameraholder.common.HttpResult;
import com.bearhunting.cameraholder.vo.DistrictVO;
import com.bearhunting.cameraholder.service.DistrictService;
import com.bearhunting.cameraholder.utils.PageUtils;
import java.sql.ResultSet;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * ClassName:DistrictController
 * Package:com.bearhunting.cameraholder.controller
 * Description:
 * @date:2019/11/15 10:51
 * @author:
 */
@RestController
@RequestMapping("district")
public class DistrictController {
  @Resource
  private DistrictService districtService;

  /***
   * @apiName pageList
   * @apiGroup district
   * @apiDescription 获取所有小区信息
   * @apiVersion 1.0.0
   * @api  {get} /district/pageList  获取所有小区信息
   * @apiParam {Integer} pageNo 选填
   * @apiParam {Integer} pageSize 选填
   * @apiErrorExample {json} 错误返回样例：
   * {"code":"500","message":"服务器错误!","data": []},
   */
  @GetMapping("pageList")
  public HttpResult<PageUtils<DistrictVO>> getCamListByDistrictId(
      @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
      @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
    PageUtils<DistrictVO> pageUtils = districtService.getPageList(pageNo, pageSize);
    return HttpResult.success(pageUtils);
  }
}
