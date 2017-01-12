import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_testconsig1_layoutsmain_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/main.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(2)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(3)
expressionOut.print(resource(dir: 'images', file: 'UniConSig.gif'))
printHtmlPart(4)
createTagBody(2, {->
createTagBody(3, {->
printHtmlPart(5)
invokeTag('layoutTitle','g',16,['default':("ConSig")],-1)
printHtmlPart(1)
})
invokeTag('captureTitle','sitemesh',17,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',17,[:],2)
printHtmlPart(6)
invokeTag('stylesheet','asset',19,['src':("application.css")],-1)
printHtmlPart(1)
invokeTag('layoutHead','g',20,[:],-1)
printHtmlPart(7)
})
invokeTag('captureHead','sitemesh',21,[:],1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
invokeTag('layoutBody','g',26,[:],-1)
printHtmlPart(9)
invokeTag('message','g',29,['code':("spinner.alt"),'default':("Loading&hellip;")],-1)
printHtmlPart(10)
invokeTag('javascript','asset',31,['src':("application.js")],-1)
printHtmlPart(11)
})
invokeTag('captureBody','sitemesh',33,[:],1)
printHtmlPart(12)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1469038648000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
