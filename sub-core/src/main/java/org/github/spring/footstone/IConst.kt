package org.github.spring.footstone

import com.google.common.base.Joiner.on
import java.lang.ThreadLocal.withInitial
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.TimeZone.getTimeZone
import java.util.regex.Pattern.compile

/** 默认时区.  */
const val TIME_ZONE = "GMT+08:00"
/** 默认日期格式化.  */
const val DATE_FORMAT = "yyyy-MM-dd HH:mm:ss"
/** 日期格式化，精确到日.  */
const val FORMAT_DATE = "yyyy-MM-dd"
/** 日期格式化，精确到时.  */
const val FORMAT_TIME = "HH:mm:ss"
/** 日期格式化，精确到年.  */
const val FORMAT_YEAR = "yyyy"
/** 日期格式化，精确到月.  */
const val FORMAT_MONTH = "yyyy-MM"
/** 日期格式化，只包含日.  */
const val FORMAT_ONLY_DAY = "dd"
/** 日期格式化，只包含月.  */
const val FORMAT_ONLY_MONTH = "MM"
/** 空字符串.  */
const val EMPTY = ""
/** 空字符串，XML版.  */
const val EMPTY_XML = "<root/>"
/** 空字符串，JSON版.  */
const val EMPTY_JSON = "{}"
/** 空格.  */
const val SPACE = " "
/** 下划线.  */
const val UNDER_LINE = "_"
/** default result count.  */
const val COUNT = 0L
/** 根目录.  */
const val ROOT = "/"
/** GET方法前缀.  */
const val GET = "get"
/** 重定向.  */
const val REDIRECT = "redirect:"
/** 跳转.  */
const val FORWARD = "forward:"
/** 排序方式.  */
const val SORT_ORDER = "sortOrder"
/** 排序属性.  */
const val SORT_NAME = "sortName"
/** 分页大小.  */
const val PAGE_SIZE = "pageSize"
/** 分页标志.  */
const val PAGE_FLAG = "pageFlag"
/** 当前页码.  */
const val PAGE_NUMBER = "pageNumber"
/** default sort sortOrder.  */
const val ASC = "ASC"
/** default page pageNumber.  */
const val NUMBER = 1
/** default page pageSize.  */
const val SIZE = 10
/** default page method.  */
const val FLAG = true
/** 回调方法名.  */
const val CALL_BACK = "callback"
/** success#code.  */
const val RET_OK_CODE = 0
/** success#message.  */
const val RET_OK_MSG = "OK"
/** failure#code.  */
const val RET_ERROR_CODE = -1
/** failure#message.  */
const val RET_ERROR_MSG = "ERROR"
/** Content-Disposition.  */
const val CONTENT_DISPOSITION = "Content-Disposition"
/** attachment;fileName.  */
const val ATTACHMENT_FILENAME = "attachment;fileName="
/** prefix of jsp.  */
const val PREFIX_JSP = "jsp/"
/** prefix of html.  */
const val PREFIX_HTML = "html/"
/** 默认导出Excel文件名.  */
const val DEFAULT_EXCEL = "excel.xlsx"
/** 默认批量下载文件名.  */
const val DEFAULT_ZIP = "package.zip"

/** 变量及方法名正则校验.  */
val PARAM_PATTERN = compile("^[A-Za-z_$]+[A-Za-z0-9_$]*$")!!
/** 统一日期格式化工具，精确到秒.  */
val DATE_FORMAT_SEC: DateFormat = withInitial { SimpleDateFormat(DATE_FORMAT) }.get()
/** 统一日期格式化工具，精确到天.  */
val DATE_FORMAT_DAY: DateFormat = withInitial { SimpleDateFormat(FORMAT_DATE) }.get()
/** 默认时区.  */
val TIME_ZONE_CHINA = getTimeZone(TIME_ZONE)!!
/** 字符串连接器，empty版.  */
val JOINER_EMPTY = on(EMPTY).skipNulls()!!
/** 字符串连接器，space版.  */
val JOINER_SPACE = on(SPACE).skipNulls()!!
/** 默认字符串连接器.  */
val JOINER = JOINER_SPACE
/** Excel空数据集.  */
val INIT = arrayOf<Array<String>>()
/** default result list.  */
val ARRAY = arrayOf<Any>()
/** API版本.  */
val API_VERSION = System.getProperty("apiVersion", "unknown")!!
/** APP根目录.  */
val PROJECT_DIR = System.getProperty("projectDir", "unknown")!!
/** do not use. */
const val DO_NOT_USE = "DO NOT USE"
