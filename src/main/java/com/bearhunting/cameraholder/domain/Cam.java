package com.bearhunting.cameraholder.domain;

import com.bearhunting.cameraholder.utils.deserializer.GeometrySerializer;
import com.bearhunting.cameraholder.utils.deserializer.LineStringDeserializer;
import com.bearhunting.cameraholder.utils.deserializer.PointDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.Data;
import org.geolatte.geom.Geometry;

import static javax.persistence.GenerationType.*;


/**
 * ClassName:HttpResultCode
 * Package:com.bearhunting.cameraholder.common
 * Description: 摄像头信息
 * @date:2019/11/15 9:39
 * @author:
 */
@Entity
@Data
public class Cam implements Serializable {
  private static final long serialVersionUID = -5470134411596749690L;

  @Id
  @GeneratedValue(strategy = SEQUENCE, generator = "cam_id")
  @SequenceGenerator(name = "cam_id", sequenceName = "cam_id_seq", allocationSize = 1)
  private Integer id;
  private Integer channelNum;//通道序号

  @Column(name = "the_type")
  private Integer type;//摄像头类型 0:数字 1:模拟 //

  private Integer ascriptionType;//归属类型 0:小区 1:道路 2:人脸 3:违章 //
  private String ip;//ip地址
  private Integer port;//端口
  private String username;//用户名
  @Column(name = "passwd")
  private String password;//密码
  @JsonSerialize(using = GeometrySerializer.class)
  private Geometry geom; //
  private String url;//rtsp 地址 //
  private Integer status;//0 : 可用 1 : 不可用
  private LocalDateTime createTime;
  private LocalDateTime updateTime;
  private Integer cameraId;//录像机id
  private Integer geomType;//多边形类型 0:多边形 1:圆形
  @JsonSerialize(using = GeometrySerializer.class)
  @JsonDeserialize(using = PointDeserializer.class)
  private Geometry center;//圆心
  private Integer radius;//半径 单位 : 米
  @JsonSerialize(using = GeometrySerializer.class)
  @JsonDeserialize(using = LineStringDeserializer.class)
  private Geometry direction;//方向

  private String name; //人脸摄像头的名字
  private Integer dahuaCamId; //人脸摄像头在大华数据库的id
}
