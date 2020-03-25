package com.bearhunting.cameraholder.vo;

import com.bearhunting.cameraholder.utils.deserializer.GeometrySerializer;
import com.bearhunting.cameraholder.utils.deserializer.PointDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.experimental.Accessors;
import org.geolatte.geom.Geometry;


/**
 * ClassName:CamVO
 * Package:com.bearhunting.cameraholder.vo
 * Description:
 * @date:2019/11/15 10:53
 * @author:lvlele@bearhunting.cn
 */
@Data
@Accessors(chain = true)
public class CamVO {
  private Integer id; // 摄像头的id
  private Integer type;//摄像头类型 0:数字 1:模拟 //
  private Integer ascriptionType;//归属类型 0:小区 1:道路 2:人脸 3:违章 //
  @JsonSerialize(using = GeometrySerializer.class)
  private Geometry geom; //
  private String url;//rtsp 地址 //
  private Integer status;//0 : 可用 1 : 不可用
  private String name; //人脸摄像头的名字 //
  private Integer geomType;//多边形类型 0:多边形 1:圆形
  @JsonSerialize(using = GeometrySerializer.class)
  @JsonDeserialize(using = PointDeserializer.class)
  private Geometry center;//圆心
  private String districtName;//名字 //
  private String place;//地址
}
