package org.goj.practice.service.impl;

import org.goj.common.entity.user.Classify;
import org.goj.practice.mapper.ClassifyMapper;
import org.goj.practice.service.ClassifyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.goj.practice.vo.ClassifyCascaderVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 题目分类 服务实现类
 * </p>
 *
 * @author CK
 * @since 2020-12-07
 */
@Service
public class ClassifyServiceImpl extends ServiceImpl<ClassifyMapper, Classify> implements ClassifyService {

    @Override
    public List<ClassifyCascaderVO> listClassifyCascader() {
        List<Classify> classifies=super.list();
        List<ClassifyCascaderVO> cascaderVOList1=new ArrayList<>();
        for (Classify classify1 : classifies) {
            if(classify1.getClassifyParentId()==0){
                ClassifyCascaderVO  classifyCascaderVO1=new ClassifyCascaderVO();
                classifyCascaderVO1.setValue(classify1.getClassifyId());
                classifyCascaderVO1.setLabel(classify1.getClassifyName());
                List<ClassifyCascaderVO> cascaderVOList2=new ArrayList<>();
                for (Classify classify2 : classifies) {
                    if(classifyCascaderVO1.getValue().equals(classify2.getClassifyParentId())){
                        ClassifyCascaderVO  classifyCascaderVO2=new ClassifyCascaderVO();
                        classifyCascaderVO2.setValue(classify2.getClassifyId());
                        classifyCascaderVO2.setLabel(classify2.getClassifyName());
                        List<ClassifyCascaderVO> cascaderVOList3=new ArrayList<>();
                        for (Classify classify3 : classifies) {
                            if(classifyCascaderVO2.getValue().equals(classify3.getClassifyParentId())) {
                                ClassifyCascaderVO classifyCascaderVO3 = new ClassifyCascaderVO();
                                classifyCascaderVO3.setValue(classify3.getClassifyId());
                                classifyCascaderVO3.setLabel(classify3.getClassifyName());
                                classifyCascaderVO3.setChildren(null);
                                cascaderVOList3.add(classifyCascaderVO3);
                            }
                        }
                        classifyCascaderVO2.setChildren(cascaderVOList3);
                        cascaderVOList2.add(classifyCascaderVO2);
                    }
                }
                classifyCascaderVO1.setChildren(cascaderVOList2);
                cascaderVOList1.add(classifyCascaderVO1);
            }
        }
        return cascaderVOList1;
    }
}
