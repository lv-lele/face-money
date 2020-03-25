package com.bearhunting.cameraholder.controller;

import com.bearhunting.cameraholder.common.HttpResult;
import com.bearhunting.cameraholder.domain.Cam;
import com.bearhunting.cameraholder.vo.CamVO;
import com.bearhunting.cameraholder.service.CamService;
import com.bearhunting.cameraholder.utils.PageUtils;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * ClassName:CamController
 * Package:com.bearhunting.cameraholder.controller
 * Description:
 * @date:2019/11/15 10:50
 * @author:
 */
@RestController
@RequestMapping("cam")
public class CamController {
  @Resource
  private CamService camService;

  /***
   * @apiName pageList
   * @apiGroup cam
   * @apiDescription 获取小区下属的所有摄像头
   * @apiVersion 1.0.0
   * @api  {get} /camera/district/list  获取小区下属的所有摄像头
   * @apiParam {Integer} districtId 小区Id
   * @apiParam {Integer} pageNo 选填
   * @apiParam {Integer} pageSize 选填
   * @apiSuccessExample {json} 成功返回样例：
   *  {
   *     "code": 200,
   *     "message": "ok",
   *     "data": {
   *         "pageNo": 1,
   *         "pageSize": 10,
   *         "pageCount": 1,
   *         "totalCount": 1,
   *         "pageContent": [
   *              {
   *                 "id": 12008,
   *                 "type": 0,
   *                 "ascriptionType": 1,
   *                 "geom": null,
   *                 "url": "rtsp://admin:zjd12345@10.3.69.52:554/Streaming/Channels/0201",
   *                 "status": 0,
   *                 "name": "红苹果幼儿园",
   *                 "geomType": 1,
   *                 "center": {
   *                     "lng": 121.51151418685913,
   *                     "lat": 31.183191038291124
   *                 },
   *                 "districtName": "周家渡市容监控",
   *                 "place": "周家渡"
   *             },
   *             {
   *                 "id": 11998,
   *                 "type": 0,
   *                 "ascriptionType": 1,
   *                 "geom": null,
   *                 "url": "rtsp://admin:zjd12345@10.3.69.51:554/Streaming/Channels/0701",
   *                 "status": 0,
   *                 "name": "清流中学",
   *                 "geomType": 1,
   *                 "center": {
   *                     "lng": 121.49488985538483,
   *                     "lat": 31.17765153499074
   *                 },
   *                 "districtName": "周家渡市容监控",
   *                 "place": "周家渡"
   *             }
   *             ]
   * }
   * @apiErrorExample {json} 错误返回样例：
   * {"code":"500","message":"服务器错误!","data": []},
   */

  @GetMapping("/district/list")
  public HttpResult<PageUtils<CamVO>> getCamListByDistrictId(@RequestParam Integer districtId,
      @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
      @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
    return HttpResult.success(camService.getCamListByDistrictId(districtId, pageNo, pageSize));
  }

  /***
   * @apiName 多条件查询摄像头信息
   *
   * @apiGroup cam
   * @apiDescription 多条件查询摄像头信息
   * @apiVersion 1.0.0
   * @api  {post} /cam/search  多条件查询摄像头信息
   * @apiParam {String} requestBody 参数：{name=摄像头名称/摄像头地址,url=rtsp地址,ip}
   * @apiParamExample {json} Request-Example:
   *  {
   *     "name":"幼儿园"
   *  }
   * @apiSuccessExample {json} 成功返回样例：
   *  {
   *     "code": 200,
   *     "message": "ok",
   *     "data": {
   *         "id": 11098,
   *         "type": 0,
   *         "ascriptionType": 0,
   *         "geom": [
   *             {
   *                 "lng": 121.49890780448914,
   *                 "lat": 31.167549253488016
   *             },
   *             {
   *                 "lng": 121.49888634681702,
   *                 "lat": 31.16737482935176
   *             },
   *             {
   *                 "lng": 121.49898290634155,
   *                 "lat": 31.167406960137825
   *             },
   *             {
   *                 "lng": 121.49890780448914,
   *                 "lat": 31.167549253488016
   *             }
   *         ],
   *         "url": "rtsp://admin:zjd12345@10.3.17.2:554/Streaming/Channels/1501",
   *         "status": 0,
   *         "name": null,
   *         "districtName": "上南十一村",
   *         "place": "德州路150弄门卫室"
   *     }
   * }
   * @apiErrorExample {json} 错误返回样例：
   * {"code":"500","message":"服务器错误!","data": []},
   */
  @PostMapping("search")
  public HttpResult<List<CamVO>> findList(@RequestBody(required = false) Cam cam) {
    return HttpResult.success(camService.findList(cam));
  }

  @GetMapping("list")
  public HttpResult<List<Map<String, Object>>> findAll() {
    return HttpResult.success(camService.findAll());
  }
}

