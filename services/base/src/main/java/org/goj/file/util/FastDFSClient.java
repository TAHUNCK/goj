package org.goj.file.util;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.goj.file.entity.FastDFSFile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传工具
 * @author CK
 * @date 2020/10/6 19:43
 */
@Component
public class FastDFSClient {

    FastDFSClient() throws Exception {
        //从classpath下获取文件对象获取路径
        String path = new ClassPathResource("fdfs_client.conf").getPath();
        ClientGlobal.init(path);
    }

    /**
     * 根据url提取出文件的组名和文件名
     *
     * @param url http://10.2.10.1:7000/group1/M00/00/00/CgIKAV-L-caAct64ADKZutm5FCs520.jpg
     * @return String
     * @author CK
     * @date 2020/10/25 15:38
     */
    private String[] getGroupNameAndFileName(String url){
        String[] gf=new String[2];
        String[] str=url.split("/");
        gf[0]=str[3];
        gf[1]=str[4]+"/"+str[5]+"/"+str[6]+"/"+str[7];
        return gf;
    }

    /**
     * 文件上传
     * @param file 文件
     * @return java.lang.String 文件上传的路径
     * @author CK
     * @date 2020/10/6 21:40
     */
    public String upload(MultipartFile file) throws Exception {
        FastDFSFile fastdfsfile = new FastDFSFile(
                //原来的文件名  1234.jpg
                file.getOriginalFilename(),
                //文件本身的字节数组
                file.getBytes(),
                StringUtils.getFilenameExtension(file.getOriginalFilename())
        );

        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient storageClient = new StorageClient(trackerServer, null);
        //参数1 字节数组
        //参数2 扩展名(不带点)
        //参数3 元数据( 文件的大小,文件的作者,文件的创建时间戳)
        NameValuePair[] metaList = new NameValuePair[]{new NameValuePair(fastdfsfile.getAuthor()), new NameValuePair(file.getName())};

        String[] strings = storageClient.upload_file(fastdfsfile.getContent(), fastdfsfile.getExt(), metaList);
        // strings[0]==group1  strings[1]=M00/00/00/wKjThF1aW9CAOUJGAAClQrJOYvs424.jpg
        //分号用作标记
        String url=getTrackerUrl();
        return url+strings[0]+"/"+strings[1];
    }

    /**
     * 文件下载功能
     * @param url 文件路径
     * @return byte[]
     * @author CK
     * @date 2020/10/7 17:15
     */
    public byte[] downFile(String url) throws Exception {
        String[] name=getGroupNameAndFileName(url);
        //3.创建trackerclient对象
        TrackerClient trackerClient = new TrackerClient();
        //4.创建trackerserver 对象
        TrackerServer trackerServer = trackerClient.getConnection();
        //5.创建stroageserver 对象
        //6.创建storageclient 对象
        StorageClient storageClient = new StorageClient(trackerServer, null);
        //7.根据组名 和 文件名 下载图片
        //参数1:指定组名
        //参数2:指定远程的文件名
        return storageClient.download_file(name[0], name[1]);
    }

    /**
     * 删除文件
     *
     * @param url  文件地址
     * @return Boolean
     * @author CK
     * @date 2020/10/25 16:06
     */
    public Boolean deleteFile(String url) throws Exception {
        String[] name=getGroupNameAndFileName(url);
        //3.创建trackerclient对象
        TrackerClient trackerClient = new TrackerClient();
        //4.创建trackerserver 对象
        TrackerServer trackerServer = trackerClient.getConnection();
        //5.创建stroageserver 对象
        //6.创建storageclient 对象
        StorageClient storageClient = new StorageClient(trackerServer, null);
        return 0 == storageClient.delete_file(name[0], name[1]);
    }

    /**
     * 根据组名获取组的信息
     * @author CK
     * @date 2020/10/6 20:01
     */
    public StorageServer getStorages(String url) throws Exception {
        String[] name=getGroupNameAndFileName(url);
        TrackerClient trackerClient = new TrackerClient();
        //4.创建trackerserver 对象
        TrackerServer trackerServer = trackerClient.getConnection();

        //参数1 指定traqckerserver 对象
        //参数2 指定组名
        return trackerClient.getStoreStorage(trackerServer, name[0]);
    }

    /**
     * 根据文件名和组名获取文件的信息
     * @author CK
     * @date 2020/10/6 20:01
     */
    public FileInfo getFile(String url) throws Exception {
        String[] name=getGroupNameAndFileName(url);
        TrackerClient trackerClient = new TrackerClient();
        //4.创建trackerserver对象
        TrackerServer trackerServer = trackerClient.getConnection();

        StorageClient storageClient = new StorageClient(trackerServer, null);

        //参数1 指定组名
        //参数2 指定文件的路径
        return storageClient.get_file_info(name[0], name[1]);
    }


    /**
     * 根据文件名和组名，获取组信息的数组信息
     * @author CK
     * @date 2020/10/6 20:02
     */
    public ServerInfo[] getServerInfo(String url) throws Exception {
        String[] name=getGroupNameAndFileName(url);
        //3.创建trackerclient对象
        TrackerClient trackerClient = new TrackerClient();
        //4.创建trackerserver 对象
        TrackerServer trackerServer = trackerClient.getConnection();

        return trackerClient.getFetchStorages(trackerServer, name[0], name[1]);
    }

    /**
     * 获取tracker的ip和端口的信息
     * http://10.2.10.1:8080
     * @author CK
     * @date 2020/10/6 20:02
     */
    public String getTrackerUrl() throws Exception {
        //3.创建trackerclient对象
        TrackerClient trackerClient = new TrackerClient();
        //4.创建trackerserver 对象
        TrackerServer trackerServer = trackerClient.getConnection();
        //tracker 的ip的信息
        String hostString = trackerServer.getInetSocketAddress().getHostString();

        //http://192.168.211.132:8080/
        int gTrackerHttpPort = ClientGlobal.getG_tracker_http_port();
        return "http://" + hostString + ":" + gTrackerHttpPort+"/";
    }

}
