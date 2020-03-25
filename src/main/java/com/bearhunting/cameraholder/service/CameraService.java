package com.bearhunting.cameraholder.service;

import com.bearhunting.cameraholder.dao.CameraDao;
import com.bearhunting.cameraholder.domain.Camera;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;


/**
 * ClassName:CameraServcie
 * Package:com.bearhunting.cameraholder.service
 * Description:
 * @date:2019/11/15 14:08
 * @author:
 */
@Service
public class CameraService {
  @Resource
  private CameraDao cameraDao;

  public List<Camera> findByDistrictId(Integer districtId) {
    return cameraDao.findByDistrictId(districtId);
  }

  public Camera findById(Integer districtId) {
    return cameraDao.findById(districtId).get();
  }
}
