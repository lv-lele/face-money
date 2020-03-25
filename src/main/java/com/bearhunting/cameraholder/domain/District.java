package com.bearhunting.cameraholder.domain;

import com.bearhunting.cameraholder.utils.deserializer.GeometrySerializer;
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
 * Description: 小区信息
 * @date:2019/11/15 9:39
 * @author:
 */
@Entity
@Data
public class District implements Serializable {
  private static final long serialVersionUID = 1773890851433260913L;

  @Id
  @GeneratedValue(strategy = SEQUENCE, generator = "district_id")
  @SequenceGenerator(name = "district_id", sequenceName = "district_id_seq", allocationSize = 1)
  private Integer id;

  @Column(name = "the_type")
  private Integer type;//类型 0:小区 1:辖区 //

  @Column(name = "the_name")
  private String name;//名字 //
  private String place;//地址

  @JsonSerialize(using = GeometrySerializer.class)
  private Geometry geom; //polygon //
  private String contact;//联系人
  private String contactPhone;//联系人手机号

  private LocalDateTime createTime;
  private LocalDateTime updateTime;
}
