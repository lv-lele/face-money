package com.bearhunting.cameraholder.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * 坐标类
 *
 * @author
 * @date 2017/5/24
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Coordinate {

  private double lng;//经度
  private double lat;//纬度
}
