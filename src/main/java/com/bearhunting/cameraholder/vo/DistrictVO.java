package com.bearhunting.cameraholder.vo;
import com.bearhunting.cameraholder.utils.deserializer.GeometrySerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.experimental.Accessors;
import org.geolatte.geom.Geometry;


/**
 * ClassName:DistrictVO
 * Package:com.bearhunting.cameraholder.vo
 * Description:
 * @date:2019/11/15 10:53
 * @author:lvlele@bearhunting.cn
 */
@Data
@Accessors(chain = true)
public class DistrictVO {
  private Integer id;
  private String name;//名字
  private String place;//地址
  @JsonSerialize(using = GeometrySerializer.class)
  private Geometry geom;
  private Integer count; // 摄像头数量
}
