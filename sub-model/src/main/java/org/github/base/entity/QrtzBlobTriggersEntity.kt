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
@TableName("qrtz_blob_triggers")
class QrtzBlobTriggersEntity: AbstractEntity() {

    var schedName: String? = null

    var triggerName: String? = null

    var triggerGroup: String? = null

    var blobData: Blob? = null

}
