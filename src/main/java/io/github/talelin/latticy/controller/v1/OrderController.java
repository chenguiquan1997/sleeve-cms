package io.github.talelin.latticy.controller.v1;

import io.github.talelin.latticy.bo.my.OrderDetailBO;
import io.github.talelin.latticy.bo.my.OrderSummaryBO;
import io.github.talelin.latticy.common.util.CommonUtils;
import io.github.talelin.latticy.common.util.DateUtil;
import io.github.talelin.latticy.common.util.LocalParams;
import io.github.talelin.latticy.dto.my.ConditionSearchDTO;
import io.github.talelin.latticy.dto.my.OrderUpdateDTO;
import io.github.talelin.latticy.model.my.Page;
import io.github.talelin.latticy.service.imy.IOrderService;
import io.github.talelin.latticy.vo.UpdatedVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;
import java.util.Map;

/**
 * @Author Guiquan Chen
 * @Date 2021/5/5 15:59
 * @Version 1.0
 */
@RestController
@RequestMapping("/v1/order")
@Validated
@Slf4j
public class OrderController {

    @Autowired
    private IOrderService orderService;

    /**
     * @Description: 根据订单id，查询指定订单详情
     * @param id 订单id
     * @return io.github.talelin.latticy.bo.my.OrderDetailBO
     * @Author: Guiquan Chen
     * @Date: 2021/5/17
     */
    @GetMapping("/detail/{id}")
    public OrderDetailBO getOrderDetailById(@PathVariable("id") @Positive Long id) {
       return orderService.searchOrderDetailById(id);
    }

    /**
     * @Description: 分页查询订单概要数据(无查询条件)
     * @param page 页码
     * @param count 每页数据量
     * @return io.github.talelin.latticy.model.my.Page
     * @Author: Guiquan Chen
     * @Date: 2021/5/17
     */
    @GetMapping("/summary")
    public Page getSkuSummary(@RequestParam(name = "page",defaultValue = "1")
                              @Min(value = 1) Integer page,
                              @RequestParam(name = "count", defaultValue = "10")
                              @Min(value = 3) @Max(value = 30) Integer count) {
        Map<String,Integer> pageMap = CommonUtils.convertPageParams(page,count);
        return orderService.searchOrderListByPage(pageMap,count,null);
    }

    /**
     * @Description: 分页查询订单概要数据(根据收货人查询)
     * @param page 页码
     * @param count 每页数据量
     * @param receiver 收货人
     * @return io.github.talelin.latticy.model.my.Page
     * @Author: Guiquan Chen
     * @Date: 2021/5/17
     */
    @GetMapping("/summary/receiver")
    public Page getSkuSummaryByReceiver(@RequestParam(name = "page",defaultValue = "1")
                              @Min(value = 1) Integer page,
                              @RequestParam(name = "count", defaultValue = "10")
                              @Min(value = 3) @Max(value = 30) Integer count,
                              @RequestParam(name = "receiver") @NotNull String receiver) {
        Map<String,Integer> pageMap = CommonUtils.convertPageParams(page,count);
        ConditionSearchDTO c = ConditionSearchDTO.builder().receiver(receiver).build();
        Page<OrderSummaryBO> pageData = orderService.searchOrderListByPage(pageMap,count,c);
        return pageData;
    }

    /**
     * @Description: 分页查询订单概要数据(根据订单号查询)
     * @param page 页码
     * @param count 每页数据量
     * @param orderNo 订单号
     * @return io.github.talelin.latticy.model.my.Page
     * @Author: Guiquan Chen
     * @Date: 2021/5/17
     */
    @GetMapping("/summary/orderno")
    public Page getSkuSummaryByOrderNo(@RequestParam(name = "page",defaultValue = "1")
                                        @Min(value = 1) Integer page,
                                        @RequestParam(name = "count", defaultValue = "10")
                                        @Min(value = 3) @Max(value = 30) Integer count,
                                        @RequestParam(name = "orderNo") @NotNull String orderNo) {
        Map<String,Integer> pageMap = CommonUtils.convertPageParams(page,count);
        ConditionSearchDTO c = ConditionSearchDTO.builder().orderNo(orderNo).build();
        Page<OrderSummaryBO> pageData = orderService.searchOrderListByPage(pageMap,count,c);
        return pageData;
    }

