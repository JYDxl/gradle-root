package org.github.base.entity

import com.baomidou.mybatisplus.annotation.TableName
import org.github.base.AbstractEntity
import java.sql.Blob

/**
 * <p>
 * 
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@TableName("qrtz_job_details")
class QrtzJobDetailsEntity: AbstractEntity() {

    var schedName: String? = null

    var jobName: String? = null

    var jobGroup: String? = null

    var description: String? = null

    var jobClassName: String? = null

    var isDurable: String? = null

    var isNonconcurrent: String? = null

    var isUpdateData: String? = null

    var requestsRecovery: String? = null

    var jobData: Blob? = null

}
