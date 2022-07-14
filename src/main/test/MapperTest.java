import com.mashang.xiaomi.XaiomiApplication;
import com.mashang.xiaomi.mapper.CollectMapper;
import com.mashang.xiaomi.mapper.ProductMapper;
import com.mashang.xiaomi.mapper.UserMapper;
import com.mashang.xiaomi.pojo.PO.User;
import com.mashang.xiaomi.pojo.VO.CollectVO;
import com.mashang.xiaomi.pojo.VO.ProductDetil;
import com.mashang.xiaomi.pojo.VO.ProductHotInfo;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.List;
@SpringBootTest(classes = XaiomiApplication.class)
public class MapperTest {

    @Autowired
    private UserMapper userMapper;





    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private CollectMapper collectMapper;

    @Test
    public void testUserMapper(){
        List<CollectVO> myCollectByuserId = collectMapper.findMyCollectByuserId(1L);
        System.out.println(myCollectByuserId);


    }
}