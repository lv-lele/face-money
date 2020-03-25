package com.bearhunting.cameraholder.service;

import com.bearhunting.cameraholder.dao.CamDao;
import com.bearhunting.cameraholder.domain.Cam;
import com.bearhunting.cameraholder.domain.District;
import com.bearhunting.cameraholder.mapper.CamMapper;
import com.bearhunting.cameraholder.utils.PageUtils;
import com.bearhunting.cameraholder.vo.CamVO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


/**
 * ClassName:CamService
 * Package:com.bearhunting.cameraholder.service
 * Description:
 * @date:2019/11/15 10:50
 * @author:
 */
@Service
public class CamService {
  @Resource
  private CamDao camDao;
  @Resource
  private CameraService cameraService;
  @Resource
  private CamMapper camMapper;
  @Resource
  private DistrictService districtService;

  public List<Cam> findByCameraIdIn(Integer[] cameraIds) {
    return camDao.findByCameraIdIn(cameraIds);
  }

  public PageUtils<CamVO> getCamListByDistrictId(Integer districtId, Integer pageNo, Integer pageSize) {
    Integer[] cameraIs =
        cameraService.findByDistrictId(districtId).stream().map(v -> v.getId()).toArray(Integer[]::new);
    District district = districtService.findById(districtId);
    List<Cam> camList = findByCameraIdIn(cameraIs).stream().filter(v -> v.getType() == 0).collect(Collectors.toList());
    List<CamVO> camVOList = camMapper.toCamVOList(camList);
    camVOList.stream().forEach(v -> {
      v.setDistrictName(district.getName()).setPlace(district.getPlace());
    });
    return PageUtils.listToPage(camVOList, pageNo, pageSize);
  }

  public List<CamVO> findList(Cam cam) {
    Specification<Cam> spec = (Specification<Cam>) (root, criteriaQuery, criteriaBuilder) -> {
      List<Predicate> predicates = new ArrayList<>();
      if (cam != null) {
        if (!StringUtils.isEmpty(cam.getName())) {
          predicates.add(criteriaBuilder.like(root.get("name").as(String.class), "%" + cam.getName() + "%"));
        }
        if (!StringUtils.isEmpty(cam.getIp())) {
          predicates.add(criteriaBuilder.equal(root.get("ip").as(String.class), cam.getIp()));
        }
        if (!StringUtils.isEmpty(cam.getUrl())) {
          predicates.add(criteriaBuilder.equal(root.get("url").as(String.class), cam.getUrl()));
        }
      }
      return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    };
    List<Cam> camList = camDao.findAll(spec);
    List<CamVO> camVOList = new ArrayList<>();
    camList.stream().forEach(v -> {
      District district = districtService.findById(cameraService.findById(v.getCameraId()).getDistrictId());
      CamVO camVO = camMapper.toCamVO(v);
      camVO.setDistrictName(district.getName()).setPlace(district.getPlace());
      camVOList.add(camVO);
    });
    return camVOList;
  }

  public List<Map<String, Object>> findAll() {
    return camDao.findList();
  }
}
