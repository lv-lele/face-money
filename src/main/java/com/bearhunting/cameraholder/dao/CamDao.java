package com.bearhunting.cameraholder.dao;

import com.bearhunting.cameraholder.domain.Cam;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * ClassName:CamDao
 * Package:com.bearhunting.cameraholder.dao
 * Description:
 * @date:2019/11/15 10:48
 * @author:
 */
public interface CamDao extends PagingAndSortingRepository<Cam, Integer>, JpaSpecificationExecutor {
  /**
   * findByCameraIdIn
   * @param cameraIds
   * @return
   */
  List<Cam> findByCameraIdIn(Integer[] cameraIds);

  /**
   * findList
   * @return
   */
  @Query(value = "SELECT ca.geom,ca.ascription_type,ca.url,cam.ip,d.place,d.the_name,d.the_type FROM cam ca LEFT JOIN camera cam ON ca.camera_id = cam.id LEFT JOIN district d ON cam.district_id = d.id", nativeQuery = true)
  List<Map<String, Object>> findList();
}
