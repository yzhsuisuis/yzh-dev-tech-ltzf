package cn.bugstack.xfg.dev.tech;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@SpringBootApplication
@Configurable
@RestController
@RequestMapping("/api/")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @RequestMapping(value = "pay_notify", method = RequestMethod.POST)
    public ResponseEntity<String> payNotify(
            @RequestParam String code,
            @RequestParam String timestamp,
            @RequestParam String mch_id,
            @RequestParam String order_no,
            @RequestParam String out_trade_no,
            @RequestParam String pay_no,
            @RequestParam String total_fee,
            @RequestParam String sign,
            @RequestParam String pay_channel,
            @RequestParam String trade_type,
            @RequestParam String success_time,
            @RequestParam String attach,
            @RequestParam String openid) {
        try {
            log.info("请求参数：{} {} {} {} {} {} {} {} {} {} {} {} {}",
                    code,
                    timestamp,
                    mch_id,
                    order_no,
                    out_trade_no,
                    pay_no,
                    total_fee,
                    sign,
                    pay_channel,
                    trade_type,
                    success_time,
                    attach, openid);

            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("FAIL", HttpStatus.BAD_REQUEST);
        }
    }


}
