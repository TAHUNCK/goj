import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CK
 * @date 2020/12/1 16:47
 */
@SpringBootTest(classes = CodeGeneratorMoreTable.class)
public class CodeGeneratorMoreTable {

    final String host = "192.168.47.130";
    final String basePackage = "org.goj.";
    final String baseSrc = "D:\\Code\\Java\\WorkSpaces\\goj\\services\\";

    @Test
    public void run() {
        //StrategyConfig strategy = new StrategyConfig();
        //strategy.setTablePrefix("BIZ_");
        //strategy.setInclude("users");
        GeneratorCode("goj", "user", User());
        //业务单明细
        //StrategyConfig strategy = new StrategyConfig();
        //strategy.setTablePrefix("BIZ_");
        //strategy.setInclude("BIZ_BUSI_ORDER_DETAILS");
        //GeneratorCode("hotuser", "hotel", strategy);
        ////用品需求单视图
        // StrategyConfig strategy = new StrategyConfig();
        // strategy.setTablePrefix("BIZ_");
        // strategy.setInclude("BIZ_ALL_ORDERS_VIEW");
        // GeneratorCode("hotuser", "user", strategy);
        //业务单明细
        //StrategyConfig strategy = new StrategyConfig();
        //strategy.setTablePrefix("BIZ_");
        //strategy.setInclude("BIZ_HOTEL_DEMAND_INQUIRY_VIEW");
        //GeneratorCode("pfuser", "hotel", strategy);
        //业务单生成
//        StrategyConfig strategy = new StrategyConfig();
//        strategy.setTablePrefix("Biz_");
//        strategy.setInclude("BIZ_SUPP_BUSI_ORDER");
//        GeneratorCode("hotuser", "hotel", strategy);
        // 权限管理服务
//        GeneratorCode("pfuser", "authority", AuthorityBIZ());
//        GeneratorCode("pfuser", "authority", AuthoritySYS());
//
//        // 数据配置服务
//        // 酒店 告警配置
//        GeneratorCode("hotuser","configuration", ConfigurationBIZ_ALARM_CONFIG());
//        // 平台
//        GeneratorCode("pfuser","configuration", ConfigurationBIZ());
//        GeneratorCode("pfuser","configuration", ConfigurationSYS());
//
//        // 调度服务 Dispatching
//        GeneratorCode("pfuser","dispatching", Dispatching());
//
//        // 门禁服务
//        GeneratorCode("hotuser", "entranceguard", EntranceGuardBIZ());
//        GeneratorCode("hotuser", "entranceguard", EntranceGuardSYS());
//
//        // 设备服务
//        GeneratorCode("hotuser", "equipment", Equipment());
//
//        // 客房服务
//        GeneratorCode("hotuser", "guestroom", GuestRoom());
//
//        // 酒店管理服务
//        // 酒店
//        GeneratorCode("hotuser", "hotmanagement", HOTManagement_HOTEL());
//        // 平台
//        GeneratorCode("pfuser", "hotmanagement", HOTManagement());
//
//        // 会员
//        GeneratorCode("pfuser", "member", Member());
//
//        // 住客服务
//        GeneratorCode("hotuser", "residents", Residents());


    }

    // 业务实体类生成
    void GeneratorCode(String userName, String serviceName, StrategyConfig strategy) {
        // 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 2、全局配置
        GlobalConfig gc = new GlobalConfig();
        // 改为项目所在路径
        String projectPath = baseSrc + serviceName;
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("CK");
        //生成后是否打开资源管理器
        gc.setOpen(false);
        //重新生成时文件是否覆盖
        gc.setFileOverride(true);
        //去掉Service接口的首字母I
        gc.setServiceName("%sService");
        //主键策略
        gc.setIdType(IdType.ASSIGN_ID);
        //定义生成的实体类中日期类型
        gc.setDateType(DateType.ONLY_DATE);
        //开启Swagger2模式
        //gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        // 3、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://" + host + ":3306/goj");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 4、包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(basePackage + serviceName);
//        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

//        // 如果模板引擎是 freemarker
//        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        //设置只生成实体类
        //cfg.setFileCreate((configBuilder, fileType, filePath) -> {
        //    //如果是Entity则直接返回true表示写文件
        //    if (fileType == FileType.ENTITY) {
        //        return true;
        //    }
        //    //否则先判断文件是否存在
        //    File file = new File(filePath);
        //    boolean exist = file.exists();
        //    if (!exist) {
        //        file.getParentFile().mkdirs();
        //    }
        //    //文件不存在或者全局配置的fileOverride为true才写文件
        //    return !exist || configBuilder.getGlobalConfig().isFileOverride();
        //});

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        templateConfig.setXml(null);
        //templateConfig.setController(null);
        //templateConfig.setService(null);
        //templateConfig.setServiceImpl(null);
        mpg.setTemplate(templateConfig);

        // 5、策略配置
        //数据库表映射到实体的命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //生成实体时去掉表前缀

        //数据库表字段映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // lombok 模型 @Accessors(chain = true) setter链式操作
        strategy.setEntityLombokModel(true);

        //restful api风格控制器
        strategy.setRestControllerStyle(true);
        //url中驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);

        // 6、执行
        mpg.execute();
    }

    // 管理服务 Management
    StrategyConfig Management() {
        StrategyConfig strategy = new StrategyConfig();
        //strategy.setTablePrefix("Biz_");
        strategy.setInclude(
                "sim",
                "privilege",
                "online",
                "news",
                "login_log"
        );
        return strategy;
    }

    // 练习服务 Practice
    StrategyConfig Practice() {
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude(
                "source_code",
                "source_code_user",
                "solution",
                "runtime_info",
                "problem",
                "printer",
                "custom_input",
                "contest",
                "contest_problem",
                "compile_info",
                "balloon"
        );
        return strategy;
    }

    // 用户服务 User
    StrategyConfig User() {
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude(
                "user",
                "topic",
                "share_code",
                "reply",
                "mail"
        );
        return strategy;
    }

}
