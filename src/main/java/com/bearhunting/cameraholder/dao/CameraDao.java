package com.bearhunting.cameraholder.dao;

import com.bearhunting.cameraholder.domain.Camera;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * ClassName:CameraDao
 * Package:com.bearhunting.cameraholder.dao
 * Description:
 * @date:2019/11/15 14:07
 * @author:
 */
public interface CameraDao extends PagingAndSortingRepository<Camera,Integer> {
  List<Camera> findByDistrictId(Integer districtId);
}
