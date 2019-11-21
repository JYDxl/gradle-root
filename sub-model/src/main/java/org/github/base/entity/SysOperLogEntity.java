package org.github.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import org.github.base.AbstractEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

/**
 * <p>
 * 操作日志记录
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-21
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@TableName("sys_oper_log")
public class SysOperLogEntity extends AbstractEntity {
    /** UID */
    private static final long serialVersionUID = 1L;

    /** 日志主键 */
    @TableId(value = "oper_id", type = IdType.AUTO)
    private Long operId;

    /** 模块标题 */
    @TableField("title")
    private String title;

    /** 业务类型（0其它 1新增 2修改 3删除） */
    @TableField("business_type")
    private Integer businessType;

    /** 方法名称 */
    @TableField("method")
    private String method;

    /** 请求方式 */
    @TableField("request_method")
    private String requestMethod;

    /** 操作类别（0其它 1后台用户 2手机端用户） */
    @TableField("operator_type")
    private Integer operatorType;

    /** 操作人员 */
    @TableField("oper_name")
    private String operName;

    /** 部门名称 */
    @TableField("dept_name")
    private String deptName;

    /** 请求URL */
    @TableField("oper_url")
    private String operUrl;

    /** 主机地址 */
    @TableField("oper_ip")
    private String operIp;

    /** 操作地点 */
    @TableField("oper_location")
    private String operLocation;

    /** 请求参数 */
    @TableField("oper_param")
    private String operParam;

    /** 返回参数 */
    @TableField("json_result")
    private String jsonResult;

    /** 操作状态（0正常 1异常） */
    @TableField("status")
    private Integer status;

    /** 错误消息 */
    @TableField("error_msg")
    private String errorMsg;

    /** 操作时间 */
    @TableField("oper_time")
    private LocalDateTime operTime;
}
