package com.bearhunting.cameraholder.mapper;

import com.bearhunting.cameraholder.domain.District;
import com.bearhunting.cameraholder.vo.DistrictVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/**
 * ClassName:DistrictMapper
 * Package:com.bearhunting.cameraholder.mapper
 * Description:
 * @date:2019/11/15 14:41
 * @author:lvlele@bearhunting.cn
 */

@Mapper(componentModel = "spring")
public interface DistrictMapper {
  District INSTANCE = Mappers.getMapper(District.class);

  /**
   * toVOList
   *
   * @param  sources List<Dept>
   * @return List<DeptVO>
   */
  List<DistrictVO> toDistrictVOList(List<District> sources);
}
