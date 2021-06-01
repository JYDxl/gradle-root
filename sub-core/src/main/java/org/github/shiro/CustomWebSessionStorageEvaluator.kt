package org.github.shiro

import org.apache.shiro.subject.Subject
import org.apache.shiro.web.mgt.DefaultWebSessionStorageEvaluator
import org.apache.shiro.web.subject.WebSubject
import org.github.spring.ops.req

class CustomWebSessionStorageEvaluator : DefaultWebSessionStorageEvaluator() {
    override fun isSessionStorageEnabled(subject: Subject): Boolean {
        return (subject.isAuthenticated && subject is WebSubject && req?.getHeader("Token").isNullOrBlank()) || super.isSessionStorageEnabled(subject)
    }
}
