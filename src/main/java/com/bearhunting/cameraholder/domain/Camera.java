package com.bearhunting.cameraholder.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.Data;

import static javax.persistence.GenerationType.*;


/**
 * ClassName:HttpResultCode
 * Package:com.bearhunting.cameraholder.common
 * Description: 硬盘录像机信息
 * @date:2019/11/15 9:39
 * @author:
 */

@Entity
@Data
public class Camera implements Serializable {

  private static final long serialVersionUID = 8109441522602243640L;

  @Id
  @GeneratedValue(strategy = SEQUENCE, generator = "camera_id")
  @SequenceGenerator(name = "camera_id", sequenceName = "camera_id_seq", allocationSize = 1)
  private Integer id;
  private Integer brandId;//品牌id
  private String model;//型号
  private String ip;//ip地址
  private Integer port;//端口
  private String username;//用户名
  @Column(name = "passwd")
  private String password;//密码
  private String loginIp;//登陆ip
  private String loginUsername;//登陆用户名
  private String loginPassword;//登陆密码
  private String urlFormat;//rtsp格式
  private Integer channelAmount;//通道数量
  @Column(name = "the_type")
  private Integer type;//类型  0:数字 1:模拟
  private Integer ascriptionType;//归属类型 0:普通 1:道路 2:人脸 3:违章
  private LocalDateTime createTime;
  private LocalDateTime updateTime;
  private Integer districtId;//小区id
}