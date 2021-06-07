package org.github.shiro.ops

import org.apache.shiro.SecurityUtils.getSubject
import org.apache.shiro.ShiroException
import org.apache.shiro.session.Session
import org.apache.shiro.subject.Subject
import org.apache.shiro.web.servlet.ShiroHttpSession.DEFAULT_SESSION_ID_NAME
import org.github.shiro.User

const val JSESSIONID = DEFAULT_SESSION_ID_NAME

const val JWT = "Token"

val subject: Subject get() = getSubject()

val session: Session? get() = subject.getSession(false)

val user: User get() = subject.principal as User? ?: throw ShiroException()
