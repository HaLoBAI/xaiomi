package com.mashang.xiaomi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mashang.xiaomi.pojo.PO.Collect;
import com.mashang.xiaomi.pojo.VO.CollectVO;

import java.util.List;

public interface CollectMapper extends BaseMapper<Collect> {
    
    List<CollectVO> findMyCollectByuserId(Long userId);
}
