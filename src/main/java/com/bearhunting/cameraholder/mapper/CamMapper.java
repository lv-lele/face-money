package com.bearhunting.cameraholder.mapper;

import com.bearhunting.cameraholder.domain.Cam;
import com.bearhunting.cameraholder.vo.CamVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/**
 * ClassName:CamMapper
 * Package:com.bearhunting.cameraholder.mapper
 * Description:
 * @date:2019/11/15 14:54
 * @author:lvlele@bearhunting.cn
 */
@Mapper(componentModel = "spring")
public interface CamMapper {
  Cam INSTANCE = Mappers.getMapper(Cam.class);

  /**
   * toVOList
   *
   * @param  sources List<Dept>
   * @return List<DeptVO>
   */
  List<CamVO> toCamVOList(List<Cam> sources);

  CamVO toCamVO(Cam cam);
}
