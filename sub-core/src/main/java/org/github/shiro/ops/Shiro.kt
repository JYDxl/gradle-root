package org.github.shiro.ops

import org.apache.shiro.SecurityUtils.getSubject
import org.apache.shiro.session.Session
import org.apache.shiro.subject.Subject
import org.apache.shiro.web.servlet.ShiroHttpSession.DEFAULT_SESSION_ID_NAME

const val JSESSIONID = DEFAULT_SESSION_ID_NAME

const val JWT = "Token"

val subject: Subject get() = getSubject()

val session: Session? get() = subject.getSession(false)

val principal: Any? get() = subject.principal
