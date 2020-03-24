package com.imooc.sell.repository;


import com.imooc.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("234h2i34b");
        productInfo.setProductName("JAVA大师宝典");
        productInfo.setProductPrice(new BigDecimal(12.44));
        productInfo.setProductStock(66);
        productInfo.setCategoryType(11);
        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void updateTest() {
        ProductInfo init = repository.findOne("234h2i34b");
        init.setProductName("3");
        ProductInfo result = repository.save(init);
        Assert.assertNotNull(result);
    }

    @Test
    public void deleteTest() {
        ProductInfo init = repository.findOne("234h2i34b");
        Assert.assertNotNull(init);
        repository.delete("234h2i34b");
        ProductInfo result = repository.findOne("234h2i34b");
        Assert.assertNull(result);
    }

    @Test
    public void insertTest() {
        List<String> titleList = Arrays.asList("中国体育偶像调查｜张伟丽，为什么如此吸粉？", "东京奥组委主席森喜朗驳“推迟奥运会”说法：同事说漏了嘴", "全英赛林丹2-1逆转昆拉武特，取得2020年赛季首胜", "2020年F1开赛在即，哈斯车队三人疑感染新冠肺炎被隔离", "2月车市出现20年最大跌幅，六大“救市建言”集中出炉", "继北京、日内瓦车展后，纽约车展也受疫情影响延期至8月举办", "副总裁洪浩主动离职，高层变动频繁的东风雷诺何时走出泥潭？", "公办取消特色班，民办摇号，一图看懂今年上海中小学报名流程", "首款北京现代纯电轿车来袭，菲斯塔纯电动抢滩合资新能源车市", "每一只网红猫背后都有一个想红的人", "一览表｜停摆延期空场，疫情已影响全球近百场赛事", "专访｜张译：秦驰让我有了寻找记忆的冲动", "上海歌剧院提前开始考核季，难度加大了", "西甲赫塔菲拒绝前往意大利踢欧联杯：宁愿球队被判负", "林丹和国羽最后的抢分机会，全英羽毛球赛在疫情笼罩下开打", "换地？延期？取消？留给欧洲杯的选择时间不多了", "一天上百份图片作业批花眼，老师教你作业的正确拍摄方式", "日本奥组委理事：如果今夏无法举办奥运，延期1到2年最现实", "歙县马拉松禁赛湖北籍跑友引争议，疫情下如何做好报名管理？", "可持续种植成葡萄酒行业趋势", "亲子学堂&艺术成长微课堂| 用有趣的创意给好友画头像写生", "东京奥组委主席森喜朗驳“推迟奥运会”说法：同事说漏了嘴", "全英赛林丹2-1逆转昆拉武特，取得2020年赛季首胜", "2020年F1开赛在即，哈斯车队三人疑感染新冠肺炎被隔离", "2月车市出现20年最大跌幅，六大“救市建言”集中出炉", "继北京、日内瓦车展后，纽约车展也受疫情影响延期至8月举办", "副总裁洪浩主动离职，高层变动频繁的东风雷诺何时走出泥潭？", "公办取消特色班，民办摇号，一图看懂今年上海中小学报名流程", "首款北京现代纯电轿车来袭，菲斯塔纯电动抢滩合资新能源车市", "每一只网红猫背后都有一个想红的人", "一览表｜停摆延期空场，疫情已影响全球近百场赛事", "专访｜张译：秦驰让我有了寻找记忆的冲动", "上海歌剧院提前开始考核季，难度加大了", "西甲赫塔菲拒绝前往意大利踢欧联杯：宁愿球队被判负", "林丹和国羽最后的抢分机会，全英羽毛球赛在疫情笼罩下开打", "换地？延期？取消？留给欧洲杯的选择时间不多了", "一天上百份图片作业批花眼，老师教你作业的正确拍摄方式", "日本奥组委理事：如果今夏无法举办奥运，延期1到2年最现实", "歙县马拉松禁赛湖北籍跑友引争议，疫情下如何做好报名管理？", "可持续种植成葡萄酒行业趋势", "亲子学堂&艺术成长微课堂| 用有趣的创意给好友画头像写生");
        List<String> urlList = Arrays.asList("https://imagecloud.thepaper.cn/thepaper/image/56/241/911.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/496/71.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/489/181.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/477/105.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/225/657.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/422/224.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/287/384.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/446/928.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/434/696.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/446/644.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/443/664.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/421/902.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/435/352.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/435/778.jpeg", "https://imagecloud.thepaper.cn/thepaper/image/56/434/638.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/436/19.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/424/273.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/424/287.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/428/824.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/248/209.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/287/594.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/496/71.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/489/181.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/477/105.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/225/657.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/422/224.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/287/384.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/446/928.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/434/696.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/446/644.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/443/664.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/421/902.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/435/352.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/435/778.jpeg", "https://imagecloud.thepaper.cn/thepaper/image/56/434/638.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/436/19.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/424/273.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/424/287.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/428/824.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/248/209.jpg", "https://imagecloud.thepaper.cn/thepaper/image/56/287/594.jpg");
        for (int i = 0; i < titleList.size(); i++) {
            ProductInfo productInfo = new ProductInfo();
            productInfo.setProductName(titleList.get(i));
            productInfo.setProductId("shenghuo" + i);
            productInfo.setProductIcon(urlList.get(i));
            productInfo.setCategoryType(7);
            productInfo.setProductPrice(new BigDecimal(6.66));
            productInfo.setProductStock(88);
            repository.save(productInfo);
        }
    }

    @Test
    public void updateStatusTest() {
        List<ProductInfo> productInfoList = repository.findAll();
        for (ProductInfo productInfo : productInfoList) {
            productInfo.setProductStatus(1);
            repository.save(productInfo);
        }
    }
}