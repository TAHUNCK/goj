package org.goj.practice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.goj.common.entity.practice.Printer;
import org.goj.practice.mapper.PrinterMapper;
import org.goj.practice.service.PrinterService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 打印服务 服务实现类
 * </p>
 *
 * @author CK
 * @since 2020-12-02
 */
@Service
public class PrinterServiceImpl extends ServiceImpl<PrinterMapper, Printer> implements PrinterService {

}
