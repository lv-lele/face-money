package com.bearhunting.cameraholder.service;

import com.bearhunting.cameraholder.dao.DistrictDao;
import com.bearhunting.cameraholder.domain.District;
import com.bearhunting.cameraholder.mapper.DistrictMapper;
import com.bearhunting.cameraholder.utils.PageUtils;
import com.bearhunting.cameraholder.vo.DistrictVO;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


/**
 * ClassName:DistrictService
 * Package:com.bearhunting.cameraholder.service
 * Description:
 * @date:2019/11/15 10:50
 * @author:
 */
@Service
public class DistrictService {
  @Resource
  private DistrictDao districtDao;
  @Resource
  private CameraService cameraService;
  @Resource
  private CamService camService;
  @Resource
  private DistrictMapper districtMapper;

  public PageUtils<DistrictVO> getPageList(Integer pageNo, Integer pageSize) {
    Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
    Page page = districtDao.findAll(pageable);
    List<DistrictVO> districtVOList = districtMapper.toDistrictVOList(page.getContent());
    districtVOList.stream().forEach(v -> {
      Integer[] cameraIs = cameraService.findByDistrictId(v.getId())
          .stream()
          .filter(n -> n.getType() == 0)
          .map(m -> m.getId())
          .toArray(Integer[]::new);
      Integer count = camService.findByCameraIdIn(cameraIs).size();
      v.setCount(count);
    });

    return PageUtils.convert(page, districtVOList);
  }

  public District findById(Integer id) {
    return districtDao.findById(id).get();
  }
}
