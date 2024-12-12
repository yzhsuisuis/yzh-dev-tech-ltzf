package cn.bugstack.xfg.dev.tech.test;

import cn.bugstack.ltzf.payments.nativepay.NativePayService;
import cn.bugstack.ltzf.payments.nativepay.model.PrepayRequest;
import cn.bugstack.ltzf.payments.nativepay.model.PrepayResponse;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

    @Resource
    private NativePayService nativePayService;

    @Test
    public void test_nativePayService_prepay() throws Exception {
        // 1. 请求参数
        PrepayRequest request = new PrepayRequest();
        request.setMchid("1700833091");
        request.setOutTradeNo(RandomStringUtils.randomNumeric(8));
        request.setTotalFee("0.01");
        request.setBody("小米SUV");
        request.setNotifyUrl("http://yzh-mall.natapp1.cc/api/pay_notify");

        // 2. 创建支付订单
        PrepayResponse response = nativePayService.prePay(request);

        log.info("请求参数:{}", JSON.toJSONString(request));
        log.info("应答结果:{}", JSON.toJSONString(response));
    }

}