    /**
     * @Description: 分页查询订单概要数据(根据订单状态查询)
     * @param page 页码
     * @param count 每页数据量
     * @param status 订单状态
     * @return io.github.talelin.latticy.model.my.Page
     * @Author: Guiquan Chen
     * @Date: 2021/5/17
     */
    @GetMapping("/summary/status")
    public Page getSkuSummaryByStatus(@RequestParam(name = "page",defaultValue = "1")
                                        @Min(value = 1) Integer page,
                                        @RequestParam(name = "count", defaultValue = "10")
                                        @Min(value = 3) @Max(value = 30) Integer count,
                                        @RequestParam(name = "status") @NotNull Integer status) {
        Map<String,Integer> pageMap = CommonUtils.convertPageParams(page,count);
        ConditionSearchDTO c = ConditionSearchDTO.builder().status(status).build();
        Page<OrderSummaryBO> pageData = orderService.searchOrderListByPage(pageMap,count,c);
        return pageData;
    }

    /**
     * @Description: 分页查询订单概要数据(根据手机号查询)
     * @param page 页码
     * @param count 每页数据量
     * @param phone 手机号
     * @return io.github.talelin.latticy.model.my.Page
     * @Author: Guiquan Chen
     * @Date: 2021/5/17
     */
    @GetMapping("/summary/phone")
    public Page getSkuSummaryByPhone(@RequestParam(name = "page",defaultValue = "1")
                                        @Min(value = 1) Integer page,
                                        @RequestParam(name = "count", defaultValue = "10")
                                        @Min(value = 3) @Max(value = 30) Integer count,
                                        @RequestParam(name = "phone") @NotNull String phone) {
        Map<String,Integer> pageMap = CommonUtils.convertPageParams(page,count);
        ConditionSearchDTO c = ConditionSearchDTO.builder().phone(phone).build();
        Page<OrderSummaryBO> pageData = orderService.searchOrderListByPage(pageMap,count,c);
        return pageData;
    }

    /**
     * @Description: 分页查询订单概要数据(根据时间段查询)
     * @param page 页码
     * @param count 每页数据量
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return io.github.talelin.latticy.model.my.Page
     * @Author: Guiquan Chen
     * @Date: 2021/5/17
     */
    @GetMapping("/summary/time")
    public Page getSkuSummaryBy(@RequestParam(name = "page",defaultValue = "1")
                                     @Min(value = 1) Integer page,
                                     @RequestParam(name = "count", defaultValue = "10")
                                     @Min(value = 3) @Max(value = 30) Integer count,
                                     @RequestParam(name = "startTime") @NotNull String startTime,
                                     @RequestParam(name = "endTime") @NotNull String endTime) {
        Map<String,Integer> pageMap = CommonUtils.convertPageParams(page,count);
        ConditionSearchDTO c = ConditionSearchDTO.builder()
                .startTime(DateUtil.getSpecifyDate(startTime))
                .endTime(DateUtil.getSpecifyDate(endTime))
                .build();
        Page<OrderSummaryBO> pageData = orderService.searchOrderListByPage(pageMap,count,c);
        return pageData;
    }

    /**
     * @Description: 更新订单信息，以及为当前订单创建物流信息
     * @param orderUpdateDTO
     * @return io.github.talelin.latticy.vo.UpdatedVO
     * @Author: Guiquan Chen
     * @Date: 2021/5/24
     */
    @PutMapping("/update")
    public UpdatedVO updateOrder(@Validated @RequestBody OrderUpdateDTO orderUpdateDTO) {
        LocalParams.setParams(orderUpdateDTO.toString());
        orderService.updateOrder(orderUpdateDTO);
        return new UpdatedVO(2);
    }


}
